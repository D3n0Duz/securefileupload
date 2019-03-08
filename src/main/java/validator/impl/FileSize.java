package validator.impl;

import validator.FileValidator;
import org.springframework.web.multipart.MultipartFile;

public class FileSize implements FileValidator {
    private boolean fileSizeIsSafe = false;

    @Override
    public boolean isSafe(MultipartFile multipartFile) {
        validate(multipartFile);

        return fileSizeIsSafe;
    }

    private void validate(MultipartFile multipartFile) {
        if (!multipartFile.isEmpty() && validFileSize(multipartFile) == true) {
            fileSizeIsSafe = true;
        }
    }

    private boolean validFileSize(MultipartFile multipartFile) {
        boolean valid = false;
        long maxSize = 5242880; //5MB

        if (multipartFile.getSize() >= maxSize) {
            valid = true;
        }

        return valid;
    }
}
