package guru.springframework.controller;

import guru.springframework.model.Recipe;
import guru.springframework.service.CategoryService;
import guru.springframework.service.RecipeService;
import guru.springframework.service.UnitOfMeasureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
public class IndexController {

    private CategoryService categoryService;
    private UnitOfMeasureService unitOfMeasureService;
    private RecipeService recipeService;

    public IndexController(CategoryService categoryService, UnitOfMeasureService unitOfMeasureService, RecipeService recipeService) {
        this.categoryService = categoryService;
        this.unitOfMeasureService = unitOfMeasureService;
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        log.debug("\n## Index Controller.getIndexPage() ##");

        List<Recipe> recipes = (List<Recipe>) recipeService.findAll();
        model.addAttribute("recipes",recipes);

        return "index";
    }

}
