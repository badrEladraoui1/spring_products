package ma.emsi.sprinbootintro;

import ma.emsi.sprinbootintro.dao.Product;
import ma.emsi.sprinbootintro.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SprinBootIntroApplication implements CommandLineRunner {
	@Autowired
	ProductRepo productRepo;

	public static void main(String[] args) {
		SpringApplication.run(SprinBootIntroApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// creation of products
		// save
		for(int i = 0 ; i < 11 ; i ++){
			productRepo.save(new Product(null , "product "+i , "REF123QWEprod "+i , 123 , new Date() , (float) (Math.random() * 1000), new Date()));
		}
		System.out.println();

		// Nombre d'enregistrement dans "Product"
		System.out.println("********** nombre total des produits ********** : " + productRepo.count());
		System.out.println();

		// lecture de la table "product"
		// findAll
		Iterable<Product> products = productRepo.findAll();
		for(Product p : products){
			System.out.println(p.getId() + p.getName() + "  " +p.getRef());
		}

		System.out.println();

//		if(productRepo.existsById(11L)) System.out.println("PRODUCT 5 : " + productRepo.findById(19L).get());
//		else System.out.println("product not found");

		// Get an object by its id :
		System.out.println("PRODUCT 5 : " + productRepo.findById(5L));


		System.out.println();
		// suppression d'objet 5
		productRepo.deleteById(5L);

		// checking
		products = productRepo.findAll();
		for(Product p : products){
			System.out.println(p.getId() + p.getName() + "  " +p.getRef());
		}

		System.out.println();
		//find by name
		System.out.println(productRepo.findByName("product 0"));
		System.out.println(productRepo.findByRef("REF123QWEprod 1"));


	}
}
