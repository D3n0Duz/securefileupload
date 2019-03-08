package validator.impl;

import org.apache.commons.io.FilenameUtils;
import validator.FileValidator;
import org.springframework.web.multipart.MultipartFile;

import static constants.Formats.ALLOWED_FILE_FORMATS;

public class FileExtension implements FileValidator {

    private boolean fileExtensionIsSafe = false;

    @Override
    public boolean isSafe(MultipartFile multipartFile) {
        validate(multipartFile);

        return fileExtensionIsSafe;
    }

    private void validate(MultipartFile multipartFile) {
        if (!multipartFile.isEmpty() && validFileExtensionsOccurrence(multipartFile) == true && validFileExtensions(multipartFile) == true) {
            fileExtensionIsSafe = true;
        }
    }

    private boolean validFileExtensions(MultipartFile multipartFile) {
        boolean valid = false;

        for(String fileFormat : ALLOWED_FILE_FORMATS) {
            if(FilenameUtils.getExtension(multipartFile.getOriginalFilename()).equals(fileFormat)){
                valid = true;
            }
        }

        return valid;
    }

    private boolean validFileExtensionsOccurrence(MultipartFile multipartFile) {
        boolean valid = false;
        char containsChar = '.';
        int count = 0;

        for (int i = 0; i < multipartFile.getOriginalFilename().length(); i++) {
            if (multipartFile.getOriginalFilename().charAt(i) == containsChar) {
                count++;
            }
        }

        if (count == 1) {
            valid = true;
        }

        return valid;
    }

}
