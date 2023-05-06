package br.edu.cruzeirodosul.ads.pit.wesleyvlk.pit_regex.controller;

import br.edu.cruzeirodosul.ads.pit.wesleyvlk.pit_regex.model.service.RegexService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/regex")
public class RegexController {

    private final RegexService service;

    public RegexController(RegexService service) {
        this.service = service;
    }

    @GetMapping("/email")
    public ResponseEntity<Object> getRegexEmail() {
        var msg = "Regex pattern for finding email addresses: \n";
        return ResponseEntity.status(HttpStatus.OK).body(msg + service.getRegexEmail().toString());
    }

    @GetMapping("/braDate")
    public ResponseEntity<Object> getRegexBraDate() {
        var msg = "Regex pattern for finding dates in the YYYY-MM-DD format: \n";
        return ResponseEntity.status(HttpStatus.OK).body(msg + service.getRegexBraDate().toString());
    }

    @PostMapping("/email")
    public ResponseEntity<Object> filterByRegexEmail(@RequestBody String input) {
        List<String> matchers = service.findMatchers(input, service.getRegexEmail());
        String replace = matchers.stream()
                .map(match -> match + "\n")
                .collect(Collectors.joining());
        var msg = "Email addresses that match the regex pattern: \n";
        return ResponseEntity.status(HttpStatus.CREATED).body(msg + replace);
    }

    @PostMapping("/braDate")
    public ResponseEntity<Object> filterByRegexBraDate(@RequestBody String input) {
        List<String> matchers = service.findMatchers(input, service.getRegexBraDate());
        String replace = matchers.stream()
                .map(match -> service.transform(match, service.getRegexBraDate(), "$3/$2/$1") + "\n")
                .collect(Collectors.joining());
        var msg = "Dates that match the regex pattern, converted to the Brazilian format: \n";
        return ResponseEntity.status(HttpStatus.CREATED).body(msg + replace);
    }

}
