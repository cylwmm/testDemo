package com.cyl.excel.upload;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

@Getter
@AllArgsConstructor(staticName = "of")
public class ImportDataRow<T> {
    private final Integer rawRowNumber;

    private final T data;

    public static <T> List<ImportDataRow<T>> from(List<T> allData, Integer lineNumberOffset) {
        List<ImportDataRow<T>> dataRowList = new LinkedList<>();
        for (int i = 0; i < allData.size(); i++) {
            dataRowList.add(ImportDataRow.of(lineNumberOffset + i + 1, allData.get(i)));
        }
        return dataRowList;
    }
}
