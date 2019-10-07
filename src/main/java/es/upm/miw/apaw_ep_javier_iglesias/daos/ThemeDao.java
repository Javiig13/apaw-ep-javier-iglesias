package es.upm.miw.apaw_ep_javier_iglesias.daos;

import es.upm.miw.apaw_ep_javier_iglesias.documents.Theme;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ThemeDao extends MongoRepository<Theme, String> {
}
