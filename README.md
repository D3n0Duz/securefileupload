# Secure File Upload Java Module
Java base module for securing file uploads.

#### How to use it

1) Copy the install-non-maven-dependencies.sh script in your file upload parent project.
```
/bin/bash install-non-maven-dependencies.sh
```

2) Import it in the pom.xml of your file upload parent project.
```
<dependency>
  <groupId>application.security</groupId>
  <artifactId>securefileupload</artifactId>
  <version>0.0.0.1-SNAPSHOT</version>
  <scope>compile</scope>
</dependency>
```

3) Validate if the uploaded file is safe or not.
```
MultipartFile file;
SecureFileUploadService fileSecurityCheck = new SecureFileUploadService(file);
if(fileSecurityCheck.validateIfSafe(file) == true) {
  // Secure
} else {
  // Not secure
}
```

#### Credits
Highly inspired from the work of https://github.com/righettod/document-upload-protection. :+1:
