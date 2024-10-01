package com.oak.tecnologia.OakTecnologia.controller.product;

import com.oak.tecnologia.OakTecnologia.dto.product.ProductDTO;
import com.oak.tecnologia.OakTecnologia.models.product.Product;
import com.oak.tecnologia.OakTecnologia.repository.product.IProductRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/product")
@SecurityRequirement(name = "bearer-key")
public class ProductController {

    @Autowired
    private IProductRepository iProductRepository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid ProductDTO productDTO, UriComponentsBuilder uriComponentsBuilder){
        var product = new Product(productDTO);
        iProductRepository.save(product);

        var uri = uriComponentsBuilder.path("/product/{id}").buildAndExpand(product.getId()).toUri();

        return ResponseEntity.ok(uri);
    }

    @GetMapping
    public ResponseEntity<List<Product>> listProduct(Pageable pageable) {
        var page = iProductRepository.findAll();
        return ResponseEntity.ok(page);
    }
}
