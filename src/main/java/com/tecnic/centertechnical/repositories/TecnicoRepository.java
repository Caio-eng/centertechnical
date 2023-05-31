package com.tecnic.centertechnical.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecnic.centertechnical.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer>  {

}
