package com.WilliamsLeaCodeTest.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "company_records")
public class CompanyRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_name", length = 255, nullable = false)
    private String companyName;

    @Column(name = "company_number", length = 20,nullable = false)
    private String companyNumber;

    @Column(name = "event_type", length = 50,nullable = false)
    private String eventType;

    @Column(name = "event_date", length =10,nullable = false)
    private String eventDate;

    @Column(name = "unique_identifier", length = 36, nullable = false)
    private String uniqueIdentifier;
}
