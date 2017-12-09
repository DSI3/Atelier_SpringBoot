package cats.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import cats.dao.IProduitRepository;
import cats.entities.Produit;
//Mise � jour de l'entit� produit pour faire la liaison entre avec l'entit� categorie
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import cats.dao.ICategorieRepository;
import cats.entities.Categorie;


@RestController
public class CatalogueControllers {
@Autowired
private IProduitRepository produitRepository;
//Mise � jour de l'entit� produit pour faire la liaison entre avec l'entit� categorie
@Autowired
private ICategorieRepository categorieRepository;

@RequestMapping(value="/save",method = RequestMethod.POST)
//@RequestBody: recherche de l'objet dans le body de la httpRequest
public Produit saveProduit(@RequestBody Produit p){
produitRepository.save(p);
return p;
}
@RequestMapping(value ="/all",method = RequestMethod.GET)
public List<Produit> getProduits(){
return produitRepository.findAll();
}
@RequestMapping(value="/get/{id}",method =RequestMethod.GET)
//@PathVariable: recherche de la valeur de l'id dans l'URL
public Produit getProduit(@PathVariable ("id")Long id){
return produitRepository.findOne(id);
}
@RequestMapping(value ="/produits/{page}",method = RequestMethod.GET)
public Page<Produit> getProduits(@PathVariable int page){
return produitRepository.findAll(new PageRequest(page, 5));
}
@RequestMapping(value= "/produitsParMC",method = RequestMethod.GET)
public Page<Produit> getProduitMC(
		//@RequestParam : à partir de l'url, dans ce cas exemple /produitsParMC?mc=HP&page=0
		@RequestParam (value ="mc",defaultValue = "0")String mc,
		@RequestParam (value ="page",defaultValue = "0") int page){
return produitRepository.produitParMC(mc, new PageRequest(page, 5));
}

@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
public boolean delete(@PathVariable Long id){
produitRepository.delete(id);
return true;
}
@RequestMapping(value="/update/{id}",method = RequestMethod.PUT)
public Produit update(@RequestBody Produit p,@PathVariable Long id){
p.setId(id);
produitRepository.saveAndFlush(p);
return p;
} 

//Mise � jour de l'entit� produit pour faire la liaison entre avec l'entit� categorie
@RequestMapping(value="/produitsParCat")
@ResponseBody
public Page<Produit> produitsParCat(
		@RequestParam (value ="page",defaultValue = "0") int page,
		@RequestParam (value ="idCategorie",defaultValue = "0")int id_cat){
	Categorie c = categorieRepository.findOne((long)id_cat);
return produitRepository.findByCategorie(c, new PageRequest(page, 3));
}
@RequestMapping(value="/saveCat")
@ResponseBody
public Categorie saveCategorie(Categorie c){
return categorieRepository.save(c);
}
@RequestMapping(value ="/allCat",method = RequestMethod.GET)
public List<Categorie> getCategories(){
return categorieRepository.findAll();
}


}
