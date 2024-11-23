import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        // Frame setup
        JFrame frame = new JFrame("Student Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 750);
        frame.setLayout(new GridBagLayout());
        frame.getContentPane().setBackground(new Color(30, 30, 30)); // Dark background

        // Positioning frame at the top-right corner
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(screenSize.width - frame.getWidth(), 0);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Banner
        JLabel banner = new JLabel("Student Form", SwingConstants.CENTER);
        banner.setFont(new Font("Arial", Font.BOLD, 24));
        banner.setOpaque(true);
        banner.setBackground(new Color(0, 102, 102)); // Dark green
        banner.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        frame.add(banner, gbc);

        // Labels and TextFields
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;

        Font labelFont = new Font("Arial", Font.BOLD, 16);
        Font fieldFont = new Font("Arial", Font.PLAIN, 14);
        Border fieldBorder = new LineBorder(new Color(70, 70, 70), 2, true);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(labelFont);
        nameLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(nameLabel, gbc);

        JTextField nameField = new JTextField(20);
        nameField.setFont(fieldFont);
        nameField.setBorder(fieldBorder);
        gbc.gridx = 1;
        frame.add(nameField, gbc);

        JLabel fatherLabel = new JLabel("Father Name:");
        fatherLabel.setFont(labelFont);
        fatherLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(fatherLabel, gbc);

        JTextField fatherField = new JTextField(20);
        fatherField.setFont(fieldFont);
        fatherField.setBorder(fieldBorder);
        gbc.gridx = 1;
        frame.add(fatherField, gbc);

        JLabel cityLabel = new JLabel("City:");
        cityLabel.setFont(labelFont);
        cityLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 3;
        frame.add(cityLabel, gbc);

        JComboBox<String> cityCombo = new JComboBox<>(new String[]{"Select City", "Lahore", "Islamabad", "Multan", "Karachi"});
        cityCombo.setFont(fieldFont);
        cityCombo.setBackground(Color.WHITE);
        cityCombo.setForeground(Color.BLACK);

        // Wrap JComboBox in a JPanel for border styling
        JPanel comboPanel = new JPanel(new BorderLayout());
        comboPanel.setBorder(fieldBorder); // Apply the border to the panel
        comboPanel.add(cityCombo); // Add JComboBox to the panel
        comboPanel.setBackground(new Color(30, 30, 30)); // Match the form background
        gbc.gridx = 1;
        frame.add(comboPanel, gbc);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setFont(labelFont);
        addressLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 4;
        frame.add(addressLabel, gbc);

        JTextField addressField = new JTextField(20);
        addressField.setFont(fieldFont);
        addressField.setBorder(fieldBorder);
        gbc.gridx = 1;
        frame.add(addressField, gbc);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(labelFont);
        emailLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 5;
        frame.add(emailLabel, gbc);

        JTextField emailField = new JTextField(20);
        emailField.setFont(fieldFont);
        emailField.setBorder(fieldBorder);
        gbc.gridx = 1;
        frame.add(emailField, gbc);

        JLabel imageLabel = new JLabel("Image:");
        imageLabel.setFont(labelFont);
        imageLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 6;
        frame.add(imageLabel, gbc);

        JButton fileChooserButton = new JButton("Choose File");
        fileChooserButton.setFont(fieldFont);
        JLabel fileLabel = new JLabel("No file chosen");
        fileLabel.setFont(fieldFont);
        fileLabel.setForeground(Color.WHITE);

        JLabel imagePreview = new JLabel();
        imagePreview.setPreferredSize(new Dimension(150, 150));
        imagePreview.setBorder(new LineBorder(Color.WHITE, 2, true));

        fileChooserButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                fileLabel.setText(file.getName());
                ImageIcon icon = new ImageIcon(file.getAbsolutePath());
                Image scaledImage = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                imagePreview.setIcon(new ImageIcon(scaledImage));
            }
        });

        gbc.gridx = 1;
        frame.add(fileChooserButton, gbc);

        gbc.gridy = 7;
        frame.add(fileLabel, gbc);

        gbc.gridy = 8;
        gbc.gridwidth = 2;
        frame.add(imagePreview, gbc);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setFont(labelFont);
        genderLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        frame.add(genderLabel, gbc);

        JRadioButton maleButton = new JRadioButton("Male");
        maleButton.setFont(fieldFont);
        maleButton.setForeground(Color.WHITE);
        maleButton.setBackground(new Color(30, 30, 30));

        JRadioButton femaleButton = new JRadioButton("Female");
        femaleButton.setFont(fieldFont);
        femaleButton.setForeground(Color.WHITE);
        femaleButton.setBackground(new Color(30, 30, 30));

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        JPanel genderPanel = new JPanel();
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        genderPanel.setBackground(new Color(30, 30, 30));
        gbc.gridx = 1;
        frame.add(genderPanel, gbc);

        // Submit Button with rounded edges
        JButton submitButton = createRoundedButton();
        submitButton.setFont(new Font("Arial", Font.BOLD, 18));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);
        submitButton.setContentAreaFilled(false);
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 2;
        frame.add(submitButton, gbc);

        // Add action listener to submitButton
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String fatherName = fatherField.getText();
                String city = (String) cityCombo.getSelectedItem();
                String address = addressField.getText();
                String email = emailField.getText();
                String gender = maleButton.isSelected() ? "Male" : femaleButton.isSelected() ? "Female" : "Not selected";
                String image = fileLabel.getText();

                Student student = new Student(name, fatherName, city, address, email, gender, image);
                studentList.add(student);
                JOptionPane.showMessageDialog(frame, "Data Submitted Successfully!");
                System.out.println(student.displayStudentInfo());
            }
        });

        frame.setVisible(true);
    }

    private static JButton createRoundedButton() {
        return new JButton("Submit") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(0, 102, 204));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
                super.paintComponent(g); // Ensure the button's content is drawn
            }
        };
    }
}