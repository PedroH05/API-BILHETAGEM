package com.pedro.api_bilhetagem.controller;

import com.pedro.api_bilhetagem.dto.EmbarqueRequestDTO;
import com.pedro.api_bilhetagem.dto.EstatisticaRequestDTO;
import com.pedro.api_bilhetagem.service.EmbarqueService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@RestController
public class EmbarqueController {

    @Autowired
    private EmbarqueService embarqueService;

    @PostMapping("/embarque")
    public ResponseEntity<Void> postEmbarque(@Valid @RequestBody EmbarqueRequestDTO request){
        embarqueService.salvar(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/estatistica")
    public ResponseEntity<EstatisticaRequestDTO> getEstatistica(){
        var estatistica = embarqueService.calcularEstatistica();
        return ResponseEntity.ok(estatistica);
    }

    @DeleteMapping("/embarque")
    public ResponseEntity<Void> deleteEmbarque(){
        embarqueService.LimparEmbarques();
        return ResponseEntity.ok().build();
    }
}
