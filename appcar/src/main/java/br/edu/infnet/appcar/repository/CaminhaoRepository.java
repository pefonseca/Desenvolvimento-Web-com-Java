package br.edu.infnet.appcar.repository;

import br.edu.infnet.appcar.model.domain.Caminhao;
import br.edu.infnet.appcar.model.domain.Usuario;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CaminhaoRepository {
    private static Integer id = 1;
    private static Map<Integer, Caminhao> mapaCaminhao = new HashMap<>();

    public static boolean incluir(Caminhao caminhao) {

        caminhao.setId(id++);

        try {
            mapaCaminhao.put(caminhao.getId(), caminhao);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Caminhao excluir(Integer key) {
        return mapaCaminhao.remove(key);
    }

    public static Collection<Caminhao> obterLista() {
        return mapaCaminhao.values();
    }

}
