package guru.springframework.service;

import guru.springframework.model.Recipe;
import guru.springframework.repository.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class RecipeService {

    private final RecipeRepository repository;

    public RecipeService(RecipeRepository repository) {
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

    public <S extends Recipe> S save(S s) {
        return repository.save(s);
    }

    public <S extends Recipe> Iterable<S> saveAll(Iterable<S> iterable) {
        return repository.saveAll(iterable);
    }

    public Optional<Recipe> findById(Long id) {
        return repository.findById(id);
    }

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    public Iterable<Recipe> findAllById(Iterable<Long> iterable) {
        return repository.findAllById(iterable);
    }

    public long count() {
        return repository.count();
    }

    void deleteById(Long id) {
        repository.deleteById(id);
    }

    void delete(Recipe recipe) {
        repository.delete(recipe);
    }

    void deleteAll(Iterable<? extends Recipe> iterable) {
        repository.deleteAll(iterable);
    }

}
