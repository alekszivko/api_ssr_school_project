package at.spengergasse.sj2324seedproject.presentation.api.commands;


import at.spengergasse.sj2324seedproject.domain.Producer;

public record CommandProducer(String shortname, String name){
    public CommandProducer(Producer producer){
        this(producer.getName(), producer.getShortname());
    }
}
