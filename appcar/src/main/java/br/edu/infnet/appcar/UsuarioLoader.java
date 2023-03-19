package br.edu.infnet.appcar;

import br.edu.infnet.appcar.model.domain.Usuario;
import br.edu.infnet.appcar.service.UsuarioService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;


@Order(1)
@Service
public class UsuarioLoader implements ApplicationRunner {

    private final UsuarioService usuarioService;

    public UsuarioLoader(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    public void run(ApplicationArguments args) {

        Usuario userAdmin = new Usuario("Administrador", "admin@admin.com", "123");
        userAdmin.setIdade(99);
        userAdmin.setSalario(9999);
        userAdmin.setSetor("Administração");
        userAdmin.setTipo("Admin");

        usuarioService.incluir(userAdmin);
        System.out.println("Inclusão do administrador "+userAdmin.getNome()+" realizada com sucesso!!!");

        for (int i = 0; i < 9; i++) {
            Usuario usuario = Usuario.builder()
                    .nome("Administrador " + i)
                    .email("admin"+ i +"@admin.com")
                    .senha("0" + i)
                    .idade(i*2)
                    .salario(i*200)
                    .setor("Presidência " + i)
                    .tipo("Admin" + i)
                    .build();

            usuarioService.incluir(usuario);

            System.out.println("Inclusão do usuário " + usuario.getNome() + " realizada com sucesso!!!");
        }
    }
}
