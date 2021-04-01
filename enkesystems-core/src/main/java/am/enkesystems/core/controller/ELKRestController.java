package am.enkesystems.core.controller;

import am.enkesystems.core.model.Member;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class ELKRestController {

    private static final Logger LOG = Logger.getLogger(ELKRestController.class.getName());

    @RequestMapping(value = "/hello")
    public ResponseEntity<String> helloElk() {
        String response = "Hi friend! This is Spring Boot.";
        LOG.log(Level.INFO, response);
        return ok(response);
    }

    @RequestMapping(value = "/exception")
    public ResponseEntity<String> exception() {
        String response = "";
        try {
            throw new Exception("TestException has occurred .... ");
        } catch (Exception e) {
            e.printStackTrace();
            LOG.severe(e.getMessage());
            LOG.severe(stackTraceToString(e));
        }
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/model")
    public ResponseEntity<Member> entity() {
        Member member = new Member();
        member.setId("1111-2222-3333-4444");
        member.setFirstname("Arayik");
        member.setLastname("Harutyunyan");
        String log = member.toString();
        LOG.log(Level.INFO, log);
        return ok(member);
    }

    public String stackTraceToString(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.toString();
    }
}
