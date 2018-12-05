package com.tipwheal.obscurephoton.config

import org.hibernate.dialect.Dialect
import org.hibernate.dialect.function.SQLFunctionTemplate
import org.hibernate.dialect.function.StandardSQLFunction
import org.hibernate.dialect.function.VarArgsSQLFunction
import org.hibernate.dialect.pagination.LimitHandler
import org.hibernate.dialect.pagination.LimitHelper
import org.hibernate.engine.spi.RowSelection
import org.hibernate.type.StringType

import java.sql.PreparedStatement
import java.sql.SQLException
import java.sql.Types

class SqLiteDialect extends Dialect {

    SqLiteDialect() {
        registerColumnType Types.BIT, "integer"
        registerColumnType Types.TINYINT, "tinyint"
        registerColumnType Types.SMALLINT, "smallint"
        registerColumnType Types.INTEGER, "integer"
        registerColumnType Types.BIGINT, "bigint"
        registerColumnType Types.FLOAT, "float"
        registerColumnType Types.REAL, "real"
        registerColumnType Types.DOUBLE, "double"
        registerColumnType Types.NUMERIC, "numeric"
        registerColumnType Types.DECIMAL, "decimal"
        registerColumnType Types.CHAR, "char"
        registerColumnType Types.VARCHAR, "varchar"
        registerColumnType Types.LONGVARCHAR, "longvarchar"
        registerColumnType Types.DATE, "date"
        registerColumnType Types.TIME, "time"
        registerColumnType Types.TIMESTAMP, "timestamp"
        registerColumnType Types.BINARY, "blob"
        registerColumnType Types.VARBINARY, "blob"
        registerColumnType Types.LONGVARBINARY, "blob"
        registerColumnType Types.BLOB, "blob"
        registerColumnType Types.CLOB, "clob"
        registerColumnType Types.BOOLEAN, "integer"

        registerFunction "concat", new VarArgsSQLFunction(StringType.INSTANCE, "", "||", "")
        registerFunction "mod", new SQLFunctionTemplate(StringType.INSTANCE, "?1 % ?2")
        registerFunction "substr", new StandardSQLFunction("substr", StringType.INSTANCE)
        registerFunction "substring", new StandardSQLFunction("substr", StringType.INSTANCE)
    }

    boolean supportsIdentityColumns() {
        return true
    }

    boolean hasDataTypeInIdentityColumn() {
        return false
    }

    String getIdentityColumnString() {
        return "integer"
    }

    String getIdentitySelectString() {
        return "select last_insert_rowid()"
    }

    @Override
    LimitHandler getLimitHandler() {
        return new LimitHandler() {
            @Override
            boolean supportsLimit() {
                return true
            }

            @Override
            boolean supportsLimitOffset() {
                return true
            }

            @Override
            String processSql(String sql, RowSelection selection) {
                final boolean hasOffset = LimitHelper.hasFirstRow(selection)
                return sql + (hasOffset ? " limit ? offset ?" : " limit ?")
            }

            @Override
            int bindLimitParametersAtStartOfQuery(RowSelection selection, PreparedStatement statement, int index) throws SQLException {
                return 0
            }

            @Override
            int bindLimitParametersAtEndOfQuery(RowSelection selection, PreparedStatement statement, int index) throws SQLException {
                return 0
            }

            @Override
            void setMaxRows(RowSelection selection, PreparedStatement statement) throws SQLException {

            }
        };
    }

    boolean supportsTemporaryTables() {
        return true
    }

    String getCreateTemporaryTableString() {
        return "create temporary table if not exists"
    }

    boolean dropTemporaryTableAfterUse() {
        return false
    }

    @Override
    boolean supportsCurrentTimestampSelection() {
        return true
    }

    @Override
    boolean isCurrentTimestampSelectStringCallable() {
        return false
    }

    @Override
    String getCurrentTimestampSelectString() {
        return "select current_timestamp"
    }

    @Override
    boolean supportsUnionAll() {
        return true
    }

    @Override
    boolean hasAlterTable() {
        return false
    }

    @Override
    boolean dropConstraints() {
        return false
    }

    @Override
    String getAddColumnString() {
        return "add column"
    }

    @Override
    String getForUpdateString() {
        return ""
    }

    @Override
    boolean supportsOuterJoinForUpdate() {
        return false
    }

    @Override
    String getDropForeignKeyString() {
        throw new UnsupportedOperationException("No drop foreign key syntax supported by SQLiteDialect")
    }

    @Override
    String getAddForeignKeyConstraintString(String constraintName,
                                            String[] foreignKey, String referencedTable, String[] primaryKey,
                                            boolean referencesPrimaryKey) {
        throw new UnsupportedOperationException("No add foreign key syntax supported by SQLiteDialect")
    }

    @Override
    String getAddPrimaryKeyConstraintString(String constraintName) {
        throw new UnsupportedOperationException("No add primary key syntax supported by SQLiteDialect")
    }

    @Override
    boolean supportsIfExistsBeforeTableName() {
        return true
    }

    @Override
    boolean supportsCascadeDelete() {
        return false
    }
}
