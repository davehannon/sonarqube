/*
 * SonarQube, open source software quality management tool.
 * Copyright (C) 2008-2014 SonarSource
 * mailto:contact AT sonarsource DOT com
 *
 * SonarQube is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * SonarQube is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package org.sonar.core.measure.db;

import org.sonar.core.persistence.Dto;

import javax.annotation.CheckForNull;
import javax.annotation.Nullable;

public class MetricDto extends Dto<String> {

  private int id;

  private String name;

  private String valueType;

  private String description;

  private int direction;

  private boolean qualitative;

  private boolean userManaged;

  private Double worstValue;

  private Double bestValue;

  private Boolean optimizedBestValue;

  private boolean enabled;

  private MetricDto() {
    // Nothing here
  }

  public int getId() {
    return id;
  }

  public MetricDto setId(int id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public MetricDto setName(String name) {
    this.name = name;
    return this;
  }

  public String getValueType() {
    return valueType;
  }

  public MetricDto setValueType(String valueType) {
    this.valueType = valueType;
    return this;
  }

  /**
   * @return null for manual metrics
   */
  @CheckForNull
  public String getDescription() {
    return description;
  }

  public MetricDto setDescription(@Nullable String description) {
    this.description = description;
    return this;
  }

  public int getDirection() {
    return direction;
  }

  public MetricDto setDirection(int direction) {
    this.direction = direction;
    return this;
  }

  public boolean isQualitative() {
    return qualitative;
  }

  public MetricDto setQualitative(boolean qualitative) {
    this.qualitative = qualitative;
    return this;
  }

  public boolean isUserManaged() {
    return userManaged;
  }

  public MetricDto setUserManaged(boolean userManaged) {
    this.userManaged = userManaged;
    return this;
  }

  @CheckForNull
  public Double getWorstValue() {
    return worstValue;
  }

  public MetricDto setWorstValue(@Nullable Double worstValue) {
    this.worstValue = worstValue;
    return this;
  }

  @CheckForNull
  public Double getBestValue() {
    return bestValue;
  }

  public MetricDto setBestValue(@Nullable Double bestValue) {
    this.bestValue = bestValue;
    return this;
  }

  /**
   * @return null for manual metrics
   */
  @CheckForNull
  public Boolean isOptimizedBestValue() {
    return optimizedBestValue;
  }

  public MetricDto setOptimizedBestValue(@Nullable Boolean optimizedBestValue) {
    this.optimizedBestValue = optimizedBestValue;
    return this;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public MetricDto setEnabled(boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  @Override
  public String getKey() {
    return name;
  }

  public static MetricDto createFor(String key) {
    return new MetricDto().setName(key);
  }
}
