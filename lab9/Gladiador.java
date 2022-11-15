package lab9;
import java.util.ArrayList;

public class Gladiador extends Lutador {
	ArrayList<Armadura> armaduras;
	ArrayList<Arma> armas;

	public Gladiador() {
		super("Gladiador sem nome " +sequencialNome++);
		armaduras = new ArrayList<>();
		armaduras.add(new Armadura("Armadura de Corpo", 0.5,1));

		armas = new ArrayList<>();

		Arma espada =new Arma("Escalibur");
		espada.addGolpe("Ataque frontal", 50);
		espada.addGolpe("Ataque Lateral", 40);
		armas.add(espada);

	}

	public Gladiador(String nome, double nivelEnergia){
		super(nome, nivelEnergia);

		armas = new ArrayList<>();
		armaduras = new ArrayList<>();
	}

	public Gladiador(String nome, double nivelEnergia, String descArma, String descGolpe, double poderGolpe) {
		this(nome, nivelEnergia);

		Arma arma = new Arma(descArma);
		arma.addGolpe(descGolpe, poderGolpe);
		armas.add(arma);
	}

	public Gladiador(String nome, double nivelEnergia, String descArmadura, double poderDefesa, double estadoConsevacao){
		this(nome, nivelEnergia);

		armaduras.add(new Armadura(descArmadura, poderDefesa, estadoConsevacao));
	}

	public Gladiador(String nome, double nivelEnergia, String descArma, String descGolpe, double poderGolpe, String descArmadura, double poderDefesa, double estadoConsevacao){
		this(nome, nivelEnergia);

		Arma arma = new Arma(descArma);
		arma.addGolpe(descGolpe, poderGolpe);
		armas.add(arma);

		armaduras.add(new Armadura(descArmadura, poderDefesa, estadoConsevacao));
	}

	public void addArmadura(ArrayList<Armadura> armaduras) {
		this.armaduras.addAll(armaduras);
	}


	public void addArma(ArrayList<Arma> armas) {
		this.armas.addAll(armas);
	}


	@Override
	public void atacar(Personagem personagem) {
		//super.atacar(personagem);

		int tipoAtaque = (int) (Math.random() * 3);

		if (tipoAtaque == 0) socar(personagem);
		else if (tipoAtaque == 1) chutar(personagem);
		else if (tipoAtaque == 2) usarArma(personagem);

	}


	private void usarArma(Personagem personagem) {
		if(armas.size() > 0) {
			int tipoArma = (int) (Math.random() * armas.size());
			Arma arma= armas.get(tipoArma);

			if(Math.random() >0.5) {
				personagem.defender(arma.pegarGolpeRandomico().poderOfensivo);
			}else {
			Golpe golpeMortal;

				if(Math.random() >0.5) {
					golpeMortal = arma.explodir();
				}else {
					golpeMortal = arma.atirar();
				}

				personagem.defender(golpeMortal.poderOfensivo);
			}
		}

	}

	@Override
	public void defender(double poderAtaque) {
		//super.defender(poderAtaque);

		int tipoDefesa = (int) (Math.random() * 4);

		if (tipoDefesa == 0) esquivar(poderAtaque);
		else if (tipoDefesa == 1) fazerGuarda(poderAtaque);
		else if (tipoDefesa == 2) usarArmadura(poderAtaque);
		else {
			nivelEnergia = nivelEnergia - poderAtaque;
		}
	}

	private void usarArmadura(double poderAtaque) {
		if(armaduras.size() > 0) {
			int tipoArmadura = (int) (Math.random() * armaduras.size());
			Armadura armadura= armaduras.get(tipoArmadura);

			double intensidadeAtaque = armadura.poderDefesa * poderAtaque;

			this.nivelEnergia = nivelEnergia - intensidadeAtaque;

			//armadura.estadoConsevacao--;
		}

	}

	@Override
	public String textToCSV() {
		String retorno = "";
		String header = "Gladiador;" + this.nome +";" + String.format("%.2f", this.nivelEnergia) + ";";

		for (Arma arma : armas) {
			ArrayList<Golpe> golpes = arma.getGolpes();
			for (Golpe golpe : golpes) {
				retorno+=header + arma.descricao + ";" + golpe.nomeGolpe + ";" + String.format("%.2f", golpe.poderOfensivo) + "\r\n";
			}
		}

		for (Armadura armadura : armaduras) {
			retorno+=header + ";;;" + armadura.descricao+ ";" +String.format("%.2f",armadura.poderDefesa) + ";" + String.format("%.2f",armadura.poderDefesa) + "\r\n";
		}

		return retorno;
	};


}

class Armadura{
	String descricao;
	double poderDefesa;
	double estadoConsevacao;
	public Armadura(String descricao, double poderDefesa, double estadoConsevacao) {
		super();
		this.descricao = descricao;
		this.poderDefesa = poderDefesa;
		this.estadoConsevacao = estadoConsevacao;
	}




}