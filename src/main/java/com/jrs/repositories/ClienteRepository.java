package com.jrs.repositories;

import com.jrs.models.InformacionCliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface InformacionClienteRepository extends JpaRepository<InformacionCliente, Integer> {


}
