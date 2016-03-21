package br.com.qiinfo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.qiinfo.entity.SensorTempUmid;
import br.com.qiinfo.repository.SensorTempUmidRepository;

/**
 * 
 * Classe reponsável por receber as requisições através do Webservice
 * para objetos do tipo SensorTempUmid
 * 
 * @author Eric Teles Leite
 *
 */
@RestController
public class SensorTempUmidResource {

	/**
	 * Construtor vazio da classe SensorTempUmidResource
	 */
	public SensorTempUmidResource() {
		
	}
	
	/**
	 * Método responsável por receber requisição de leitura de Temperatura/Umidade
	 * do sensor DHT11 e retornar valor através do WebService
	 * @return
	 */
	@RequestMapping( value = "/TempUmid", method = RequestMethod.GET)
	public ResponseEntity<SensorTempUmid> getTempUmid() {
		
		SensorTempUmidRepository sensorTempUmidRepository = new SensorTempUmidRepository();
	  	SensorTempUmid sensorTempUmid = sensorTempUmidRepository.getSensorTempUmid();
		
		if(sensorTempUmid == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<SensorTempUmid>(sensorTempUmid, HttpStatus.OK);
	}
	
}
