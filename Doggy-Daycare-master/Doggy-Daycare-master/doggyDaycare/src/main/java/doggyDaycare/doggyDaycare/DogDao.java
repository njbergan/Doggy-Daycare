package doggyDaycare.doggyDaycare;

public interface DogDao {
	public void add(Dog dog);
	public void update(Dog dog);
	public void active(long id);
}
