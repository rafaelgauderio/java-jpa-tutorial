package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {

		Pessoa p1 = new Pessoa(null, "Rafael De Luca", "rafael@gmail.com");
		Pessoa p2 = new Pessoa(null, "Juliana da Silva", "juliana@gmail.com");
		Pessoa p3 = new Pessoa(null, "Cristiano Souza", "cristiano@gmail.com");
		Pessoa p4 = new Pessoa();
		p4.setId(null);
		p4.setName("Joao da Silva");
		p4.setEmail("joaodasilva@gmail");

		Pessoa p5 = new Pessoa(null, "Catarina", "catarinalinda@gmail.com");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.persist(p4);
		em.persist(p5);

		em.getTransaction().commit();

		Pessoa buscaPessoa = em.find(Pessoa.class, 5);

		System.out.println(buscaPessoa);

		System.out.println("Finalizado");

		em.close();
		emf.close();

		/*
		 * System.out.println(p1); System.out.println(p2); System.out.println(p3);
		 * System.out.println(p4);
		 */
	}

}
