package com.cyl.excel.upload;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImportUserDto {
    @ExcelProperty("id")
    private String id;
    @ExcelProperty("name")
    private String name;
    @ExcelProperty("age")
    private String age;
    @ExcelProperty("departmentId")
    private String departmentId;
}
