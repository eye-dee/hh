package ico.hh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PROTECTED)
@AllArgsConstructor
@NoArgsConstructor
public class Specialization {

  @JsonProperty("profarea_id")
  private String profareaId;
  @JsonProperty("profarea_name")
  private String profareaName;
  private String id;
  private String name;
}
