package com.sanghwan.demo.repository;

import com.sanghwan.demo.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
