import java.util.*;
public class Lixeira {
    public static void main(String args[]){
        Random gerador = new Random();
        String placa = "";
        for (int i : gerador.ints(3, (int) 'A', ((int) 'Z') + 1).toArray()) {
            placa += (char) i;
        }
        placa += '-';
        placa += gerador.nextInt(10);
        placa += (char) (gerador.ints(1, (int) 'A', ((int) 'Z') + 1).toArray()[0]);
        for (int i : gerador.ints(3, 0, 10).toArray()){
            placa += i;
        }
        System.out.println(placa);
    }
}
