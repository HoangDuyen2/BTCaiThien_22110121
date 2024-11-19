package iot.star.btcaithien_22110121.Services;

import iot.star.btcaithien_22110121.Entity.Product;

import java.util.List;

public interface ProductServices {
    void delete(Long id);
    Product getProduct(Long id);
    Product saveProduct(Product product);
    List<Product> getProducts();
}
