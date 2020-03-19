package cz.covid.po.api.generated.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Address
 */
@Validated

public class Address   {
  @JsonProperty("street")
  private String street = null;

  @JsonProperty("streetNumberDescriptive")
  private String streetNumberDescriptive = null;

  @JsonProperty("streetNumberEvidence")
  private String streetNumberEvidence = null;

  @JsonProperty("city")
  private String city = null;

  @JsonProperty("zipCode")
  private String zipCode = null;

  public Address street(String street) {
    this.street = street;
    return this;
  }

  /**
   * Get street
   * @return street
  **/
  @ApiModelProperty(value = "")


  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public Address streetNumberDescriptive(String streetNumberDescriptive) {
    this.streetNumberDescriptive = streetNumberDescriptive;
    return this;
  }

  /**
   * Get streetNumberDescriptive
   * @return streetNumberDescriptive
  **/
  @ApiModelProperty(value = "")


  public String getStreetNumberDescriptive() {
    return streetNumberDescriptive;
  }

  public void setStreetNumberDescriptive(String streetNumberDescriptive) {
    this.streetNumberDescriptive = streetNumberDescriptive;
  }

  public Address streetNumberEvidence(String streetNumberEvidence) {
    this.streetNumberEvidence = streetNumberEvidence;
    return this;
  }

  /**
   * Get streetNumberEvidence
   * @return streetNumberEvidence
  **/
  @ApiModelProperty(value = "")


  public String getStreetNumberEvidence() {
    return streetNumberEvidence;
  }

  public void setStreetNumberEvidence(String streetNumberEvidence) {
    this.streetNumberEvidence = streetNumberEvidence;
  }

  public Address city(String city) {
    this.city = city;
    return this;
  }

  /**
   * Get city
   * @return city
  **/
  @ApiModelProperty(value = "")


  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Address zipCode(String zipCode) {
    this.zipCode = zipCode;
    return this;
  }

  /**
   * Get zipCode
   * @return zipCode
  **/
  @ApiModelProperty(value = "")


  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Address address = (Address) o;
    return Objects.equals(this.street, address.street) &&
        Objects.equals(this.streetNumberDescriptive, address.streetNumberDescriptive) &&
        Objects.equals(this.streetNumberEvidence, address.streetNumberEvidence) &&
        Objects.equals(this.city, address.city) &&
        Objects.equals(this.zipCode, address.zipCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(street, streetNumberDescriptive, streetNumberEvidence, city, zipCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Address {\n");
    
    sb.append("    street: ").append(toIndentedString(street)).append("\n");
    sb.append("    streetNumberDescriptive: ").append(toIndentedString(streetNumberDescriptive)).append("\n");
    sb.append("    streetNumberEvidence: ").append(toIndentedString(streetNumberEvidence)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    zipCode: ").append(toIndentedString(zipCode)).append("\n");
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

