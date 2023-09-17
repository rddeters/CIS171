/**  
 * River Deters - mddeters  
 * CIS171 22149
 * July 7th, 2023
 * Windows 10 Operating System Eclipse Version - 2023-03
 */ 

public class PizzaTesterDeters {
	public static void main(String[] args) {        
		Pizza myPizza = new Pizza();
		Pizza yourPizza = new Pizza("pineapple", "extra large", 13.50);
		
		myPizza.setPrice(12.50);
		myPizza.setSingleToppings("mushroom");
		
		System.out.println(myPizza.repeatOrder());
		System.out.println(yourPizza.repeatOrder());
	}
}
