package cz.covid.po.api.generated.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import cz.covid.po.api.generated.dto.Address;
import cz.covid.po.api.generated.dto.CodebookItemDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.util.UUID;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PersonResponse
 */
@Validated

public class PersonResponse   {
  @JsonProperty("personUid")
  private UUID personUid = null;

  @JsonProperty("returnHash")
  private String returnHash = null;

  @JsonProperty("phoneNumber")
  private String phoneNumber = null;

  @JsonProperty("firstname")
  private String firstname = null;

  @JsonProperty("surname")
  private String surname = null;

  @JsonProperty("addressHome")
  private Address addressHome = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("healthStatus")
  private CodebookItemDto healthStatus = null;

  @JsonProperty("healthStatusLastChange")
  private LocalDate healthStatusLastChange = null;

  public PersonResponse personUid(UUID personUid) {
    this.personUid = personUid;
    return this;
  }

  /**
   * Get personUid
   * @return personUid
  **/
  @ApiModelProperty(value = "")

  @Valid

  public UUID getPersonUid() {
    return personUid;
  }

  public void setPersonUid(UUID personUid) {
    this.personUid = personUid;
  }

  public PersonResponse returnHash(String returnHash) {
    this.returnHash = returnHash;
    return this;
  }

  /**
   * Get returnHash
   * @return returnHash
  **/
  @ApiModelProperty(value = "")


  public String getReturnHash() {
    return returnHash;
  }

  public void setReturnHash(String returnHash) {
    this.returnHash = returnHash;
  }

  public PersonResponse phoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

  /**
   * Get phoneNumber
   * @return phoneNumber
  **/
  @ApiModelProperty(value = "")


  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public PersonResponse firstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  /**
   * Get firstname
   * @return firstname
  **/
  @ApiModelProperty(value = "")


  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public PersonResponse surname(String surname) {
    this.surname = surname;
    return this;
  }

  /**
   * Get surname
   * @return surname
  **/
  @ApiModelProperty(value = "")


  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public PersonResponse addressHome(Address addressHome) {
    this.addressHome = addressHome;
    return this;
  }

  /**
   * Get addressHome
   * @return addressHome
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Address getAddressHome() {
    return addressHome;
  }

  public void setAddressHome(Address addressHome) {
    this.addressHome = addressHome;
  }

  public PersonResponse email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  **/
  @ApiModelProperty(value = "")


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public PersonResponse healthStatus(CodebookItemDto healthStatus) {
    this.healthStatus = healthStatus;
    return this;
  }

  /**
   * Get healthStatus
   * @return healthStatus
  **/
  @ApiModelProperty(value = "")

  @Valid

  public CodebookItemDto getHealthStatus() {
    return healthStatus;
  }

  public void setHealthStatus(CodebookItemDto healthStatus) {
    this.healthStatus = healthStatus;
  }

  public PersonResponse healthStatusLastChange(LocalDate healthStatusLastChange) {
    this.healthStatusLastChange = healthStatusLastChange;
    return this;
  }

  /**
   * Get healthStatusLastChange
   * @return healthStatusLastChange
  **/
  @ApiModelProperty(value = "")

  @Valid

  public LocalDate getHealthStatusLastChange() {
    return healthStatusLastChange;
  }

  public void setHealthStatusLastChange(LocalDate healthStatusLastChange) {
    this.healthStatusLastChange = healthStatusLastChange;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonResponse personResponse = (PersonResponse) o;
    return Objects.equals(this.personUid, personResponse.personUid) &&
        Objects.equals(this.returnHash, personResponse.returnHash) &&
        Objects.equals(this.phoneNumber, personResponse.phoneNumber) &&
        Objects.equals(this.firstname, personResponse.firstname) &&
        Objects.equals(this.surname, personResponse.surname) &&
        Objects.equals(this.addressHome, personResponse.addressHome) &&
        Objects.equals(this.email, personResponse.email) &&
        Objects.equals(this.healthStatus, personResponse.healthStatus) &&
        Objects.equals(this.healthStatusLastChange, personResponse.healthStatusLastChange);
  }

  @Override
  public int hashCode() {
    return Objects.hash(personUid, returnHash, phoneNumber, firstname, surname, addressHome, email, healthStatus, healthStatusLastChange);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonResponse {\n");
    
    sb.append("    personUid: ").append(toIndentedString(personUid)).append("\n");
    sb.append("    returnHash: ").append(toIndentedString(returnHash)).append("\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    firstname: ").append(toIndentedString(firstname)).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    addressHome: ").append(toIndentedString(addressHome)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    healthStatus: ").append(toIndentedString(healthStatus)).append("\n");
    sb.append("    healthStatusLastChange: ").append(toIndentedString(healthStatusLastChange)).append("\n");
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

