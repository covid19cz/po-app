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
 * CodebookItemDto
 */
@Validated

public class CodebookItemDto   {
  @JsonProperty("code")
  private String code = null;

  @JsonProperty("default")
  private Boolean _default = null;

  @JsonProperty("order")
  private Integer order = null;

  @JsonProperty("text")
  private String text = null;

  public CodebookItemDto code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Get code
   * @return code
  **/
  @ApiModelProperty(value = "")


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public CodebookItemDto _default(Boolean _default) {
    this._default = _default;
    return this;
  }

  /**
   * Get _default
   * @return _default
  **/
  @ApiModelProperty(value = "")


  public Boolean isDefault() {
    return _default;
  }

  public void setDefault(Boolean _default) {
    this._default = _default;
  }

  public CodebookItemDto order(Integer order) {
    this.order = order;
    return this;
  }

  /**
   * Get order
   * @return order
  **/
  @ApiModelProperty(value = "")


  public Integer getOrder() {
    return order;
  }

  public void setOrder(Integer order) {
    this.order = order;
  }

  public CodebookItemDto text(String text) {
    this.text = text;
    return this;
  }

  /**
   * Get text
   * @return text
  **/
  @ApiModelProperty(value = "")


  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CodebookItemDto codebookItemDto = (CodebookItemDto) o;
    return Objects.equals(this.code, codebookItemDto.code) &&
        Objects.equals(this._default, codebookItemDto._default) &&
        Objects.equals(this.order, codebookItemDto.order) &&
        Objects.equals(this.text, codebookItemDto.text);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, _default, order, text);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CodebookItemDto {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    _default: ").append(toIndentedString(_default)).append("\n");
    sb.append("    order: ").append(toIndentedString(order)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
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

