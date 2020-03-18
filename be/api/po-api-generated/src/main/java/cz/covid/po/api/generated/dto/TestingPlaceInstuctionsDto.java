package cz.covid.po.api.generated.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import cz.covid.po.api.generated.dto.Address;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TestingPlaceInstuctionsDto
 */
@Validated

public class TestingPlaceInstuctionsDto   {
  @JsonProperty("address")
  private Address address = null;

  @JsonProperty("openingHours")
  private String openingHours = null;

  public TestingPlaceInstuctionsDto address(Address address) {
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

  public TestingPlaceInstuctionsDto openingHours(String openingHours) {
    this.openingHours = openingHours;
    return this;
  }

  /**
   * Get openingHours
   * @return openingHours
  **/
  @ApiModelProperty(value = "")


  public String getOpeningHours() {
    return openingHours;
  }

  public void setOpeningHours(String openingHours) {
    this.openingHours = openingHours;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TestingPlaceInstuctionsDto testingPlaceInstuctionsDto = (TestingPlaceInstuctionsDto) o;
    return Objects.equals(this.address, testingPlaceInstuctionsDto.address) &&
        Objects.equals(this.openingHours, testingPlaceInstuctionsDto.openingHours);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, openingHours);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TestingPlaceInstuctionsDto {\n");
    
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    openingHours: ").append(toIndentedString(openingHours)).append("\n");
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

