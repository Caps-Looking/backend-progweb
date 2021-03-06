package edu.unievangelica.programacaoweb.ecommerce.repository;

import edu.unievangelica.programacaoweb.ecommerce.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
