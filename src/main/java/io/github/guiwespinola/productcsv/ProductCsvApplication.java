package io.github.guiwespinola.productcsv;

import com.opencsv.bean.CsvToBeanBuilder;
import io.github.guiwespinola.productcsv.entity.dto.ProductDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class ProductCsvApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCsvApplication.class, args);

	}
}
