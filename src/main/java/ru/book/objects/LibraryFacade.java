package ru.book.objects;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.book.dao.interfaces.BookDao;
import ru.book.entities.Author;
import ru.book.entities.Book;

import java.util.List;

@Component
@Scope("singleton")
public class LibraryFacade {

    private static final String FIELD_CONTENT="content";

    @Autowired
    private BookDao bookDao;

    private List<Book> books;

    @Autowired
    private SearchCriteria searchCriteria;

    public List<Book> getBooks() {
        if(books==null){
            books=bookDao.getBooks();
        }
        return books;
    }
    public void searchBooksByLetter(){
        books=bookDao.getBooks(searchCriteria.getLetter());
    }
    public void searchBooksByGenre(){
        books=bookDao.getBooks(searchCriteria.getGenre());
    }
    public void searchBooksByText(){
        switch (searchCriteria.getSearchType()) {
            case TITLE:
            books = bookDao.getBooks(searchCriteria.getText());
            break;
            case AUTHOR:
                books = bookDao.getBooks(new Author(searchCriteria.getText()));
        }
    }
    public byte[] getContent(Long id){
        return (byte[]) bookDao.getFieldValue(id,FIELD_CONTENT);
    }
}
