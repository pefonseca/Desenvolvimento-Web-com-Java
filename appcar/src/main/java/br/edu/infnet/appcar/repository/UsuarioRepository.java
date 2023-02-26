package br.edu.infnet.appcar.repository;

import java.util.*;

import br.edu.infnet.appcar.model.domain.Usuario;

public class UsuarioRepository {

	private static Integer id = 1;
	private static Map<Integer, Usuario> mapaUsuario = new HashMap<>();

	public static boolean incluir(Usuario usuario) {

		usuario.setId(id++);

		try {
			mapaUsuario.put(usuario.getId(), usuario);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static Usuario excluir(Integer key) {
		return mapaUsuario.remove(key);
	}
	
	public static Collection<Usuario> obterLista() {
		return mapaUsuario.values();
	}
}
