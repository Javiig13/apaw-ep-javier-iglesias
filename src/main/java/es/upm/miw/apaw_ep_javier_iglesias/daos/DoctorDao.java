package es.upm.miw.apaw_ep_javier_iglesias.daos;

import es.upm.miw.apaw_ep_javier_iglesias.documents.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DoctorDao extends MongoRepository<Doctor, String> {
}
