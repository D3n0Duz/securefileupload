package validator;

import org.springframework.web.multipart.MultipartFile;

public interface FileValidator {
    boolean isSafe(MultipartFile f);
}
