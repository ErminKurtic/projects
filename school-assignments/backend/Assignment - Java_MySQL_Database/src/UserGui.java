import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.*;

public class UserGui extends JFrame {

        private String userName;
        private Connection dbConnection;

        private JTextField searchBook;
        private JTextArea searchBookResult;

        private JButton showBooks;
        private JTextArea showBooksResult;

        private JButton borrowBooks;
        private JTextArea borrowBooksResult;

        private JTextField searchJournal;
        private JTextArea searchJournalResult;
        private JPanel jPanel;

        public UserGui(Connection con, String userName){

            this.dbConnection = con;
            this.userName = userName;

            searchBook = new JTextField("Search for book...",20);
            showBooks = new JButton("Search borrowed books...");
            borrowBooks = new JButton("Borrow books...");
            searchJournal =  new JTextField("Search journals...", 20);
            this.setTitle("SQL - Front");
            this.setSize(800, 800);
            this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            jPanel = new JPanel(new GridLayout(4,2));
            searchBook.setBackground(Color.gray);
            searchJournal.setBackground(Color.gray);

            borrowBooksResult = new JTextArea();
            searchBookResult = new JTextArea();
            showBooksResult = new JTextArea();
            searchJournalResult = new JTextArea();

            jPanel.add(searchBook);
            jPanel.add(searchBookResult);
            jPanel.add(showBooks);
            jPanel.add(showBooksResult);
            jPanel.add(borrowBooks);
            jPanel.add(borrowBooksResult);
            jPanel.add(searchJournal);
            jPanel.add(searchJournalResult);
            this.add(jPanel);

            this.setLocationRelativeTo(null);

            ActionListener searchBooks = e->{
                String answer ="";

                    String query = "select title, author, pages, classification from books where title like ? '%' ; ";
                    //"select * from persons where name = ?;"; //Prepared statement, safer

                    if (checkInput(searchBook.getText())) { //Följer input mönstret jag satt regler för, kör då...

                        try {

                            PreparedStatement p = con.prepareStatement(query);
                            p.setString(1, searchBook.getText());  // Det första frågetecknet, ersätts med input från användare
                            ResultSet rs = p.executeQuery();

                            while (rs.next())
                                answer += "\n" + (rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getInt(3) + " " + rs.getString(4));
                            this.searchBookResult.setText(answer);

                            //con.close();

                        } catch (Exception exception) {
                            System.out.println(exception);
                        }
                    }
            };

            ActionListener showAvailableBooks = e->{
                String answer = "";

                try {
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT Id, title FROM books WHERE title NOT IN (SELECT title FROM borrowed_books);");

                    while (rs.next())
                        answer += "\n" + (rs.getInt(1) + " " + rs.getString(2));
                    this.showBooksResult.setText(answer);

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            };

            ActionListener addBorrowedBook= e-> {


                String inputBookId = JOptionPane.showInputDialog("Enter BookId");

                String bookTitleQuery = "SELECT title from books where Id = ?";
                String title = "";
                String libraryCardQuery = "SELECT loaner_ID from persons where name = '" + userName + "';";
                int libraryCard = -1;

//            if(inputBookId) kolla om det int/null SAMT GÖRA BOOKID UNIK
//            check relation books borrowed .  bookid

                try {
                    Integer.parseInt(inputBookId);
                    try {
                        PreparedStatement p = con.prepareStatement(bookTitleQuery);
                        p.setString(1, inputBookId);
                        ResultSet rs = p.executeQuery();

                        while (rs.next())
                            title = rs.getString(1);

                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }

                    try {
                        PreparedStatement p = con.prepareStatement(libraryCardQuery);
                        ResultSet rs = p.executeQuery();

                        while (rs.next())
                            libraryCard = rs.getInt(1);
                        //System.out.println(libraryCard);
//
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }

                    String query = "INSERT INTO borrowed_books(loaner_ID, title, BookID) VALUE(" + libraryCard + ", '" + title + "', " + inputBookId + ");";
                    try {
                        PreparedStatement p = con.prepareStatement(query);
                        p.executeUpdate();
                        this.borrowBooksResult.setText("Book: " + title + " is borrowed!");

                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
                catch(NumberFormatException es){
                this.borrowBooksResult.setText("Not a valid BookID. Please try again...");
            }
//        } // SLUTER INT/STRING CHECKER
            };




            /*ActionListener borrowBooks = e ->{
                String answer = "";
                String query = "select * from borrowed_books where title = ?; ";

                if (checkInput(searchBorrowedBook.getText())) {

                    try {

                        PreparedStatement p = con.prepareStatement(query);
                        p.setString(1, searchBorrowedBook.getText());
                        ResultSet rs = p.executeQuery();

                        while (rs.next())
                            answer = "\n" + (rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getInt(3) + " " + rs.getString(4));
                        this.searchBorrowedBookResult.setText(answer);

                        //con.close();

                    } catch (Exception exception) {
                        System.out.println(exception);
                    }
                }
            };*/

            ActionListener searchJournals = e->{
                String answer ="";

                String query = " select * from journals where title = ?;";

                if (checkInput(searchJournal.getText())) {

                    try {

                        PreparedStatement p = con.prepareStatement(query);
                        p.setString(1, searchJournal.getText());
                        ResultSet rs = p.executeQuery();

                        while (rs.next())
                            answer += "\n" + (rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
                        this.searchJournalResult.setText(answer);

                        //con.close();

                    } catch (Exception exception) {
                        System.out.println(exception);
                    }
                }
            };

            borrowBooks.addActionListener(addBorrowedBook);
            searchBook.addActionListener(searchBooks);
            showBooks.addActionListener(showAvailableBooks);
            //searchBorrowedBook.addActionListener(borrowBooks);
            searchJournal.addActionListener(searchJournals);

            this.setVisible(true);
        }


    public static boolean checkInput(String input){
        Pattern p = Pattern.compile("[A-Z]([a-z]{1,25})");

        Matcher m = p.matcher(input);

        while (m.find()){  // Så länge matcher hittar något, letar vi vidare, söker genom hela srkivna strängen
            if(m.group().length() != 0){  // Och kolla om tecknen vi får in inte har längden noll
                return true;
            }
        }
        return false;

    }

}
