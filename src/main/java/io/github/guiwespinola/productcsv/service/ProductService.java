package io.github.guiwespinola.productcsv.service;

import io.github.guiwespinola.productcsv.entity.Product;
import io.github.guiwespinola.productcsv.entity.dto.ProductDTO;
import io.github.guiwespinola.productcsv.exception.ResourceNotFoundException;
import io.github.guiwespinola.productcsv.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final ModelMapper mapper;

    @Transactional
    public Product save(ProductDTO product) {
        return productRepository.save(mapper.map(product, Product.class));
    }

    public ProductDTO getProductByCode(String code) {
        Product product = productRepository.findByCodeIgnoreCase(code)
                .orElseThrow(() -> new ResourceNotFoundException("Product not Found"));
        return mapper.map(product, ProductDTO.class);
    }

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> mapper.map(product, ProductDTO.class))
                .toList();
    }
}
