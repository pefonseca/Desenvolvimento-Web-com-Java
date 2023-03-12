package br.edu.infnet.appcar;

import br.edu.infnet.appcar.model.domain.Caminhao;
import br.edu.infnet.appcar.service.CaminhaoService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class CaminhaoLoader implements ApplicationRunner {

    private final CaminhaoService caminhaoService;

    public CaminhaoLoader(CaminhaoService caminhaoService) {
        this.caminhaoService = caminhaoService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            String arq = "caminhoes.txt";

            try {
                FileReader fileR = new FileReader(arq);
                BufferedReader leitura = new BufferedReader(fileR);

                String linha = leitura.readLine();
                String[] campos = null;

                while(linha != null) {
                    campos = linha.split(";");

                    Caminhao caminhao = new Caminhao(
                                            campos[0],
                                            campos[1],
                                            Integer.valueOf(campos[2]),
                                            campos[3],
                                            campos[4],
                                            Double.valueOf(campos[5]),
                                            Double.valueOf(campos[6]),
                                            Float.parseFloat(campos[7]));

                    caminhaoService.incluir(caminhao);

                    System.out.println("A inclusão do caminhão " + caminhao.getNome() + " foi realizada com sucesso!!!");

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
