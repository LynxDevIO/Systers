package dev.team.systers.grupos;

import dev.team.systers.usuarios.Usuario;
import dev.team.systers.usuarios.UsuarioException;
import dev.team.systers.usuarios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GrupoController {
    private final GrupoService grupoService;
    private final UsuarioService usuarioService;

    @Autowired
    public GrupoController(GrupoService grupoService, UsuarioService usuarioService) {
        this.grupoService = grupoService;
        this.usuarioService = usuarioService;
    }

    @GetMapping("/grupos/criar-grupo")
    public String registrarGrupo(Model model) {
        model.addAttribute("grupo", new Grupo());
        return "/criar-grupo";
    }

    @PostMapping("/grupos/criar-grupo")
    public String registrarGrupo(@ModelAttribute("grupo") Grupo grupo, Model model) {
        model.addAttribute("grupo", new Grupo());

        try {
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

            model.addAttribute("usuario", usuario);

            grupoService.criarGrupo(grupo.getNome(), grupo.getDescricao(), usuario);
        } catch (GrupoException e) {
            model.addAttribute("mensagemErro", e.getMessage());
            return "/grupos/criar-grupo";
        }
        return "/grupos";
    }
}
