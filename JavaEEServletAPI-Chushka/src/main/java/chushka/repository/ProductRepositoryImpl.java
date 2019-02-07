package chushka.repository;

import chushka.domain.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository{
    private final EntityManager entityManager;

    public ProductRepositoryImpl() {
        this.entityManager = Persistence.createEntityManagerFactory("soft_uni").createEntityManager();
    }

    @Override
    public Product save(Product product) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(product);
        this.entityManager.getTransaction().commit();

        return product;
    }

    @SuppressWarnings("unchecked")
    public List<Product> getAllProductsNames(){
        return this.entityManager.createQuery("SELECT p FROM products AS p").getResultList();
    }

    @Override
    public Product findByName(String name) {
        return (Product) this.entityManager.createQuery("SELECT p FROM products AS p WHERE name = :name")
                .setParameter("name",name)
                .getSingleResult();
    }
}
