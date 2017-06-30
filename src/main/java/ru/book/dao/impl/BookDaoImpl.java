package ru.book.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.book.dao.interfaces.BookDao;
import ru.book.entities.Author;
import ru.book.entities.Book;
import ru.book.entities.Genre;

import java.util.List;

@Component
public class BookDaoImpl implements BookDao{

    @Autowired
    SessionFactory sessionFactory;

    private List<Book> books;

    @Transactional
    @Override
    public List<Book> getBooks() {
        books=(List<Book>) sessionFactory.getCurrentSession()
                .createCriteria(Book.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        return books;
    }

    @Override
    public List<Book> getBooks(Author author) {
        return null;
    }

    @Override
    public List<Book> getBooks(String bookName) {
        return null;
    }

    @Override
    public List<Book> getBooks(Genre genre) {
        return null;
    }

    @Override
    public List<Book> getBooks(Character letter) {
        return null;
    }
}
