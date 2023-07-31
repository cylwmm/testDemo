package com.cyl.excel.upload;

import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotBlank;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

@Slf4j
public class DataImportMonitor {
    private final AtomicInteger succeeded = new AtomicInteger(0);
    private final AtomicInteger failed = new AtomicInteger(0);
    private LocalDateTime startTime;

    public void startImport() {
        startTime = LocalDateTime.now();
    }

    public void finishImport() {
        Duration duration = Duration.between(startTime, LocalDateTime.now());
        log.info("Import finished. Duration: {}h{}m{}s",
                duration.toHoursPart(), duration.toMinutesPart(), duration.toSecondsPart());
    }

    public void succeeded(String code, Integer rowNumber) {
        log.info("Succeed for code {}, row {}", code, rowNumber);
        this.succeeded.incrementAndGet();
    }

    public void failed(@NotBlank String code, Integer rawRowNumber, Exception e) {
        log.warn("Failed for code {}, row {}: {}", code, rawRowNumber, e.getMessage(), e);
        this.failed.incrementAndGet();
    }

    public void logImportedCount() {
        log.info("{} documents succeeded", this.succeeded.get());
        log.info("{} documents failed", this.failed.get());
    }

    public void nonDataReceived() {
        log.warn("Empty excel file");
    }

    public void processRow(String code, Integer rawRowNumber) {
        log.info("Started for code {}, row {}", code, rawRowNumber);
    }

    public <T> void failedForBatch(List<ImportDataRow<T>> batchRows, Function<T, String> getCodeFunction, Exception e) {
        for (ImportDataRow<T> row : batchRows) {
            log.warn("Failed for code {}, row {}: {}", getCodeFunction.apply(row.getData()), row.getRawRowNumber(), e.getMessage(), e);
        }
    }

    public void validationFailed(String code, Integer rowNumber, String errorMessage) {
        log.error("Validation failed for code {}, row {}: {}", code, rowNumber, errorMessage);
        this.failed.incrementAndGet();
    }
}
