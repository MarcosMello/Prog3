//package lab2;
import java.util.*;

public class Carro {
    private String modelo;
    private String chassi;
    private String placa;
    private ArrayList<Multa> multas = new ArrayList<Multa>();

    public Carro(String modelo, String chassi){
        this.modelo = modelo;
        this.chassi = chassi;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public String getModelo(){
        return this.modelo;
    }

    public void setChassi(String chassi){
        this.chassi = chassi;
    }

    public String getChassi(){
        return this.chassi;
    }

    public boolean setPlaca(String placa){
        if (placa.length() != 7){
            return false;
        }

        this.placa = placa;
        return true;
    }

    public String getPlaca(){
        return this.placa;
    }

    public void addMulta(Multa multa){
        this.multas.add(multa);
    }

    public Multa[] getMultas(){
        return this.multas.toArray(new Multa[multas.size()]);
    }

    public Multa getMulta(int pos){
        return this.multas.get(pos);
    }
}
