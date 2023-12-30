package com.WilliamsLeaCodeTest.service.impl;

import com.WilliamsLeaCodeTest.entity.EventType;
import com.WilliamsLeaCodeTest.exception.InvalidFileException;
import com.WilliamsLeaCodeTest.repository.CompanyRecordRepository;
import com.WilliamsLeaCodeTest.entity.CompanyRecord;
import com.WilliamsLeaCodeTest.service.CompanyRecordService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class CompanyRecordServiceImpl implements CompanyRecordService {

    private final CompanyRecordRepository companyRecordRepository;

    @Autowired
    public CompanyRecordServiceImpl(CompanyRecordRepository companyRecordRepository) {
        this.companyRecordRepository = companyRecordRepository;
    }

    @Override
    public CompanyRecord addRecord(CompanyRecord companyRecord) {
        log.info("adding company records to the database...");
        return companyRecordRepository.save(companyRecord);
    }

    @Override
    public CompanyRecord processFile(MultipartFile file) {
        log.info("processing file...");
        validateFileType(file);

        List<String> lines = readLinesFromFile(file);
        CompanyRecord currentCompanyRecord = null;

        for (String line : lines) {
            if (line.trim().isEmpty()) {
                continue;
            }

            if (currentCompanyRecord == null) {
                currentCompanyRecord = new CompanyRecord();
            }

            if (line.toUpperCase().contains("LTD")) {
                processCompanyNameLine(line, currentCompanyRecord);
            } else if (isNumeric(line.trim())) {
                processCompanyNumberLine(line, currentCompanyRecord);
            } else if (line.matches("\".*\"")) {
                processEventTypeLine(line, currentCompanyRecord);
            } else if (isValidDate(line.trim())) {
                processEventDateLine(line, currentCompanyRecord);
                addRecord(currentCompanyRecord);
                currentCompanyRecord = null;
            }
        }

        return currentCompanyRecord;
    }

    private void validateFileType(MultipartFile file) {
        if (!file.getOriginalFilename().toLowerCase().endsWith(".txt")) {
            log.warn("not .txt file...");
            throw new InvalidFileException("Invalid file type. Please upload a .txt file.");
        }
    }

    private List<String> readLinesFromFile(MultipartFile file) {
        try {
            log.info("reading the file by line...");
            return IOUtils.readLines(file.getInputStream(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            log.warn("error while reading line in file...");
            throw new RuntimeException("Error reading lines from the file: " + e.getMessage(), e);
        }
    }

    private void processCompanyNameLine(String line, CompanyRecord currentCompanyRecord) {
        log.info("set company name and UUID ...");
        currentCompanyRecord.setCompanyName(line.trim());
        currentCompanyRecord.setUniqueIdentifier(UUID.randomUUID().toString());
    }

    private void processCompanyNumberLine(String line, CompanyRecord currentCompanyRecord) {
        log.info("setting company no...");
        currentCompanyRecord.setCompanyNumber(line.trim());
    }

    private void processEventTypeLine(String line, CompanyRecord currentCompanyRecord) {
        log.info("setting event type code...");
        String eventType = extractEventType(line);
        String eventCode = getEventTypeCodeByDescription(eventType);
        currentCompanyRecord.setEventType(eventCode);
    }

    private void processEventDateLine(String line, CompanyRecord currentCompanyRecord) {
        log.info("setting event date...");
        currentCompanyRecord.setEventDate(line.trim());
    }

    private String extractEventType(String line) {
        log.info("extracting event type line...");
        // Assuming the event type is enclosed in double quotes
        return line.replaceAll(".*\"(.*?)\".*", "$1");
    }

    private String getEventTypeCodeByDescription(String description) {
        log.info("getting event code by event type line...");
        for (EventType eventType : EventType.values()) {
            if (eventType.getDescription().equals(description)) {
                return eventType.name();
            }
        }
        return "Unknown Event Type";
    }

    private boolean isNumeric(String str) {
        log.info("string numeric check...");
        return str.matches("\\d+");
    }

    private boolean isValidDate(String str) {
        log.info("date checking...");
        // Assuming the format is MM/dd/yyyy
        return str.matches("\\d{2}/\\d{2}/\\d{4}");
    }
}
