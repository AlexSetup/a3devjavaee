package fr.imie.contact.repositories;

import fr.imie.contact.entities.*;

import javax.ejb.*;
import javax.persistence.*;
import java.util.*;

@Stateless
public class BankAccountRepository {

  @PersistenceContext
  EntityManager em;

  public List<BankAccount> findAll() {
    return em.createQuery("select ba from BankAccount ba", BankAccount.class).getResultList();
  }

  public void save(BankAccount entity) {
    em.persist(entity);
  }

}
