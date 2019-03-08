package service;

import org.springframework.web.multipart.MultipartFile;
import validator.FileValidator;
import validator.impl.*;

public class SecureFileUploadService {
    private MultipartFile multipart;
    private FileValidator validator;
    boolean isBodySafe = false, isContentTypeSafe = false, isExtensionSafe = false, isNameSafe = false, isSizeSafe = false;

    public SecureFileUploadService(MultipartFile multipart) {
        this.multipart = multipart;
    }

    public boolean validateIfSafe(MultipartFile multipart) {

        boolean valid = false;

        validator = new FileBody();
        isBodySafe = validator.isSafe(multipart);

        validator = new FileContentType();
        isContentTypeSafe = validator.isSafe(multipart);

        validator = new FileExtension();
        isExtensionSafe = validator.isSafe(multipart);

        validator = new FileName();
        isNameSafe = validator.isSafe(multipart);

        validator = new FileSize();
        isSizeSafe = validator.isSafe(multipart);


        if(isBodySafe == true && isContentTypeSafe == true && isExtensionSafe == true && isNameSafe == true && isSizeSafe == true) {
            valid = true;
        }

        return valid;
    }

    public void setMultipart(MultipartFile multipart) {
        this.multipart = multipart;
    }
}
