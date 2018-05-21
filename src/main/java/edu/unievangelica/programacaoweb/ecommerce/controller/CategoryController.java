package edu.unievangelica.programacaoweb.ecommerce.controller;

import edu.unievangelica.programacaoweb.ecommerce.model.dto.BaseResponse;
import edu.unievangelica.programacaoweb.ecommerce.model.entity.Category;
import edu.unievangelica.programacaoweb.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/category")
@CrossOrigin(origins = "*")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public BaseResponse findAll() {
        return new BaseResponse("Successfully loaded", categoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public BaseResponse findById(@PathVariable Long id) {
        return new BaseResponse("Successfully loaded", categoryService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public BaseResponse save(@Valid @RequestBody Category category) {
        return new BaseResponse("Successfully loaded", categoryService.save(category), HttpStatus.CREATED);
    }

    @PutMapping
    public BaseResponse update(@RequestBody Category category) {
        return new BaseResponse("Successfully loaded", categoryService.update(category), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public BaseResponse delete(@PathVariable Long id) {
        return categoryService.delete(id);
    }

}
