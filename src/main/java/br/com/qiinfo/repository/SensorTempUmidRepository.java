package br.com.qiinfo.repository;

import java.util.List;

import br.com.qiinfo.entity.SensorTempUmid;
import br.com.qiinfo.util.ExecutaComandoShell;

/**
 * 
 * Classe responsável pela manipulação do Objeto SensorTempUmid
 * 
 * @author Eric Teles Leite
 *
 */

public class SensorTempUmidRepository {

	private SensorTempUmid sensorTempUmid = new SensorTempUmid();
	
	/**
	 * Construtor vazio para a classe SensorTempUmidRepository
	 */
	public SensorTempUmidRepository() {		
		
	}

	public SensorTempUmid getSensorTempUmid() {
		ExecutaComandoShell executaComandoShell = new ExecutaComandoShell();
	    List<String> tempumid = executaComandoShell.executar("bash /home/eric/TempUmid.sh");
		
	    if(tempumid.get(0).equals("OK")) {
	    	this.sensorTempUmid.setTemperatura(Double.parseDouble(tempumid.get(1)));
		    this.sensorTempUmid.setUmidade(Double.parseDouble(tempumid.get(2)));
		    
	    } else {
	    	
		    this.sensorTempUmid = null;
	    }	
		
		return sensorTempUmid;
	}	
}
