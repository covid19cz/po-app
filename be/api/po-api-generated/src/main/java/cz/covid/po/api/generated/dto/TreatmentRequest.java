package cz.covid.po.api.generated.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import cz.covid.po.api.generated.dto.Address;
import cz.covid.po.api.generated.dto.CodebookItemDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TreatmentRequest
 */
@Validated

public class TreatmentRequest   {
  @JsonProperty("place")
  private CodebookItemDto place = null;

  @JsonProperty("address")
  private Address address = null;

  @JsonProperty("health_check_date")
  private LocalDate healthCheckDate = null;

  @JsonProperty("health_check_location")
  private CodebookItemDto healthCheckLocation = null;

  @JsonProperty("expected_infection_date")
  private LocalDate expectedInfectionDate = null;

  @JsonProperty("in_contact_phone_numbers")
  private String inContactPhoneNumbers = null;

  public TreatmentRequest place(CodebookItemDto place) {
    this.place = place;
    return this;
  }

  /**
   * Get place
   * @return place
  **/
  @ApiModelProperty(value = "")

  @Valid

  public CodebookItemDto getPlace() {
    return place;
  }

  public void setPlace(CodebookItemDto place) {
    this.place = place;
  }

  public TreatmentRequest address(Address address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public TreatmentRequest healthCheckDate(LocalDate healthCheckDate) {
    this.healthCheckDate = healthCheckDate;
    return this;
  }

  /**
   * Get healthCheckDate
   * @return healthCheckDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public LocalDate getHealthCheckDate() {
    return healthCheckDate;
  }

  public void setHealthCheckDate(LocalDate healthCheckDate) {
    this.healthCheckDate = healthCheckDate;
  }

  public TreatmentRequest healthCheckLocation(CodebookItemDto healthCheckLocation) {
    this.healthCheckLocation = healthCheckLocation;
    return this;
  }

  /**
   * Get healthCheckLocation
   * @return healthCheckLocation
  **/
  @ApiModelProperty(value = "")

  @Valid

  public CodebookItemDto getHealthCheckLocation() {
    return healthCheckLocation;
  }

  public void setHealthCheckLocation(CodebookItemDto healthCheckLocation) {
    this.healthCheckLocation = healthCheckLocation;
  }

  public TreatmentRequest expectedInfectionDate(LocalDate expectedInfectionDate) {
    this.expectedInfectionDate = expectedInfectionDate;
    return this;
  }

  /**
   * Get expectedInfectionDate
   * @return expectedInfectionDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public LocalDate getExpectedInfectionDate() {
    return expectedInfectionDate;
  }

  public void setExpectedInfectionDate(LocalDate expectedInfectionDate) {
    this.expectedInfectionDate = expectedInfectionDate;
  }

  public TreatmentRequest inContactPhoneNumbers(String inContactPhoneNumbers) {
    this.inContactPhoneNumbers = inContactPhoneNumbers;
    return this;
  }

  /**
   * Get inContactPhoneNumbers
   * @return inContactPhoneNumbers
  **/
  @ApiModelProperty(value = "")


  public String getInContactPhoneNumbers() {
    return inContactPhoneNumbers;
  }

  public void setInContactPhoneNumbers(String inContactPhoneNumbers) {
    this.inContactPhoneNumbers = inContactPhoneNumbers;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TreatmentRequest treatmentRequest = (TreatmentRequest) o;
    return Objects.equals(this.place, treatmentRequest.place) &&
        Objects.equals(this.address, treatmentRequest.address) &&
        Objects.equals(this.healthCheckDate, treatmentRequest.healthCheckDate) &&
        Objects.equals(this.healthCheckLocation, treatmentRequest.healthCheckLocation) &&
        Objects.equals(this.expectedInfectionDate, treatmentRequest.expectedInfectionDate) &&
        Objects.equals(this.inContactPhoneNumbers, treatmentRequest.inContactPhoneNumbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(place, address, healthCheckDate, healthCheckLocation, expectedInfectionDate, inContactPhoneNumbers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TreatmentRequest {\n");
    
    sb.append("    place: ").append(toIndentedString(place)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    healthCheckDate: ").append(toIndentedString(healthCheckDate)).append("\n");
    sb.append("    healthCheckLocation: ").append(toIndentedString(healthCheckLocation)).append("\n");
    sb.append("    expectedInfectionDate: ").append(toIndentedString(expectedInfectionDate)).append("\n");
    sb.append("    inContactPhoneNumbers: ").append(toIndentedString(inContactPhoneNumbers)).append("\n");
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

