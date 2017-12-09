package cats.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Produit implements Serializable {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long Id;
private Long reference;
private String designation;
private double prix;
//Mise à jour de l'entité produit pour faire la liaison entre avec l'entité categorie
@ManyToOne
@JoinColumn(name="ID_CAT")
private Categorie categorie;
/***************************************************************************************/
public Long getId() {
	return Id;
}
public void setId(Long id) {
	Id = id;
}
public Long getReference() {
	return reference;
}
public void setReference(Long reference) {
	this.reference = reference;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public double getPrix() {
	return prix;
}
public void setPrix(double prix) {
	this.prix = prix;
}
public Produit() {
	super();
	// TODO Auto-generated constructor stub
}
public Produit(Long reference, String designation, double prix) {
	super();
	this.reference = reference;
	this.designation = designation;
	this.prix = prix;
}
public Produit(Long reference, String designation, double prix, Categorie categorie) {
	super();
	this.reference = reference;
	this.designation = designation;
	this.prix = prix;
	this.categorie = categorie;
}



}