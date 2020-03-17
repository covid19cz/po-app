package cz.covid.model.jpa;

import cz.covid.model.jpa.cb.Comorbidity;
import cz.covid.model.jpa.cb.Gender;
import cz.covid.model.jpa.cb.Nationality;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "PERSON")
public class Person extends Meta {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "AGE")
    private Integer age;

    @ManyToOne
    @JoinColumn(name = "GENDER_ID")
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "NATIONALITY_ID")
    private Nationality nationality;

    @Column(name = "DISEASE_CONFIDENCE", precision = 5, scale = 4)
    private BigDecimal diseaseConfidence;

    @Column(name = "IN_QUARANTINE")
    @Type(type = "yes_no")
    private boolean inQuarantine;

    @Column(name = "EVENT_SOURCE_ID")
    private String eventSourceId;

    @Column(name = "LOCATIONS_ID")
    private String locationsId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "PERSON_ID")
    private List<Symptom> symptoms;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "PERSON_ID")
    private List<Comorbidity> comorbidities;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consent> signedConsents;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "PERSON_ID")
    private List<Test> tests;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "PERSON_ID")
    private List<Test> riskyAreaVisits;

    @ElementCollection
    @MapKeyColumn(name = "KEY")
    @Column(name = "VALUE")
    @CollectionTable(name = "PERSON_OTHER_DATA", joinColumns = @JoinColumn(name = "PERSON_ID"))
    private Map<String, String> otherData = new HashMap<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public BigDecimal getDiseaseConfidence() {
        return diseaseConfidence;
    }

    public void setDiseaseConfidence(BigDecimal diseaseConfidence) {
        this.diseaseConfidence = diseaseConfidence;
    }

    public boolean isInQuarantine() {
        return inQuarantine;
    }

    public void setInQuarantine(boolean inQuarantine) {
        this.inQuarantine = inQuarantine;
    }

    public String getEventSourceId() {
        return eventSourceId;
    }

    public void setEventSourceId(String eventSourceId) {
        this.eventSourceId = eventSourceId;
    }

    public String getLocationsId() {
        return locationsId;
    }

    public void setLocationsId(String locationsId) {
        this.locationsId = locationsId;
    }

    public List<Symptom> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<Symptom> symptoms) {
        this.symptoms = symptoms;
    }

    public List<Comorbidity> getComorbidities() {
        return comorbidities;
    }

    public void setComorbidities(List<Comorbidity> comorbidities) {
        this.comorbidities = comorbidities;
    }

    public List<Consent> getSignedConsents() {
        return signedConsents;
    }

    public void setSignedConsents(List<Consent> signedConsents) {
        this.signedConsents = signedConsents;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    public List<Test> getRiskyAreaVisits() {
        return riskyAreaVisits;
    }

    public void setRiskyAreaVisits(List<Test> riskyAreaVisits) {
        this.riskyAreaVisits = riskyAreaVisits;
    }

    public Map<String, String> getOtherData() {
        return otherData;
    }

    public void setOtherData(Map<String, String> otherData) {
        this.otherData = otherData;
    }
}
