package com.cyl.excel.upload;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class UserDocumentImportServiceImpl implements UserDocumentImportService {
    @Value("${data-import.batch-size: 100}")
    private int batch;
    @Autowired
    private UserDocumentParse userDocumentParse;

    @Override
    public void importUser(InputStream inputStream, DataImportMonitor monitor) {
        List<ImportDataRow<ImportUserDto>> exportUserDtos = userDocumentParse.parseExcel(inputStream);
        if (exportUserDtos.isEmpty()) {
            monitor.nonDataReceived();
            return;
        }
        Lists.partition(exportUserDtos, batch).forEach(batch -> {
            try {
                importForBatch(batch, monitor);
            } catch (Exception e) {
               monitor.failedForBatch(batch, ImportUserDto::getId, e);
            }
        });
        monitor.logImportedCount();
    }

    private void importForBatch(List<ImportDataRow<ImportUserDto>> dataRowList, DataImportMonitor monitor) {
        dataRowList.forEach(row -> {
            monitor.processRow(row.getData().getId(), row.getRawRowNumber());
            try {
                valid();
                monitor.succeeded(row.getData().getId(), row.getRawRowNumber());
            } catch (Exception e) {
                monitor.failed(row.getData().getId(), row.getRawRowNumber(), e);
            }
        });
        save();
    }

    private void save() {
        System.out.println("保存数据库！！");
    }

    private void valid() {
        System.out.println("校验数据！！");
    }

}
