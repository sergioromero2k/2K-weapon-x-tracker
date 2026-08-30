package com.example.weapon_x_tracker.repository;

import com.example.weapon_x_tracker.model.Operative;
import java.util.List;
import java.util.Optional;

/**
 * Repository for operative entities.
 */
public interface OperativeRepository {

  /**
   * Saves an operative.
   *
   * @param operative the operative to save
   * @return the saved operative
   */
  Operative save(Operative operative);

  /**
   * Finds an operative by its ID.
   *
   * @param id the operative ID
   * @return the operative if found
   */
  Optional<Operative> findById(Long id);

  /**
   * Finds all operatives.
   *
   * @return all operatives
   */
  List<Operative> findAll();

  /**
   * Deletes an operative by its ID.
   *
   * @param id the operative ID
   */
  void deleteById(Long id);
}
