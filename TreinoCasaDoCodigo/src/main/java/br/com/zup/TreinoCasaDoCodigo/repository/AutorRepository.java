package br.com.zup.TreinoCasaDoCodigo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.TreinoCasaDoCodigo.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

	public Optional<Autor> findByemail(String email);

}
