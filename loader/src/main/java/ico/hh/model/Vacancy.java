package ico.hh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@Document(collection = "vacancy")
@Getter
@Setter(AccessLevel.PROTECTED)
@AllArgsConstructor
@NoArgsConstructor
public class Vacancy {

  @Id
  private String id;
  private String description;
  @JsonProperty("branded_description")
  private String brandedDescription;

  @JsonProperty("key_skill")
  private List<KeySkill> keySkills;

  private Schedule schedule;

  @JsonProperty("accept_handicapped")
  private boolean acceptHandicapped;

  @JsonProperty("accept_kids")
  private boolean acceptKids;

  private Experience experience;

  private Address address;

  @JsonProperty("alternate_url")
  private String alternateUrl;

  @JsonProperty("apply_alternate_url")
  private String apply_alternate_url;

  private String code;

  private Department department;

  private Employment employment;

  private Salary salary;

  private boolean archived;

  private String name;

  private Area area;

  @JsonProperty("published_at")
  @DateTimeFormat(iso = ISO.DATE_TIME)
  private Date publishedAt;

  private Employer employer;

  @JsonProperty("response_letter_required")
  private boolean responseLetterRequired;

  private Type type;

  @JsonProperty("has_test")
  private boolean hasTest;

  @JsonProperty("respnonse_url")
  private String responseUrl;

  private Test test;

  List<Specialization> specializations;

  private Contacts contacts;

  @JsonProperty("billing_type")
  private BillingType billingType;

  @JsonProperty("allow_messages")
  private boolean allowMessages;

  private boolean premium;

  @JsonProperty("driver_license_types")
  List<DriverLicense> driverLicenseTypes;

  @JsonProperty("accept_incomplete_resumes")
  private boolean accept_incomplete_resumes;


}
