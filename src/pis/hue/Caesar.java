package pis.hue;

/**
 * Caesar-Verfahren
 */

public class Caesar implements Codec {

    private String losungOriginal;
    private int charShift;

    /**
     * Loope durch alle chars im Klartext.
     * Wenn char nicht Zeichen von a-z dann shifte char um "charShift" Postitionen.
     *
     * @param klartext Nachricht, die zu verschluesseln ist.
     * @return Gibt Geheimtext zurück
     */
    @Override
    public String kodiere(String klartext) {
        StringBuilder result = new StringBuilder(klartext);
        for (int i = 0; i < klartext.length(); i++) {
            if (!((int) result.charAt(i) < 97 || (int) result.charAt(i) > 122))
                result.setCharAt(i, (char) (97 + (((int) result.charAt(i) + charShift - 97) % 26)));
        }
        return result.toString();
    }

    /**
     * Loope durch alle chars im Geheimtext.
     * Wenn char nicht außerhalb von a-z, dann shifte char um "charShift" Postionen zurück.
     * Wenn char kleiner
     *
     * @param geheimtext Nachricht, die zu entschlüsseln ist.
     * @return
     */
    @Override
    public String dekodiere(String geheimtext) {
        StringBuilder result = new StringBuilder(geheimtext);
        for (int i = 0; i < geheimtext.length(); i++) {
            char currentChar = Character.toLowerCase(result.charAt(i));
            if (!((int) currentChar < 97 || (int) currentChar > 122)) {
                int offset = 0;
                int asciiPos = 97;
                if (((int) currentChar - 122) <= 0)
                    offset = 26;
                if (Character.isUpperCase(result.charAt(i)))
                    asciiPos = 65;
                result.setCharAt(i, (char) (asciiPos + (((int) result.charAt(i) - charShift - asciiPos + offset) % 26)));
            }
        }
        return result.toString();
    }

    @Override
    public String gibLosung() {
        return losungOriginal;
    }

    /**
     * Prüfe ob Sonderzeichen vorhanden.
     * @param schluessel Neue Losung.
     * @throws IllegalArgumentException
     */
    @Override
    public void setzeLosung(String schluessel) throws IllegalArgumentException {
        losungOriginal = schluessel;
        schluessel = schluessel.toLowerCase();
        for (int i = 0; i < schluessel.length(); i++)
            if ((int) schluessel.charAt(i) < 97 || (int) schluessel.charAt(i) > 122)
                throw new IllegalArgumentException("SONDERZEICHEN NICHT ERLAUBT!");

        charShift = schluessel.length();
    }
}
