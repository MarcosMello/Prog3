//package lab2;
public class Multa {
    private String infracao;
    private float valor;

    public Multa(String infracao, float valor){
        this.infracao = infracao;
        this.valor = valor;
    }

    public String getInfracao(){
        return this.infracao;
    }

    public void setInfracao(String infracao){
        this.infracao = infracao;
    }

    public float getValor(){
        return this.valor;
    }

    public void setValor(float valor){
        this.valor = valor;
    }
}
