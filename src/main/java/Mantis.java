import com.tecknobit.apimanager.formatters.JsonHelper;
import net.suuft.libretranslate.Language;
import net.suuft.libretranslate.Translator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;

public class Mantis {

    private static final String MANTIS_RESOURCES_PATH = "resources.mantis";

    private Locale currentLocale;

    private JsonHelper resources;

    public Mantis(String currentLocale) throws IOException {
        this(Locale.forLanguageTag(currentLocale));
    }

    public Mantis(Locale currentLocale) throws IOException {
        try {
            setCurrentResources();
        } catch (IOException e) {
            throw new IOException("The resources file is not found");
        }
        this.currentLocale = currentLocale;
    }

    private void setCurrentResources() throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(MANTIS_RESOURCES_PATH);
        if(inputStream == null)
            throw new IOException();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null)
            stringBuilder.append(line);
        resources = new JsonHelper(stringBuilder.toString());
    }

    public String getResource(String resourceKey) {
        return resources.getJsonHelper(currentLocale.toLanguageTag()).getString(resourceKey, "");
    }

    public void changeCurrentLocale(String newLocale) {
        changeCurrentLocale(Locale.forLanguageTag(newLocale));
    }

    public void changeCurrentLocale(Locale newLocale) {
        this.currentLocale = newLocale;
    }

    /**
     * RUSSIAN
     * ENGLISH
     * ARABIC
     * AZERBAIJANI
     * CATALAN
     * CHINESE
     * CZECH
     * DANISH
     * DUTCH
     * ESPERANTO
     * FINNISH
     * FRENCH
     * GERMAN
     * GREEK
     * HEBREW
     * HINDI
     * HUNGARIAN
     * INDONESIAN
     * IRISH
     * ITALIAN
     * JAPANESE
     * KOREAN
     * PERSIAN
     * POLISH
     * PORTUGUESE
     * SLOVAK
     * SPANISH
     * SWEDISH
     * TURKISH
     * UKRAINIAN
     * @param content
     * @return
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
