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
public class MetroStation {


  @JsonProperty("station_id")
  private String stationId;
  @JsonProperty("station_name")
  private String stationName;
  @JsonProperty("line_id")
  private String lineId;
  private String line_name;
  private double lat;
  private double lng;

}
