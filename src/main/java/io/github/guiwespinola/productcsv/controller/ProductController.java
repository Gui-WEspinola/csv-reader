package io.github.guiwespinola.productcsv.controller;

import com.opencsv.bean.CsvToBeanBuilder;
import io.github.guiwespinola.productcsv.entity.Product;
import io.github.guiwespinola.productcsv.entity.dto.ProductDTO;
import io.github.guiwespinola.productcsv.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @SneakyThrows
    @PostMapping("/upload")
    public ResponseEntity<String> createProduct(MultipartFile file) {
        InputStreamReader reader = new InputStreamReader(file.getInputStream());
        List<ProductDTO> beans = new CsvToBeanBuilder(reader)
            .withType(ProductDTO.class)
            .build()
            .parse();

        reader.close();

        beans.stream().map(productService::save).toList();

    return ResponseEntity.status(HttpStatus.CREATED).body("File successfully uploaded");
    }
//    @SneakyThrows
//    @PostMapping("/create-product-from-local-file")
//    public ResponseEntity<?> createProduct() {
//        List<ProductDTO> beans = new CsvToBeanBuilder(new FileReader("csv/Products.csv"))
//                .withType(ProductDTO.class)
//                .build()
//                .parse();
//
//        beans.stream().map(productService::save).toList();
//
//        return ResponseEntity.status(HttpStatus.CREATED).build();
//    }
}
