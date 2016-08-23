package spittr.data;

import org.springframework.stereotype.Component;

import spittr.Spitter;
@Component
public class SpitterRepositoryDaoImpl implements SpitterRepositoryDao {
	private Spitter savedSpitter;
	@Override
	public void save(Spitter spitter) {
		// TODO Auto-generated method stub
		this.savedSpitter=spitter;
	}
	public  Spitter findByUserName(String userName) {
		// TODO Auto-generated method stub
		return savedSpitter;
	}
	
}
