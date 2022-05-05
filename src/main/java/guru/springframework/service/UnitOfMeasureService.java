package guru.springframework.service;

import guru.springframework.model.UnitOfMeasure;
import guru.springframework.repository.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UnitOfMeasureService {

    private final UnitOfMeasureRepository repository;

    public UnitOfMeasureService(UnitOfMeasureRepository repository) {
        this.repository = repository;
    }

    public Optional<UnitOfMeasure> findByDescription(String description) {
        return repository.findByDescription(description);
    }

    public <S extends UnitOfMeasure> S save(S s) {
        return repository.save(s);
    }

    public <S extends UnitOfMeasure> Iterable<S> saveAll(Iterable<S> iterable) {
        return repository.saveAll(iterable);
    }

    public Optional<UnitOfMeasure> findById(Long id) {
        return repository.findById(id);
    }

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    public Iterable<UnitOfMeasure> findAll() {
        return repository.findAll();
    }

    public Iterable<UnitOfMeasure> findAllById(Iterable<Long> iterable) {
        return repository.findAllById(iterable);
    }

    public long count() {
        return repository.count();
    }

    void deleteById(Long id) {
        repository.deleteById(id);
    }

    void delete(UnitOfMeasure recipe) {
        repository.delete(recipe);
    }

    void deleteAll(Iterable<? extends UnitOfMeasure> iterable) {
        repository.deleteAll(iterable);
    }
}
