package br.com.zup.TreinoCasaDoCodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.TreinoCasaDoCodigo.model.Estado;
import br.com.zup.TreinoCasaDoCodigo.model.Pais;

public interface EstadoRepository extends JpaRepository<Estado, Long>{
}
