package doggyDaycare.doggyDaycare;

import java.util.HashMap;
import java.util.Map;

public class DogDaoImpl implements DogDao{

	private Map<Long,Dog>dogsMap = new HashMap<Long,Dog>();
	{
		
	}
	public void add(Dog dog) {
		
		dogsMap.put(dog.getDogId(),dog);
	}

	public void update(Dog dog) {
		dogsMap.put(dog.getDogId(),dog);
		
	}

}
