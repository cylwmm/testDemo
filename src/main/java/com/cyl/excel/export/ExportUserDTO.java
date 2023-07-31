package com.cyl.excel.export;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExportUserDTO {
    @ExcelProperty(value = "id", index = 0)
    private String id;
    @ExcelProperty(value = "name", index = 1)
    private String name;
    @ExcelProperty(value = "age", index = 2)
    private String age;
    @ExcelProperty(value = "departmentId", index = 3)
    private String departmentId;
}
