import javax.swing.*;


public class AddReservation {
    private JPanel Panel1;
    private JCheckBox japanCheckBox;
    private JCheckBox singaporeCheckBox;
    private JCheckBox taiwanCheckBox;
    private JCheckBox chinaCheckBox;
    private JCheckBox southKoreaCheckBox;
    private JCheckBox a7AMCheckBox;
    private JCheckBox a7PMCheckBox;
    private JButton goBackButton;
    private JButton reserveButton;
    private JTextField textFieldTime1;
    Lists list = new Lists();
    boolean hasSelected = false, hasTime = false;
    TemporaryVariables temp = new TemporaryVariables();
    String selectedLocation, selectedTime = "", selectedPlaneName = "", content1, content2;
    double selectedCost;


    AddReservation(){
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(Panel1);
        ImageIcon icon = new ImageIcon("src/happilogo.jpg");
        frame.setIconImage(icon.getImage());
        frame.setTitle("Airline Reservations System");


        goBackButton.addActionListener(e -> {
            new HomePage();
            frame.dispose();
        });



        // para single selection
        JCheckBox[] allCheckBoxes = {japanCheckBox, singaporeCheckBox, taiwanCheckBox, chinaCheckBox, southKoreaCheckBox};
        String[] places = {"Japan", "Singapore", "Taiwan", "China", "South Korea"};
        for (int i = 0; i < 5; i++){
            int select = i;
            allCheckBoxes[i].addActionListener(e -> {
                for (int j = 0; j < 5; j++){
                    if (j == select){
                        selectedLocation = places[select];
                        selectedCost = list.getSelectedPlaneCost().get(selectedLocation);
                        hasSelected = true;
                        //list.getAccounts().get(temp.getAccountID()).addToThisAccountsLocation(places[select]); saldfjlrhoewhrehior ewaohiromnweiavhioa ahhhhhhhhhhhhhhhhhhhhh
                        continue;
                    }
                    allCheckBoxes[j].setSelected(false);
                }
            });
        }

        a7AMCheckBox.addActionListener(e -> {
            a7PMCheckBox.setSelected(false);
            content2 = "AM";
        });
        a7PMCheckBox.addActionListener(e -> {
            a7AMCheckBox.setSelected(false);
            content2 = "PM";
        });


        reserveButton.addActionListener(e -> {
            content1 = textFieldTime1.getText();
            try {
                int num = Integer.parseInt(content1);
                if (num <= 12 && num >= 1){
                    hasTime = true;
                }
            } catch (NumberFormatException ex) {
                System.out.println("hdhdvhahoihaieshiaeavw");
                JOptionPane.showMessageDialog(null, "Enter Number 1-12", "!!!", JOptionPane.WARNING_MESSAGE);
            }
            selectedTime = selectedTime.concat(content1 + " " + content2);
            selectedPlaneName = selectedPlaneName.concat(selectedLocation + selectedTime);

            System.out.println("plane name: " + selectedPlaneName);
            if (!list.getPlaneNames().contains(selectedPlaneName)){
                PlaneSeatsObject newPlane = new PlaneSeatsObject(selectedPlaneName);
                list.addToPlaneNames(selectedPlaneName);
                list.addToPlanes(newPlane);
            }
            if (hasTime && hasSelected && (a7PMCheckBox.isSelected() || a7AMCheckBox.isSelected()) && !content1.equals("")){
                list.getAccounts().get(temp.getAccountID()).addToThisAccountsLocation(selectedLocation);
                list.getAccounts().get(temp.getAccountID()).addToThisAccountsTime(selectedTime);
                list.getAccounts().get(temp.getAccountID()).addToThisAccountsCost(selectedCost);
                temp.setPlaneID(list.getPlaneNames().indexOf(selectedPlaneName));
                new SeatsSelection();
                frame.dispose();
            }
            selectedPlaneName = "";
            selectedTime = "";
//            System.out.println(list.getAccounts().get(temp.getAccountID()).getThisAccountsLocation());
//            System.out.println(list.getAccounts().get(temp.getAccountID()).getThisAccountsTime());
//            System.out.println(list.getAccounts().get(temp.getAccountID()).getThisAccountsCosts());
        });


    }
}
