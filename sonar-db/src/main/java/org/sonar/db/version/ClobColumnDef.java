/*
 * SonarQube
 * Copyright (C) 2009-2016 SonarSource SA
 * mailto:contact AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.db.version;

import javax.annotation.CheckForNull;
import org.sonar.db.dialect.Dialect;
import org.sonar.db.dialect.H2;
import org.sonar.db.dialect.MsSql;
import org.sonar.db.dialect.MySql;
import org.sonar.db.dialect.Oracle;
import org.sonar.db.dialect.PostgreSql;

import static org.sonar.db.version.Validations.validateColumnName;

/**
 * Used to define CLOB columns
 *
 * Warning, for the moment it's only supporting MsSQL
 */
public class ClobColumnDef extends AbstractColumnDef {

  private ClobColumnDef(Builder builder) {
    super(builder.columnName, builder.isNullable);
  }

  public static Builder newClobColumnDefBuilder() {
    return new Builder();
  }

  @Override
  public String generateSqlType(Dialect dialect) {
    switch (dialect.getId()) {
      case MsSql.ID:
        return "NVARCHAR (MAX)";
      case MySql.ID:
        return "LONGTEXT";
      case Oracle.ID:
        return "CLOB";
      case H2.ID:
        return "CLOB(2147483647)";
      case PostgreSql.ID:
        return "TEXT";
      default:
        throw new IllegalArgumentException("Unsupported dialect id " + dialect.getId());
    }
  }

  public static class Builder {
    @CheckForNull
    private String columnName;

    private boolean isNullable = true;

    public Builder setColumnName(String columnName) {
      this.columnName = validateColumnName(columnName);
      return this;
    }

    public Builder setIsNullable(boolean isNullable) {
      this.isNullable = isNullable;
      return this;
    }

    public ClobColumnDef build() {
      validateColumnName(columnName);
      return new ClobColumnDef(this);
    }
  }

}
