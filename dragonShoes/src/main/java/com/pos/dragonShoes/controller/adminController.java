package com.pos.dragonShoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.pos.dragonShoes.entity.*;
import com.pos.dragonShoes.service.*;

@Controller
@RequestMapping("/admin")
public class adminController {

	@Autowired
	private UserService userSer;
	
	@Autowired
	private RoleService roleSer;
	
	@Autowired
	private CategoryService catSer;
	
	@Autowired
	private FootwearService footwearSer;
	
	@Autowired
	private FootwearDService footwearDSer;
	
	@Autowired
	private CartService cartSer;
	
	@Autowired
	private CartItemService cartItemSer;
	
	@Autowired
	private VoucherService vouchSer;
	
	@Autowired
	private VoucherDetailService vouchDSer;
	
	
	@GetMapping("/index")
	public String goToIndexPage() {
		return "adminLogin";
	}
	
	@GetMapping("/register")
	public String goToRegisterPage(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("rolelist",roleSer.findAll());
		return "adminRegister";
	}
	
	@PostMapping("/login")
	public String loginProcess(@RequestParam("email")String email,
			@RequestParam("password")String password,Model model) {
		
		User user = userSer.checkAdmin(email,password);
		if(user != null) 
		{	
			model.addAttribute("user", user);
			if((user.getRole().getRoleName().equalsIgnoreCase("ACCOUNTANT") || user.getRole().getRoleName().equalsIgnoreCase("MANAGER") || user.getRole().getRoleName().equalsIgnoreCase("CLERK")))
				return "redirect:/admin/home/"+user.getId();
			else {
				System.out.println("id = "+user.getId());
				return "adminLogin";
			}
		}
		else 
		{
			System.out.println("id = "+user.getId());
			return "adminLogin";
		}
		
	}
	
	@PostMapping("/save")
	public String saveProcess(@ModelAttribute("user")User user) {
		Role role = roleSer.findById((long) 1).get();
		user.setRole(role);
		/* user.setAccRegDate((java.sql.Date) new Date()); */
		userSer.saveUser(user);		
		return "adminLogin";
	}
	
	@GetMapping("/home/{id}")
	public String goToDashboardPage(@PathVariable(value="id") Long id,Model model) {
		model.addAttribute("user",userSer.findById(id).get());
		return "adminHome";
	}
	
	@GetMapping("/categoryView/{id}")
	public String goToCategoryViewPage(@PathVariable(value="id") Long id, Model model) {
		model.addAttribute("user",userSer.findById(id).get());
		model.addAttribute("catList", catSer.findAll());
		return "adminCategoryView";
	}
	
	@GetMapping("/categoryAddNew/{id}")
	public String goToCategoryAddNewPage(@PathVariable(value="id") Long id, Model model) {
		model.addAttribute("user",userSer.findById(id).get());
		model.addAttribute("category", new Category());
		return "adminCategoryAddNew";
	}
	@PostMapping("/saveCategory/{id}")
	public String saveCategoryProcess(@PathVariable(value="id") Long id, @ModelAttribute("category") Category category, Model model) {
		catSer.saveCategory(category);
		model.addAttribute("user",userSer.findById(id).get());
		return "redirect:/admin/categoryView/{id}";
	}
	
	@GetMapping("/inventoryView/{id}")
	public String goToInventoryViewPage(@PathVariable(value="id") Long id, Model model) {
		model.addAttribute("category", new Footwear());
		model.addAttribute("user",userSer.findById(id).get());
		model.addAttribute("footwearList", footwearDSer.findAll());
		return "adminInventoryView";
	}
	
	@GetMapping("/inventoryAddNew/{id}")
	public String goToInventoryAddNewPage(@PathVariable(value="id") Long id, Model model) {
		model.addAttribute("user",userSer.findById(id).get());
		model.addAttribute("footwearD", new FootwearDetail());
		model.addAttribute("footwearList", footwearSer.findAll());
		return "adminInventoryAddNew";
	}
	@GetMapping("/inventoryDetailAddNew/{id}")
	public String goToFDetailAddNewPage(@PathVariable(value="id") Long id, Model model) {
		model.addAttribute("footwear", new Footwear());
		model.addAttribute("categorylist", catSer.findAll());
		model.addAttribute("user",userSer.findById(id).get());
		return "adminInventoryDAddNew";
	}
	@PostMapping("/saveFootwearD/{id}")
	public String saveFootwearDProcess(@PathVariable(value="id") Long id, @ModelAttribute("footwear") FootwearDetail footwear, Model model) {
		footwearDSer.saveFootwearD(footwear);
		model.addAttribute("user",userSer.findById(id).get());
		return "redirect:/admin/inventoryView/{id}";
	}
	@PostMapping("/saveFootwear/{id}")
	public String saveFootwearProcess(@PathVariable(value="id") Long id, @ModelAttribute("footwear") Footwear footwear, Model model) {
		footwearSer.saveFootwear(footwear);
		model.addAttribute("user",userSer.findById(id).get());
		return "redirect:/admin/inventoryView/{id}";
	}
	
	@GetMapping("/reportOrders/{id}")
	public String goToReportOrdersPage(@PathVariable(value="id") Long id, Model model) {
		model.addAttribute("user",userSer.findById(id).get());
		return "adminReportOrder";
	}
	
	@GetMapping("/reportOrdersDetail/{id}")
	public String goToReportOrdersDetailPage(@PathVariable(value="id") Long id, Model model) {
		model.addAttribute("user",userSer.findById(id).get());
		return "adminReportOrderDetail";
	}
	
	@GetMapping("/reportRevenue/{id}")
	public String goToReportRevenuePage(@PathVariable(value="id") Long id, Model model) {
		model.addAttribute("user",userSer.findById(id).get());
		return "adminReportRevenue";
	}
	
	@GetMapping("/account/{id}")
	public String goToAccountPage(@PathVariable(value="id") Long id, Model model) {
		model.addAttribute("user",userSer.findById(id).get());
		return "adminAccount";
	}
}
