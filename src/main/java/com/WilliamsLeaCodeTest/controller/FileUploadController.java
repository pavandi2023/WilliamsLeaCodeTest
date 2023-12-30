package com.WilliamsLeaCodeTest.controller;

import com.WilliamsLeaCodeTest.entity.CompanyRecord;
import com.WilliamsLeaCodeTest.service.CompanyRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Slf4j
@RestController
@RequestMapping("/api/company")
public class FileUploadController {

    private final CompanyRecordService companyRecordService;

    @Autowired
    public FileUploadController(CompanyRecordService companyRecordService) {
        this.companyRecordService = companyRecordService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            CompanyRecord processedRecord = companyRecordService.processFile(file);
            log.info("File uploaded successfully and processed: {}", processedRecord);

            return new ResponseEntity<>("File uploaded successfully", HttpStatus.OK);
        } catch (IOException e) {
            log.error("Error processing the uploaded file: {}", e.getMessage());
            return new ResponseEntity<>("Error processing the uploaded file", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
