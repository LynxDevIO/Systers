package dev.team.systers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.team.systers.model.Mentoria;
import dev.team.systers.model.Participante;
import dev.team.systers.model.Usuario;
import dev.team.systers.repository.ParticipanteRepository;

@Service
public class ParticipanteService {
    
    private final ParticipanteRepository participanteRepository;

    @Autowired
    public ParticipanteService(ParticipanteRepository participanteRepository) {
        this.participanteRepository = participanteRepository;
    }

    public void criarParticipanteMentor(Usuario mentor, Mentoria mentoria) {
        Participante participante = new Participante();
        participante.setNome(mentor.getNome());
        participante.setUsuario(mentor);
        participante.setTipo(Participante.TipoParticipante.MENTOR);
        participante.setMentoria(mentoria);
        participanteRepository.save(participante);
    }

    public void criarParticipanteMentorado(Usuario mentorado, Mentoria mentoria) {
        Participante participante = new Participante();
        participante.setNome(mentorado.getNome());
        participante.setUsuario(mentorado);
        participante.setTipo(Participante.TipoParticipante.MENTORADO);
        participante.setMentoria(mentoria);
        participanteRepository.save(participante);
    }

    public Participante buscarParticipantePorUsuarioEMentoria(Usuario usuario, Mentoria mentoria) {
        return participanteRepository.findParticipanteByUsuarioAndMentoria(usuario, mentoria);
    }
}