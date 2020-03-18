package cz.covid.po.api.generated.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import cz.covid.po.api.generated.dto.CodebookItemDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TestingPlaceRequest
 */
@Validated

public class TestingPlaceRequest   {
  @JsonProperty("preferredHealthCheckLocation")
  private CodebookItemDto preferredHealthCheckLocation = null;

  @JsonProperty("ableToDrive")
  private Boolean ableToDrive = null;

  public TestingPlaceRequest preferredHealthCheckLocation(CodebookItemDto preferredHealthCheckLocation) {
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

  public TestingPlaceRequest ableToDrive(Boolean ableToDrive) {
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
    TestingPlaceRequest testingPlaceRequest = (TestingPlaceRequest) o;
    return Objects.equals(this.preferredHealthCheckLocation, testingPlaceRequest.preferredHealthCheckLocation) &&
        Objects.equals(this.ableToDrive, testingPlaceRequest.ableToDrive);
  }

  @Override
  public int hashCode() {
    return Objects.hash(preferredHealthCheckLocation, ableToDrive);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TestingPlaceRequest {\n");
    
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

