import javax.swing.JOptionPane;

public class exerciciobasico1 {
    public static void main(String args[]){
        Double ti, tf, si, sf, vel;

        ti = Double.parseDouble(JOptionPane.showInputDialog("Digite o tempo inicial: "));
        tf = Double.parseDouble(JOptionPane.showInputDialog("Digite o tempo final: "));
        si = Double.parseDouble(JOptionPane.showInputDialog("Digite a posição inicial: "));
        sf = Double.parseDouble(JOptionPane.showInputDialog("Digite a posição final: "));

        vel = 3.6 * ((sf - si) / (tf-ti));

        System.out.println("Velocidade: " + vel);
    }
}
