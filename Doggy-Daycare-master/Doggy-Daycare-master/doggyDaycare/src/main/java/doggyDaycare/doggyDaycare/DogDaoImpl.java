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
	public void active(long id) {
		if (dogsMap.get(id).getActiveFlag() == 0)
		{
			dogsMap.get(id).setActiveFlag(1);
		}
		else
		{
			dogsMap.get(id).setActiveFlag(0);
		}
	}
}
