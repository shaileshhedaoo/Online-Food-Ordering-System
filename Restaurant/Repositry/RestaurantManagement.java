package Repositry;
import Interfaces.RestaurantMethod;
import model.Restaurant;
import java.util.HashMap;
import java.util.Map;
public class RestaurantManagement implements RestaurantMethod {
    public Map<String, Restaurant> restaurantMap;
    public RestaurantManagement()
    {
        this.restaurantMap=new HashMap<>();
    }
    @Override
    public void addRestaurant(String name, String cuisineType,String location)
    {

        try {
            if(!restaurantMap.containsKey(name))
            {
                Restaurant restaurant=new Restaurant(name,cuisineType,location);
                restaurantMap.put(name,restaurant);
                throw new RuntimeException("Restaurant Added Successfully with name:- "+ name);
            }
        }
        catch (RuntimeException e)
        {
            System.out.println("Restaurant with this name already exists.");
        }

        //Update

    }



}
