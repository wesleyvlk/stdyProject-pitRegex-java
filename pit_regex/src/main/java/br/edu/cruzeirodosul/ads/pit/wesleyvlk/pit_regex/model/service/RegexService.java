package br.edu.cruzeirodosul.ads.pit.wesleyvlk.pit_regex.model.service;

import java.util.List;
import java.util.regex.Pattern;

public interface RegexService {

    String transform(String input, Pattern pattern, String replacement);

    List<String> findMatchers(String input, Pattern pattern);

    Pattern getRegexEmail();

    Pattern getRegexBraDate();

}
