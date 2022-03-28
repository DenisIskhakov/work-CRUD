package ru.sitronics.tn.transneftcontract.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.sitronics.tn.transneftcontract.exception.ContractNotFoundException;
import ru.sitronics.tn.transneftcontract.model.Contract;
import ru.sitronics.tn.transneftcontract.repository.ContractRepository;

import java.util.List;

@Service
@Slf4j // logging

public class ContractService {
    @Autowired
    private ContractRepository contractRepository;

    //2 раза не залазием в БД,а достаем из кжша по "contracts" |
    // и по ключу ,когда id изменится-обновим кэш и сделаем запрос по этому полю
    @Cacheable(value = "contracts", key = "organizationId")
    public List<Contract> findByAll(){
        List<Contract> contracts = contractRepository.findAll();
        log.info("Getting all contract " + contracts);
        return contracts;
    }
    //Всегда лезем в БД,а результат пишем в кэш(обновляем)
    //метод всегда будет выполняться, а результат всегда кэшироваться
    // принудительно будет делать всегда запрос,а в кэш результат
    @CachePut(value = "contracts", key = "organizationId")
    public List<Contract> findByAllCaching(){
        List<Contract> contracts = contractRepository.findAll();
        log.info("Getting all contract " + contracts);
        return contracts;
    }
    public Contract findById(Long id){
        return contractRepository.findById(id)
                .orElseThrow(() ->
                new ContractNotFoundException("Contract Not Found with -> id : " + id)
        );
    }
    public Contract create(Long id, Contract contracts){
        Contract oldContracts = contractRepository.findById(id).orElseThrow();
        oldContracts.setOrganizationId(contracts.getId()); // достали по id
        oldContracts.setResponsibleUserId(contracts.getId());
        return contractRepository.save(oldContracts); //перезаписали старый
    }
    public Contract update(Contract contract){
        return contractRepository.save(contract);
    }
    //как только удалю id и сразу же удаляю из кэша(обновляю кэш)
    @CacheEvict(value = "contracts")
    public Contract deleteById(Long id){
       Contract contractDel = contractRepository.findById(id)
                .orElseThrow(() -> new ContractNotFoundException("Contract Not Found with -> id : " + id));
         contractRepository.deleteById(id);
        return contractDel;
    }


}