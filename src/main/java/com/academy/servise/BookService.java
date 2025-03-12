package com.academy.servise;

import com.academy.model.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Data
@AllArgsConstructor
public class BookService {
    private List<Book> books;

    public BookService() {
        books = new ArrayList<>();
        books.add(new Book("title1", "Tom Hansk", 2001, 1));
        books.add(new Book("title2", "Gen Berry", 2010, 2));
        books.add(new Book("title3", "Adam", 2003, 3));
        books.add(new Book("title4", "Kavalsky", 2021, 4));
    }

    public Book getBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
}
