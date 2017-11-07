package pis.hue;

import java.util.ArrayList;

public class Wuerfel implements Codec {

    private String losung;
    private ArrayList<Integer> codes;

    @Override
    public String kodiere(String klartext) {
        return generateMessage(false, klartext);
    }

    @Override
    public String dekodiere(String geheimtext) {
        return generateMessage(true, geheimtext);
    }

    /**
     * Generiert ver- oder entschluesselte Nachricht
     *
     * @param decode true: Entschluesseln, false: Verschluesseln
     * @param text   Nachricht
     * @return gibt ver- oder entschlüsselte Nachricht zurück
     */
    private String generateMessage(boolean decode, String text) {
        StringBuilder result;
        if (decode)
            result = new StringBuilder(text);
        else
            result = new StringBuilder("");
        int counter = 0;
        for (int a = 0; a < codes.size(); a++) {
            for (int i = 0; i < codes.size(); i++) {
                if (codes.get(i) == a) {
                    for (int e = 0; e < Integer.MAX_VALUE; e++) {
                        try {
                            if (decode) {
                                result.setCharAt(i + e * (codes.size()), text.charAt(counter));
                                counter++;
                            } else {
                                result.append(text.substring(i + e * (codes.size()), i + e * (codes.size()) + 1));
                            }
                        } catch (StringIndexOutOfBoundsException ex) {
                            break;
                        }
                    }
                }
            }
        }
        return result.toString();
    }

    @Override
    public String gibLosung() {
        return losung;
    }

    @Override
    public void setzeLosung(String schluessel) throws IllegalArgumentException {
        schluessel = schluessel.toLowerCase();
        for (int i = 0; i < schluessel.length(); i++)
            if ((int) schluessel.charAt(i) < 97 || (int) schluessel.charAt(i) > 172)
                throw new IllegalArgumentException("SONDERZEICHEN NICHT ERLAUBT!");

        losung = schluessel;
        codes = generateCodes();
    }

    /**
     * Nummeriert chars des Losungswortes.
     *
     * @return gibt Liste mit Nummerierungen zurück.
     */
    private ArrayList<Integer> generateCodes() {
        ArrayList<Integer> codes = new ArrayList<>();
        for (int i = 0; i < losung.length(); i++) {
            codes.add((int) losung.charAt(i));
        }

        for (int a = 0; a < codes.size(); a++) {
            int max = 0;
            int index = 0;
            for (int i = 0; i < codes.size(); i++) {
                if (codes.get(i) >= max) {
                    max = codes.get(i);
                    index = i;
                }
            }
            codes.set(index, codes.size() - 1 - a);
        }
        return codes;
    }
}