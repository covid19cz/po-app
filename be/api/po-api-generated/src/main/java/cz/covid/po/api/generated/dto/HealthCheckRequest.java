package cz.covid.po.api.generated.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import cz.covid.po.api.generated.dto.CodebookItemDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * HealthCheckRequest
 */
@Validated

public class HealthCheckRequest   {
  @JsonProperty("symtompsSince")
  private LocalDate symtompsSince = null;

  @JsonProperty("highTemperatureDuration")
  private Integer highTemperatureDuration = null;

  @JsonProperty("dryCoughDuration")
  private Integer dryCoughDuration = null;

  @JsonProperty("headache")
  private Boolean headache = null;

  /**
   * Gets or Sets infectedInContact
   */
  public enum InfectedInContactEnum {
    Y("Y"),
    
    N("N"),
    
    QUESTION_MARK("?");

    private String value;

    InfectedInContactEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static InfectedInContactEnum fromValue(String text) {
      for (InfectedInContactEnum b : InfectedInContactEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("infectedInContact")
  private InfectedInContactEnum infectedInContact = null;

  @JsonProperty("infectedInContactDate")
  private LocalDate infectedInContactDate = null;

  @JsonProperty("infectedPhoneNumbers")
  private String infectedPhoneNumbers = null;

  @JsonProperty("visitedRiskArea")
  private CodebookItemDto visitedRiskArea = null;

  @JsonProperty("preferredHealthCheckLocation")
  private CodebookItemDto preferredHealthCheckLocation = null;

  @JsonProperty("ableToDrive")
  private Boolean ableToDrive = null;

  public HealthCheckRequest symtompsSince(LocalDate symtompsSince) {
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

  public HealthCheckRequest highTemperatureDuration(Integer highTemperatureDuration) {
    this.highTemperatureDuration = highTemperatureDuration;
    return this;
  }

  /**
   * Get highTemperatureDuration
   * @return highTemperatureDuration
  **/
  @ApiModelProperty(value = "")


  public Integer getHighTemperatureDuration() {
    return highTemperatureDuration;
  }

  public void setHighTemperatureDuration(Integer highTemperatureDuration) {
    this.highTemperatureDuration = highTemperatureDuration;
  }

  public HealthCheckRequest dryCoughDuration(Integer dryCoughDuration) {
    this.dryCoughDuration = dryCoughDuration;
    return this;
  }

  /**
   * Get dryCoughDuration
   * @return dryCoughDuration
  **/
  @ApiModelProperty(value = "")


  public Integer getDryCoughDuration() {
    return dryCoughDuration;
  }

  public void setDryCoughDuration(Integer dryCoughDuration) {
    this.dryCoughDuration = dryCoughDuration;
  }

  public HealthCheckRequest headache(Boolean headache) {
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

  public HealthCheckRequest infectedInContact(InfectedInContactEnum infectedInContact) {
    this.infectedInContact = infectedInContact;
    return this;
  }

  /**
   * Get infectedInContact
   * @return infectedInContact
  **/
  @ApiModelProperty(value = "")


  public InfectedInContactEnum getInfectedInContact() {
    return infectedInContact;
  }

  public void setInfectedInContact(InfectedInContactEnum infectedInContact) {
    this.infectedInContact = infectedInContact;
  }

  public HealthCheckRequest infectedInContactDate(LocalDate infectedInContactDate) {
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

  public HealthCheckRequest infectedPhoneNumbers(String infectedPhoneNumbers) {
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

  public HealthCheckRequest visitedRiskArea(CodebookItemDto visitedRiskArea) {
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

  public HealthCheckRequest preferredHealthCheckLocation(CodebookItemDto preferredHealthCheckLocation) {
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

  public HealthCheckRequest ableToDrive(Boolean ableToDrive) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HealthCheckRequest healthCheckRequest = (HealthCheckRequest) o;
    return Objects.equals(this.symtompsSince, healthCheckRequest.symtompsSince) &&
        Objects.equals(this.highTemperatureDuration, healthCheckRequest.highTemperatureDuration) &&
        Objects.equals(this.dryCoughDuration, healthCheckRequest.dryCoughDuration) &&
        Objects.equals(this.headache, healthCheckRequest.headache) &&
        Objects.equals(this.infectedInContact, healthCheckRequest.infectedInContact) &&
        Objects.equals(this.infectedInContactDate, healthCheckRequest.infectedInContactDate) &&
        Objects.equals(this.infectedPhoneNumbers, healthCheckRequest.infectedPhoneNumbers) &&
        Objects.equals(this.visitedRiskArea, healthCheckRequest.visitedRiskArea) &&
        Objects.equals(this.preferredHealthCheckLocation, healthCheckRequest.preferredHealthCheckLocation) &&
        Objects.equals(this.ableToDrive, healthCheckRequest.ableToDrive);
  }

  @Override
  public int hashCode() {
    return Objects.hash(symtompsSince, highTemperatureDuration, dryCoughDuration, headache, infectedInContact, infectedInContactDate, infectedPhoneNumbers, visitedRiskArea, preferredHealthCheckLocation, ableToDrive);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HealthCheckRequest {\n");
    
    sb.append("    symtompsSince: ").append(toIndentedString(symtompsSince)).append("\n");
    sb.append("    highTemperatureDuration: ").append(toIndentedString(highTemperatureDuration)).append("\n");
    sb.append("    dryCoughDuration: ").append(toIndentedString(dryCoughDuration)).append("\n");
    sb.append("    headache: ").append(toIndentedString(headache)).append("\n");
    sb.append("    infectedInContact: ").append(toIndentedString(infectedInContact)).append("\n");
    sb.append("    infectedInContactDate: ").append(toIndentedString(infectedInContactDate)).append("\n");
    sb.append("    infectedPhoneNumbers: ").append(toIndentedString(infectedPhoneNumbers)).append("\n");
    sb.append("    visitedRiskArea: ").append(toIndentedString(visitedRiskArea)).append("\n");
    sb.append("    preferredHealthCheckLocation: ").append(toIndentedString(preferredHealthCheckLocation)).append("\n");
    sb.append("    ableToDrive: ").append(toIndentedString(ableToDrive)).append("\n");
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

