package ru.sitronics.tn.transneftcontract.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sitronics.tn.transneftcontract.model.Contract;
import ru.sitronics.tn.transneftcontract.model.SpecificationItem;
import ru.sitronics.tn.transneftcontract.repository.ContractRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class ContractServiceSpecification {

    @PersistenceContext
    EntityManager entityManager;

    public List<Contract> findAll(){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Contract> criteriaQuery = criteriaBuilder.createQuery(Contract.class);
        Root<Contract> root = criteriaQuery.from(Contract.class);

//        Predicate predicate = criteriaBuilder.equal(root.get("organizationId"),1000);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public List<Contract> findByfield(String field, Long value){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Contract> criteriaQuery = criteriaBuilder.createQuery(Contract.class);
        Root<Contract> root = criteriaQuery.from(Contract.class);

        Predicate predicate = criteriaBuilder.equal(root.get(field),value);
        criteriaQuery.where(predicate);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public List<Contract> findByfield1(List<SpecificationItem> specificationItems){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Contract> criteriaQuery = criteriaBuilder.createQuery(Contract.class);
        Root<Contract> root = criteriaQuery.from(Contract.class);
        Predicate basicPredicate = criteriaBuilder.conjunction(); // базовый предикат безусловный

        for(SpecificationItem specificationItem : specificationItems){
            Predicate predicate = criteriaBuilder.equal(root.get(specificationItem.getField()),specificationItem.getValue());
            //ставим and- выполниться должно  либо 1 либо 2(совпадать) ,ставим or или 1 или 2
            basicPredicate = criteriaBuilder.or(basicPredicate,predicate);
            // просуммировать все предикаты и добавить !!!! ДЗ

        }

//        Predicate predicate = criteriaBuilder.equal(root.get(field),value);
        criteriaQuery.where(basicPredicate);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
