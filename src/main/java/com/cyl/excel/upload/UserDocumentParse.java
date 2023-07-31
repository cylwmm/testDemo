package com.cyl.excel.upload;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.support.ExcelTypeEnum;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
@AllArgsConstructor
public class UserDocumentParse implements ParseExcelInterface<ImportUserDto> {
    @Override
    public List<ImportDataRow<ImportUserDto>> parseExcel(InputStream inputStream) {
        ReadAllListen<ImportUserDto> readAllListen = new ReadAllListen<>();
        try {
            EasyExcelFactory.read(inputStream, ImportUserDto.class, readAllListen)
                    .excelType(ExcelTypeEnum.XLSX)
                    .autoCloseStream(true)
                    .ignoreEmptyRow(true)
                    .autoTrim(true)
                    .sheet(0)
                    .headRowNumber(1)
                    .doRead();
        } catch (Exception e) {
            System.out.println("error");
        }
        return readAllListen.getAllRow();
    }
}
