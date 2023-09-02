package com.java.inspSaude.client;

import com.java.inspSaude.dto.InspecaoDTO;
import com.java.inspSaude.dto.MilitarDTO;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MilitarClient {

    public MilitarDTO buscarporId(Long id) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<MilitarDTO> result = restTemplate.exchange("https://swapi.dev/api/people/" + id + "", HttpMethod.GET, null, MilitarDTO.class);
        return result.getBody();
    }
}