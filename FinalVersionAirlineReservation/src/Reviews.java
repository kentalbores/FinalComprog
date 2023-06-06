import javax.swing.*;
import java.util.ArrayList;

public class Reviews {
    private JPanel panel1;
    Lists list = new Lists();
    TemporaryVariables temp = new TemporaryVariables();
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private JRadioButton radioButton5;
    private JTextField textField1;
    private JButton skipButton;
    private JButton submitReviewButton;
    ArrayList<JRadioButton> allButtons = new ArrayList<>();
    int stars;
    String review;
    Reviews(){
        JFrame frame = new JFrame();
        frame.add(panel1);
        frame.setVisible(true);
        frame.setSize(500,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        allButtons.add(radioButton1); allButtons.add(radioButton2); allButtons.add(radioButton3); allButtons.add(radioButton4); allButtons.add(radioButton5);
        for (JRadioButton button: allButtons){
            button.addActionListener(e -> {
                stars = allButtons.indexOf(button);
                for (int i = allButtons.indexOf(button); i >= 0; i--){
                    allButtons.get(i).setSelected(true);
                }
                for (int i = allButtons.indexOf(button)+1; i < 5; i++){
                    allButtons.get(i).setSelected(false);
                }
                System.out.println(stars + 1);
            });
        }

        skipButton.addActionListener(e -> {
            new LaunchPage();
            frame.dispose();
        });
        submitReviewButton.addActionListener(e -> {
            review = textField1.getText();
            if (!review.equals("") && radioButton1.isSelected()){
                list.addToReviews(review);
                list.addToReviewerName(list.getAccounts().get(temp.getAccountID()).getName());
                list.addToStars(stars + 1);
                new LaunchPage();
                frame.dispose();
            }
        });
    }
}
