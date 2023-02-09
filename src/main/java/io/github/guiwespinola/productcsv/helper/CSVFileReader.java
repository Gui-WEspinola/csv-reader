package io.github.guiwespinola.productcsv.helper;

import com.opencsv.bean.CsvToBeanBuilder;
import io.github.guiwespinola.productcsv.entity.dto.ProductDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Component
public class CSVFileReader {

    public List<ProductDTO> readCsvFile(MultipartFile file) {
        try (InputStreamReader reader = new InputStreamReader(file.getInputStream())) {
            return new CsvToBeanBuilder<ProductDTO>(reader)
                    .withType(ProductDTO.class)
                    .build()
                    .parse();

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
