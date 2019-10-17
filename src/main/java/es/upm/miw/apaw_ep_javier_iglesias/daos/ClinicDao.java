package es.upm.miw.apaw_ep_javier_iglesias.daos;

import es.upm.miw.apaw_ep_javier_iglesias.documents.Clinic;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClinicDao extends MongoRepository<Clinic, String> {
}
