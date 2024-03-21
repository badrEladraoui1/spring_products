package ma.emsi.sprinbootintro.service;

import ma.emsi.sprinbootintro.dao.Product;
import ma.emsi.sprinbootintro.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProductImpl implements ServiceProduct {

    @Autowired
    ProductRepo productRepo;

    @Override
    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        // Verifier si le produit existe ...
        return productRepo.findById(id).get();
    }

    @Override
    public Product getProductByName(String name) {
        return productRepo.findByName(name);
    }

    @Override
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product editProductPrice(Long id, Float price) {
        Product productToBeEdited = productRepo.findById(id).get();
        if (productToBeEdited != null) {
            productToBeEdited.setPrice(price);
            return productRepo.save(productToBeEdited);
        }
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }

    @Override
    public Product deleteProduct(String name) {
        Product productToBeDeleted = productRepo.findByName(name);
        if (productToBeDeleted != null) {
            productRepo.delete(productToBeDeleted);
            return productToBeDeleted;
        }
        return null;
    }
}