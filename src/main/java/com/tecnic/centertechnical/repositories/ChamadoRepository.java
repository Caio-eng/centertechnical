package com.tecnic.centertechnical.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecnic.centertechnical.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer>  {

}
