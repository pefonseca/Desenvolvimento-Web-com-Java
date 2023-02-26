package br.edu.infnet.appcar.repository;

import br.edu.infnet.appcar.model.domain.Caminhao;
import br.edu.infnet.appcar.model.domain.Carro;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CarroRepository {

    private static Integer id = 1;
    private static Map<Integer, Carro> mapaCarro = new HashMap<>();

    public static boolean incluir(Carro carro) {

        carro.setId(id++);

        try {
            mapaCarro.put(carro.getId(), carro);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Carro excluir(Integer key) {
        return mapaCarro.remove(key);
    }

    public static Collection<Carro> obterLista() {
        return mapaCarro.values();
    }
}
