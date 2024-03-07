package at.spengergasse.sj2324seedproject.service;

import at.spengergasse.sj2324seedproject.domain.Producer;
import at.spengergasse.sj2324seedproject.exceptions.ExceptionProducer;
import at.spengergasse.sj2324seedproject.persistence.RepositoryProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ServiceProducer{

    @Autowired
    private final RepositoryProducer repositoryProducer;


    public List<Producer> fetchProducer(Optional<String> nameParam){
        List<Producer> prod2 = new ArrayList<>();
        if(nameParam.isPresent()){
            //            List<Producer> prod = new ArrayList<>();
            //            Producer           oneProd      = persistenceProducer.findOneProducerByName(nameParam);
            List<Producer>     producerList = repositoryProducer.findAll();
            Iterator<Producer> iter         = producerList.iterator();

            while(iter.hasNext()){
                Producer temp = iter.next();
                String toUpperCase1 = temp.getName()
                                          .toUpperCase();
                String toUpperCase2 = nameParam.get()
                                               .toUpperCase();
                if(toUpperCase1.contains(toUpperCase2)){
                    prod2.add(temp);
                }
            }

            if(nameParam.isPresent() && prod2.isEmpty()){
                return repositoryProducer.findAll();
            }
        }else{
            return repositoryProducer.findAll();
        }
        return prod2;
    }

    public List<Producer> fetchProducerName(Optional<String> namePart){
        return repositoryProducer.findProducerByName(namePart);
    }

    public Producer saveProducer(String shortName,
                                 String name){
        Producer producer = Producer.builder()
                                    .shortname(shortName)
                                    .name(name)
                                    .build();

        return repositoryProducer.save(producer);

    }

    public void deleteProducer(String shortName) throws ExceptionProducer{
        if(shortName != null){
            repositoryProducer.deleteProducerByShortname(shortName);
        }else{
            throw new ExceptionProducer("shortName is null");
        }
    }

    public Producer deleteProducerB(String shortName) throws ExceptionProducer{
        if(shortName != null){
            return repositoryProducer.deleteProducerByShortname(shortName);
        }else{
            throw new ExceptionProducer("shortName is null");
        }
    }

    public Producer findProducerByID(Long id){
        return repositoryProducer.findProducerById(id);
    }

    public Producer findProducerByStringID(String id){
        return repositoryProducer.findProducerById(id)
                                 .get();
    }
}
