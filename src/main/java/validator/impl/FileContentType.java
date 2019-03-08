package validator.impl;

import validator.FileValidator;
import org.springframework.web.multipart.MultipartFile;

import static constants.Formats.ALLOWED_CONTENT_TYPE_FORMATS;

public class FileContentType implements FileValidator {
    private boolean fileContentTypeIsSafe = false;

    @Override
    public boolean isSafe(MultipartFile multipartFile) {
        validate(multipartFile);

        return fileContentTypeIsSafe;
    }

    private void validate(MultipartFile multipartFile) {
        if (!multipartFile.isEmpty() && validFileContentType(multipartFile) == true) {
            fileContentTypeIsSafe = true;
        }
    }

    private boolean validFileContentType(MultipartFile multipartFile) {
        boolean valid = false;

        for(String fileContentType : ALLOWED_CONTENT_TYPE_FORMATS) {
            if(multipartFile.getContentType().equals(fileContentType)){
                valid = true;
            }
        }

        return valid;
    }
}
