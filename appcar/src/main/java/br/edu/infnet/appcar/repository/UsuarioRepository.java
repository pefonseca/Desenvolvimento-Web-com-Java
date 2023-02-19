package br.edu.infnet.appcar.repository;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.appcar.model.domain.Usuario;

public class UsuarioRepository {
	
	private static final List<Usuario> lista = new ArrayList<>();

	public static boolean incluir(Usuario usuario) {
		try {
			lista.add(usuario);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static List<Usuario> obterLista() {
		return lista;
	}
}
