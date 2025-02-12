package book;

class Books {
    String title;
    String author;
}

class BookTestDrive {
    public static void main(String[] args) {
        Books[] myBooks = new Books[3];
  //  int i = 0;
        for (int i=0; i< myBooks.length; i++) {
            myBooks[i] = new Books();
           // x++;
        }

        myBooks[0].title = "Плоды Java";
        myBooks[1].title = "Java Гэтсби";
        myBooks[2].title = "Сборник рецептов";

        myBooks[0].author = "Боб";
        myBooks[1].author = "Сью";
        myBooks[2].author = "Ян";

        for (int i=0; i < myBooks.length; i++) {
            System.out.println(myBooks[i].title + " ,автор " + myBooks[i].author);
        }

    }
}
