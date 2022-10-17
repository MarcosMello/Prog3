// package lab4;

public class Lutador extends Combatente{
    private double danoBase = 40;
    private double nivelEnergiaBase = 200;
    private double poderDefesaBase = 60;

    private int count = 0;
    private double ultDano = 70;
    private double ultDefesa = 65;

    public Lutador(String nome){
        super(nome);

        super.dano = danoBase;
        super.nivelEnergia = nivelEnergiaBase;
        super.poderDefesa = poderDefesaBase;
    }

    public void atacar(Combatente Personagem){
        if (count == 5){
            super.dano = ultDano;
            count = 0;
        } else{
            super.dano = danoBase;
            count++;
        }

        super.atacar(Personagem);
    }

    public void defender(double poderAtaque){
        if (count == 5){
            super.poderDefesa = ultDefesa;
            count = 0;
        } else{
            super.poderDefesa = poderDefesaBase;
            count++;
        }

        super.defender(poderAtaque);
    }
}
