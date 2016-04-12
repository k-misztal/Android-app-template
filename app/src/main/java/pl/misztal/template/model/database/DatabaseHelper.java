package pl.misztal.template.model.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import timber.log.Timber;

class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    public static final String DATABASE_NAME = "babbler.db";
    public static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        Timber.d("Creating database.");
        createTables(connectionSource);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        Timber.d("Upgrading database from version " + oldVersion + " to " + newVersion + ".");
    }

    void clearTable(Class clazz) throws SQLException {
        TableUtils.clearTable(getConnectionSource(), clazz);
    }

    private void createTables(ConnectionSource connectionSource) {
        try {
            // TODO: CREATE TABLES
            TableUtils.createTable(connectionSource, Object.class);
        } catch (SQLException e) {
            Timber.e("Fatal error, cannot create database!", e);
        }
    }
}
