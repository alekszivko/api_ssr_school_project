package at.spengergasse.sj2324seedproject.presentation.api;

import at.spengergasse.sj2324seedproject.constants.ConstantsDomain;
import at.spengergasse.sj2324seedproject.domain.Producer;
import at.spengergasse.sj2324seedproject.exceptions.ExceptionProducer;
import at.spengergasse.sj2324seedproject.presentation.api.commands.CommandProducer;
import at.spengergasse.sj2324seedproject.presentation.api.dtos.ProducerDTO;
import at.spengergasse.sj2324seedproject.service.ServiceProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.jdbc.support.JdbcUtils.isNumeric;

@RequiredArgsConstructor
@RestController
@RequestMapping(ConstantsDomain.URL_BASE_PRODUCER)
@Log4j2
public class RestControllerProducer{

    private final ServiceProducer serviceProducer;

    @GetMapping()
    public List<ProducerDTO> fetchProducers(@RequestParam Optional<String> nameParam){
        List<ProducerDTO> result = new ArrayList<>();
        log.debug("fetchProducers called with nameParam={}", nameParam);
        List<Producer> persProducer = serviceProducer.fetchProducer(nameParam);
        for(Producer pro: persProducer){
            ProducerDTO producerDTO = new ProducerDTO(pro);
            result.add(producerDTO);
        }
        log.debug("fetchProducers returned {} elements", result.size());
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

    @GetMapping(ConstantsDomain.URI_ID)
    public ResponseEntity<ProducerDTO> getProducer(@PathVariable String id) throws ExceptionProducer{
        log.debug("getProducer called with id={}", id);
        long idLong = Long.parseLong(id);
        int  idTemp = (int) idLong;

        return serviceProducer.findProducerByStringID(id).map(ProducerDTO::new)
                       .map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

//        if(isNumeric(idTemp)){
//            var                         prod   = serviceProducer.findProdducerByID(idLong); //2559
//            ResponseEntity<ProducerDTO> result = ResponseEntity.ok(new ProducerDTO(prod));
//            return result;
//        }else{
//            throw new ExceptionProducer("ID is not numeric");
//        }
    }

    @PostMapping
    public ResponseEntity<ProducerDTO> createProducer(@RequestBody CommandProducer command){
        log.debug("createProducer called with {}", command);
        var producer = serviceProducer.saveProducer(command.shortname(), command.name());

        URI uri = URI.create(ConstantsDomain.URL_BASE_PRODUCER+producer.getId());
        return ResponseEntity.created(uri).body(ProducerDTO.builder()
                                                        .name(producer.getName())
                                                        .shortname(producer.getShortname())
                                                        .build());
    }

    @DeleteMapping(ConstantsDomain.URI_SHORTNAME)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<ProducerDTO> delete(@PathVariable String delShortname) throws ExceptionProducer{
        log.debug("delete called with shortName= {}", delShortname);

        var                         producer = serviceProducer.deleteProducerB(delShortname);
        ResponseEntity<ProducerDTO> prod     = ResponseEntity.ok().body(new ProducerDTO(producer));
            return prod;
    }
}
