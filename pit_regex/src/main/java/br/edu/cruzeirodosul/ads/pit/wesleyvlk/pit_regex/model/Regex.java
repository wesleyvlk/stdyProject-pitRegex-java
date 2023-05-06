package br.edu.cruzeirodosul.ads.pit.wesleyvlk.pit_regex.model;

import lombok.Getter;
import lombok.Setter;

import java.util.regex.Pattern;

@Getter
@Setter
public class Regex {

    private Pattern email;

    private Pattern braDate;

    private Regex(String emailRegex, String braDateRegex) {
        this.email = Pattern.compile(emailRegex);
        this.braDate = Pattern.compile(braDateRegex);
    }

    public static class Builder {
        private String emailRegex;
        private String braDateRegex;

        public Builder email(String emailRegex) {
            this.emailRegex = emailRegex;
            return this;
        }

        public Builder braDate(String braDateRegex) {
            this.braDateRegex = braDateRegex;
            return this;
        }

        public Regex build() {
            return new Regex(emailRegex, braDateRegex);
        }
    }

}
