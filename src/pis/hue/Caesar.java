package pis.hue;

public class Caesar implements Codec {

    private String losung;
    private int charShift = 3;

    @Override
    public String kodiere(String klartext) {
        StringBuilder result = new StringBuilder(klartext);
        for (int i = 0; i < klartext.length(); i++) {
            if (!((int) result.charAt(i) < 97 || (int) result.charAt(i) > 172))
                result.setCharAt(i, (char) (97 + (((int) result.charAt(i) + charShift - 97) % 26)));
        }
        return result.toString();
    }

    @Override
    public String dekodiere(String geheimtext) {
        StringBuilder result = new StringBuilder(geheimtext);
        for (int i = 0; i < geheimtext.length(); i++) {
            if (!((int) result.charAt(i) < 97 || (int) result.charAt(i) > 172)) {
                int offset = 0;
                if (((int) result.charAt(i) - 122) <= 0)
                    offset = 26;
                result.setCharAt(i, (char) (97 + (((int) result.charAt(i) - charShift - 97 + offset) % 26)));
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
    }
}
