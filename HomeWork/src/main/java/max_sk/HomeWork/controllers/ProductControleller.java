package max_sk.HomeWork.controllers;

import lombok.RequiredArgsConstructor;
import max_sk.HomeWork.model.Product;
import max_sk.HomeWork.repositories.ProductRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductControleller  {
    private ProductRepositories productRepositories;

    @Autowired
    public ProductControleller(ProductRepositories productRepositories){
        this.productRepositories = productRepositories;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productRepositories.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productRepositories.findById(id).get();
    }
    @GetMapping("/title")
    public Product getProductByTitle(@RequestParam String title){
        return productRepositories.findByTitle(title).get();
    }

    @GetMapping("/del/{id}")
    public void delProductById(@PathVariable Long id){
        productRepositories.deleteById(id);
    }

    @GetMapping("min_cost")
    public List<Product> searchByMinCost(@RequestParam(name = "min") Integer minCost){
        return productRepositories.findAllByCostIsGreaterThanEqual(minCost);
    }

    @GetMapping("max_cost")
    public List<Product> searchByMaxCost(@RequestParam(name = "max") Integer maxCost){
        return productRepositories.findAllByCostIsLessThanEqual(maxCost);
    }

    @GetMapping("min_sort")
    public List<Product> searchByMinSortCost(){
        return productRepositories.findByOrderByCostAsc();
    }

    @GetMapping("max_sort")
    public List<Product> searchByMaxSortCost(){
        return productRepositories.findByOrderByCostDesc();
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        product.setId(null);
        return productRepositories.save(product);
    }
}
