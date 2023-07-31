package com.cyl.excel.export;

import org.springframework.stereotype.Component;

@Component
public interface ExportUser {
    void export(String path);
}
