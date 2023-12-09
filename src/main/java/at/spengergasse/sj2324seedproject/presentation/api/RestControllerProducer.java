package at.spengergasse.sj2324seedproject.presentation.api;

import at.spengergasse.sj2324seedproject.domain.Producer;
import at.spengergasse.sj2324seedproject.presentation.api.dtos.ProducerDTO;
import at.spengergasse.sj2324seedproject.service.ServiceProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/producer")
public class RestControllerProducer{

    private final ServiceProducer serviceProducer;

    @GetMapping()
    public List<ProducerDTO> fetchProducers(@RequestParam Optional<String> nameParam){
        List<ProducerDTO> result       = new ArrayList<>();
        List<Producer>    persProducer = serviceProducer.fetchProducer(nameParam);
        for(Producer pro: persProducer){
            ProducerDTO producerDTO = new ProducerDTO(pro);
            result.add(producerDTO);
        }
        return result;
        //        return  persistenceProducer.findAll()
        //                        .stream()
        //                        .map(ProducerDTO::new)
        //                        .toList();
    }

    //    @GetMapping()
    //    public List<ProducerDTO> fetchProducersName(@RequestParam Optional<String> namePart){
    //
    //        List<ProducerDTO> result       = new ArrayList<>();
    //        List<Producer>    persProducer = serviceProducer.fetchProducerName(namePart);
    //        for(Producer pro : persProducer){
    //            ProducerDTO producerDTO = new ProducerDTO(pro);
    //            result.add(producerDTO);
    //        }
    //        return result;
    //    }

}
