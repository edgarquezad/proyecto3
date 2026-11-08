package org.egibide.proyecto3.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;


public abstract class Dao<T_Entidad,K_Id > {

    EntityManager em = Persistence
            .createEntityManagerFactory("default")
            .createEntityManager();

    public EntityManager getEntityManager() {
        return this.em;
    }

    public abstract T_Entidad find(K_Id id);

    public T_Entidad create(T_Entidad entidad) {
        EntityTransaction entityTransaction = em.getTransaction();
        entityTransaction.begin();
        em.persist(entidad);
        entityTransaction.commit();
        return entidad;
    }

    public T_Entidad update(T_Entidad entidad) {
        EntityTransaction entityTransaction = em.getTransaction();
        entityTransaction.begin();
        em.merge(entidad);
        entityTransaction.commit();
        return entidad;
    }

    public void delete(T_Entidad entidad) {
        EntityTransaction entityTransaction = em.getTransaction();
        entityTransaction.begin();
        em.remove(entidad);
        entityTransaction.commit();
    }
}

