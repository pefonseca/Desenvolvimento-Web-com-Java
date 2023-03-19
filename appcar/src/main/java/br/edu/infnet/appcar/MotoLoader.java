package br.edu.infnet.appcar;

import br.edu.infnet.appcar.model.domain.Moto;
import br.edu.infnet.appcar.model.domain.Usuario;
import br.edu.infnet.appcar.service.MotoService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class MotoLoader implements ApplicationRunner {

    private final MotoService service;

    public MotoLoader(MotoService service) {
        this.service = service;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            String arq = "motos.txt";

            try {
                FileReader fileR = new FileReader(arq);
                BufferedReader leitura = new BufferedReader(fileR);

                String linha = leitura.readLine();
                String[] campos = null;

                while(linha != null) {
                    campos = linha.split(";");

                    Usuario usuario = new Usuario();
                    usuario.setId(1);

                    Moto moto = new Moto(
                                    campos[0],
                                    campos[1],
                                    Integer.valueOf(campos[2]),
                                    campos[3],
                                    campos[4],
                                    Double.valueOf(campos[5]),
                                    Double.valueOf(campos[6]));

                    moto.setUsuario(usuario);

                    service.incluir(moto);

                    System.out.println("A inclusão do carro " + moto.getNome() + " foi realizada com sucesso!!!");

                    linha = leitura.readLine();
                }

                leitura.close();
                fileR.close();
            } catch (IOException e) {
                System.out.println("[ERRO] " + e.getMessage());
            }
        } finally {
            System.out.println("Processamento realizada com sucesso!!");
        }
    }
}
