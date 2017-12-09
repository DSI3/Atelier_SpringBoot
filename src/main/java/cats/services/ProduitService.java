package cats.services;
import java.util.List; 
import javax.jws.WebMethod; 
import javax.jws.WebParam;
import javax.jws.WebService; 
import cats.dao.IProduitRepository;
import cats.entities.Produit; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
@WebService
public class ProduitService {
	@Autowired
	private IProduitRepository produitRepository;
	@WebMethod
	public List<Produit> allProducts(){
	return produitRepository.findAll();
	}

}
