package ico.hh.repository;

import ico.hh.model.Vacancy;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VacancyRepository extends MongoRepository<Vacancy, Integer> {

}
