package cz.covid.po.api.generated.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.UUID;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SendCodeResponse
 */
@Validated

public class SendCodeResponse   {
  @JsonProperty("personUid")
  private UUID personUid = null;

  public SendCodeResponse personUid(UUID personUid) {
    this.personUid = personUid;
    return this;
  }

  /**
   * Unique Person's ID (person_uid.person)
   * @return personUid
  **/
  @ApiModelProperty(value = "Unique Person's ID (person_uid.person)")

  @Valid

  public UUID getPersonUid() {
    return personUid;
  }

  public void setPersonUid(UUID personUid) {
    this.personUid = personUid;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SendCodeResponse sendCodeResponse = (SendCodeResponse) o;
    return Objects.equals(this.personUid, sendCodeResponse.personUid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(personUid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SendCodeResponse {\n");
    
    sb.append("    personUid: ").append(toIndentedString(personUid)).append("\n");
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

