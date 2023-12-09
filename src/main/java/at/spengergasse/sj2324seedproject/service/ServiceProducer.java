package at.spengergasse.sj2324seedproject.service;

import at.spengergasse.sj2324seedproject.domain.Producer;
import at.spengergasse.sj2324seedproject.persistence.RepositoryProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Service
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
                String toUpperCase1 = temp.getName().toUpperCase();
                String toUpperCase2 = nameParam.get().toUpperCase();
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
}
