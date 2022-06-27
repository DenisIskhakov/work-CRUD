package ru.sitronics.tn.transneftcontract.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sitronics.tn.transneftcontract.model.Contract;
import ru.sitronics.tn.transneftcontract.model.SpecificationItem;
import ru.sitronics.tn.transneftcontract.service.ContractServiceSpecification;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/specificaton")
public class ContractServiceSpecificationController {
    ContractServiceSpecification contractServiceSpecification;

    @GetMapping
    public List<Contract> findAll(){
        return contractServiceSpecification.findAll();
    }
    @GetMapping("/field")
    public List<Contract> findAll(@RequestParam(value = "field") String field, @RequestParam(value = "value") Long value){
        return contractServiceSpecification.findByfield(field, value);
    }
    @PostMapping
    public List<Contract> findSpecification(@RequestBody List<SpecificationItem> lists){
        // specification -> в список predicatov с поомщью цикла for
    }
}
