package ru.sitronics.tn.transneftcontract.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import ru.sitronics.tn.transneftcontract.model.Contract;


import java.util.List;

public interface ContractRepository extends CrudRepository<Contract, Long> , JpaSpecificationExecutor<Contract> {
    List<Contract> findAll();
}
