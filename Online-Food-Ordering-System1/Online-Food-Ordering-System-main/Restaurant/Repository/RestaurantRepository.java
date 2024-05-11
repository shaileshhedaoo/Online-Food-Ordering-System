package Repository;

import model.ConcreteRestaurant;
import model.MenuItem;

import java.util.List;

public interface RestaurantRepository {

    void addRestaurant(ConcreteRestaurant restaurant);

    void setActivationStatus(boolean status);

    void updateMenuItem(MenuItem item);

    ConcreteRestaurant getRestaurantById(long id);

    List<ConcreteRestaurant> findRestaurantByLocation(String location);

    List<ConcreteRestaurant> findRestaurantByName(String name);

    List<ConcreteRestaurant> findRestaurantByType(String CuisineType );

    List<ConcreteRestaurant> findAllActiveRestaurant();

    List<ConcreteRestaurant> findAllDeactivatedRestaurant();
}
