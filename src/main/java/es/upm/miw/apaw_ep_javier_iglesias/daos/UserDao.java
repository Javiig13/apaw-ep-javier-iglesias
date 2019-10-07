package es.upm.miw.apaw_ep_javier_iglesias.daos;

import es.upm.miw.apaw_ep_javier_iglesias.documents.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDao extends MongoRepository<User, String> {
}
