package guru.springframework.bootstrap;

import guru.springframework.model.*;
import guru.springframework.service.CategoryService;
import guru.springframework.service.RecipeService;
import guru.springframework.service.UnitOfMeasureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class BootstrapDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private RecipeService recipeService;
    private CategoryService categoryService;
    private UnitOfMeasureService unitOfMeasureService;

    public BootstrapDataLoader(RecipeService recipeService, CategoryService categoryService, UnitOfMeasureService unitOfMeasureService) {
        this.recipeService = recipeService;
        this.categoryService = categoryService;
        this.unitOfMeasureService = unitOfMeasureService;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.debug("\n## Loading Bootstrap Data ##");
        recipeService.saveAll(getRecipes());
    }

    public List<Recipe> getRecipes() {
        List<Recipe> recipes = new ArrayList<>(2);
        // get categories
        Category mexican = categoryService.findByDescription("Mexican").get();
        Category american = categoryService.findByDescription("American").get();

        // get units of measure
        UnitOfMeasure noneUOM = unitOfMeasureService.findByDescription("").get();
        UnitOfMeasure teaspoonUOM = unitOfMeasureService.findByDescription("Teaspoon").get();
        UnitOfMeasure tablespoonUOM = unitOfMeasureService.findByDescription("Tablespoon").get();
        UnitOfMeasure cupUOM = unitOfMeasureService.findByDescription("Cup").get();
        UnitOfMeasure pinchUOM = unitOfMeasureService.findByDescription("Pinch").get();
        UnitOfMeasure ounceUOM = unitOfMeasureService.findByDescription("Ounce").get();
        UnitOfMeasure pintUOM = unitOfMeasureService.findByDescription("Pint").get();

        // Recipe #1
        Recipe perfectGuac = new Recipe();
        perfectGuac.setDirections("The best guacamole keeps it simple: just ripe avocados " +
                "and a handful of flavorful mix-ins. Serve it as a dip at your next party or " +
                "spoon it on top of tacos for an easy dinner upgrade.");
        perfectGuac.setDescription("Perfect Guacamole");
        perfectGuac.setDifficulty(Difficulty.EASY);
        perfectGuac.setPrepTime(10);
        perfectGuac.setCookTime(0);
        perfectGuac.getCategories().add(mexican);
        perfectGuac.getCategories().add(american);

        Note perfectGuacNote = new Note();
        perfectGuacNote.setText("Be careful handling chilis! If using, it's best to wear " +
                "food-safe gloves. If no gloves are available, wash your hands thoroughly " +
                "after handling, and do not touch your eyes or the area near your eyes for " +
                "several hours afterwards");
        perfectGuac.setNote(perfectGuacNote);
        perfectGuacNote.setRecipe(perfectGuac);

        // Ingredients
        perfectGuac.addIngredient(new Ingredient("ripe avocados",new BigDecimal(2),noneUOM));
        perfectGuac.addIngredient(new Ingredient("kosher salt, plus more to taste",new BigDecimal(0.25),teaspoonUOM));
        perfectGuac.addIngredient(new Ingredient("fresh lime or lemon juice",new BigDecimal(1),tablespoonUOM));
        perfectGuac.addIngredient(new Ingredient("minced red onion or thinly sliced green onion",new BigDecimal(3),tablespoonUOM));
        perfectGuac.addIngredient(new Ingredient("(or jalapeño) chilis, stems and seeds removed, minced",new BigDecimal(1.5), noneUOM));
        perfectGuac.addIngredient(new Ingredient("(leaves and tender stems), finely chopped",new BigDecimal(2),tablespoonUOM));
        perfectGuac.addIngredient(new Ingredient("freshly ground black pepper",new BigDecimal(2),pinchUOM));
        perfectGuac.addIngredient(new Ingredient("ripe tomato, chopped (optional)",new BigDecimal(0.5),noneUOM));
        perfectGuac.addIngredient(new Ingredient("Red radish or jicama slices for garnish (optional)",new BigDecimal(5),noneUOM));
        perfectGuac.addIngredient(new Ingredient("Tortilla chips, to serve",new BigDecimal(50),noneUOM));
        recipes.add(perfectGuac);

        // Recipe #2
        Recipe tacos = new Recipe();
        tacos.setDescription("Spicy Grilled Chicken Tacos");
        tacos.setDifficulty(Difficulty.MEDIUM);
        perfectGuac.setPrepTime(10);
        perfectGuac.setCookTime(20);
        tacos.getCategories().add(mexican);
        tacos.getCategories().add(american);
        Note tacoNote = new Note();
        tacoNote.setText("Look for ancho chile powder with the Mexican ingredients at your " +
                "grocery store, on buy it online. (If you can't find ancho chili powder, you " +
                "replace the ancho chili, the oregano, and the cumin with 2 1/2 tablespoons " +
                "regular chili powder, though the flavor won't be quite the same.)");
        tacos.setNote(tacoNote);
        tacoNote.setRecipe(tacos);

        // ingredients
        tacos.addIngredient(new Ingredient("ancho chili powder",new BigDecimal(2),tablespoonUOM));
        tacos.addIngredient(new Ingredient("dried oregano",new BigDecimal(1),teaspoonUOM));
        tacos.addIngredient(new Ingredient("dried cumin",new BigDecimal(1),teaspoonUOM));
        tacos.addIngredient(new Ingredient("sugar",new BigDecimal(1),teaspoonUOM));
        tacos.addIngredient(new Ingredient("salt",new BigDecimal(0.5),teaspoonUOM));
        tacos.addIngredient(new Ingredient("clove garlic, finely chopped",new BigDecimal(1),noneUOM));
        tacos.addIngredient(new Ingredient("finely grated orange zest",new BigDecimal(1),tablespoonUOM));
        tacos.addIngredient(new Ingredient("fresh-squeezed orange juice",new BigDecimal(3),tablespoonUOM));
        tacos.addIngredient(new Ingredient("olive oil",new BigDecimal(2),tablespoonUOM));
        tacos.addIngredient(new Ingredient("skinless, boneless chicken thighs (1 1/4 pounds)",new BigDecimal(5),noneUOM));

        recipes.add(tacos);

        return recipes;
    }
}
