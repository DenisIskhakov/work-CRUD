package ru.sitronics.tn.transneftcontract.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.sitronics.tn.transneftcontract.model.Contract;
import ru.sitronics.tn.transneftcontract.service.ContractService;


import java.util.List;

@RestController
@RequestMapping("/api/v1/contract")
@Slf4j
public class ContractController {
    @Autowired
    private ContractService contractsService;

    @GetMapping
    public List<Contract> findByAll(){
        List<Contract> contracts = contractsService.findByAll();
        log.info("Getting all contract " + contracts);
        return contracts;
    }

    @GetMapping("/{id}")
    public Contract findById(@PathVariable Long id){
        return contractsService.findById(id);
    }
    @PostMapping
    public Contract post(@RequestBody Contract contracts){
        return contractsService.update(contracts);
    }
    @PutMapping
    public Contract put(@PathVariable Long id, @RequestBody Contract contract){
        return contractsService.create(id,contract);
    }
    @DeleteMapping("/{id}")
    public Contract delete(@PathVariable Long id){
        return contractsService.deleteById(id);
    }
}