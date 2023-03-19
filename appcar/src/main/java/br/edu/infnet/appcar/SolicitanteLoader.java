package br.edu.infnet.appcar;

import br.edu.infnet.appcar.model.domain.Solicitante;
import br.edu.infnet.appcar.model.domain.Usuario;
import br.edu.infnet.appcar.service.SolicitanteService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


@Order(2)
@Service
public class SolicitanteLoader implements ApplicationRunner {

    private final SolicitanteService solicitanteService;

    public SolicitanteLoader(SolicitanteService solicitanteService) {
        this.solicitanteService = solicitanteService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        try {
            String arq = "solicitantes.txt";

            try {
                FileReader fileR = new FileReader(arq);
                BufferedReader leitura = new BufferedReader(fileR);

                String linha = leitura.readLine();
                String[] campos = null;

                while(linha != null) {
                    campos = linha.split(";");

                    Usuario usuario = new Usuario();
                    usuario.setId(1);

                    Solicitante solicitante = Solicitante.builder()
                                                         .nome(campos[0])
                                                         .cpf(campos[1])
                                                         .email(campos[2])
                                                         .usuario(usuario)
                                                         .build();

                    solicitante.setUsuario(usuario);

                    solicitanteService.incluir(solicitante);

                    System.out.println("A inclusão do solicitante " + solicitante.getNome() + " foi realizada com sucesso!!!");

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
