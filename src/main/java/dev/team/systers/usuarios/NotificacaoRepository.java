package dev.team.systers.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {
    List<Notificacao> findNotificacaosByUsuarioNotificacaoDestinatario_Id(Long usuarioId);
}
