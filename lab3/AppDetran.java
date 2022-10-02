//package lab2;
import java.util.*;

public class AppDetran {
    private static String createPlaca(int seq){
        Random gerador = new Random();
        String placa = "";
        for (int i : gerador.ints(3, (int) 'A', ((int) 'Z') + 1).toArray()) {
            placa += (char) i;
        }
        placa += '-';
        placa += gerador.nextInt(10);
        placa += (char) (gerador.ints(1, (int) 'A', ((int) 'Z') + 1).toArray()[0]);
        placa += String.format("%03d", seq);

        return placa;
    }

    public static void main(String agrs[]){
        int seq = 0;

        ArrayList<Proprietario> proprietarios = new ArrayList<Proprietario>();
        ArrayList<Carro> carros = new ArrayList<Carro>();
        ArrayList<Multa> multas = new ArrayList<Multa>();

        proprietarios.add(new Proprietario("João"));

        carros.add(new Carro("Fusca", "123456789"));
        carros.add(new Carro("Fiat 147", "987654321"));

        multas.add(new Multa("Estacionamento em local proibido", 100));
        multas.add(new Multa("Estacionamento em local proibido", 150));

        proprietarios.get(0).setCNH("987654321");
        proprietarios.get(0).addCarro(carros.get(0));
        proprietarios.get(0).addCarro(carros.get(1));
        proprietarios.get(0).getCarro(0).addMulta(multas.get(0));
        proprietarios.get(0).getCarro(0).addMulta(multas.get(1));
        proprietarios.get(0).getCarro(1).addMulta(multas.get(1));
        proprietarios.get(0).getCarro(0).setPlaca(createPlaca(++seq));
        proprietarios.get(0).getCarro(1).setPlaca(createPlaca(++seq));

        System.out.println("Proprietário: " + proprietarios.get(0).getNome());
        System.out.println("CNH: " + proprietarios.get(0).getCNH());
        System.out.println("Carros: ");
        System.out.println(proprietarios.get(0).getCarros());
        System.out.println("Multas: ");
        for(int i = 0; i < proprietarios.get(0).getCarros().length; i++){
            System.out.println("Carro " + (i + 1) + " - Placa: " + proprietarios.get(0).getCarro(i).getPlaca());
            System.out.println(proprietarios.get(0).getCarro(i).getMultas());
        }

        System.out.println("Numero de proprietarios criados: " + proprietarios.size());
        System.out.println("Numero de multas criadas: " + multas.size());
        System.out.println("Numero de carros criados: " + carros.size());
    }
}