/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heardfirstjava;

/**
 *
 * @author PIRUZ
 */
class Book {

    String title;
    String author;
}

public class Library {

    public static void main(String[] args) {
        Livre[] myBooks = new Livre[3];
        int x = 0;
        while (x < myBooks.length) {
            myBooks[x] = new Livre();
            myBooks[x].title = "The Grapes of Java ";
            myBooks[x].author = "bob ";
            if (x == 1) {
                myBooks[x].title = "The Java Gatsby ";
                myBooks[x].author = "sue ";
            }
            if (x == 2) {
                myBooks[x].title = "The Java Cookbook ";
                myBooks[x].author = "ian ";
            }
            System.out.print(myBooks[x].title);
            System.out.print("by ");
            System.out.println(myBooks[x].author);
            x += 1;
        }

    }

}
