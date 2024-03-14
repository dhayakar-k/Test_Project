package strings;

import java.util.List;
import java.util.Map;

public class SiseStatusDetails {

    private String compName;

    private Map<String, List<String>> translationText;

    public String getCompName() {
        return compName;
    }

    public void setCompName(final String compName) {
        this.compName = compName;
    }

    public Map<String, List<String>> getTranslationText() {
        return translationText;
    }

    public void setTranslationText(final Map<String, List<String>> translationText) {
        this.translationText = translationText;
    }

    @Override
    public String toString() {
        return "{" +
                "compName:" + compName +
                ",translationText:" + translationText +
                "}";
    }
}
