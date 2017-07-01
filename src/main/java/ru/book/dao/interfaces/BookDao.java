package ru.book.dao.interfaces;

import ru.book.entities.Author;
import ru.book.entities.Book;
import ru.book.entities.Genre;

import java.util.List;

public interface BookDao {
    List<Book> getBooks();
    List<Book> getBooks(Author author);
    List<Book> getBooks(String bookName);
    List<Book> getBooks(Genre genre);
    List<Book> getBooks(Character letter);
    Object getFieldValue(Long id, String fieldName);
}
