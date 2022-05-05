package guru.springframework.service;

import guru.springframework.model.Category;
import guru.springframework.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class CategoryService {

    private CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public Optional<Category> findByDescription(String description) {
        return repository.findByDescription(description);
    }

    public <S extends Category> S save(S s) {
        return repository.save(s);
    }

    public <S extends Category> Iterable<S> saveAll(Iterable<S> iterable) {
        return repository.saveAll(iterable);
    }

    public Optional<Category> findById(Long id) {
        return repository.findById(id);
    }

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    public Iterable<Category> findAll() {
        return repository.findAll();
    }

    public Iterable<Category> findAllById(Iterable<Long> iterable) {
        return repository.findAllById(iterable);
    }

    public long count() {
        return repository.count();
    }

    void deleteById(Long id) {
        repository.deleteById(id);
    }

    void delete(Category recipe) {
        repository.delete(recipe);
    }

    void deleteAll(Iterable<? extends Category> iterable) {
        repository.deleteAll(iterable);
    }
}
