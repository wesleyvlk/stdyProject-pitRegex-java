package br.edu.cruzeirodosul.ads.pit.wesleyvlk.pit_regex.model.service;

import br.edu.cruzeirodosul.ads.pit.wesleyvlk.pit_regex.model.Regex;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class RegexServiceImpl implements RegexService {

    private final Regex regex;

    private RegexServiceImpl() {
        this.regex = new Regex.Builder()
                .email("([\\w._%+\\-]+)@([\\w_%+\\-]+)(\\.[\\w]{2,})(\\.[\\w]{2,})?")
                .braDate("([0-9]{4})-([0-9]{2})-([0-9]{2})")
                .build();
    }

    @Override
    public List<String> findMatchers(String input, Pattern pattern) {
        List<String> matches = new LinkedList<>();
        var matcher = pattern.matcher(input);
        while (matcher.find()) {
            matches.add(matcher.group());
        }
        return matches;
    }

    @Override
    public String transform(String input, Pattern pattern, String replacement) {
        return pattern.matcher(input).replaceAll(replacement);
    }

    @Override
    public Pattern getRegexEmail() {
        return regex.getEmail();
    }

    @Override
    public Pattern getRegexBraDate() {
        return regex.getBraDate();
    }
}
