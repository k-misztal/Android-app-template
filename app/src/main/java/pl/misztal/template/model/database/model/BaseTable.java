package pl.misztal.template.model.database.model;

import com.j256.ormlite.field.DatabaseField;

public abstract class BaseTable {
    public static final String COLUMN_ID = "_id";

    @DatabaseField(generatedId = true, columnName = COLUMN_ID)
    Long id;

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseTable baseTable = (BaseTable) o;

        return id != null ? id.equals(baseTable.id) : baseTable.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
