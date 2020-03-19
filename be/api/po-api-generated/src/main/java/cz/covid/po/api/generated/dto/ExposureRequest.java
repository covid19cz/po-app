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
 * ExposureRequest
 */
@Validated

public class ExposureRequest   {
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

  public ExposureRequest infectedInContact(InfectedInContactEnum infectedInContact) {
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

  public ExposureRequest infectedInContactDate(LocalDate infectedInContactDate) {
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

  public ExposureRequest infectedPhoneNumbers(String infectedPhoneNumbers) {
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

  public ExposureRequest visitedRiskArea(CodebookItemDto visitedRiskArea) {
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
    ExposureRequest exposureRequest = (ExposureRequest) o;
    return Objects.equals(this.infectedInContact, exposureRequest.infectedInContact) &&
        Objects.equals(this.infectedInContactDate, exposureRequest.infectedInContactDate) &&
        Objects.equals(this.infectedPhoneNumbers, exposureRequest.infectedPhoneNumbers) &&
        Objects.equals(this.visitedRiskArea, exposureRequest.visitedRiskArea);
  }

  @Override
  public int hashCode() {
    return Objects.hash(infectedInContact, infectedInContactDate, infectedPhoneNumbers, visitedRiskArea);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExposureRequest {\n");
    
    sb.append("    infectedInContact: ").append(toIndentedString(infectedInContact)).append("\n");
    sb.append("    infectedInContactDate: ").append(toIndentedString(infectedInContactDate)).append("\n");
    sb.append("    infectedPhoneNumbers: ").append(toIndentedString(infectedPhoneNumbers)).append("\n");
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

