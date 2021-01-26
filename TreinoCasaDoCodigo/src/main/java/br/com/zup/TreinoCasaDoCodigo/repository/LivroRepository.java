package br.com.zup.TreinoCasaDoCodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.TreinoCasaDoCodigo.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

}
