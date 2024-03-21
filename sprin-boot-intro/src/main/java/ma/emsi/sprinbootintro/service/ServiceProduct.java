package ma.emsi.sprinbootintro.service;

import ma.emsi.sprinbootintro.dao.Product;

import java.util.List;

public interface ServiceProduct {

    List<Product> getProducts();
    Product getProductById(Long id);
    Product getProductByName(String name);
    Product addProduct(Product product);
    Product editProductPrice(Long id , Float price);
    void deleteProduct(Long id);
    Product deleteProduct(String name);


    // to complete with other operations

}
