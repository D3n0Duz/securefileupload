# Secure File Upload Java Module
Java base module for securing file uploads

#### How to use it

1) Import it in the pom.xml of your file upload project
```
<dependency>
  <groupId>application.security</groupId>
  <artifactId>securefileupload</artifactId>
  <version>0.0.0.1-SNAPSHOT</version>
  <scope>compile</scope>
</dependency>
```

2) Validate if the uploaded file is safe
```
MultipartFile file;
SecureFileUploadService fileSecurityCheck = new SecureFileUploadService(file);
if(fileSecurityCheck.validateIfSafe(file) == true) {
  // Secure
} else {
  // Not secure
}
```
