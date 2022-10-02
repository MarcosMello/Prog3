//package lab1;

public class AppDetran {
    public static void main(String[] args){
        Carro carro = new Carro("Fusca");
        Proprietario proprietario = new Proprietario("João", carro);

        System.out.println("Proprietário: " + proprietario.nome);
        System.out.println("Carro: " + proprietario.carro.modelo);
    }
}
