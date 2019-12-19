package pl.javastart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import pl.javastart.dao.BookDao;
import pl.javastart.model.Book;

@Configuration
@ComponentScan
public class SpringJpaApplication {

	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringJpaApplication.class);
		BookDao bookDao = ctx.getBean(BookDao.class);
		
		Book book1 = new Book("2345", "¯eglowanie w weekend", "Tony Jay");
		Book book2 = new Book("3456", "Atlantyk dla odwa¿nych", "Apoloniusz Malicky");
		Book book3 = new Book("4567", "Prawdziwe oblicze Pacyfiku", "Bierat Adam");
        bookDao.save(book1);
        bookDao.save(book2);
        bookDao.save(book3);
        
       Book bookGet = bookDao.get(1L);
       System.out.println("Ksiazka" + bookGet.toString());
       
        ctx.close();
	
	}
}
