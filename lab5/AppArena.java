// package lab4;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Random;

public class AppArena {
    public int lutadores = 0;
    public int gladiadores = 0;

    public static Gladiador createGladiador(AppArena appArena){
        int maxA = 10;
        int nA = (int) (Math.random() * maxA);

        int armorLife, armaDamage;

        Gladiador gladiador = new Gladiador("Gladiador " + (appArena.gladiadores++));

        for (int i = 0; i < nA; i++){
            armorLife = ((int) (Math.random() * 100));
            gladiador.addArmadura(new Armadura(armorLife > 50 ? 50 : armorLife));
        }

        if (Math.random() > 0.5){
            armaDamage = ((int) (Math.random() * 100));
            armaDamage = armaDamage > 40 ? 40 : armaDamage;

            Arma arma = new Arma("Espada", armaDamage);

            gladiador.addArma(arma);
        }

        return gladiador;
    }

    public static Lutador createLutador(AppArena appArena){
        return new Lutador("Lutador " + (appArena.lutadores++));
    }

    public static Combatente startFights(AppArena appArena){
        int maxC = 10;
        int nC = 0;

        ArrayList<Combatente> combatentes = new ArrayList<Combatente>();

        do{
            nC = (int) (Math.random() * maxC);
        }while(nC == 0);

        for (int i = 0; i < nC; i++){
            combatentes.add(Math.random() > 0.5 ? createLutador(appArena) : createGladiador(appArena));
        }

        System.out.println(combatentes.toString());

        while(combatentes.size() > 1){
            int c1 = 0, c2 = 0;

            Random gerador = new Random();

            do{
                c1 = gerador.ints(1, 0, combatentes.size()).toArray()[0];
                c2 = gerador.ints(1, 0, combatentes.size()).toArray()[0];
            }while(c1 == c2);

            Combatente combatente1 = combatentes.get(c1);
            Combatente combatente2 = combatentes.get(c2);

            boolean t1 = true;

            System.out.println("Combatente 1: " + combatente1);
            System.out.println("Combatente 2: " + combatente2);

            while(combatente1.estaVivo() && combatente2.estaVivo()){
                if (t1){
                    combatente1.atacar(combatente2);
                } else{
                    combatente2.atacar(combatente1);
                }

                t1 = !t1;
            }

            if (!combatente1.estaVivo()){
                combatentes.remove(c1);
            }
            if(!combatente2.estaVivo()){
                combatentes.remove(c2);
            }
        }

        return combatentes.get(0);
    }

    public static void main(String args[]){
        AppArena appArena = new AppArena();

        System.out.println("Ganhador: " + startFights(appArena).toString());
    }
}
