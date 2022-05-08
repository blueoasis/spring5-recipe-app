package guru.springframework.service;

import guru.springframework.model.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();

    Iterable<Recipe> findAll();

    <S extends Recipe> Iterable<S> saveAll(Iterable<S> iterable);
}
