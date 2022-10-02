//package lab2;
public class AppDetran {
    public static void main(String agrs[]){
        Proprietario proprietario = new Proprietario("João");

        Carro carro = new Carro("Fusca", "123456789");
        Carro carro2 = new Carro("Fiat 147", "987654321");

        Multa multa = new Multa("Estacionamento em local proibido", 100);
        Multa multa2 = new Multa("Estacionamento em local proibido", 150);

        proprietario.setCNH("987654321");
        proprietario.addCarro(carro);
        proprietario.addCarro(carro2);
        proprietario.getCarro(0).addMulta(multa);
        proprietario.getCarro(0).addMulta(multa2);
        proprietario.getCarro(1).addMulta(multa2);
        proprietario.getCarro(0).setPlaca("ABC!@#$");
        proprietario.getCarro(1).setPlaca("ABC1234");

        System.out.println("Proprietário: " + proprietario.getNome());
        System.out.println("CNH: " + proprietario.getCNH());
        System.out.println("Carros: ");
        System.out.println(proprietario.getCarros());
        System.out.println("Multas: ");
        for(int i = 0; i < proprietario.getCarros().length; i++){
            System.out.println("Carro " + (i + 1));
            System.out.println(proprietario.getCarro(i).getMultas());
        }
    }
}