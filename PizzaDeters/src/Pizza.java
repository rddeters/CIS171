/**  
 * River Deters - mddeters  
 * CIS171 22149
 * July 7th, 2023
 * Windows 10 Operating System Eclipse Version - 2023-03
 */ 

public class Pizza {
	private String singleToppings;
	private String pizzaSize;
	private double price;
	
	public Pizza() {
		setSingleToppings("cheese");
		setPizzaSize("large");
		setPrice(9.99);
	}
	
	public Pizza(String top, String size, double pc) {
		setSingleToppings(top);
		setPizzaSize(size);
		setPrice(pc);
	}
	
	public String getSingleToppings() {
		return singleToppings;
	}
	public void setSingleToppings(String singleToppings) {
		this.singleToppings = singleToppings;
	}
	public String getPizzaSize() {
		return pizzaSize;
	}
	public void setPizzaSize(String pizzaSize) {
		this.pizzaSize = pizzaSize;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String repeatOrder() {
        String order = "You ordered a " + getPizzaSize() + " " + getSingleToppings() + " pizza for $" + getPrice() + ".";
        return order;
    }
}
