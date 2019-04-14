package com.univ.demo;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import com.univ.demo.Entity.Dictionnaire;

public class Client {




	
	private static final Logger log = LoggerFactory.getLogger(Client.class);

	public static void main(String[] args) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpEntity<Dictionnaire> request = new HttpEntity<>(new Dictionnaire(4,"44QQ66",200, "porche"));
		restTemplate.postForObject("http://localhost:8080/dictionnaires", request, Dictionnaire.class);
		
        List dictionnaires = restTemplate.getForObject("http://localhost:8080/dictionnaires", List.class);
        log.info(dictionnaires.toString());
        
	}


}
