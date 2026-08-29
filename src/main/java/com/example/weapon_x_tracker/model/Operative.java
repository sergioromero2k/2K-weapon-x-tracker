package com.example.weapon_x_tracker.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import java.time.LocalDate;

/**
 * Represents an operative tracked by the Weapon-X system.
 */
public class Operative {

  private Long id;

  @NotBlank
  private String name;

  @NotBlank
  private String codename;

  @NotNull
  @Min(0)
  @Max(100)
  private Integer regenerationLevel;

  @NotNull
  private OperativeStatus status;

  @NotNull
  @PastOrPresent
  private LocalDate recruitmentDate;

  /**
   * Creates an empty operative.
   */
  public Operative() {
  }

  /**
   * Creates an operative with the specified information.
   *
   * @param id the operative identifier
   * @param name the operative real name
   * @param codename the operative codename
   * @param regenerationLevel the regeneration ability level
   * @param status the current operative status
   * @param recruitmentDate the date when the operative was recruited
   */
  public Operative(
      Long id,
      String name,
      String codename,
      Integer regenerationLevel,
      OperativeStatus status,
      LocalDate recruitmentDate) {
    this.id = id;
    this.name = name;
    this.codename = codename;
    this.regenerationLevel = regenerationLevel;
    this.status = status;
    this.recruitmentDate = recruitmentDate;
  }

  /**
   * Returns the operative identifier.
   *
   * @return the operative identifier
   */
  public Long getId() {
    return id;
  }

  /**
   * Returns the operative name.
   *
   * @return the operative name
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the operative codename.
   *
   * @return the operative codename
   */
  public String getCodename() {
    return codename;
  }

  /**
   * Returns the regeneration level.
   *
   * @return the regeneration level
   */
  public Integer getRegenerationLevel() {
    return regenerationLevel;
  }

  /**
   * Returns the operative status.
   *
   * @return the operative status
   */
  public OperativeStatus getStatus() {
    return status;
  }

  /**
   * Returns the recruitment date.
   *
   * @return the recruitment date
   */
  public LocalDate getRecruitmentDate() {
    return recruitmentDate;
  }

  /**
   * Sets the operative identifier.
   *
   * @param id the operative identifier
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Sets the operative name.
   *
   * @param name the operative name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Sets the operative codename.
   *
   * @param codename the operative codename
   */
  public void setCodename(String codename) {
    this.codename = codename;
  }

  /**
   * Sets the regeneration level.
   *
   * @param regenerationLevel the regeneration level
   */
  public void setRegenerationLevel(Integer regenerationLevel) {
    this.regenerationLevel = regenerationLevel;
  }

  /**
   * Sets the operative status.
   *
   * @param status the operative status
   */
  public void setStatus(OperativeStatus status) {
    this.status = status;
  }

  /**
   * Sets the recruitment date.
   *
   * @param recruitmentDate the recruitment date
   */
  public void setRecruitmentDate(LocalDate recruitmentDate) {
    this.recruitmentDate = recruitmentDate;
  }
}
