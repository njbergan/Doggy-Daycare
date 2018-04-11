package doggyDaycare.doggyDaycare;

import java.util.HashMap;
import java.util.Map;

public class OwnerDaoImpl implements OwnerDao
{
	private Map<String,Owner>ownersMap = new HashMap<String,Owner>();
	{
		
	}
	public void add(Owner owner) {
		
		ownersMap.put(owner.getOwnerId(),owner);
	}

	public void update(Owner owner) {
		ownersMap.put(owner.getOwnerId(),owner);
		
	}
}
