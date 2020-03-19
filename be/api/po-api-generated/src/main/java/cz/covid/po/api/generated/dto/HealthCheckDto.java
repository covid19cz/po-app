package cz.covid.po.api.generated.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import cz.covid.po.api.generated.dto.CodebookItemDto;
import cz.covid.po.api.generated.dto.HealthCheckResultDto;
import cz.covid.po.api.generated.dto.SymptomEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * HealthCheckDto
 */
@Validated

public class HealthCheckDto   {
  @JsonProperty("symtompsSince")
  private LocalDate symtompsSince = null;

  @JsonProperty("highTemperatureDuration")
  private SymptomEnum highTemperatureDuration = null;

  @JsonProperty("dryCoughDuration")
  private SymptomEnum dryCoughDuration = null;

  @JsonProperty("headache")
  private Boolean headache = null;

  @JsonProperty("infectedInContact")
  private String infectedInContact = null;

  @JsonProperty("infectedInContactDate")
  private LocalDate infectedInContactDate = null;

  @JsonProperty("infectedPhoneNumbers")
  private String infectedPhoneNumbers = null;

  @JsonProperty("preferredHealthCheckLocation")
  private CodebookItemDto preferredHealthCheckLocation = null;

  @JsonProperty("ableToDrive")
  private Boolean ableToDrive = null;

  @JsonProperty("healthCheckCode")
  private String healthCheckCode = null;

  @JsonProperty("healthCheckType")
  private CodebookItemDto healthCheckType = null;

  @JsonProperty("finalHealthCheckLocation")
  private CodebookItemDto finalHealthCheckLocation = null;

  @JsonProperty("healthCheckResults")
  @Valid
  private List<HealthCheckResultDto> healthCheckResults = null;

  @JsonProperty("visitedRiskArea")
  private CodebookItemDto visitedRiskArea = null;

  public HealthCheckDto symtompsSince(LocalDate symtompsSince) {
    this.symtompsSince = symtompsSince;
    return this;
  }

  /**
   * Get symtompsSince
   * @return symtompsSince
  **/
  @ApiModelProperty(value = "")

  @Valid

  public LocalDate getSymtompsSince() {
    return symtompsSince;
  }

  public void setSymtompsSince(LocalDate symtompsSince) {
    this.symtompsSince = symtompsSince;
  }

  public HealthCheckDto highTemperatureDuration(SymptomEnum highTemperatureDuration) {
    this.highTemperatureDuration = highTemperatureDuration;
    return this;
  }

  /**
   * Get highTemperatureDuration
   * @return highTemperatureDuration
  **/
  @ApiModelProperty(value = "")

  @Valid

  public SymptomEnum getHighTemperatureDuration() {
    return highTemperatureDuration;
  }

  public void setHighTemperatureDuration(SymptomEnum highTemperatureDuration) {
    this.highTemperatureDuration = highTemperatureDuration;
  }

  public HealthCheckDto dryCoughDuration(SymptomEnum dryCoughDuration) {
    this.dryCoughDuration = dryCoughDuration;
    return this;
  }

  /**
   * Get dryCoughDuration
   * @return dryCoughDuration
  **/
  @ApiModelProperty(value = "")

  @Valid

  public SymptomEnum getDryCoughDuration() {
    return dryCoughDuration;
  }

  public void setDryCoughDuration(SymptomEnum dryCoughDuration) {
    this.dryCoughDuration = dryCoughDuration;
  }

  public HealthCheckDto headache(Boolean headache) {
    this.headache = headache;
    return this;
  }

  /**
   * Get headache
   * @return headache
  **/
  @ApiModelProperty(value = "")


  public Boolean isHeadache() {
    return headache;
  }

  public void setHeadache(Boolean headache) {
    this.headache = headache;
  }

  public HealthCheckDto infectedInContact(String infectedInContact) {
    this.infectedInContact = infectedInContact;
    return this;
  }

  /**
   * Get infectedInContact
   * @return infectedInContact
  **/
  @ApiModelProperty(value = "")


  public String getInfectedInContact() {
    return infectedInContact;
  }

  public void setInfectedInContact(String infectedInContact) {
    this.infectedInContact = infectedInContact;
  }

  public HealthCheckDto infectedInContactDate(LocalDate infectedInContactDate) {
    this.infectedInContactDate = infectedInContactDate;
    return this;
  }

  /**
   * Get infectedInContactDate
   * @return infectedInContactDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public LocalDate getInfectedInContactDate() {
    return infectedInContactDate;
  }

  public void setInfectedInContactDate(LocalDate infectedInContactDate) {
    this.infectedInContactDate = infectedInContactDate;
  }

  public HealthCheckDto infectedPhoneNumbers(String infectedPhoneNumbers) {
    this.infectedPhoneNumbers = infectedPhoneNumbers;
    return this;
  }

  /**
   * Get infectedPhoneNumbers
   * @return infectedPhoneNumbers
  **/
  @ApiModelProperty(value = "")


  public String getInfectedPhoneNumbers() {
    return infectedPhoneNumbers;
  }

  public void setInfectedPhoneNumbers(String infectedPhoneNumbers) {
    this.infectedPhoneNumbers = infectedPhoneNumbers;
  }

  public HealthCheckDto preferredHealthCheckLocation(CodebookItemDto preferredHealthCheckLocation) {
    this.preferredHealthCheckLocation = preferredHealthCheckLocation;
    return this;
  }

  /**
   * Get preferredHealthCheckLocation
   * @return preferredHealthCheckLocation
  **/
  @ApiModelProperty(value = "")

  @Valid

  public CodebookItemDto getPreferredHealthCheckLocation() {
    return preferredHealthCheckLocation;
  }

  public void setPreferredHealthCheckLocation(CodebookItemDto preferredHealthCheckLocation) {
    this.preferredHealthCheckLocation = preferredHealthCheckLocation;
  }

  public HealthCheckDto ableToDrive(Boolean ableToDrive) {
    this.ableToDrive = ableToDrive;
    return this;
  }

  /**
   * Get ableToDrive
   * @return ableToDrive
  **/
  @ApiModelProperty(value = "")


  public Boolean isAbleToDrive() {
    return ableToDrive;
  }

  public void setAbleToDrive(Boolean ableToDrive) {
    this.ableToDrive = ableToDrive;
  }

  public HealthCheckDto healthCheckCode(String healthCheckCode) {
    this.healthCheckCode = healthCheckCode;
    return this;
  }

  /**
   * Get healthCheckCode
   * @return healthCheckCode
  **/
  @ApiModelProperty(value = "")


  public String getHealthCheckCode() {
    return healthCheckCode;
  }

  public void setHealthCheckCode(String healthCheckCode) {
    this.healthCheckCode = healthCheckCode;
  }

  public HealthCheckDto healthCheckType(CodebookItemDto healthCheckType) {
    this.healthCheckType = healthCheckType;
    return this;
  }

  /**
   * Get healthCheckType
   * @return healthCheckType
  **/
  @ApiModelProperty(value = "")

  @Valid

  public CodebookItemDto getHealthCheckType() {
    return healthCheckType;
  }

  public void setHealthCheckType(CodebookItemDto healthCheckType) {
    this.healthCheckType = healthCheckType;
  }

  public HealthCheckDto finalHealthCheckLocation(CodebookItemDto finalHealthCheckLocation) {
    this.finalHealthCheckLocation = finalHealthCheckLocation;
    return this;
  }

  /**
   * Get finalHealthCheckLocation
   * @return finalHealthCheckLocation
  **/
  @ApiModelProperty(value = "")

  @Valid

  public CodebookItemDto getFinalHealthCheckLocation() {
    return finalHealthCheckLocation;
  }

  public void setFinalHealthCheckLocation(CodebookItemDto finalHealthCheckLocation) {
    this.finalHealthCheckLocation = finalHealthCheckLocation;
  }

  public HealthCheckDto healthCheckResults(List<HealthCheckResultDto> healthCheckResults) {
    this.healthCheckResults = healthCheckResults;
    return this;
  }

  public HealthCheckDto addHealthCheckResultsItem(HealthCheckResultDto healthCheckResultsItem) {
    if (this.healthCheckResults == null) {
      this.healthCheckResults = new ArrayList<>();
    }
    this.healthCheckResults.add(healthCheckResultsItem);
    return this;
  }

  /**
   * Get healthCheckResults
   * @return healthCheckResults
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<HealthCheckResultDto> getHealthCheckResults() {
    return healthCheckResults;
  }

  public void setHealthCheckResults(List<HealthCheckResultDto> healthCheckResults) {
    this.healthCheckResults = healthCheckResults;
  }

  public HealthCheckDto visitedRiskArea(CodebookItemDto visitedRiskArea) {
    this.visitedRiskArea = visitedRiskArea;
    return this;
  }

  /**
   * Get visitedRiskArea
   * @return visitedRiskArea
  **/
  @ApiModelProperty(value = "")

  @Valid

  public CodebookItemDto getVisitedRiskArea() {
    return visitedRiskArea;
  }

  public void setVisitedRiskArea(CodebookItemDto visitedRiskArea) {
    this.visitedRiskArea = visitedRiskArea;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HealthCheckDto healthCheckDto = (HealthCheckDto) o;
    return Objects.equals(this.symtompsSince, healthCheckDto.symtompsSince) &&
        Objects.equals(this.highTemperatureDuration, healthCheckDto.highTemperatureDuration) &&
        Objects.equals(this.dryCoughDuration, healthCheckDto.dryCoughDuration) &&
        Objects.equals(this.headache, healthCheckDto.headache) &&
        Objects.equals(this.infectedInContact, healthCheckDto.infectedInContact) &&
        Objects.equals(this.infectedInContactDate, healthCheckDto.infectedInContactDate) &&
        Objects.equals(this.infectedPhoneNumbers, healthCheckDto.infectedPhoneNumbers) &&
        Objects.equals(this.preferredHealthCheckLocation, healthCheckDto.preferredHealthCheckLocation) &&
        Objects.equals(this.ableToDrive, healthCheckDto.ableToDrive) &&
        Objects.equals(this.healthCheckCode, healthCheckDto.healthCheckCode) &&
        Objects.equals(this.healthCheckType, healthCheckDto.healthCheckType) &&
        Objects.equals(this.finalHealthCheckLocation, healthCheckDto.finalHealthCheckLocation) &&
        Objects.equals(this.healthCheckResults, healthCheckDto.healthCheckResults) &&
        Objects.equals(this.visitedRiskArea, healthCheckDto.visitedRiskArea);
  }

  @Override
  public int hashCode() {
    return Objects.hash(symtompsSince, highTemperatureDuration, dryCoughDuration, headache, infectedInContact, infectedInContactDate, infectedPhoneNumbers, preferredHealthCheckLocation, ableToDrive, healthCheckCode, healthCheckType, finalHealthCheckLocation, healthCheckResults, visitedRiskArea);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HealthCheckDto {\n");
    
    sb.append("    symtompsSince: ").append(toIndentedString(symtompsSince)).append("\n");
    sb.append("    highTemperatureDuration: ").append(toIndentedString(highTemperatureDuration)).append("\n");
    sb.append("    dryCoughDuration: ").append(toIndentedString(dryCoughDuration)).append("\n");
    sb.append("    headache: ").append(toIndentedString(headache)).append("\n");
    sb.append("    infectedInContact: ").append(toIndentedString(infectedInContact)).append("\n");
    sb.append("    infectedInContactDate: ").append(toIndentedString(infectedInContactDate)).append("\n");
    sb.append("    infectedPhoneNumbers: ").append(toIndentedString(infectedPhoneNumbers)).append("\n");
    sb.append("    preferredHealthCheckLocation: ").append(toIndentedString(preferredHealthCheckLocation)).append("\n");
    sb.append("    ableToDrive: ").append(toIndentedString(ableToDrive)).append("\n");
    sb.append("    healthCheckCode: ").append(toIndentedString(healthCheckCode)).append("\n");
    sb.append("    healthCheckType: ").append(toIndentedString(healthCheckType)).append("\n");
    sb.append("    finalHealthCheckLocation: ").append(toIndentedString(finalHealthCheckLocation)).append("\n");
    sb.append("    healthCheckResults: ").append(toIndentedString(healthCheckResults)).append("\n");
    sb.append("    visitedRiskArea: ").append(toIndentedString(visitedRiskArea)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

