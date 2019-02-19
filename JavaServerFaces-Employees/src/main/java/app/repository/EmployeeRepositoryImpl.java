package app.repository;

import app.domain.entities.Employee;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepostory {
    private EntityManager entityManager;

    public EmployeeRepositoryImpl() {
        this.entityManager = Persistence.createEntityManagerFactory("soft_uni").createEntityManager();
    }

    @Override
    public Employee save(Employee entity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(entity);
        this.entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public List<Employee> findAll() {
        return this.entityManager.createQuery("SELECT e FROM employees AS e")
                .getResultList();
    }

    @Override
    public boolean delete(String id) {
        this.entityManager.getTransaction().begin();
        this.entityManager.createQuery("DELETE FROM employees AS e WHERE e.id = :id")
                .setParameter("id",id)
                .executeUpdate();
        try{
            this.entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            return false;
        }
    }
}
