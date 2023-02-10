package mk.ukim.finki.emt_193005.model.enumerations;

import java.util.List;

public enum Category {
    NOVEL("NOVEL"),
    THRILLER("THRILLER"),
    HISTORY("HISTORY"),
    FANTASY("FANTASY"),
    BIOGRAPHY("BIOGRAPHY"),
    CLASSICS("CLASSICS"),
    DRAMA("DRAMA");

    private final String displayValue;

    Category(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
