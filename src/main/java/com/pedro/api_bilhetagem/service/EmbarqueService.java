package com.pedro.api_bilhetagem.service;

import com.pedro.api_bilhetagem.dto.EmbarqueRequestDTO;
import com.pedro.api_bilhetagem.dto.EstatisticaRequestDTO;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
public class EmbarqueService {
    private final List<EmbarqueRequestDTO> listaEmbarques =
            Collections.synchronizedList(new ArrayList<EmbarqueRequestDTO>());

    public void salvar(EmbarqueRequestDTO embarqueRequestDTO){
        listaEmbarques.add(embarqueRequestDTO);
    }

    public void LimparEmbarques(){
        listaEmbarques.clear();
    }

    public EstatisticaRequestDTO calcularEstatistica(){
        OffsetDateTime tempoLimite= OffsetDateTime.now().minusSeconds(60);

        DoubleSummaryStatistics stats = listaEmbarques.stream()
                .filter(t -> t.dataHora().isAfter(tempoLimite))
                .mapToDouble(EmbarqueRequestDTO::valor)
                .summaryStatistics();

        if(stats.getCount()==0){
            return new EstatisticaRequestDTO(0L, 0.0, 0.0, 0.0, 0.0);
        }

        return new EstatisticaRequestDTO(
                stats.getCount(),
                stats.getSum(),
                stats.getAverage(),
                stats.getMin(),
                stats.getMax()
        );
    }
}
