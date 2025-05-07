

public class Aereo {
    int codiceVolo;
    String impresaCostruttrice;
    int maxPasseggeri;
    int passeggieri;
    int maxPesoBagagli;
    int pesoBagagli;
    boolean andataERitorno;
    boolean serbatoioPieno;

    public Aereo(){
        this.codiceVolo = 0;
        this.impresaCostruttrice = "";
        this.maxPasseggeri = 0;
        this.passeggieri = 0;
        this.maxPesoBagagli = 0;
        this.pesoBagagli = 0;
        this.serbatoioPieno = false;
        this.andataERitorno = false;
    }

    public Aereo(int codiceVolo, String impresaCostruttrice, int maxPasseggeri, int passeggieri, int maxPesoBagagli, boolean andataERitorno, boolean serbatoioPieno){
        this.codiceVolo = codiceVolo;
        this.impresaCostruttrice = impresaCostruttrice;
        this.maxPasseggeri = maxPasseggeri;
        this.passeggieri = passeggieri;
        this.maxPesoBagagli = maxPesoBagagli;
        this.pesoBagagli = 0;
        this.andataERitorno = andataERitorno;
        this.serbatoioPieno = serbatoioPieno;
    }

    public int getCodiceVolo() {
        return codiceVolo;
    }

    public void setCodiceVolo(int codiceVolo) {
        this.codiceVolo = codiceVolo;
    }

    public String getImpresaCostruttrice() {
        return impresaCostruttrice;
    }

    public void setImpresaCostruttrice(String impresaCostruttrice) {
        this.impresaCostruttrice = impresaCostruttrice;
    }

    public int getMaxPasseggeri() {
        return maxPasseggeri;
    }

    public void setMaxPasseggeri(int maxPasseggeri) {
        this.maxPasseggeri = maxPasseggeri;
    }

    public int getPasseggieri() {
        return passeggieri;
    }

    public void setPasseggieri(int passeggieri) {
        this.passeggieri = passeggieri;
    }

    public int getMaxPesoBagagli() {
        return maxPesoBagagli;
    }

    public void setMaxPesoBagagli(int maxPesoBagagli) {
        this.maxPesoBagagli = maxPesoBagagli;
    }

    public int getPesoBagagli() {
        return pesoBagagli;
    }

    public void setPesoBagagli(int pesoBagagli) {
        this.pesoBagagli = pesoBagagli;
    }

    public boolean getAndataERitorno() {
        return andataERitorno;
    }

    public void setAndataERitorno(boolean andataERitorno) {
        this.andataERitorno = andataERitorno;
    }
    
    public boolean getSerbatoioPieno() {
        return serbatoioPieno;
    }

    public void setSerbatoioPieno(boolean serbatoioPieno) {
        this.serbatoioPieno = serbatoioPieno;
    }

    public void caricaPasseggieri(int passeggieriNuovi){
        if(getPasseggieri() + passeggieriNuovi > getMaxPasseggeri()){
            setPasseggieri(getMaxPasseggeri());
        }else{
            setPasseggieri(getPasseggieri() + passeggieriNuovi);
        }
    }

    public void scaricaPasseggieri(){
       setPasseggieri(0); 
    }

    public boolean prontoAlDecollo(){
        return (getPasseggieri() == getMaxPasseggeri()) || (getPesoBagagli() == getMaxPesoBagagli());
    }

    @Override
    public String toString() {
        return "Aereo con: \ncodice di volo: " + codiceVolo + "\nimpresa costruttrice: " + impresaCostruttrice + "\nmax passeggeri: "
                + maxPasseggeri + "\npasseggieri: " + passeggieri + "\nmaxPesoBagagli: " + maxPesoBagagli
                + "\npeso bagagli:" + pesoBagagli + "\nandata e ritorno?:" + andataERitorno + "\nserbatoio pieno?:"
                + serbatoioPieno;
    }

    public String toStringCodiceVolo() {
        return "Aereo con codice di volo: " + codiceVolo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Aereo other = (Aereo) obj;
        if (codiceVolo != other.codiceVolo)
            return false;
        if (impresaCostruttrice == null) {
            if (other.impresaCostruttrice != null)
                return false;
        } else if (!impresaCostruttrice.equals(other.impresaCostruttrice))
            return false;
        if (maxPasseggeri != other.maxPasseggeri)
            return false;
        if (maxPesoBagagli != other.maxPesoBagagli)
            return false;
        return true;
    }

    

    



    
}
