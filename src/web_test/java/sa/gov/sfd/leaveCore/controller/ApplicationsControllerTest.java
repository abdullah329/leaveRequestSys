package sa.gov.sfd.leaveDeliveryMechanism.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ApplicationsControllerTest {

    @RequestMapping("/api/application")
    public String home(){
        return "Hello World!";
    }
}
