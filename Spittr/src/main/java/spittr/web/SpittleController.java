package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spittr.data.SpittleRepositoryDao;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
	private static final String MAX_LONG_AS_RATING="235900";/*Long.toString(Long.MAX_VALUE);*/
	private SpittleRepositoryDao spittleRepository;
	@Autowired
	public SpittleController(SpittleRepositoryDao spittleRepository){
		this.spittleRepository=spittleRepository;
	}
	@RequestMapping(method=RequestMethod.GET)
	public String spittles(Model model,@RequestParam(value="max",defaultValue=MAX_LONG_AS_RATING)long max,
			@RequestParam(value="count",defaultValue="20")int count){
		model.addAttribute(spittleRepository.findSpittles(max,count));
		return "spittles";
	}
	//use of path variables 
	/*value of the path variable in case not given than placeholder name and 
	method parameter should exactly be the same.*/
	@RequestMapping(value="/{spittleId}",method=RequestMethod.GET)
	public String spittle(@PathVariable("spittleId") long spittleID,Model model){
		model.addAttribute(spittleRepository.findOne(spittleID));
		return "spittle";
	}
}
