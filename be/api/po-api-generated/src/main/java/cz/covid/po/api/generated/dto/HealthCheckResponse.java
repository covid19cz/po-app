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
 * HealthCheckResponse
 */
@Validated

public class HealthCheckResponse   {
  @JsonProperty("timeSlot")
  private String timeSlot = null;

  @JsonProperty("address")
  private String address = null;

  @JsonProperty("healthCheckCode")
  private String healthCheckCode = null;

  public HealthCheckResponse timeSlot(String timeSlot) {
    this.timeSlot = timeSlot;
    return this;
  }

  /**
   * Get timeSlot
   * @return timeSlot
  **/
  @ApiModelProperty(value = "")


  public String getTimeSlot() {
    return timeSlot;
  }

  public void setTimeSlot(String timeSlot) {
    this.timeSlot = timeSlot;
  }

  public HealthCheckResponse address(String address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
  **/
  @ApiModelProperty(value = "")


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public HealthCheckResponse healthCheckCode(String healthCheckCode) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HealthCheckResponse healthCheckResponse = (HealthCheckResponse) o;
    return Objects.equals(this.timeSlot, healthCheckResponse.timeSlot) &&
        Objects.equals(this.address, healthCheckResponse.address) &&
        Objects.equals(this.healthCheckCode, healthCheckResponse.healthCheckCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timeSlot, address, healthCheckCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HealthCheckResponse {\n");
    
    sb.append("    timeSlot: ").append(toIndentedString(timeSlot)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    healthCheckCode: ").append(toIndentedString(healthCheckCode)).append("\n");
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

