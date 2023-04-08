package com.ecuapp.market.domain.service;

import com.ecuapp.market.domain.Product;
import com.ecuapp.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId){
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int CategoryId){
        return productRepository.getByCategory(CategoryId);
    }

    public Optional<List<Product>> getScarseProducts(int quantity){
        return productRepository.getScarseProducts(quantity);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public boolean delete(int productId){
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }

    /*
    public boolean Otrodelete(int productId){
        if(getProduct(productId).isPresent()){
            productRepository.delete(productId);
            return true;
        } else {  return false; }
    }
    */

}
