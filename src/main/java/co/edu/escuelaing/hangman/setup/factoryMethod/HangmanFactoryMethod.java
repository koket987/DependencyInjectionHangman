package co.edu.escuelaing.hangman.setup.factoryMethod;

import co.edu.escuelaing.hangman.model.Language;
import co.edu.escuelaing.hangman.model.dictionary.HangmanDictionary;
import co.edu.escuelaing.hangman.view.HangmanPanel;
import org.springframework.stereotype.Component;

@Component
abstract public class HangmanFactoryMethod {
    abstract public Language createLanguage();

    abstract public HangmanDictionary createDictionary();

    abstract public HangmanPanel createHangmanPanel();
}
