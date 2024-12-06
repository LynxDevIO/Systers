package dev.team.systers.controller;

import dev.team.systers.exception.UsuarioException;
import dev.team.systers.model.Perfil;
import dev.team.systers.model.Usuario;
import dev.team.systers.service.PerfilService;
import dev.team.systers.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PerfilController {
    private final UsuarioService usuarioService;
    private final PerfilService perfilService;

    @Autowired
    public PerfilController(PerfilService perfilService, UsuarioService usuarioService, PerfilService perfilService1) {
        this.usuarioService = usuarioService;
        this.perfilService = perfilService1;
    }

    @GetMapping("/perfil/me")
    public String exibirPerfilAtual(Model model) {
        Authentication(model, usuarioService);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null ||
                !auth.isAuthenticated() ||
                auth.getName().equals("anonymousUser")) {
            throw new UsuarioException("Usuário não autenticado");
        }

        String username = auth.getName();
        Usuario usuario = usuarioService.findByLogin(username);
        if (usuario == null) {
            throw new UsuarioException("Usuário não encontrado");
        }
        Perfil perfil = perfilService.buscarPerfilPorIDUsuario(usuario.getId());

        model.addAttribute("usuario", usuario);
        model.addAttribute("perfil", perfil);
        return "perfil";
    }

    static void Authentication(Model model, UsuarioService usuarioService) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null ||
                !auth.isAuthenticated() ||
                auth.getName().equals("anonymousUser")) {
            throw new IllegalStateException("Usuário não autenticado");
        }

        String login = auth.getName();
        Usuario usuario = usuarioService.findByLogin(login);
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não encontrado");
        }
        model.addAttribute("usuario", usuario);
    }

    @GetMapping("/perfil/{login}")
    public String exibirPerfilUsuario(@PathVariable String login, Model model) {
        Usuario usuario = usuarioService.findByLogin(login);
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não encontrado");
        }
        model.addAttribute("usuario", usuario);
        return "perfil";
    }
}
