package com.example.Dog.API.consumer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("consulta-dog")
public class DogApiConsumer {

    /*HttpHeaders headers = new HttpHeaders();
		headers.set("x-api-key", "live_kPXxgzvnUVQIwdUuq0njPS9LE16zEsrVdblbemCEnHIGnBZCtw3AtOnEUtVTDSBj");*/

    @GetMapping("{id}")
    public DogDTO getCachorro(@PathVariable("id") int id){
        RestTemplate restTemplate = new RestTemplate();


        String url = "https://api.thedogapi.com/v1/breeds/"+id+":breed_id";

        ResponseEntity<DogDTO> resp = restTemplate.getForEntity(url, DogDTO.class);
        return resp.getBody();
    }
}
