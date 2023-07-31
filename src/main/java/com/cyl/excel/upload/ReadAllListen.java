package com.cyl.excel.upload;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;

import java.util.ArrayList;
import java.util.List;

public class ReadAllListen<T> implements ReadListener<T> {
    List<T> list = new ArrayList<>();

    @Override
    public void invoke(T data, AnalysisContext context) {
        list.add(data);
    }
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
    }

    public List<ImportDataRow<T>> getAllRow() {
        return ImportDataRow.from(list, 0);
    }
}
