package Hw;
import java.util.*;

public class Menu  {
	

	
	    private int menuId;
	    private String itemName;
	    private double price;
	    private String rating;

	    
	    public Menu(int menuId, String itemName, double price, String rating) {
	        this.menuId = menuId;
	        this.itemName = itemName;
	        this.price = price;
	        this.rating = rating;
	    }

	    // Getter and setter methods for menuId
	    public int getMenuId() {
	        return menuId;
	    }

	    public void setMenuId(int menuId) {
	        this.menuId = menuId;
	    }

	    // Getter and setter methods for itemName
	    public String getItemName() {
	        return itemName;
	    }

	    public void setItemName(String itemName) {
	        this.itemName = itemName;
	    }

	    // Getter and setter methods for price
	    public double getPrice() {
	        return price;
	    }

	    public void setPrice(double price) {
	        this.price = price;
	    }

	    // Getter and setter methods for rating
	    public String getRating() {
	        return rating;
	    }

	    public void setRating(String rating) {
	        this.rating = rating;
	    }

	    public static void main(String[] args) {
	       
	        Set<Menu> menuSet = new TreeSet<>(Comparator.comparing(Menu::getItemName));

	        
	        menuSet.add(new Menu(1, "Pizza", 900, "Good"));
	        menuSet.add(new Menu(2, "caker", 1000, "Excellent"));
	        menuSet.add(new Menu(3, "Salad", 700, "Average"));
	        menuSet.add(new Menu(3, "cooldrink", 200, "Average"));
	        menuSet.add(new Menu(3, "potato chipes", 100, "Average"));

	       
	        for (Menu menu : menuSet) {
	            System.out.println(menu.getItemName() + ": rs" + menu.getPrice());
	        }
	    }
	}

	

	

	
	    