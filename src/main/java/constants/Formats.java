package constants;

import java.util.Arrays;
import java.util.List;

public final class Formats {
    public static final List<String> ALLOWED_FILE_FORMATS = Arrays.asList(new String[] { "doc", "docx", "pdf", "jpeg", "jpg", "png" });
    public static final List<String> ALLOWED_CONTENT_TYPE_FORMATS = Arrays.asList(new String[] { "application/msword", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", "application/pdf", "image/jpeg", "image/png" });
}
