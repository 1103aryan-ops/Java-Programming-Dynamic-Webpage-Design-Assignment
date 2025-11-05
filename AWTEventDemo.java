import java.awt.*;
import java.awt.event.*;

public class AWTEventDemo extends Frame implements ActionListener {

    Label nameLabel;
    TextField nameTextField;
    Button clickButton;

    public AWTEventDemo() {
        
        super("AWT Event Handling Demo");

        setLayout(new FlowLayout());

        nameLabel = new Label("Enter your name:");
        add(nameLabel);

        nameTextField = new TextField(20); 
        add(nameTextField);

        clickButton = new Button("Click Me");
        add(clickButton); 

        clickButton.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        setSize(400, 100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if (e.getSource() == clickButton) {
           
            String name = nameTextField.getText();

            System.out.println("Hello, " + name);

        }
    }

    public static void main(String[] args) {
        new AWTEventDemo();
    }
}
