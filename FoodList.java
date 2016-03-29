

import java.util.ArrayList;

public class FoodList 
{

	private static ArrayList<Food> FOOD_LIST = new ArrayList<Food>();
	private static String[] FOOD_TYPES = 	{
												"Cheese",
												"BlueCheese",
												"SoupPowder"
											};
		
	public static void addFood(Food food)
	{
		FOOD_LIST.add(food);
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
	
	public static int getNumFoodTypes()
	{
		return FOOD_TYPES.length;
	}
	
	public static String getFoodType(int index)
	{
		return FOOD_TYPES[index];
	}
}
