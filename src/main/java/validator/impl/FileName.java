package validator.impl;

import validator.FileValidator;
import org.springframework.web.multipart.MultipartFile;

import java.util.regex.Pattern;

import static constants.Regex.INPUT_VALIDATION_PATTERN;

public class FileName implements FileValidator {

    private boolean fileNameIsSafe = false;

    @Override
    public boolean isSafe(MultipartFile multipartFile) {
        validate(multipartFile);

        return fileNameIsSafe;
    }

    private void validate(MultipartFile multipartFile) {
        if (!multipartFile.isEmpty() && validFileNameLength(multipartFile) == true && validFileNameText(multipartFile) == true) {
            fileNameIsSafe = true;
        }
    }

    private boolean validFileNameLength(MultipartFile multipartFile) {
        boolean valid = false;

        if (multipartFile.getOriginalFilename().length() <= 50 && !multipartFile.getOriginalFilename().isEmpty()) {
            valid = true;
        }
        return valid;
    }

    private boolean validFileNameText(MultipartFile multipartFile) {
        boolean valid = false;
        if(Pattern.matches(INPUT_VALIDATION_PATTERN, multipartFile.getOriginalFilename())) {
            valid = true;
        }
        return valid;
    }



}
