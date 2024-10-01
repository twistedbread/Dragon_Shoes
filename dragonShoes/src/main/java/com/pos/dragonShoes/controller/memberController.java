package com.pos.dragonShoes.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pos.dragonShoes.entity.*;
import com.pos.dragonShoes.service.*;

@Controller
@RequestMapping("/member")
public class memberController {

	@Autowired
	private RoleService roleSer;
	
	@Autowired
	private UserService userSer;
	
	@Autowired
	private FootwearService footwearSer;
	
	@Autowired
	private FootwearDService footwearDSer;
	
	@Autowired
	private CartService cartSer;
	
	@Autowired
	private CartItemService cartItemSer;
	
	@Autowired
	private VoucherService voucherSer;
	
	@GetMapping("/index")
	public String goToIndexPage() {
		return "memberLogin";
	}
	
	@GetMapping("/register")
	public String goToRegisterPage(Model model) {
		model.addAttribute("member", new User());
		return "memberRegister";
	}
	
	@PostMapping("/save")
	public String saveProcess(@ModelAttribute("member")User user) {
		Role role = roleSer.findById((long) 4).get();
		user.setRole(role);
		userSer.saveUser(user);
		
		Cart cart = new Cart();
		cart.setMember(user);
		cartSer.saveCart(cart);

		return "memberLogin";
	}
	
	@PostMapping("/login")
	public String loginProcess(@RequestParam("email")String email,
			@RequestParam("password")String password,Model model) {
		
		User user = userSer.checkMember(email,password);
		System.out.println("User:  "+user);
		if(user != null) 
		{	
			model.addAttribute("user", user);
			if(user.getRole().getRoleName().equalsIgnoreCase("MEMBER")) {
				System.out.println("id = "+user.getId());
				return "redirect:/member/home/"+user.getId();
			}
			else
			{
				System.out.println("id = "+user.getId());
				System.out.println("Role: "+user.getRole().getRoleName());
				return "memberLogin";
			}
		}
		else 
		{
			System.out.println("Role: "+user.getRole().getRoleName());
			System.out.println("id = "+user.getId());
			return "memberLogin";
		}
	}
	
	@GetMapping("/home/{id}")
	public String goToHomePage(@PathVariable(value="id") Long id, Model model) {
		model.addAttribute("user", userSer.findById(id).get());
		return "memberHome";
	}
	
	@GetMapping("/collection/{id}")
	public String goToCollectionPage(@PathVariable(value="id") Long id, Model model) {
		model.addAttribute("user", userSer.findById(id).get());
		model.addAttribute("footwearList", footwearSer.findAll());
		return "memberCollection";
	}
	
	@GetMapping("/cart/{id}")
	public String goToCartPage(@PathVariable(value="id") Long id, Model model) {
		model.addAttribute("user", userSer.findById(id).get());
		return "memberCart";
	}
	@GetMapping("/collection/{id}/{fid}")
	public String goToShoeInfoPage(@PathVariable(value="id") Long id, @PathVariable(value="fid") Long fid, Model model) {
		model.addAttribute("footwear", footwearSer.findById(fid).get());
		model.addAttribute("user", userSer.findById(id).get());
		
//		model.addAttribute("cart",userSer.findById(id).get().getCart());
		model.addAttribute("cartItem",new CartItem());
		return "memberShoeInfo";
	}
	@GetMapping("/profile/{id}")
	public String goToProfile(@PathVariable(value="id") Long id, Model model) {
		model.addAttribute("user", userSer.findById(id).get());
		return "memberProfile";
	}
	@PostMapping("/addToCart/{id}/{fid}")
	public String addToCartProcess(@PathVariable(value="id") Long id, @PathVariable(value="fid") Long fid, Model model, @ModelAttribute("cartItem")CartItem cartItem) {
		model.addAttribute("user",userSer.findById(id).get());
		Footwear footwear = footwearSer.findById(fid).get();
		cartItem.setCart(userSer.findById(id).get().getCart());
		cartItem.setFootwear(footwear);
		cartItem.setAmount(footwear.getPrice() * cartItem.getQuantity());
		cartItemSer.saveCartItem(cartItem);
		return "redirect:/member/collection/{id}/{fid}";
	}
	
	@PostMapping("/selected-value")
    public String handleSelectedValue(@RequestBody Map<String, String> payload) {
        String selectedValue = payload.get("selectedValue");
        // Process the selected value here
        System.out.println("Selected value: " + selectedValue);

        // Return a response, e.g., a success message
        return "Value received: " + selectedValue;
    }
}
