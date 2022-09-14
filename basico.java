import java.util.Scanner;

public class basico {
    public static void main(String args[]){
        double ti, tf, si, sf, vel;

        Scanner in = new Scanner(System.in);

        System.out.print("Digite o tempo inicial: ");
        ti = in.nextDouble();

        System.out.print("Digite o tempo final: ");
        tf = in.nextDouble();

        System.out.print("Digite a posição inicial: ");
        si = in.nextDouble();

        System.out.print("Digite a posição final: ");
        sf = in.nextDouble();

        vel = 3.6 * ((sf - si) / (tf-ti));

        System.out.println("Velocidade: " + vel);

        if (vel > 100){
            System.out.println("Velocidade acima do permitido!");
        }
        else{
            System.out.println("Velocidade dentro do permitido!");
        }

        boolean vel2 = vel > 100 ? true : false;

        System.out.println("Velocidade acima do permitido? " + (vel2 ? "Sim" : "Não"));

        switch ((int) vel){
            case 100:
                System.out.println("Velocidade acima do permitido!\nMulta: R$ 100,00");
                break;
            case 200:
                System.out.println("Velocidade acima do permitido!\nMulta: R$ 1000,00");
                break;
            default:
                System.out.println("Velocidade dentro do permitido!");
                break;
        }

        while (true){
            System.out.println("OI");
            break;
        }

        do{
            System.out.println("OI");
            break;
        }while(true);

        for(int i = 0; i < 10; i++){
            System.out.println("OI");
        }

        int numeros[] = new int[5];
        int[] numeros2 = new int[numeros.length];

        for (int i = 0; i < numeros.length; i++){
            numeros[i] = i;
            numeros2[i] = i;
        }

        String nomes[] = {"João", "Maria", "José", "Pedro", "Paulo"};

        System.out.println(nomes.length);
        System.out.println(nomes[0]);

        String[][] dados = {{"Marcos", "Marcos"},
                            {"Mbrcos", "Mbrcos"},
                            {"Mcrcos", "Mcrcos"}};

        System.out.println(dados[0][0]);
        System.out.println(dados[2][1]);

        String str1 = "Oi";
        String str2 = "Oi";

        if (str1.equals(str2)){
            System.out.println("Iguais");
        }
        else{
            System.out.println("Diferentes");
        }

        if (str1 == str2){ //Melhor não utilizar esse
            System.out.println("Iguais");
        }
        else{
            System.out.println("Diferentes");
        }

        /** JAVA DOC - COMENTARIOS PUBLICOS **/

        in.close();
    }
}
