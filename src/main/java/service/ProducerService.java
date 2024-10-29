package service;

import dominio.Producer;
import repository.ProducerRepository;

import java.util.List;

public class ProducerService {

    public static void save(String nome){
        ProducerRepository.save(nome);
    }

    public static void delete(int id){
        validId(id);
        ProducerRepository.delete(id);
    }

    public static void update(int ids, String nome){
        validId(ids);
        ProducerRepository.update(ids, nome);
    }

    public static List<Producer> findAll(){
        return ProducerRepository.findAll();
    }

    //validação do id;
    private static void validId(Integer id){
        if (id == null || id <= 0){
            throw new IllegalStateException("Valor invalido para o ID");
        }
    }

}
