package entidades;

public class RegistroSensor {
    String numSensor;
    int umidade, concenPotassio;
    float ph;

    public String getNumSensor() {
        return numSensor;
    }

    public RegistroSensor(String numSensor, int umidade, int concenPotassio, float ph) {
        this.numSensor = numSensor;
        this.umidade = umidade;
        this.concenPotassio = concenPotassio;
        this.ph = ph;
    }

    public void setNumSensor(String numSensor) {
        this.numSensor = numSensor;
    }

    public int getUmidade() {
        return umidade;
    }

    public void setUmidade(int umidade) {
        this.umidade = umidade;
    }

    public int getConcenPotassio() {
        return concenPotassio;
    }

    public void setConcenPotassio(int concenPotassio) {
        this.concenPotassio = concenPotassio;
    }

    public float getPh() {
        return ph;
    }

    public void setPh(float ph) {
        this.ph = ph;
    }

    @Override
    public String toString() {
        return "Sensor: " + numSensor + "\nUmidade = " + umidade + "\nConcentração de Potássio = " + concenPotassio
                + "\nPh = " + ph + ".";
    }

}
