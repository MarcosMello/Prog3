package lab10.filemonitor;

import br.ufes.llcostalonga.lab10.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AppSharedArena extends AppArena implements  PropertyChangeListener {

	
	
	public AppSharedArena(String dir) throws InterruptedException {
		super();
		MeuMonitorArquivos monitor = new MeuMonitorArquivos(dir);
		monitor.addListener(this);
		monitor.iniciarMonitoramento();
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println("Novo arquivo encontrado:" + evt.getNewValue());
		String filePath = evt.getNewValue().toString();
		this.loadData(filePath);
		this.iniciarCombates();
	}
	
	public static void main(String[] args) {
		try {
			String filePath = "G:/My Drive/POOARENA";
			System.out.println("Monitorando o diret�rio " + filePath);
			AppSharedArena arena = new AppSharedArena(filePath);
			
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
