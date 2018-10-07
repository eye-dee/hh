package ico.hh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter(AccessLevel.PROTECTED)
@AllArgsConstructor
@NoArgsConstructor
public class Address {

  private String city;
  private String street;
  private String building;
  private String description;
  private double lat;
  private double lng;
  private String raw;
  @JsonProperty("metro_stations")
  private List<MetroStation> metroStations;

}
