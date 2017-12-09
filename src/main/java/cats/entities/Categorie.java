package cats.entities;

import java.io.Serializable; import java.util.Collection;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Categorie implements Serializable {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long idCategorie;
private String nomCategorie;
@OneToMany(mappedBy="categorie",fetch=FetchType.LAZY)
private Collection<Produit> produits;
public Categorie() { }
public Categorie(String nomCategorie) {
this.nomCategorie = nomCategorie;
}


@JsonIgnore
@XmlTransient
public Collection<Produit> getProduits() {
return produits;
}
//Getters et Setters
public Long getIdCategorie() {
	return idCategorie;
}
public void setIdCategorie(Long idCategorie) {
	this.idCategorie = idCategorie;
}
public String getNomCategorie() {
	return nomCategorie;
}
public void setNomCategorie(String nomCategorie) {
	this.nomCategorie = nomCategorie;
}
public void setProduits(Collection<Produit> produits) {
	this.produits = produits;
}


}