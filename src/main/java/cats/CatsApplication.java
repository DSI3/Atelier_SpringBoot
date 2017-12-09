package cats;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
//MVC
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
/*******************************************************/
import cats.dao.ICategorieRepository;
import cats.dao.IProduitRepository;
import cats.entities.Categorie;
import cats.entities.Produit;
@SpringBootApplication
@ComponentScan
@ImportResource("classpath:spring-config.xml")
@EnableAutoConfiguration

public class CatsApplication implements CommandLineRunner  {
	@Autowired
	IProduitRepository pr;
	@Autowired
	ICategorieRepository cr;
	public static void main(String[] args) {
		//ApplicationContext ctx =
				SpringApplication.run(CatsApplication.class, args);
		//IProduitRepository pr = ctx.getBean(IProduitRepository.class);
		
		
	}
	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		Categorie c1 = new Categorie("Imprimante");
		cr.save(c1);
		cr.save(new Categorie("PC"));
		
		pr.save(new Produit((long)121,"HP",100,c1));
		pr.save(new Produit((long)125,"Lexmark",200,c1));
		pr.save(new Produit((long)126,"Epson",230,c1));
		
		//List<Produit> prods = pr.findAll();
	//	prods.forEach(p->System.out.println(p.getDesignation()));
		
	}
}
