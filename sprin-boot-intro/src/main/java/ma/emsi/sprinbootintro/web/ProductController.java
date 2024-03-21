package ma.emsi.sprinbootintro.web;

import ma.emsi.sprinbootintro.dao.Product;
import ma.emsi.sprinbootintro.service.ServiceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

//    @Autowired not needed if you use constructor injection and not recommended for autowiring
    ServiceProduct serviceProduct;

    // @HTTP_TYPE_REQUEST + PATH + METHODE
    // METHOD : call for service
    // to complete ...

    public ProductController(ServiceProduct serviceProduct) {
        this.serviceProduct = serviceProduct;
    } // or use @AllArgsConstructor same as autowiring (autowired)

    @GetMapping("/products")
    List<Product> getProducts() {
        return serviceProduct.getProducts();
    }

    @GetMapping("/product")
    Product getProduct(@RequestParam Long id) {
        return serviceProduct.getProductById(id);
    } // or u can use this :
    //    @GetMapping("/product/id/{id}")
//    Product getProduct(@PathVariable Long id) {
//        return serviceProduct.getProductById(id);
//    }


    @GetMapping("/product/name/{name}")
    Product getProduct(@PathVariable String name) {
        return serviceProduct.getProductByName(name);
    }


    @PostMapping("/product")
    Product addProduct(@RequestBody Product product) {
        return serviceProduct.addProduct(product);
    }


    @PutMapping("/product")
    Product editProductByPrice(@RequestParam Float price, @RequestParam Long id) {
        return serviceProduct.editProductPrice(id, price);
    }



    @DeleteMapping("/product/del/{id}")
    void deleteProductById(@PathVariable Long id) {
        serviceProduct.deleteProduct(id);
    }


    @DeleteMapping("/product/delByName")
    Product deleteProductByName(@RequestParam String name) {
        return serviceProduct.deleteProduct(name);
    }


}
