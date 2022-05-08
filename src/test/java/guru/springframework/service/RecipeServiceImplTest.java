package guru.springframework.service;

import guru.springframework.model.Recipe;
import guru.springframework.repository.RecipeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository repository;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(repository);
    }

    @Test
    public void getRecipes() throws Exception {
        Recipe mockRecipe = new Recipe();
        HashSet<Recipe> mockRecipes = new HashSet<>();
        mockRecipes.add(mockRecipe);

        when(repository.findAll()).thenReturn(mockRecipes);

        Set<Recipe> recipes = recipeService.getRecipes();
        Assert.assertNotNull(recipes);
        Assert.assertEquals(1,recipes.size());

        verify(repository, times(1)).findAll();
    }
}
