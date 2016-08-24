package spittr.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spittr.Spitter;
import spittr.data.SpitterRepositoryDao;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
	private SpitterRepositoryDao spitterRepositoryDao;
	@Autowired
	public SpitterController(SpitterRepositoryDao spitterRepositoryDao){
		this.spitterRepositoryDao=spitterRepositoryDao;
	}
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String showRegistrationForm(){
		return "registerForm";
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String processRegistrationForm(@Valid Spitter spitter,Errors errors,@RequestParam("firstName")String firstName,
											@RequestParam("lastName")String lastName,
											@RequestParam("userName")String userName,
											@RequestParam("password")String password){
		//if form has errors return to registrationForm
		if(errors.hasErrors()){
			return "registerForm";
		}else{
		 spitter = new Spitter();
		spitter.setFirstName(firstName);
		spitter.setLastName(lastName);
		spitter.setUserName(userName);
		spitter.setPassword(password);
		spitterRepositoryDao.save(spitter);
		/*redirect is handled by the internalResourceViewResolver in a manner 
		 * that it doesn't handle it as a logical 
		view name, insted it redirects the request to the controller for further processing.*/
		System.out.println("here");
		return "redirect:/spitter/"+spitter.getUserName();
		}
	}
	//redirected request handling here, path variable is used here to take username in placeholder.
	
	/*also as no value is given in @PathVariable annotation the reason behind this is
	there is no need to give value for the annotation if the parameter comming in 
	placeholder has the same name as the parameter declared in method*/
	@RequestMapping(value="/{userName}",method=RequestMethod.GET)
	public String showSpitterPorfile(@PathVariable String userName,Model model){
		Spitter spitter = spitterRepositoryDao.findByUserName(userName);
		model.addAttribute(spitter);
		return "profile";
	}
}
