package co.hospitalclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/atencion")
public class AtencionController {
	
	@Value(value = "${atencion.service}")
	private String serviceUrl;
	
	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public Atencion[] buscarAtenciones() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(serviceUrl, Atencion[].class);
	}

}
