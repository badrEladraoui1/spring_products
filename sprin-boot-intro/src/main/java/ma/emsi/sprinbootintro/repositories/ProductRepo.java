package ma.emsi.sprinbootintro.repositories;

import ma.emsi.sprinbootintro.dao.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends JpaRepository<Product , Long> {
    Product findByName (String name);
    Product findByRef (String ref);
    Product deleteByName(String name);


}
