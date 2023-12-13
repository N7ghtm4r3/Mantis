package com.tecknobit.mantis;

import net.suuft.libretranslate.Language;
import net.suuft.libretranslate.Translator;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;

/**
 * The {@code com.tecknobit.mantis.Mantis} class is useful to translate all the {@link String} resources in different languages, e.g
 * <pre>
 *     {@code
 * {
 *     // current locale
 *    "it-IT": {
 *         "string_one" : "ciao!",
 *         "string_two": "prova questa libreria :)"
 *     },
 *     // all translations
 *     "en-EN": {
 *         "string_one" : "hello!",
 *         "string_two": "try this library :)"
 *     }
 *     ...
 * }
 *
 *     }
 * </pre>
 * @author N7ghtm4r3 - Tecknobit
 */
public class Mantis {

    /**
     * {@code MANTIS_RESOURCES_PATH} the path where are stored the resources to translate
     */
    private static final String MANTIS_RESOURCES_PATH = "resources.mantis";

    /**
     * {@code currentLocale} the current locale language chosen as default
     */
    private Locale currentLocale;

    /**
     * {@code resources} the resources data
     */
    private JSONObject resources;

    /**
     * Constructor to init the {@link Mantis} object
     *
     * @param currentLocale:{@code currentLocale} the current locale language chosen as default
     *
     */
    public Mantis(String currentLocale) throws IOException {
        this(Locale.forLanguageTag(currentLocale));
    }

    /**
     * Constructor to init the {@link Mantis} object
     *
     * @param currentLocale:{@code currentLocale} the current locale language chosen as default
     *
     */
    public Mantis(Locale currentLocale) throws IOException {
        this.currentLocale = currentLocale;
        try {
            setCurrentResources();
        } catch (IOException e) {
            throw new IOException("The resources file is not found");
        }
    }

    /**
     * Method to get a resource from the {@link #MANTIS_RESOURCES_PATH} resources file in the {@link #currentLocale} chosen
     * @param resourceKey the key of the resource to get e.g. "string_one"
     * @return the resource in the {@link #currentLocale} chosen as {@link String}
     */
    public String getResource(String resourceKey) {
        if(resources.has(resourceKey))
            return resources.getString(resourceKey);
        return "";
    }

    /**
     * Method to change the {@link Locale} for the {@link #currentLocale} chosen
     * @param newLocale: the new {@link Locale} to use
     */
    public void changeCurrentLocale(String newLocale) {
        changeCurrentLocale(Locale.forLanguageTag(newLocale));
    }

    /**
     * Method to change the {@link Locale} for the {@link #currentLocale} chosen
     * @param newLocale: the new {@link Locale} to use
     */
    public void changeCurrentLocale(Locale newLocale) {
        Locale tmpLocale = Locale.forLanguageTag(currentLocale.toLanguageTag());
        this.currentLocale = newLocale;
        try {
            setCurrentResources();
        } catch (IOException e) {
            currentLocale = Locale.forLanguageTag(tmpLocale.toLanguageTag());
        }
    }

    /**
     * Method to read the current resources stored from {@link #MANTIS_RESOURCES_PATH} and to load the {@link #resources}
     * instance <br>
     * No-any params required
     * @throws IOException when an error reading the resources file occurred
     */
    private void setCurrentResources() throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(MANTIS_RESOURCES_PATH);
        if(inputStream == null)
            throw new IOException();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null)
            stringBuilder.append(line);
        resources = new JSONObject(stringBuilder.toString()).getJSONObject(currentLocale.toLanguageTag());
    }

    /**
     * Method to translate a dynamic content
     * @param content: the content to translate
     * @return the content translated as {@link String}
     * @apiNote the translation is executed by the <a href="https://github.com/dynomake/libretranslate-java">
     *     libretranslate-java</a> library
     * @implNote current languages available:
     * RUSSIAN,
     * ENGLISH,
     * ARABIC,
     * AZERBAIJANI,
     * CATALAN,
     * CHINESE,
     * CZECH,
     * DANISH,
     * DUTCH,
     * ESPERANTO,
     * FINNISH,
     * FRENCH,
     * GERMAN,
     * GREEK,
     * HEBREW,
     * HINDI,
     * HUNGARIAN,
     * INDONESIAN,
     * IRISH,
     * ITALIAN,
     * JAPANESE,
     * KOREAN,
     * PERSIAN,
     * POLISH,
     * PORTUGUESE,
     * SLOVAK,
     * SPANISH,
     * SWEDISH,
     * TURKISH,
     * UKRAINIAN
     */
    public String translate(String content) {
        Language language = null;
        for(Language lLanguage : Language.values()) {
            if(lLanguage.getCode().equals(currentLocale.getLanguage()))
                language = lLanguage;
        }
        if(language != null)
            return Translator.translate(language, content);
        return "";
    }

}
