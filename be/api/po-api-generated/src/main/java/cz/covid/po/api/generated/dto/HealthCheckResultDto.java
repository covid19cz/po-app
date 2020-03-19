package cz.covid.po.api.generated.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * HealthCheckResultDto
 */
@Validated

public class HealthCheckResultDto   {
  @JsonProperty("positive")
  private Boolean positive = null;

  @JsonProperty("testDate")
  private LocalDate testDate = null;

  @JsonProperty("resultSentAt")
  private OffsetDateTime resultSentAt = null;

  public HealthCheckResultDto positive(Boolean positive) {
    this.positive = positive;
    return this;
  }

  /**
   * Get positive
   * @return positive
  **/
  @ApiModelProperty(value = "")


  public Boolean isPositive() {
    return positive;
  }

  public void setPositive(Boolean positive) {
    this.positive = positive;
  }

  public HealthCheckResultDto testDate(LocalDate testDate) {
    this.testDate = testDate;
    return this;
  }

  /**
   * Get testDate
   * @return testDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public LocalDate getTestDate() {
    return testDate;
  }

  public void setTestDate(LocalDate testDate) {
    this.testDate = testDate;
  }

  public HealthCheckResultDto resultSentAt(OffsetDateTime resultSentAt) {
    this.resultSentAt = resultSentAt;
    return this;
  }

  /**
   * Get resultSentAt
   * @return resultSentAt
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getResultSentAt() {
    return resultSentAt;
  }

  public void setResultSentAt(OffsetDateTime resultSentAt) {
    this.resultSentAt = resultSentAt;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HealthCheckResultDto healthCheckResultDto = (HealthCheckResultDto) o;
    return Objects.equals(this.positive, healthCheckResultDto.positive) &&
        Objects.equals(this.testDate, healthCheckResultDto.testDate) &&
        Objects.equals(this.resultSentAt, healthCheckResultDto.resultSentAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(positive, testDate, resultSentAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HealthCheckResultDto {\n");
    
    sb.append("    positive: ").append(toIndentedString(positive)).append("\n");
    sb.append("    testDate: ").append(toIndentedString(testDate)).append("\n");
    sb.append("    resultSentAt: ").append(toIndentedString(resultSentAt)).append("\n");
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

