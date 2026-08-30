package com.example.weapon_x_tracker.repository;

import com.example.weapon_x_tracker.model.Operative;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Repository;

/**
 * In-memory implementation of the operative repository.
 */
@Repository
public class InMemoryOperativeRepository implements OperativeRepository {

  private final Map<Long, Operative> operatives = new ConcurrentHashMap<>();
  private final AtomicLong idGenerator = new AtomicLong(0);

  /**
   * Saves an operative.
   *
   * @param operative the operative to save
   * @return the saved operative
   */
  @Override
  public Operative save(Operative operative) {
    if (operative.getId() == null) {
      operative.setId(idGenerator.incrementAndGet());
    }

    operatives.put(operative.getId(), operative);
    return operative;
  }

  /**
   * Finds an operative by its ID.
   *
   * @param id the operative ID
   * @return the operative if found
   */
  @Override
  public Optional<Operative> findById(Long id) {
    return Optional.ofNullable(operatives.get(id));
  }

  /**
   * Finds all operatives.
   *
   * @return a list containing all operatives
   */
  @Override
  public List<Operative> findAll() {
    return new ArrayList<>(operatives.values());
  }

  /**
   * Deletes an operative by its ID.
   *
   * @param id the operative ID
   */
  @Override
  public void deleteById(Long id) {
    operatives.remove(id);
  }
}