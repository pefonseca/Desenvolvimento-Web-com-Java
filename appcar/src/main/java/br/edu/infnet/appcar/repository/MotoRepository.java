package br.edu.infnet.appcar.repository;

import br.edu.infnet.appcar.model.domain.Caminhao;
import br.edu.infnet.appcar.model.domain.Moto;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MotoRepository {
    private static Integer id = 1;
    private static Map<Integer, Moto> mapaMoto = new HashMap<>();

    public static boolean incluir(Moto moto) {

        moto.setId(id++);

        try {
            mapaMoto.put(moto.getId(), moto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Moto excluir(Integer key) {
        return mapaMoto.remove(key);
    }

    public static Collection<Moto> obterLista() {
        return mapaMoto.values();
    }

}
