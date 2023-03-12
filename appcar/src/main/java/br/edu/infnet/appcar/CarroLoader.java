package br.edu.infnet.appcar;

import br.edu.infnet.appcar.model.domain.Carro;
import br.edu.infnet.appcar.service.CarroService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class CarroLoader implements ApplicationRunner {

    private final CarroService service;

    public CarroLoader(CarroService service) {
        this.service = service;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            String arq = "carros.txt";

            try {
                FileReader fileR = new FileReader(arq);
                BufferedReader leitura = new BufferedReader(fileR);

                String linha = leitura.readLine();
                String[] campos = null;

                while(linha != null) {
                    campos = linha.split(";");

                    Carro carro = new Carro(
                                            campos[0],
                                            campos[1],
                                            Integer.valueOf(campos[2]),
                                            campos[3],
                                            campos[4],
                                            Double.valueOf(campos[5]),
                                            Double.valueOf(campos[6]));

                    service.incluir(carro);

                    System.out.println("A inclusão do carro " + carro.getNome() + " foi realizada com sucesso!!!");

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
