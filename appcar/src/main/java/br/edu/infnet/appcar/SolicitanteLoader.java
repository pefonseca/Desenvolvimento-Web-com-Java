package br.edu.infnet.appcar;

import br.edu.infnet.appcar.model.domain.Solicitante;
import br.edu.infnet.appcar.service.SolicitanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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

                    Solicitante solicitante = Solicitante.builder()
                                                         .nome(campos[0])
                                                         .cpf(campos[1])
                                                         .email(campos[2])
                                                         .build();

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
