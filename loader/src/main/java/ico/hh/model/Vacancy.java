package ico.hh.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "vacancy")
@Getter
@Setter(AccessLevel.PROTECTED)
@AllArgsConstructor
@NoArgsConstructor
public class Vacancy {

  @Id
  private int id;
  private String description;
  @JsonProperty("branded_description")
  private String brandedDescription;
}
