package com.example.weapon_x_tracker.service;

import com.example.weapon_x_tracker.exception.OperativeNotFoundException;
import com.example.weapon_x_tracker.model.Operative;
import com.example.weapon_x_tracker.model.OperativeStatus;
import com.example.weapon_x_tracker.repository.OperativeRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 * Service for managing operatives.
 */
@Service
public class OperativeService {

  private final OperativeRepository repository;

  /**
   * Creates an operative service.
   *
   * @param repository the operative repository
   */
  public OperativeService(OperativeRepository repository) {
    this.repository = repository;
  }

  /**
   * Creates an operative.
   *
   * @param operative the operative to create
   * @return the created operative
   */
  public Operative create(Operative operative) {
    return repository.save(operative);
  }

  /**
   * Lists all operatives.
   *
   * @return all operatives
   */
  public List<Operative> listAll() {
    return repository.findAll();
  }

  /**
   * Filters operatives by status.
   *
   * @param status the operative status
   * @return operatives with the specified status
   */
  public List<Operative> filterStatus(OperativeStatus status) {
    return repository.findAll().stream()
        .filter(operative -> operative.getStatus() == status)
        .collect(Collectors.toList());
  }

  /**
   * Finds an operative by ID.
   *
   * @param id the operative ID
   * @return the operative
   * @throws OperativeNotFoundException if the operative does not exist
   */
  public Operative getById(Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new OperativeNotFoundException(id));
  }
}
