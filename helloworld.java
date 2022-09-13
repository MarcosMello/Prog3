import javax.swing.JOptionPane;

public class helloworld {
    public static void main(String args[]){
        int n1, n2, soma; //comentario /* comentario */

        String texto = "Hello World!";
        System.out.println(texto);

        n1 = 10;
        n2 = 10;
        soma = n1 + n2;

        System.out.println("Soma: " + soma);

        int var = Integer.parseInt(JOptionPane.showInputDialog("Mensagem"));
        System.out.println("Valor digitado: " + var);
    }
}