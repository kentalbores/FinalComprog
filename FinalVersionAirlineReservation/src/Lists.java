import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Lists {
    private static ArrayList<PlaneSeatsObject> planes = new ArrayList<>();
    private static ArrayList<String> planeNames = new ArrayList<>();
    private static ArrayList<String> passwords = new ArrayList<>();
    private static ArrayList<String> usernames = new ArrayList<>();
    private static ArrayList<Accounts> accounts = new ArrayList<>();
    private static HashMap<String,Double> selectedPlaneCost = new HashMap<>();
    private static ArrayList<String> reviews = new ArrayList<>();
    private static ArrayList<String> reviewerName = new ArrayList<>();
    private static ArrayList<Integer> stars = new ArrayList<>();

    Lists(){
        selectedPlaneCost.put("Japan", 35000.00);
        selectedPlaneCost.put("Singapore", 25000.00);
        selectedPlaneCost.put("Taiwan", 23000.00);
        selectedPlaneCost.put("China", 28000.00);
        selectedPlaneCost.put("South Korea", 26000.00);
    }
    public ArrayList<PlaneSeatsObject> getPlanes(){
        return planes;
    }
    public void addToPlanes(PlaneSeatsObject plane){
        planes.add(plane);
    }
    public void addToPlaneNames(String name){
        planeNames.add(name);
    }
    public ArrayList<String> getPlaneNames(){
        return planeNames;
    }
    public HashMap<String, Double> getSelectedPlaneCost() {
        return selectedPlaneCost;
    }
    public void addToUsernames(String username){
        usernames.add(username);
    }
    public void addToPasswords(String pass){
        passwords.add(pass);
    }
    public void addToAccounts(Accounts account){
        accounts.add(account);
    }
    public ArrayList<String> getUsernames(){
        return usernames;
    }
    public ArrayList<String> getPasswords(){
        return passwords;
    }
    public ArrayList<Accounts> getAccounts(){
        return accounts;
    }
    public ArrayList<String> getReviews(){
        return reviews;
    }
    public ArrayList<String> getReviewerName(){
        return reviewerName;
    }
    public ArrayList<Integer> getStars(){
        return stars;
    }
    public void addToReviews(String rev){
        reviews.add(rev);
    }
    public void addToReviewerName(String rev){
        reviewerName.add(rev);
    }
    public void addToStars(int star){
        stars.add(star);
    }
}
