

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FoodList 
{

	private static ArrayList<Food> FOOD_LIST = new ArrayList<Food>();
	private static Set<String> FOOD_TYPES = new HashSet<String>();
		
	public static  void addFood(Food food)
	{
		FOOD_LIST.add(food);
		FOOD_TYPES.add(food.getClass().getName());
	}
	
	public static void removeFood(Food food)
	{
	
		FOOD_LIST.remove(food);
		
		food = null;
	}
	
	public static void dispose(Food food)
	{
		
		Machine machine = food.getCurrentMachine();
		machine.remove(food);
		removeFood(food);
	}
	
	
}
