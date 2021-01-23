package br.com.zup.TreinoCasaDoCodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.TreinoCasaDoCodigo.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {
	
	public Autor findByemail(String email);
}
