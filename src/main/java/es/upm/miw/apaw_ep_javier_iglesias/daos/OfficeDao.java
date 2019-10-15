package es.upm.miw.apaw_ep_javier_iglesias.daos;

import es.upm.miw.apaw_ep_javier_iglesias.documents.Office;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface OfficeDao extends MongoRepository<Office, String> {
}