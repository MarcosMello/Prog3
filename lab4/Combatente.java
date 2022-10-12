// package lab4;

public class Combatente {
    protected double nivelEnergia;
    protected double dano;
    protected double poderDefesa;

    public boolean estaVivo(){
        return this.nivelEnergia > 0;
    }
    public void atacar(Combatente Personagem){
        Personagem.defender(this.dano);
    }
    public void defender(double poderAtaque){
        this.nivelEnergia -= poderAtaque * (1 - (poderDefesa/100));
    }
}
