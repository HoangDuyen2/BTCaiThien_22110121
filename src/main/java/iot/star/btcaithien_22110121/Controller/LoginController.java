package iot.star.btcaithien_22110121.Controller;

import iot.star.btcaithien_22110121.Entity.Product;
import iot.star.btcaithien_22110121.Services.ProductServices;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private ProductServices productServices;

    @PostMapping("/login_sucess_handler")
    public String login_sucess_handler() {
        System.out.println("logging user login success");
        return "home";
    }

    @PostMapping("/login_failure_handler")
    public String login_failure_handler() {
        System.out.println("logging user login failure");
        return "login";
    }

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Product> products = productServices.getProducts();
        model.addAttribute("products", products);
        return "home";
    }

    @RequestMapping("/new")
    public String newProductPage(Model model, @ModelAttribute("product") Product product) {
        model.addAttribute("product", product);
        return "newProduct";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product) {
        productServices.saveProduct(product);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public String editProduct(Model model, @PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("editProduct");
        Product product = productServices.getProduct(id);
        modelAndView.addObject("product", product);
        return modelAndView.toString();
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(Model model, @PathVariable(name = "id") Long id) {
        productServices.delete(id);
        return "redirect:/";
    }

}
