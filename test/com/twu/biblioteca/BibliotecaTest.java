package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by egalperi on 6/16/15.
 */
public class BibliotecaTest {
    private PrintStream printStream;
    private Biblioteca biblioteca;
    private List<Book> books;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        books = new ArrayList<Book>();
        biblioteca = new Biblioteca(printStream, books);
    }

    @Test
    public void shouldPrintWelcomeMessageWhenAppStarts(){

        biblioteca.start();

        verify(printStream).println("Welcome to Biblioteca! Please select a menu option:");

    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {
        biblioteca.listBooks();

        verify(printStream).println("");
    }

    @Test
    public void shouldPrintOneBookWhenThereIsOneBook() {
        books.add(new Book("Harry Potter", "JK Rowling", "10"));
        biblioteca.listBooks();

        verify(printStream).println("Harry Potter");
    }

    @Test
    public void shouldPrintAllBooksWhenThereAreMoreThanOneBook() {
        books.add(new Book("Harry Potter", "", "10"));
        books.add(new Book("Lord of the Rings", "", "10"));
        biblioteca.listBooks();

        verify(printStream).println("Harry Potter");
        verify(printStream).println("Lord of the Rings");
    }

    @Test
    public void shouldListMainMenuOptionListBooksWhenAppStart(){
        biblioteca.start();

        verify(printStream).println("List Books");
    }
}



