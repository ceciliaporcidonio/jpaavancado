package com.seu_projeto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;

public class HibernateTest {
    public static void main(String[] args) {
        // Configura o EntityManagerFactory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Inicia uma transação
        entityManager.getTransaction().begin();

        // Cria uma marca
        Marca marcaToyota = new Marca("Toyota");
        entityManager.persist(marcaToyota);

        // Cria acessórios
        Acessorio acessorioGPS = new Acessorio("GPS");
        Acessorio acessorioAirbag = new Acessorio("Airbag");
        entityManager.persist(acessorioGPS);
        entityManager.persist(acessorioAirbag);

        // Cria um carro com a marca e os acessórios
        Carro carroCorolla = new Carro("Corolla", marcaToyota);
        carroCorolla.setAcessorios(Arrays.asList(acessorioGPS, acessorioAirbag));
        entityManager.persist(carroCorolla);

        // Confirma a transação
        entityManager.getTransaction().commit();

        // Fecha o EntityManager e EntityManagerFactory
        entityManager.close();
        entityManagerFactory.close();

        System.out.println("Dados persistidos com sucesso.");
    }
}
