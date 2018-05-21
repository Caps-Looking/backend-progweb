package edu.unievangelica.programacaoweb.ecommerce.service;

import edu.unievangelica.programacaoweb.ecommerce.model.entity.Category;
import edu.unievangelica.programacaoweb.ecommerce.repository.CategoryRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends AbstractService<Category> {

    @Getter
    @Autowired
    CategoryRepository repository;

}
