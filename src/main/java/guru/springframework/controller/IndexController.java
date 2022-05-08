package guru.springframework.controller;

import guru.springframework.model.Recipe;
import guru.springframework.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@Slf4j
public class IndexController {

    private RecipeService recipeService;

    public IndexController(RecipeService recipeService) {this.recipeService = recipeService;}


    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        log.debug("\n## Index Controller.getIndexPage() ##");

        Set<Recipe> recipes = recipeService.getRecipes();
        model.addAttribute("recipes",recipes);

        return "index";
    }

}
