//package lab2;
import java.util.*;

public class Proprietario {
    private String nome;
    private String CNH;
    private ArrayList<Carro> carros = new ArrayList<Carro>();

    public Proprietario(String nome){
        this.nome = nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setCNH(String CNH){
        this.CNH = CNH;
    }

    public String getCNH(){
        return this.CNH;
    }

    public void addCarro(Carro carro){
        this.carros.add(carro);
    }

    public Carro[] getCarros(){
        return this.carros.toArray(new Carro[this.carros.size()]);
    }

    public Carro getCarro(int pos){
        return this.carros.get(pos);
    }
}
