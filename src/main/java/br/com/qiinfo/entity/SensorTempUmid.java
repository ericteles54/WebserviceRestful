package br.com.qiinfo.entity;

import java.io.Serializable;

/**
 * 
 * Classe responsável por modelar objeto do sensor DHT11
 * que possui informações de temperatura e umidade 
 * 
 * @author Eric Teles Leite
 *
 */

public class SensorTempUmid implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private double temperatura;
	private double umidade;
	
	public double getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}
	public double getUmidade() {
		return umidade;
	}
	public void setUmidade(double umidade) {
		this.umidade = umidade;
	}
}
