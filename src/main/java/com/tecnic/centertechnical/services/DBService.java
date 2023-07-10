package com.tecnic.centertechnical.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tecnic.centertechnical.domain.Tecnico;
import com.tecnic.centertechnical.domain.enums.Perfil;
import com.tecnic.centertechnical.repositories.PessoaRepository;

@Service
public class DBService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	public void instaciaDB() {
		Tecnico tec1 = new Tecnico(null, "Admin", "94213127087", "admin@email.com", encoder.encode("123"));
		tec1.addPerfil(Perfil.ADMIN);
		
		pessoaRepository.saveAll(Arrays.asList(tec1));
		
	}
}
