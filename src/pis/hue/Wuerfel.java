package pis.hue;

import java.util.Arrays;
import java.util.Hashtable;

public class Wuerfel implements Codec {

    String losung;

    @Override
    public String kodiere(String klartext){
        int[] originalOrder = new int[losung.length()];
        for(int i = 0; i < originalOrder.length; i++)
            originalOrder[i] = i;
            char[] sortedLosung = losung.toCharArray();
        Arrays.sort(sortedLosung);
        Hashtable<Integer, Character> hashtable = new Hashtable<>();
        for(int i = 0; i < originalOrder.length; i++)
            hashtable.put(originalOrder[i],sortedLosung[i]);
    }

    @Override
    public String dekodiere(String geheimtext) {
        return null;
    }

    @Override
    public String gibLosung() {
        return losung;
    }

    @Override
    public void setzeLosung(String schluessel) throws IllegalArgumentException {
        losung = schluessel;
    }
}
