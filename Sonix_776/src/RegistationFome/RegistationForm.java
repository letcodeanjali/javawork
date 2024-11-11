
package RegistationFome;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistationForm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Registration Form");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(8, 2));

        JLabel firstNameLabel = new JLabel("First Name:");
        JTextField firstNameField = new JTextField();

        JLabel lastNameLabel = new JLabel("Last Name:");
        JTextField lastNameField = new JTextField();

        JLabel mobileNumberLabel = new JLabel("Mobile Number:");
        JTextField mobileNumberField = new JTextField();

        JLabel dobLabel = new JLabel("Date of Birth:");
        JTextField dobField = new JTextField();

        JLabel idProofLabel = new JLabel("ID Proof:");
        JTextField idProofField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String mobileNumber = mobileNumberField.getText();
                String dob = dobField.getText();
                String idProof = idProofField.getText();
                String password = new String(passwordField.getPassword());
                String username = usernameField.getText();

                // Perform actions with the user's input, e.g., save to a database

                // For this example, we'll just display the inputs
                JOptionPane.showMessageDialog(frame, "First Name: " + firstName +
                        "\nLast Name: " + lastName +
                        "\nMobile Number: " + mobileNumber +
                        "\nDate of Birth: " + dob +
                        "\nID Proof: " + idProof +
                        "\nPassword: " + password +
                        "\nUsername: " + username);
            }
        });

        frame.add(firstNameLabel);
        frame.add(firstNameField);
        frame.add(lastNameLabel);
        frame.add(lastNameField);
        frame.add(mobileNumberLabel);
        frame.add(mobileNumberField);
        frame.add(dobLabel);
        frame.add(dobField);
        frame.add(idProofLabel);
        frame.add(idProofField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(usernameLabel);
        frame.add(usernameField);
        frame.add(new JLabel()); // Placeholder
        frame.add(submitButton);

        frame.setVisible(true);
    }


	}


