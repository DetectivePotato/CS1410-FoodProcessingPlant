

import java.util.ArrayList;
import java.util.Iterator;

/**
*	FoodList stores a list of all current Food objects in the system and food types used.
*	It also provides a method for handling the removal of spoiled Foods from the system.
*/
public class FoodList 
{

	private static ArrayList<Food> FOOD_LIST = new ArrayList<Food>();
	private static ArrayList<Food> SPOIL_LIST = new ArrayList<Food>();
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
	
	public static int getNum()
	{
		return FOOD_LIST.size(); 
	}
	
	public static int getNumFoodTypes()
	{
		return FOOD_TYPES.length;
	}
	
	public static String getFoodType(int index)
	{
		return FOOD_TYPES[index];
	}

	public static void spoilFood(Food food)
	{
		Machine foodMachine = food.getCurrentMachine();
		foodMachine.remove(food);
		ProfitStats.addLost();
		SPOIL_LIST.add(food);
	} 
	
	public static void packFood(Food food)
	{
		ProfitStats.addPacked();
		removeFood(food);
	}
	public static void reset()
	{
		Iterator<Food> iter = FOOD_LIST.iterator();
		
		while(iter.hasNext())
		{
			Food food = iter.next();
			iter.remove();
			food = null;
		}
		
		System.out.println(FOOD_LIST.size());
	}
	
	public static void ageFood()
	{
		if(FOOD_LIST.size() > 0)
		{
			for(Food food : FOOD_LIST)
			{
				if(food.isPerishable())
				{
					Perishable perishable = (Perishable) food;

					perishable.incrementAge();
				}
			}
			
			Iterator<Food> iter = SPOIL_LIST.iterator();
			while(iter.hasNext())
			{
				Food spoiledFood = iter.next();
				removeFood(spoiledFood);
				iter.remove();
			}
		}
	}
}
