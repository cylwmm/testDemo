package com.cyl.excel.export;

import com.alibaba.excel.EasyExcel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExportUserImpl implements ExportUser {
    @Override
    public void export(String path) {
        String fileName = path + ".xlsx";
        EasyExcel.write(fileName, ExportUser.class).sheet("sheet1").doWrite(data());
    }

    private List<ExportUserDTO> data() {
        ExportUserDTO userDTO = ExportUserDTO.builder().id("1").name("张三").age("22").departmentId("1").build();
        return List.of(userDTO);
    }
}
