package com.univ.demo.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.univ.demo.Entity.Dictionnaire;
import com.univ.demo.Entity.DictionnaireRepository;
import com.univ.demo.Entity.EtudiantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;

@RestController
public class LocationService {
	
	
private List<Dictionnaire> dictionnaires = new ArrayList<Dictionnaire>();

	public LocationService() {
		dictionnaires.add(new Dictionnaire(4,"11AA22",200,"Ferrari"));
		dictionnaires.add(new Dictionnaire(5,"33BB44",400,"Porshe"));
	}
	
	
	@Autowired
	DictionnaireRepository repository;
	
	
	@RequestMapping(value="/dictionnaires", method=RequestMethod.GET) 
	@ResponseStatus(HttpStatus.OK) 
	public List<Dictionnaire> getListOfDictionnaires(){
		
		
try{
			
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextJMS.xml");
			QueueConnectionFactory factory = (QueueConnectionFactory) applicationContext.getBean("connectionFactory");
			
			Queue queue = (Queue) applicationContext.getBean("queue");
			
			// Create a connection. See https://docs.oracle.com/javaee/7/api/javax/jms/package-summary.html	
			QueueConnection connection = factory.createQueueConnection() ;

			// Open a session without transaction and acknowledge automatic
			QueueSession session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE) ;

			// Start the connection
			connection.start();
			
			// Create a sender
			QueueSender sender = session.createSender(queue);
			
			// Create a message
			Message message = session.createTextMessage("bonjour");
			
			// Send the message
			sender.send(message);

			// Close the session
			session.close();
			
			// Close the connection
			connection.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}

		
		return (List<Dictionnaire>) repository.findAll();
	}
	
	@RequestMapping(value = "/dictionnaires", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public String addDictionnaire(@RequestBody Dictionnaire dictionnaire) throws Exception{
		repository.save(dictionnaire);
		return("livre ajouté sans passsage de paramétre");
	}
	
	@RequestMapping(value = "/dictionnaires/{iSBN}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Dictionnaire aDictionnaire(@PathVariable("iSBN") String iSBN) throws Exception{
		return repository.findByISBN(iSBN);
	}
	
	@RequestMapping(value = "/dictionnaires/{iSBN}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public String getBack(@PathVariable("iSBN") String iSBN) throws Exception{
		for(int i=0; i < dictionnaires.size(); i++) {
			if(dictionnaires.get(i).getISBN().equals(iSBN)) {
				if (dictionnaires.get(i).isEmprunt() == true) {dictionnaires.get(i).setEmprunt(false); return("Vous venez de rendre le livre");}
				else return("le livre n'est pas emprunt� donc on ne peut pas la rendre");
			}
		}
		return ("livre non trouvée");
	}
	
	@RequestMapping(value = "/dictionnaires/{iSBN}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public String emprunt(@PathVariable("iSBN") String iSBN) throws Exception{
		for(int i=0; i < dictionnaires.size(); i++) {
			if(dictionnaires.get(i).getISBN().equals(iSBN)) { 
				if (dictionnaires.get(i).isEmprunt() == false) {dictionnaires.get(i).setEmprunt(true); return("Vous venez d'emprunter le livre");}
				else return("le livre est déjà emprunt�");
			}
		}
		return ("Voiture non trouvée");
	}
	
	@RequestMapping(value = "/dictionnaires", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public String addDictionnaire(@RequestParam int numberOfSeats,@RequestParam String plateNumber,@RequestParam int price, @RequestParam String nomv) throws Exception{
		dictionnaires.add(new Dictionnaire(numberOfSeats,plateNumber,price,nomv));
		return ("livre ajoutée avec passage de paramétre");
	}

}
