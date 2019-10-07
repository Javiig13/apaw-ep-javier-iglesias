package es.upm.miw.apaw_ep_javier_iglesias.daos;

import es.upm.miw.apaw_ep_javier_iglesias.documents.Suggestion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SuggestionDao extends MongoRepository<Suggestion, String> {
}
