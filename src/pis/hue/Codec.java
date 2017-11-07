package pis.hue;

public interface Codec{
    /**
     * Kodiert Nachricht.
     *
     * @param klartext Nachricht, die zu verschluesseln ist.
     * @return Gibt kodierte Nachricht zurück.
     */
    String kodiere(String klartext);

    /**
     * Dekodiert Nachricht.
     *
     * @param geheimtext Nachricht, die zu entschlüsseln ist.
     * @return Gibt entschlüssete Nachricht zurück.
     */
    String dekodiere(String geheimtext);

    /**
     * @return Gibt Losung zurück.
     */
    String gibLosung();

    /**
     * Setzt neue Losung.
     *
     * @param schluessel Neue Losung.
     * @throws IllegalArgumentException Wirft Exception, wenn die Losung Sonderzeichen enthält.
     */
    void setzeLosung(String schluessel) throws IllegalArgumentException; // bei ungeeignetem Schlüssel!
}

