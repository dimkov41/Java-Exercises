package chushka.repository;

import chushka.domain.entity.Product;

public interface GenericRepository<Entity,Key> {
    Product save(Entity entity);

    Entity findByName(String name);
}
