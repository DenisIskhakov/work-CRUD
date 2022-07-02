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
import java.util.Arrays;
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
        Predicate basicPredicate = criteriaBuilder.or(specificationItems
                .stream()
                .map(s -> criteriaBuilder.equal(root.get(s.getField()),s.getValue())) // из специфакиции в STEAM Predicate [до этого стрим спецификаций]
                .toArray(Predicate[]::new));  // сделали массив предикатов
        criteriaQuery.where(basicPredicate);
        return entityManager.createQuery(criteriaQuery).getResultList();

    }
    public List<Contract> contractsList(List<SpecificationItem> list) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Contract> criteriaQuery = criteriaBuilder.createQuery(Contract.class);
        Root<Contract> root = criteriaQuery.from(Contract.class);

        //criteriaQuery.select(root);
        Predicate predicate = criteriaBuilder.conjunction();
        for (SpecificationItem specificationItem : list) {
            predicate = criteriaBuilder.or(predicate, criteriaBuilder.equal(root.get(specificationItem.getField()), specificationItem.getValue()));


        }
        criteriaQuery.where(predicate);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }


//    public List<Client> clientsListOr (List<CriteriaParam> list) {
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Client> criteriaQuery = criteriaBuilder.createQuery(Client.class);
//        Root<Client> root = criteriaQuery.from(Client.class);
//
//        //criteriaQuery.select(root);
//        Predicate predicate = criteriaBuilder.conjunction();
//        for (CriteriaParam criteriaParam : list) {
//            predicate = criteriaBuilder.or(predicate, criteriaBuilder.equal(root.get(criteriaParam.getName()), criteriaParam.getValue()));
//        }
//        criteriaQuery.where(predicate);
//        return entityManager.createQuery(criteriaQuery).getResultList();
//    }
}
