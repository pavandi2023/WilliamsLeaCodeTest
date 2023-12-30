package com.WilliamsLeaCodeTest.entity;

public enum EventType {
    A("CERTIFICATES OF INCORPORATION"),
    B1("THE COMPANY'S MEMORANDUM AND ARTICLES."),
    B2("ANY AMENDMENT TO COMPANY'S ARTICLES (INCLUDING EVERY RESOLUTION OR AGREEMENT REQUIRED TO BE EMBODIED IN OR ANNEXED TO COPIES OF THE COMPANY'S ARTICLES ISSUED BY THE COMPANY)."),
    B3("AFTER ANY AMENDMENT OF THE COMPANY'S ARTICLES, THE TEXT OF THE ARTICLES AS AMENDED."),
    B4("ANY NOTICE OF A CHANGE OF COMPANY'S NAME."),
    C1("THE STATEMENT OF PROPOSED OFFICERS REQUIRED ON FORMATION OF THE COMPANY."),
    C2("NOTIFICATION OF ANY CHANGE AMONG THE COMPANY'S DIRECTORS."),
    C3("NOTIFICATION OF ANY CHANGE IN THE PARTICULARS OF DIRECTORS REQUIRED TO BE DELIVERED TO THE REGISTRAR."),
    D1("ALL DOCUMENTS REQUIRED TO BE DELIVERED TO THE REGISTRAR UNDER SECTION 441 (ANNUAL ACCOUNTS AND REPORTS)."),
    D2("THE COMPANY'S ANNUAL RETURN."),
    D3("ALL DOCUMENTS DELIVERED TO THE REGISTRAR UNDER SECTIONS 394A(2)(E), 448A(2)(E) AND 479A(2)(E) (QUALIFYING SUBSIDIARY COMPANIES: CONDITIONS FOR EXEMPTION FROM THE PREPARATION, FILING AND AUDIT OF ACCOUNTS)."),
    D4("THE COMPANY'S CONFIRMATION STATEMENT."),
    E1("NOTIFICATION OF ANY CHANGE OF THE COMPANY'S REGISTERED OFFICE."),
    F1("COPY OF ANY WINDING-UP ORDER IN RESPECT OF THE COMPANY."),
    F2("NOTICE OF THE APPOINTMENT OF LIQUIDATORS."),
    F3("ORDER FOR THE DISSOLUTION OF A COMPANY ON A WINDING UP."),
    F4("RETURN BY LIQUIDATOR OF THE FINAL MEETING OF A COMPANY ON A WINDING UP."),
    G1("ANY STATEMENT OF CAPITAL AND INITIAL SHAREHOLDINGS."),
    G2("ANY RETURN OF ALLOTMENT AND THE STATEMENT OF CAPITAL ACCOMPANYING IT."),
    G3("COPY OF ANY RESOLUTION UNDER SECTION 570 OR 571 (DIS-APPLICATION OF PRE-EMPTION RIGHTS)."),
    G4("COPY OF ANY REPORT UNDER SECTION 593 OR 599 AS TO THE VALUE OF A NON-CASH ASSET."),
    G5("STATEMENT OF CAPITAL ACCOMPANYING NOTICE GIVEN UNDER SECTION 625 (NOTICE BY COMPANY OF REDENOMINATION OF SHARES)."),
    G6("STATEMENT OF CAPITAL ACCOMPANYING NOTICE GIVEN UNDER SECTION 627 (NOTICE BY COMPANY OF REDUCTION OF CAPITAL IN CONNECTION WITH REDENOMINATION OF SHARES)."),
    G7("NOTICE DELIVERED UNDER SECTION 636 (NOTICE OF NEW NAME OF CLASS OF SHARES) OR 637 (NOTICE OF VARIATION OF RIGHTS ATTACHED TO SHARES)."),
    G8("STATEMENT OF CAPITAL ACCOMPANYING ORDER DELIVERED UNDER SECTION 649 (ORDER OF COURT CONFIRMING REDUCTION OF CAPITAL) OR ACCOMPANYING ORDER OF COURT TO CANCEL SHARE WARRANTS UNDER SCHEDULE 4 OF SBEE ACT 2015."),
    G9("NOTIFICATION (UNDER SECTION 689) OF THE REDEMPTION OF SHARES AND THE STATEMENT OF CAPITAL ACCOMPANYING IT."),
    G10("STATEMENT OF CAPITAL ACCOMPANYING RETURN DELIVERED UNDER SECTION 708 (NOTICE OF CANCELLATION OF SHARES ON PURCHASE OF OWN SHARES) OR 730 (NOTICE OF CANCELLATION OF SHARES HELD AS TREASURY SHARES)."),
    G11("ANY STATEMENT OF COMPLIANCE DELIVERED UNDER SECTION 762 (STATEMENT THAT COMPANY MEETS CONDITIONS FOR ISSUE OF TRADING CERTIFICATE)."),
    H1("COPY OF ANY DRAFT OF THE TERMS OF A SCHEME REQUIRED TO BE DELIVERED TO THE REGISTRAR UNDER SECTION 906 OR 921."),
    H2("COPY OF ANY ORDER UNDER SECTION 899 OR 900 IN RESPECT OF A COMPROMISE OR ARRANGEMENT TO WHICH PART 27 (MERGERS AND DIVISIONS OF PUBLIC COMPANIES) APPLIES."),
    J1("THE LAST STATEMENT OF CAPITAL RELATING TO THE COMPANY RECEIVED BY THE REGISTRAR UNDER ANY PROVISION OF THE COMPANIES ACTS."),
    K1("ANY RETURN DELIVERED UNDER REGULATION 4 (DUTY TO REGISTER PARTICULARS), REGULATION 12 (DUTY TO REGISTER ALTERATIONS) AND REGULATION 14 (STATEMENT AS TO CERTIFIED COPY OF COMPANY'S CONSTITUTION)."),
    K2("ANY DOCUMENT DELIVERED UNDER REGULATION 8, 12 OR 14."),
    K3("ANY DOCUMENTS DELIVERED UNDER PART 4 (DELIVERY OF ACCOUNTS AND REPORTS BY COMPANIES THAT ARE NOT RELEVANT CREDIT OR FINANCIAL INSTITUTIONS). OR ANY DOCUMENTS DELIVERED UNDER PART 5 (DELIVERY OF ACCOUNTS AND REPORTS BY RELEVANT CREDIT OR FINANCIAL INSTITUTIONS)."),
    K4("ANY RETURN DELIVERED UNDER REGULATION 56 (PARTICULARS TO BE DELIVERED TO THE REGISTRAR ON A WINDING UP)."),
    K5("ANY NOTICE UNDER REGULATION 75 (DUTY TO GIVE NOTICE OF CLOSURE OF UK ESTABLISHMENT)."),
    L1("NOTICE IS HEREBY GIVEN, PURSUANT TO SECTION 1031 OF THE COMPANIES ACT 2006, THAT THE COMPANIES LISTED HEREUNDER HAVE BEEN RESTORED BY COURT ORDER TO THE REGISTER OF COMPANIES."),
    L2("NOTICE IS HEREBY GIVEN, PURSUANT TO SECTION 1027 OF THE COMPANIES ACT 2006, THAT THE COMPANIES LISTED HEREUNDER HAVE BEEN ADMINISTRATIVELY RESTORED TO THE REGISTER OF COMPANIES.");

    private final String description;

    EventType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static String getDescriptionByCode(String code) {
        for (EventType eventType : EventType.values()) {
            if (eventType.name().equals(code)) {
                return eventType.getDescription();
            }
        }
        return "Unknown Event Type";
    }
}