package io.github.guiwespinola.productcsv.service;

import io.github.guiwespinola.productcsv.entity.Product;
import io.github.guiwespinola.productcsv.entity.dto.ProductDTO;
import io.github.guiwespinola.productcsv.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final ModelMapper mapper;

    @Transactional
    public Product save(ProductDTO product) {

        return productRepository.save(mapper.map(product, Product.class));
    }
}
