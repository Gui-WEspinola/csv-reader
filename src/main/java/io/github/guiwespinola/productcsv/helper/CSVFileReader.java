package io.github.guiwespinola.productcsv.helper;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import io.github.guiwespinola.productcsv.entity.dto.ProductDTO;
import io.github.guiwespinola.productcsv.enums.ErrorCode;
import io.github.guiwespinola.productcsv.exception.InvalidCSVException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Component
public class CSVFileReader {

    public List<ProductDTO> readCsvFile(MultipartFile file) {
        checkFileExtension(file);
        try (InputStreamReader reader = new InputStreamReader(file.getInputStream())) {
            return new CsvToBeanBuilder<ProductDTO>(reader)
                    .withType(ProductDTO.class)
                    .build()
                    .parse();

        } catch (IOException e) {
            throw new InvalidCSVException(ErrorCode.EC1101.getErrorMessage());
        }
    }

    private void checkFileExtension(MultipartFile file) {
        if (!file.getOriginalFilename().endsWith(".csv")) {
            throw new InvalidCSVException(ErrorCode.EC1001.getErrorMessage());
        }
    }
}
