// package lab4;

public abstract class Combatente {
    protected double nivelEnergia;
    protected double dano;
    protected double poderDefesa;
    protected String nome;

    public Combatente(String nome){
        this.nome = nome;
    }

    public boolean estaVivo(){
        return this.nivelEnergia > 0;
    }
    public void defender(double poderAtaque){
        this.nivelEnergia -= poderAtaque * (1 - (poderDefesa/100));
    }

    public abstract void atacar(Combatente Personagem);

    public String toString(){
        return nome + " (" + super.toString() + ")";
    }
}
