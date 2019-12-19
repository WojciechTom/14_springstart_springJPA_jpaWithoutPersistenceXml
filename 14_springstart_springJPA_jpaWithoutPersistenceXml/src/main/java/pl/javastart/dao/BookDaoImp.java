package pl.javastart.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import pl.javastart.model.Book;


@Repository
public class BookDaoImp implements BookDao {

	@PersistenceUnit
	private EntityManagerFactory managoFact;
	
	
	@Override
	public void save(Book book) {
		EntityManager manago = managoFact.createEntityManager();
		EntityTransaction tx = manago.getTransaction();
		tx.begin();
		manago.persist(book);
		tx.commit();
	}

	
	@Override
	public Book get(Long id) {
		EntityManager manago = managoFact.createEntityManager();
		return manago.find(Book.class, id);
	}

}
