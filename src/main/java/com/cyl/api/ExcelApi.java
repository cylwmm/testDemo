package com.cyl.api;

import com.cyl.excel.upload.DataImportMonitor;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping("/excel")
@RestController
public interface ExcelApi {
    @PostMapping("/import")
    void importUser(MultipartFile file, DataImportMonitor monitor) throws IOException;

    @GetMapping("/export")
    void exportUser(@Param("path") String path);
}
