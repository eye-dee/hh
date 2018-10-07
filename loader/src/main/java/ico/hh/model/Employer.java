package ico.hh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PROTECTED)
@AllArgsConstructor
@NoArgsConstructor
public class Employer {

  private String name;
  private String url;
  @JsonProperty("alternate_url")
  private String alternateUrl;
  private String id;
  private boolean trusted;
  private boolean blacklisted;

  private Map<String, String> logo_urls;

}
