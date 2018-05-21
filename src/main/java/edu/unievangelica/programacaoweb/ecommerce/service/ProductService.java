package edu.unievangelica.programacaoweb.ecommerce.service;

import edu.unievangelica.programacaoweb.ecommerce.model.entity.Product;
import edu.unievangelica.programacaoweb.ecommerce.repository.ProductRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends AbstractService<Product> {

    @Getter
    @Autowired
    ProductRepository repository;

}
