import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CancellationPage {
    int selectedButton = -1;
    int selectedSeat;
    String selectedPlaneName = "";
    CancellationPage(){
        Lists list = new Lists();
        TemporaryVariables temp = new TemporaryVariables();
        JFrame frame = new JFrame();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        ArrayList<JButton> allButtons = new ArrayList<>();
        JButton buttonCancel;
        JButton button;
        ImageIcon icon = new ImageIcon("src/happilogo.jpg");
        frame.setIconImage(icon.getImage());
        frame.setTitle("Airline Reservations System");
        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel3, BorderLayout.SOUTH);
        frame.add(panel2);
        panel2.setBackground(new Color(30, 30, 30));
        panel3.setBackground(new Color(30, 30, 30));
        panel1.setBackground(new Color(30, 30, 30));
        frame.setVisible(true);
        frame.setSize(400,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel2.setLayout(new GridLayout(20,43));
        int j = 0;
        for (String i : list.getAccounts().get(temp.getAccountID()).getThisAccountsLocation()){
            panel2.add(button = new JButton(i + " " + list.getAccounts().get(temp.getAccountID()).getThisAccountsTime().get(j) + " => " + list.getAccounts().get(temp.getAccountID()).getThisAccountsSeats().get(j)));
            button.setBackground(new Color(120, 120, 125));
            button.setForeground(new Color(250,250,250));
            button.setPreferredSize(new Dimension(100,50));
            button.setFocusable(false);
            allButtons.add(button);
            j++;
        }
        for (JButton buttons : allButtons){
            buttons.addActionListener(e -> {
                selectedPlaneName = "";
                buttons.setBackground(Color.red);
                selectedButton = allButtons.indexOf(buttons);
                System.out.println("selected button: " + selectedButton);
                System.out.println("selected button: " + selectedSeat);
                selectedSeat = list.getAccounts().get(temp.getAccountID()).getThisAccountsSeats().get(selectedButton);
                selectedPlaneName = selectedPlaneName.concat(list.getAccounts().get(temp.getAccountID()).getThisAccountsLocation().get(selectedButton) + list.getAccounts().get(temp.getAccountID()).getThisAccountsTime().get(selectedButton));
                temp.setPlaneID(list.getPlaneNames().indexOf(selectedPlaneName));
                for (JButton button2 : allButtons){
                    if (allButtons.indexOf(button2)!= selectedButton){
                        button2.setBackground(new Color(120,120,125));
                    }
                }
                System.out.println("plane name: " + selectedPlaneName);
            });
        }
        JButton buttonBack;
        panel1.add(buttonBack = new JButton("go back"));
        buttonBack.setBackground(new Color(120, 120, 125));
        buttonBack.setForeground(new Color(250,250,250));
        buttonBack.setPreferredSize(new Dimension(100,50));
        panel3.add(buttonCancel = new JButton("Cancel Reservation"));
        buttonCancel.setBackground(new Color(120,120,125));
        buttonCancel.setForeground(new Color(250,250,250));

        buttonBack.addActionListener(e -> {
            new HomePage();
            frame.dispose();
        });
        buttonCancel.addActionListener(e -> {
            temp.setPlaneID(list.getPlaneNames().indexOf(selectedPlaneName));
            if (list.getAccounts().get(temp.getAccountID()).getThisAccountsSeats().size() != 0 && selectedButton!= -1){
                list.getAccounts().get(temp.getAccountID()).getThisAccountsSeats().remove(selectedButton);
                list.getAccounts().get(temp.getAccountID()).getThisAccountsTime().remove(selectedButton);
                list.getAccounts().get(temp.getAccountID()).getThisAccountsCosts().remove(selectedButton);
                list.getAccounts().get(temp.getAccountID()).getThisAccountsLocation().remove(selectedButton);
                System.out.println("button: " + selectedButton);
                System.out.println("seat: "+ selectedSeat);
                list.getPlanes().get(temp.getPlaneID()).getOccupiedSeats().remove((Integer) selectedSeat);
                System.out.println(list.getPlanes().get(temp.getPlaneID()).getOccupiedSeats());
                new HomePage();
                frame.dispose();
            }

        });

    }

}
