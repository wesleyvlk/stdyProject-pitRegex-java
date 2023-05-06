package br.edu.cruzeirodosul.ads.pit.wesleyvlk.pit_regex.model.service;

import br.edu.cruzeirodosul.ads.pit.wesleyvlk.pit_regex.model.Regex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("RegexServiceImplTest")
class RegexServiceImplTest {

    @Autowired
    RegexService service;

    Regex regex;

    @BeforeEach
    public void setUp() {
        regex = new Regex.Builder()
                .email("([\\w._%+\\-]+)@([\\w_%+\\-]+)(\\.[\\w]{2,})(\\.[\\w]{2,})?")
                .braDate("([0-9]{4})-([0-9]{2})-([0-9]{2})")
                .build();
    }

    @Test
    @DisplayName("Tests if the text passed from the match with the Regex")
    void testFindMatchers() {
        String inputEmails = "bla example@example.com bla bla example@example.com.br bla bla bla";
        List<String> matchersEmails = service.findMatchers(inputEmails, regex.getEmail());

        assertAll("list matcher emails contains?",
                () -> assertTrue(matchersEmails.contains("example@example.com")),
                () -> assertTrue(matchersEmails.contains("example@example.com.br")),
                () -> assertFalse(matchersEmails.contains("bla")),
                () -> assertNotEquals("bla", matchersEmails.toString())
        );

        String inputBraDate = "bla 2000-12-12 bla bla 1999-12-12 bla bla bla";
        List<String> matchersBraDate = service.findMatchers(inputBraDate, regex.getBraDate());

        assertAll("list matcher emails contains?",
                () -> assertTrue(matchersBraDate.contains("2000-12-12")),
                () -> assertTrue(matchersBraDate.contains("1999-12-12")),
                () -> assertFalse(matchersBraDate.contains("bla")),
                () -> assertNotEquals("bla", matchersBraDate.toString())
        );
    }

    @Test
    @DisplayName("Tests whether the date input in US is being transformed into BR data")
    void testTransform() {
        String inputUSDate = "2000-12-12";
        String convertToBraDate = "$3/$2/$1";
        String transform = service.transform(inputUSDate, regex.getBraDate(), convertToBraDate);

        String inputBraDate = "12/12/2000";
        assertAll("converted US date to BR date?",
                () -> assertEquals(transform, inputBraDate),
                () -> assertNotEquals(transform, inputUSDate)
        );
    }
}