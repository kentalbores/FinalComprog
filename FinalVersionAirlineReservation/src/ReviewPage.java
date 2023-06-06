import javax.swing.*;

public class ReviewPage {
    private JPanel panel1;
    private JButton goBackButton;
    private JTextPane textPane1;
    private JTextPane averageTextPane;
    float averageStars = 0f;
    String message = "";

    ReviewPage(){
        Lists list = new Lists();
        JFrame frame = new JFrame();
        frame.add(panel1);
        frame.setVisible(true);
        frame.setSize(400,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int j = 0;
        for (String i : list.getReviews()){
            message = message.concat(list.getReviewerName().get(j) + "\n" + i + "\n" + list.getStars().get(j) + " Star" + "\n\n");
            averageStars += list.getStars().get(j);
            j++;
        }
        averageStars = averageStars / list.getStars().size();
        textPane1.setText(message);
        if (averageStars > 0){
            averageTextPane.setText(averageStars + " Stars");
        } else if (averageStars <= 0){
            averageTextPane.setText("No Reviews Yet");
        }
        goBackButton.addActionListener(e -> {
            new LaunchPage();
            frame.dispose();
        });
    }
}
