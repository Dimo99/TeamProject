import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.util.Random;

public class BullsAndCows extends JFrame {
    JButton button;
    JLabel label;
    JTextField textField;

    public BullsAndCows() {
        setLayout(new FlowLayout());
        label = new JLabel();
        add(label);
        button = new JButton("Start");
        add(button);
        textField = new JTextField(10);
        event e = new event();
        button.addActionListener(e);
    }

    public int genarator() {
        Random gen = new Random();
        int target;
        while (hasDupes(target = (gen.nextInt(9000) + 1000))) ;
        return target;
    }

    public class event implements ActionListener {
        int target = genarator();

        public void actionPerformed(ActionEvent e) {
            try {
                add(textField);
                button.setText("Guess");
                String targetStr = target + "";
                boolean guessed = false;
                int guesses = 0;
                int bulls = 0;
                int cows = 0;
                label.setText("Guess a 4-digit number with no duplicate digits: ");
                int guess = 0;
                try {
                    guess = Integer.parseInt(textField.getText());
                    if (hasDupes(guess) || guess < 1000) actionPerformed(e);
                } catch (InputMismatchException ex) {
                    if (button.isSelected())
                        actionPerformed(e);
                } catch (Exception exc) {
                    if (button.isSelected())
                        actionPerformed(e);
                }
                guesses++;
                String guessStr = guess + "";
                for (int i = 0; i < 4; i++) {
                    if (guessStr.charAt(i) == targetStr.charAt(i)) {
                        bulls++;
                    } else if (targetStr.contains(guessStr.charAt(i) + "")) {
                        cows++;
                    }
                }
                if (bulls == 4) {
                    label.setText("You did it");
                    guessed = true;
                    return;
                } else {
                    label.setText(cows + " Cows and " + bulls + " Bulls.");
                }
                if (button.isSelected()) {
                    actionPerformed(e);
                }
            } catch (Exception exc) {
                if(button.isSelected())
                actionPerformed(e);
            }
        }
    }

    public static void runBullAndCows() {
        BullsAndCows gui = new BullsAndCows();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
        gui.setSize(300, 300);
        gui.setTitle("BullsAndCows");
    }

    public static boolean hasDupes(int num) {
        boolean[] digs = new boolean[10];
        while (num > 0) {
            if (digs[num % 10]) return true;
            digs[num % 10] = true;
            num /= 10;
        }
        return false;
    }
}
