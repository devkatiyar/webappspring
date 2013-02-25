package com.springapp.user.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;




import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.springapp.user.services.UserService;
import com.springapp.user.vo.Contact;
import com.springapp.user.dao.ContactsDAO;

//@PreAuthorize("hasRole('ROLE_USER_MEMBER')")
@Controller
@Scope("session")
public class ContactsController {
	private Logger log = Logger.getLogger(this.getClass());
	@Autowired
	public ContactsDAO contactsDAO;
	
	@Autowired
	public UserService userService;
	

	
	/*
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}
	*/
	
	@RequestMapping("/searchContacts")
	public ModelAndView searchContacts(
			@RequestParam(required = false, defaultValue = "") String name) {
		ModelAndView mav = new ModelAndView("showContacts");
		List<Contact> contacts = userService.searchContacts(name.trim());
		mav.addObject("SEARCH_CONTACTS_RESULTS_KEY", contacts);
		return mav;
	}

	@RequestMapping("/viewAllContacts")
	public ModelAndView getAllContacts() {
		ModelAndView mav = new ModelAndView("showContacts");
		List<Contact> contacts = userService.getAllContacts();
		mav.addObject("SEARCH_CONTACTS_RESULTS_KEY", contacts);
		return mav;
	}

	@RequestMapping(value = "/saveContact", method = RequestMethod.GET)
	public ModelAndView newuserForm() {
		ModelAndView mav = new ModelAndView("newContact");
		Contact contact = new Contact();
		mav.getModelMap().put("newContact", contact);
		return mav;
	}

	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
	public String create(@ModelAttribute("newContact") Contact contact,
			BindingResult result, SessionStatus status) {
		if (result.hasErrors()) {
			return "newContact";
		}
		//contactsDAO.save(contact);
		userService.save(contact);
		status.setComplete();
		return "redirect:viewAllContacts.do";
	}

	@RequestMapping(value = "/updateContact", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam("id") Integer id) {
		ModelAndView mav = new ModelAndView("editContact");
		Contact contact = userService.getById(id);
		mav.addObject("editContact", contact);
		return mav;
	}

	@RequestMapping(value = "/updateContact", method = RequestMethod.POST)
	public String update(@ModelAttribute("editContact") Contact contact,
			BindingResult result, SessionStatus status) {
		System.out.println("updateContact post");
		userService.update(contact);
		status.setComplete();
		return "redirect:viewAllContacts.do";
	}

	@RequestMapping("deleteContact")
	public ModelAndView delete(@RequestParam("id") Integer id) {
		ModelAndView mav = new ModelAndView("redirect:viewAllContacts.do");
		userService.delete(id);
		return mav;
	}
}
