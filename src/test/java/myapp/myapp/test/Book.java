package myapp.myapp.test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Book {
        private String name;
        private int isbn;

        Book(String name,int isbn){
                this.name = name;
                this.isbn = isbn;
        }

        public void setName(String name) {
                this.name = name;
        }


        public void setIsbn(int isbn) {
                this.isbn = isbn;
        }


        public int getIsbn() {
                return isbn;
        }

        public String getName() {
                return name;
        }
}

