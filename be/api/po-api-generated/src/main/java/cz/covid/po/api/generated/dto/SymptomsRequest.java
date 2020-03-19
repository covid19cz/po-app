package cz.covid.po.api.generated.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import cz.covid.po.api.generated.dto.SymptomEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SymptomsRequest
 */
@Validated

public class SymptomsRequest   {
  @JsonProperty("symtomsSince")
  private LocalDate symtomsSince = null;

  @JsonProperty("highTemperatureDuration")
  private SymptomEnum highTemperatureDuration = null;

  @JsonProperty("dryCoughDuration")
  private SymptomEnum dryCoughDuration = null;

  @JsonProperty("headache")
  private Boolean headache = null;

  public SymptomsRequest symtomsSince(LocalDate symtomsSince) {
    this.symtomsSince = symtomsSince;
    return this;
  }

  /**
   * Get symtomsSince
   * @return symtomsSince
  **/
  @ApiModelProperty(value = "")

  @Valid

  public LocalDate getSymtomsSince() {
    return symtomsSince;
  }

  public void setSymtomsSince(LocalDate symtomsSince) {
    this.symtomsSince = symtomsSince;
  }

  public SymptomsRequest highTemperatureDuration(SymptomEnum highTemperatureDuration) {
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

  public SymptomsRequest dryCoughDuration(SymptomEnum dryCoughDuration) {
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

  public SymptomsRequest headache(Boolean headache) {
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
    SymptomsRequest symptomsRequest = (SymptomsRequest) o;
    return Objects.equals(this.symtomsSince, symptomsRequest.symtomsSince) &&
        Objects.equals(this.highTemperatureDuration, symptomsRequest.highTemperatureDuration) &&
        Objects.equals(this.dryCoughDuration, symptomsRequest.dryCoughDuration) &&
        Objects.equals(this.headache, symptomsRequest.headache);
  }

  @Override
  public int hashCode() {
    return Objects.hash(symtomsSince, highTemperatureDuration, dryCoughDuration, headache);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SymptomsRequest {\n");
    
    sb.append("    symtomsSince: ").append(toIndentedString(symtomsSince)).append("\n");
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

