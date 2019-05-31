package com.sanghwan.demo;

import com.sanghwan.demo.domain.Book;
import com.sanghwan.demo.domain.Category;
import com.sanghwan.demo.repository.BookRepository;
import com.sanghwan.demo.repository.CategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class DemoApplicationTests {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private BookRepository bookRepository;

	@Test
	public void testSaveEntity() {
		Category category = new Category();
		category.setGenre("운영체제");
		categoryRepository.save(category);

		Book book = new Book();//여기서 id값은 null이 된다.
		book.setName("공룡책");
		//OnetoMany , ManyToOne을 저장할때
		book.setCategory(category);
		book.getCategory().getBook().add(book);//이렇게 하지않으면 category에 book이 저장이 되지 않는다.
		//
		bookRepository.save(book);

		Category newCategory = new Category();
		newCategory.setGenre("프로그래밍언어");
		categoryRepository.save(newCategory);

		book.setCategory(newCategory);//여기서 문제발생 이거 안된다 왜 안되니
		book.getCategory().getBook().add(book);
		bookRepository.save(book);

//		bookRepository.findAll().forEach(b -> System.out.println(b.getName()));

		categoryRepository.findAll().forEach(c -> System.out.println(c.getBook().get(0).getName())); //공룡책이 하나가 나와야 디는데 두개가 나온다 == 무결성이 깨졌다

//		bookRepository.findAll().forEach(b-> System.out.println(b.getCategory().getGenre()));

//		Book book = new Book();//여기서 id값은 null이 된다.
//		book.setName("공룡책");
//		assertThat(bookRepository.save(book).getName()).isEqualTo("공룡책");//우리는 여기서 id값을 반환해준적이 없다 그런데 저장이 되어있다?? 이건 이상하다고 생각을 해야된다.1

//		book.setCategory(category); //id를 확인할경우 값이 나온다
//		bookRepository.save(book);


	}

}
