package com.WilliamsLeaCodeTest.repository;

import com.WilliamsLeaCodeTest.entity.CompanyRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRecordRepository extends JpaRepository<CompanyRecord, Long> {
}
