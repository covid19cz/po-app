package cz.covid.po.api.generated.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SimtompsRequest
 */
@Validated

public class SimtompsRequest   {
  @JsonProperty("symtompsSince")
  private LocalDate symtompsSince = null;

  @JsonProperty("highTemperatureDuration")
  private Integer highTemperatureDuration = null;

  @JsonProperty("dryCoughDuration")
  private Integer dryCoughDuration = null;

  @JsonProperty("headache")
  private Boolean headache = null;

  public SimtompsRequest symtompsSince(LocalDate symtompsSince) {
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

  public SimtompsRequest highTemperatureDuration(Integer highTemperatureDuration) {
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

  public SimtompsRequest dryCoughDuration(Integer dryCoughDuration) {
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

  public SimtompsRequest headache(Boolean headache) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SimtompsRequest simtompsRequest = (SimtompsRequest) o;
    return Objects.equals(this.symtompsSince, simtompsRequest.symtompsSince) &&
        Objects.equals(this.highTemperatureDuration, simtompsRequest.highTemperatureDuration) &&
        Objects.equals(this.dryCoughDuration, simtompsRequest.dryCoughDuration) &&
        Objects.equals(this.headache, simtompsRequest.headache);
  }

  @Override
  public int hashCode() {
    return Objects.hash(symtompsSince, highTemperatureDuration, dryCoughDuration, headache);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SimtompsRequest {\n");
    
    sb.append("    symtompsSince: ").append(toIndentedString(symtompsSince)).append("\n");
    sb.append("    highTemperatureDuration: ").append(toIndentedString(highTemperatureDuration)).append("\n");
    sb.append("    dryCoughDuration: ").append(toIndentedString(dryCoughDuration)).append("\n");
    sb.append("    headache: ").append(toIndentedString(headache)).append("\n");
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

