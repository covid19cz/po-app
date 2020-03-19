package cz.covid.po.api.generated.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets SymptomEnum
 */
public enum SymptomEnum {
  
  NONE("NONE"),
  
  MORE("MORE"),
  
  ONE_OR_TWO("ONE_OR_TWO"),
  
  THREE_OR_FOUR("THREE_OR_FOUR");

  private String value;

  SymptomEnum(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static SymptomEnum fromValue(String text) {
    for (SymptomEnum b : SymptomEnum.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

