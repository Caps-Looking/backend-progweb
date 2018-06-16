package edu.unievangelica.programacaoweb.ecommerce.controller;

import edu.unievangelica.programacaoweb.ecommerce.model.dto.BaseResponse;
import edu.unievangelica.programacaoweb.ecommerce.model.entity.Product;
import edu.unievangelica.programacaoweb.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/product")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public BaseResponse findAll() {
        return new BaseResponse("Successfully loaded", productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public BaseResponse findById(@PathVariable Long id) {
        return new BaseResponse("Successfully loaded", productService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public BaseResponse save(@RequestBody Product product) {
        return new BaseResponse("Successfully loaded", productService.save(product), HttpStatus.CREATED);
    }

    @PutMapping
    public BaseResponse update(@RequestBody Product product) {
        return new BaseResponse("Successfully loaded", productService.update(product), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

}
