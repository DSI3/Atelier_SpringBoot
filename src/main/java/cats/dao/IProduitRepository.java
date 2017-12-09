package cats.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cats.entities.Produit;
//Mise � jour de l'entit� produit pour faire la liaison entre avec l'entit� categorie
import cats.entities.Categorie;
/*************************************************************************************/
public interface IProduitRepository extends JpaRepository<Produit, Long>{
	@Query("select p from Produit p where p.designation like :x")
	public Page<Produit> produitParMC(@Param("x")String mc,Pageable p);
	@Query("select p from Produit p where p.designation like :x")
	public List<Produit> findByDesignation(@Param("x")String des);
	public Page<Produit> findByDesignation(String des,Pageable p);
	//Mise � jour de l'entit� produit pour faire la liaison entre avec l'entit� categorie
	public Page<Produit> findByCategorie(Categorie categorie,Pageable pageable);
		/**********************************************************************************/
	}
	
