package edu.unievangelica.programacaoweb.ecommerce.repository;

import edu.unievangelica.programacaoweb.ecommerce.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
