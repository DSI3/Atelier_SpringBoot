package cats.dao;
import cats.entities.Categorie;
import cats.entities.Produit;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
@SuppressWarnings("unused")
public interface ICategorieRepository extends JpaRepository<Categorie, Long> {
	
	@Query("select c from Categorie c where c.nomCategorie like :x")
	public Categorie findByNom(@Param("x")String nom);
}

