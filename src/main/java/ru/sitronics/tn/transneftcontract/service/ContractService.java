package ru.sitronics.tn.transneftcontract.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sitronics.tn.transneftcontract.exception.ContractNotFoundException;
import ru.sitronics.tn.transneftcontract.model.Contract;
import ru.sitronics.tn.transneftcontract.repository.ContractRepository;

import java.util.List;

@Service
public class ContractService {
    @Autowired
    private ContractRepository contractRepository;

    public List<Contract> findByAll(){
        return contractRepository.findAll();
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
    public Contract deleteById(Long id){
       Contract contractDel = contractRepository.findById(id)
                .orElseThrow(() -> new ContractNotFoundException("Contract Not Found with -> id : " + id));
         contractRepository.deleteById(id);
        return contractDel;
    }


}