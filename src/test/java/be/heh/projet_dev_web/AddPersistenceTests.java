package be.heh.projet_dev_web;

import be.heh.projet_dev_web.model.Tournament;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

@DataJpaTest
public class AddPersistenceTests extends AbstractIntegrationTest {

    Tournament tournament=new Tournament("VALORANT", LocalDate.now(),17.5);


}
