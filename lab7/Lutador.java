//package lab7;

public class Lutador extends Combatente implements ArtesInterface{
    private double danoBase = 40; //dadosBases.LUTADOR.danoBase();
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

    public void chutar(Combatente Personagem){
        super.dano = ultDano;
        this.count = 0;
    }

    public void socar(Combatente Personagem){
        super.dano = danoBase;
        this.count++;
    }

    public void atacar(Combatente Personagem){
        if (count == 5){
            chutar(Personagem);
        } else{
            socar(Personagem);
        }

        Personagem.defender(super.dano);
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
