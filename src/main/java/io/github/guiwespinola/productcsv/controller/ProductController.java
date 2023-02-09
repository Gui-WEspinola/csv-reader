package io.github.guiwespinola.productcsv.controller;

import io.github.guiwespinola.productcsv.entity.dto.ProductDTO;
import io.github.guiwespinola.productcsv.helper.CSVFileReader;
import io.github.guiwespinola.productcsv.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    private final CSVFileReader csvFileReader;

    @SneakyThrows
    @PostMapping("/upload")
    public ResponseEntity<String> createProduct(MultipartFile file) {
        List<ProductDTO> beans = csvFileReader.readCsvFile(file);

        beans.stream().map(productService::save).toList();

        return ResponseEntity.status(HttpStatus.CREATED).body("File successfully uploaded");
    }
}
