// package lab4;

public class Arma {
    private String descricao;
    private double powerIncrease;

    public Arma(String descricao, double powerIncrease){
        this.descricao = descricao;
        this.powerIncrease = powerIncrease;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public String getDescricao(){
        return this.descricao;
    }

    public void setPowerIncrease(double powerIncrease){
        this.powerIncrease = powerIncrease;
    }
    public double getPowerIncrease(){
        return this.powerIncrease;
    }
}