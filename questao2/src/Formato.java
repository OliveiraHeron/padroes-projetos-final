import java.util.Locale;

public class Formato {
    private static final Locale BR = Locale.forLanguageTag("pt-BR");
    public static String moeda(double v) { return String.format(BR, "R$ %,.2f", v); }
}
