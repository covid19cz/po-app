package cz.covid.model.jpa;

import cz.covid.model.jpa.cb.Organization;
import cz.covid.model.jpa.cb.TestResult;
import cz.covid.model.jpa.cb.TestType;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "TEST")
public class Test extends Meta {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "TEST_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date testDate;

    @Column(name = "PATIENT_INFORMED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date patientInformedDate;

    @ManyToOne
    @JoinColumn(name = "TEST_TYPE_ID")
    private TestType testType;

    @ManyToOne
    @JoinColumn(name = "TEST_RESULT_ID")
    private TestResult testResult;

    @ElementCollection
    @MapKeyColumn(name = "KEY")
    @Column(name = "VALUE")
    @CollectionTable(name = "TEST_RESULT_DETAIL_DATA", joinColumns = @JoinColumn(name = "TEST_ID"))
    private Map<String, String> testResultData = new HashMap<>();

    @ManyToOne
    @JoinColumn(name = "ORGANIZATION_ID")
    private Organization organization;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public Date getPatientInformedDate() {
        return patientInformedDate;
    }

    public void setPatientInformedDate(Date patientInformedDate) {
        this.patientInformedDate = patientInformedDate;
    }

    public TestType getTestType() {
        return testType;
    }

    public void setTestType(TestType testType) {
        this.testType = testType;
    }

    public TestResult getTestResult() {
        return testResult;
    }

    public void setTestResult(TestResult testResult) {
        this.testResult = testResult;
    }

    public Map<String, String> getTestResultData() {
        return testResultData;
    }

    public void setTestResultData(Map<String, String> testResultData) {
        this.testResultData = testResultData;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
