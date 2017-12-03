package soa.jaxrslabs.helloepsiwebservicerestexercice2;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "train")
public class Train {

    private String numTrain;
    private String villeDepart;
    private String villeArrivee;
    private int heureDepart; // Format : 1230 = 12h30

    public Train() {
    }

    public Train(String numTrain, String villeDepart, String villeArrivee, int heureDepart) {
        this.numTrain = numTrain;
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.heureDepart = heureDepart;
    }

    public int getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(int heureDepart) {
        this.heureDepart = heureDepart;
    }
//a completer

    /**
     * @return the numTrain
     */
    public String getNumTrain() {
        return numTrain;
    }

    /**
     * @param numTrain the numTrain to set
     */
    public void setNumTrain(String numTrain) {
        this.numTrain = numTrain;
    }

    /**
     * @return the villeDepart
     */
    public String getVilleDepart() {
        return villeDepart;
    }

    /**
     * @param villeDepart the villeDepart to set
     */
    public void setVilleDepart(String villeDepart) {
        this.villeDepart = villeDepart;
    }

    /**
     * @return the villeArrivee
     */
    public String getVilleArrivee() {
        return villeArrivee;
    }

    /**
     * @param villeArrivee the villeArrivee to set
     */
    public void setVilleArrivee(String villeArrivee) {
        this.villeArrivee = villeArrivee;
    }
}
