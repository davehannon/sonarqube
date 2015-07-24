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
package org.sonar.server.computation.monitoring;

public interface ComputeEngineQueueMonitorMBean {

  /**
   * Count of received batch reports since instance startup
   */
  long getReceivedCount();

  /**
   * Count of batch report waiting for processing since startup, including reports received before instance startup.
   */
  long getPendingCount();

  /**
   * Count of batch report under processing.
   */
  long getInProgressCount();

  /**
   * Count of batch report which processing ended with an error since instance startup.
   */
  long getErrorCount();

  /**
   * Count of batch report which processing ended successfully since instance startup.
   */
  long getSuccessCount();
}
