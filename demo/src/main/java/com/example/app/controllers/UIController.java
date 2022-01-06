package com.example.app.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.app.models.CarModel;
import com.example.app.models.CarDetails;
import com.example.app.models.SearchCarModels;
import com.example.app.models.SearchSellers;
import com.example.app.models.FavoriteCar;
import com.example.app.services.CarModelService;
import com.example.app.services.CarDetailsService;
import com.example.app.services.FavoriteCarService;

@Controller
@RequestMapping("/carsales")
public class UIController
{
    @Autowired
    CarModelService carModelService;
    @Autowired
    CarDetailsService carDetailsService;
    @Autowired
    FavoriteCarService favoriteCarService;

    @Value("${pagesize}")
    private int pageSize;
    
    @GetMapping("/logout")
    public String doLogout() {
        return "index";
    }
    
    @GetMapping("/home")
    public String goHome() {
        return "index";
    }
    
    @GetMapping("/uploadcarmodels")
    public String showUploadCarModels() {
        return "upload_carmodels";
    }
    
    @GetMapping("/uploadcardetails")
    public String showUploadCarDetails() {
        return "upload_cardetails";
    }
    
    @GetMapping("/showmodelsearch")
    public String showModelSearch(Model model) {
        model.addAttribute("searchCarModels", new SearchCarModels());
        model.addAttribute("makers", carModelService.getCarMakers());
        return "searchmodels_form";
    }
    
    @GetMapping("/showmakesearch")
    public String showMakeSearch(Model model) {
        model.addAttribute("searchSellers", new SearchSellers());
        model.addAttribute("makes", carDetailsService.getMakes());
        return "searchsellers_form";
    }
    
    @GetMapping("/addfavorite/{vin}")
    public String addFavorite(@PathVariable("vin") String vin, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        favoriteCarService.save(vin, userName);
        List<FavoriteCar> favoriteCars = favoriteCarService.getByUserName(userName);
        model.addAttribute("favoriteCars", favoriteCars);
        return "show_favorites";
    }
    
    @GetMapping("/showfavorites")
    public String showFavorites(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        List<FavoriteCar> favoriteCars = favoriteCarService.getByUserName(userName);
        model.addAttribute("favoriteCars", favoriteCars);
        return "show_favorites";
    }
    
    @GetMapping("/searchmodels/{pageNum}")
    public String returnPaginated(@PathVariable("pageNum") int pageNum, 
    @RequestParam(name="sortField", defaultValue="makeYear") String sortField,
    @RequestParam(name="sortDir", defaultValue="asc") String sortDir,
    @RequestParam("maker") String maker, Model model) {
        Page<CarModel> carModelsPage = carModelService.getModelsByMaker(maker, pageNum, pageSize, sortField, sortDir);
        List<CarModel> carModels = carModelsPage.getContent();
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", carModelsPage.getTotalPages());
        model.addAttribute("totalItems", carModelsPage.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc": "asc");
        model.addAttribute("makermodels", carModels);
        model.addAttribute("maker", maker);
        return "showmodels";        
    }
    
    @PostMapping("/searchmodels/{pageNum}")
    public String searchModels(@ModelAttribute("searchCarModels") SearchCarModels searchCarModels, Model model) {
        return returnPaginated(1, "makeYear", "asc", searchCarModels.getMaker(), model);
    }
    
    @GetMapping("/searchsellers/{pageNum}")
    public String returnPaginatedSellers(@PathVariable("pageNum") int pageNum,
    @RequestParam(name="sortField", defaultValue="seller") String sortField,
    @RequestParam(name="sortDir", defaultValue="asc") String sortDir,
    @RequestParam("make") String make, Model model) {
        Page<CarDetails> carDetailsPage = carDetailsService.getByMake(make, pageNum, pageSize, sortField, sortDir);
        List<CarDetails> carDetailsList = carDetailsPage.getContent();
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", carDetailsPage.getTotalPages());
        model.addAttribute("totalItems", carDetailsPage.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc": "asc");
        model.addAttribute("carDetailsList", carDetailsList);
        model.addAttribute("make", make);
        return "showsellers";
    }
    
    @PostMapping("/searchsellers/{pageNum}")
    public String searchSellers(@ModelAttribute("searchSellers") SearchSellers searchSellers, Model model) {
        return returnPaginatedSellers(1, "seller", "asc", searchSellers.getMake(), model);
    }
    
    @GetMapping("/favorites")
    public String getFavorites(Model model) {
        model.addAttribute("favoriteCars", favoriteCarService.getFavoriteCars());
        return "show_favorites";
    }
}
