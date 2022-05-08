package guru.springframework.service;

import guru.springframework.model.Recipe;
import guru.springframework.repository.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository repository;

    public RecipeServiceImpl(RecipeRepository repository) {
        this.repository = repository;
    }

    public Set<Recipe> getRecipes() {
        log.debug("\n## RecipeService.getRecipes ##");
        Set<Recipe> recipeSet = new HashSet<>();
        repository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }

    public Iterable<Recipe> findAll() {
        log.debug("\n## RecipeService.findAll() ##");
        return repository.findAll();
    }

    @Override
    public <S extends Recipe> Iterable<S> saveAll(Iterable<S> iterable) {
        return repository.saveAll(iterable);
    }

}
