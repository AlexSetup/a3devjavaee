package fr.imie.contact.repositories;

import fr.imie.contact.entities.*;

import javax.ejb.*;
import javax.persistence.*;
import java.util.*;

@Stateless
public class PersonRepository {

  @PersistenceContext
  private EntityManager em;

  public List<Person> findAll() {
    return em.createQuery("select p from Person p", Person.class).getResultList();
  }

  public Person findById(Integer id) {
    return em.find(Person.class, id);
  }

  public void save(Person person) {
    if (person.getId() == null)
      em.persist(person);
    else
      em.merge(person);
  }

  public void deleteById(int id) {
    em.remove(em.getReference(Person.class, id));
  }

}
