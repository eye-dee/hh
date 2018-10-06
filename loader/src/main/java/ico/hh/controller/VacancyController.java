package ico.hh.controller;

import ico.hh.model.Vacancy;
import ico.hh.repository.VacancyRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("vacancy")
@RequiredArgsConstructor
public class VacancyController {

  private final VacancyRepository repository;

  @GetMapping
  public List<Vacancy> findAll() {
    return repository.findAll();
  }

}
