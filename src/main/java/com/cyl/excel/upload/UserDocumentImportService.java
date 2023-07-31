package com.cyl.excel.upload;

import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public interface UserDocumentImportService {
    void importUser(InputStream inputStream, DataImportMonitor monitor);
}
