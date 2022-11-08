// package lab4;

import java.util.ArrayList;

public class Gladiador extends Combatente{
    private double danoBase = 20;
    private double nivelEnergiaBase = 100;
    private double poderDefesaBase = 50;

    private ArrayList<Arma> armas = new ArrayList<Arma>();
    private ArrayList<Armadura> armaduras = new ArrayList<Armadura>();

    public Gladiador(String nome){
        super(nome);

        super.dano = danoBase;
        super.nivelEnergia = nivelEnergiaBase;
        super.poderDefesa = poderDefesaBase;
    }

    public void addArmadura(Armadura armadura){
        this.armaduras.add(armadura);
    }

    public void addArma(Arma arma){
        this.armas.add(arma);
    }

    public void atacar(Combatente Personagem){
        if (armas.size() != 0){
            super.dano = (armas.get(0).getPowerIncrease() + danoBase);
        } else{
            super.dano = danoBase;
        }

        Personagem.defender(super.dano);
    }

    public void defender(double poderAtaque){
        if (armaduras.size() != 0){
            while(poderAtaque > 0 && armaduras.size() != 0){
                poderAtaque -= armaduras.get(0).getArmorDuration();

                if (poderAtaque >= 0){
                    armaduras.remove(0);
                } else{
                    armaduras.get(0).setArmorDuration(armaduras.get(0).getArmorDuration() - poderAtaque);
                }
            }

            if (poderAtaque > 0){
                super.defender(poderAtaque);
            }
        } else{
            super.defender(poderAtaque);
        }
    }
}