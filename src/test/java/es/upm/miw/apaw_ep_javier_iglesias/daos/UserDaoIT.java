package es.upm.miw.apaw_ep_javier_iglesias.daos;

import es.upm.miw.apaw_ep_javier_iglesias.TestConfig;
import es.upm.miw.apaw_ep_javier_iglesias.documents.Address;
import es.upm.miw.apaw_ep_javier_iglesias.documents.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
class UserDaoIT {

    @Autowired
    private UserDao userDao;

    @Test
    void testCreate() {
        User user = new User("nick", "email@gmail.com", new Address("España", "Madrid", "Alan Turing"));
        this.userDao.save(user);
        User databaseUser = this.userDao.findById(user.getId()).orElseGet(Assertions::fail);
        assertEquals("nick", databaseUser.getNick());
    }
}
