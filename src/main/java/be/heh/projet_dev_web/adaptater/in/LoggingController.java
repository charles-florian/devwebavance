package be.heh.projet_dev_web.adaptater.in;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LoggingController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/log ")
    public String index() {
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");

        return "This is a logging example controller.";
    }
}
