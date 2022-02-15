import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminGui extends JFrame implements ActionListener {

    private Connection dbConnection;
    private static JLabel employeeID, name, adress,
            phoneNumber1, phoneNumber2, phoneNumber3, salary, semesterDays;
    private static JTextField inputEmployeeID, inputName, inputAdress,
            inputPhoneNumber1, inputPhoneNumber2, inputPhoneNumber3, inputSalary, inputSemesterDays;
    private static JButton checkBorrowers;

    public AdminGui(Connection con){

        this.dbConnection = con;

        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(260,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        this.setLocationRelativeTo(null);

        employeeID = new JLabel("Employee ID");
        employeeID.setBounds(10, 20, 80, 25);
        panel.add(employeeID);

        inputEmployeeID = new JTextField(20);
        inputEmployeeID.setBounds(10, 20, 165, 25);
        panel.add(inputEmployeeID);

        name = new JLabel("Name");
        name.setBounds(10, 60, 80, 25);
        panel.add(name);

        inputName = new JTextField(20);
        inputName.setBounds(10, 100, 165, 25);
        panel.add(inputName);

        adress = new JLabel("Adress");
        adress.setBounds(10, 20, 80, 25);
        panel.add(adress);

        inputAdress = new JTextField(20);
        inputAdress.setBounds(10, 20, 165, 25);
        panel.add(inputAdress);

        phoneNumber1 = new JLabel("Telephone 1");
        phoneNumber1.setBounds(10, 20, 80, 25);
        panel.add(phoneNumber1);

        inputPhoneNumber1 = new JTextField(20);
        inputPhoneNumber1.setBounds(10, 20, 165, 25);
        panel.add(inputPhoneNumber1);

        phoneNumber2 = new JLabel("Telephone 2");
        phoneNumber2.setBounds(10, 20, 80, 25);
        panel.add(phoneNumber2);

        inputPhoneNumber2 = new JTextField(20);
        inputPhoneNumber2.setBounds(10, 20, 165, 25);
        panel.add(inputPhoneNumber2);

        phoneNumber3 = new JLabel("Telephone 3");
        phoneNumber3.setBounds(10, 20, 80, 25);
        panel.add(phoneNumber3);

        inputPhoneNumber3 = new JTextField(20);
        inputPhoneNumber3.setBounds(10, 20, 165, 25);
        panel.add(inputPhoneNumber3);

        checkBorrowers = new JButton("Check borrowers");
        checkBorrowers.setBounds(10, 140, 80, 25);
        checkBorrowers.addActionListener(this::actionPerformed);
        panel.add(checkBorrowers);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String answer = "";
        //String query = "SELECT * from borrowed_books;";
        String query = "SELECT name, title FROM borrowed_books INNER JOIN persons ON borrowed_books.loaner_ID = persons.loaner_ID";

        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mybase", "Admin", "123");

            PreparedStatement p = con.prepareStatement(query);
            ResultSet rs = p.executeQuery();

            while (rs.next()) {
                answer += "\n" + (rs.getString(1) + "  " + rs.getString(2));
            }

            JOptionPane.showMessageDialog(null, answer);


            //con.close();

        } catch (Exception exception) {
            System.out.println(exception);
        }

    }
}
