package com.cyl.excel.upload;

import com.cyl.api.ExcelApi;
import com.cyl.excel.export.ExportUser;
import io.lettuce.core.dynamic.annotation.Param;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping
public class ExcelApiImpl implements ExcelApi {
    private final UserDocumentImportService userDocumentImportService;

    private final ExportUser exportUser;
    @PostMapping("/excel/import")
    @Override
    public void importUser(MultipartFile file, DataImportMonitor monitor) throws IOException {
        monitor.startImport();
        userDocumentImportService.importUser(file.getInputStream(), monitor);
        monitor.finishImport();
    }

    @GetMapping("/excel/export")
    @Override
    public void exportUser(@Param("path") String path) {
        exportUser.export(path);
    }
}
