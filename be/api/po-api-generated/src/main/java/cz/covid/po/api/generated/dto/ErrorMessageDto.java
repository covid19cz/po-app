package cz.covid.po.api.generated.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ErrorMessageDto
 */
@Validated

public class ErrorMessageDto   {
  @JsonProperty("additionalMessages")
  private Object additionalMessages = null;

  /**
   * Gets or Sets errorCode
   */
  public enum ErrorCodeEnum {
    SMS_CODE_GEN_ERROR("SMS_CODE_GEN_ERROR"),
    
    UNAUTHORIZED("UNAUTHORIZED"),
    
    UNKNOWN("UNKNOWN");

    private String value;

    ErrorCodeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ErrorCodeEnum fromValue(String text) {
      for (ErrorCodeEnum b : ErrorCodeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("errorCode")
  private ErrorCodeEnum errorCode = null;

  @JsonProperty("message")
  private String message = null;

  public ErrorMessageDto additionalMessages(Object additionalMessages) {
    this.additionalMessages = additionalMessages;
    return this;
  }

  /**
   * Get additionalMessages
   * @return additionalMessages
  **/
  @ApiModelProperty(value = "")


  public Object getAdditionalMessages() {
    return additionalMessages;
  }

  public void setAdditionalMessages(Object additionalMessages) {
    this.additionalMessages = additionalMessages;
  }

  public ErrorMessageDto errorCode(ErrorCodeEnum errorCode) {
    this.errorCode = errorCode;
    return this;
  }

  /**
   * Get errorCode
   * @return errorCode
  **/
  @ApiModelProperty(value = "")


  public ErrorCodeEnum getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(ErrorCodeEnum errorCode) {
    this.errorCode = errorCode;
  }

  public ErrorMessageDto message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
  **/
  @ApiModelProperty(value = "")


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorMessageDto errorMessageDto = (ErrorMessageDto) o;
    return Objects.equals(this.additionalMessages, errorMessageDto.additionalMessages) &&
        Objects.equals(this.errorCode, errorMessageDto.errorCode) &&
        Objects.equals(this.message, errorMessageDto.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(additionalMessages, errorCode, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorMessageDto {\n");
    
    sb.append("    additionalMessages: ").append(toIndentedString(additionalMessages)).append("\n");
    sb.append("    errorCode: ").append(toIndentedString(errorCode)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

