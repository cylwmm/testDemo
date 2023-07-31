package com.cyl.excel.upload;

import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
public interface ParseExcelInterface<T> {
    List<ImportDataRow<T>> parseExcel(InputStream inputStream);
}
