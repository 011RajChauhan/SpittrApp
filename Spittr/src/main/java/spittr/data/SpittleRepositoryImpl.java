package spittr.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import spittr.Spittle;
@Component
public class SpittleRepositoryImpl implements SpittleRepositoryDao {
	
	@Override
	public List<Spittle> findSpittles(long max, int count) {
		List<Spittle> expectedSpittles = createSpittleList(count);
		return expectedSpittles;
	}
	public List<Spittle> createSpittleList(int count){
		List<Spittle> spittles = new ArrayList<>();
		for(int i=0;i<count;i++){
			spittles.add(new Spittle("Spittle "+i,new Date()));
		}
		return spittles;
	}
	@Override
	public Spittle findOne(long spittleId) {
		// TODO Auto-generated method stub
		Spittle spittle = new Spittle(" "+spittleId,new Date());
		return spittle;
	}

}
