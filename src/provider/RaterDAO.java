package provider;

public interface RaterDAO {

	public int insertRater(Rater r);
	
	public Rater getRater(String username, String pass);
}
