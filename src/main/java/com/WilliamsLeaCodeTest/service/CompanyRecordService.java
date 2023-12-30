package com.WilliamsLeaCodeTest.service;

import com.WilliamsLeaCodeTest.entity.CompanyRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CompanyRecordService {
    CompanyRecord addRecord(CompanyRecord companyRecord);

    public CompanyRecord processFile(MultipartFile file) throws IOException;
}
