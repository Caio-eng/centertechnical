package com.tecnic.centertechnical.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tecnic.centertechnical.domain.Chamado;
import com.tecnic.centertechnical.domain.Cliente;
import com.tecnic.centertechnical.domain.Tecnico;
import com.tecnic.centertechnical.domain.enums.Perfil;
import com.tecnic.centertechnical.domain.enums.Prioridade;
import com.tecnic.centertechnical.domain.enums.Status;
import com.tecnic.centertechnical.repositories.ChamadoRepository;
import com.tecnic.centertechnical.repositories.PessoaRepository;

@Service
public class DBService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	public void instaciaDB() {
		Tecnico tec1 = new Tecnico(null, "Guilherme", "94213127087", "gui@email.com", encoder.encode("123"));
		tec1.addPerfil(Perfil.ADMIN);
		Tecnico tec2 = new Tecnico(null, "Richard Stall", "903.347.070-56", "stallman@email.com", encoder.encode("123"));
		Tecnico tec3 = new Tecnico(null, "Claude", "271.068.470-54", "claude@email.com", encoder.encode("123"));
		Tecnico tec4 = new Tecnico(null, "Tim", "162.720.120-39", "tim@email.com", encoder.encode("123"));
		Tecnico tec5 = new Tecnico(null, "Linus", "778.556.170-27", "linus@email.com", encoder.encode("123"));
		
		Cliente cli1 = new Cliente(null, "Albert", "111.661.890-74", "einsten@email.com", encoder.encode("123"));
		Cliente cli2 = new Cliente(null, "Marie", "322.429.140-06", "marie@email.com", encoder.encode("123"));
		Cliente cli3 = new Cliente(null, "Charles", "792.043.830-62", "charles@email.com", encoder.encode("123"));
		Cliente cli4 = new Cliente(null, "Stephen", "177.409.680-30", "stephen@email.com", encoder.encode("123"));
		Cliente cli5 = new Cliente(null, "Max", "081.399.300-83", "planck@email.com", encoder.encode("123"));
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 1", "Teste chamado 1", tec1, cli1);
		Chamado c2 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 2", "Teste chamado 2", tec1, cli2);
		Chamado c3 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 3", "Teste chamado 3", tec2, cli3);
		Chamado c4 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 4", "Teste chamado 4", tec3, cli3);
		Chamado c5 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 5", "Teste chamado 5", tec2, cli1);
		Chamado c6 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 6", "Teste chamado 6", tec1, cli5);
		
		pessoaRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4, tec5, cli1, cli2, cli3, cli4, cli5));
		chamadoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));
		
	}
}