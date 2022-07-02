package ru.sitronics.tn.transneftcontract.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;
import ru.sitronics.tn.transneftcontract.model.*;
import ru.sitronics.tn.transneftcontract.repository.ContractRepository;
import ru.sitronics.tn.transneftcontract.service.ContractServiceSpecification;

import javax.persistence.criteria.Predicate;
import java.util.Arrays;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/specificaton")
public class ContractServiceSpecificationController {
    ContractServiceSpecification contractServiceSpecification;
    private ContractRepository contractRepository;
    @GetMapping
    public List<Contract> findAll(){
//        StackTraceElement[] stackTraceElements =Thread.currentThread().getStackTrace();
//
//        Arrays.stream(stackTraceElements).forEach(System.out::println);
    return contractServiceSpecification.findAll();
    }

    @GetMapping("/field")
    public List<Contract> findAll(@RequestParam(value = "field") String field, @RequestParam(value = "value") Long value){
        return contractServiceSpecification.findByfield(field, value);
    }
    @PostMapping("/specification")
    public List<Contract> findSpecification(@RequestBody List<SpecificationItem> lists){
        // specification -> в список predicatov с поомщью цикла for
        return  contractServiceSpecification.findByfield1(lists);
    }
    @PostMapping("/newSpecification")
    public List<Contract> findSpecification1(@RequestBody List<SpecificationItem> lists){
        // specification -> в список predicatov с поомщью цикла for
        return  contractServiceSpecification.contractsList(lists);
    }
    @PostMapping("/critContract")
    public List<Contract> critCOntract(@RequestBody SearchCriteria searchCriteria){
        UserSpecification userSpecification = new UserSpecification(searchCriteria);
        return contractRepository.findAll(userSpecification);
    }
    @PostMapping("/criteriaSpecification")
    public List<Contract> specificationCrit(@RequestBody List<SearchCriteria> searchCriterias){
//        UserSpecification userSpecification = new UserSpecification(searchCriteria);
        ContractSpecificationsBuilder contractSpecificationsBuilder = new ContractSpecificationsBuilder();
        for(SearchCriteria searchCriteria : searchCriterias){
            contractSpecificationsBuilder.with(searchCriteria);
        }
        Specification specification = contractSpecificationsBuilder.build();
        return contractRepository.findAll(specification);
    }
}
