package com.example.gym.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class GymDatabase_Impl extends GymDatabase {
  private volatile WorkoutDao _workoutDao;

  private volatile WorkoutCategoryDao _workoutCategoryDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `workout_table` (`id` INTEGER NOT NULL, `title` TEXT NOT NULL, `time` INTEGER NOT NULL, `category` TEXT NOT NULL, `iconCode` TEXT NOT NULL, `instruction` TEXT NOT NULL, `isSaved` INTEGER NOT NULL, `timeSaved` INTEGER NOT NULL, `isRecommended` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `category_table` (`id` TEXT NOT NULL, `title` TEXT NOT NULL, `overview` TEXT NOT NULL, `description` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '4fe2dcf5575430950b33f30850313c2d')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `workout_table`");
        _db.execSQL("DROP TABLE IF EXISTS `category_table`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsWorkoutTable = new HashMap<String, TableInfo.Column>(9);
        _columnsWorkoutTable.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutTable.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutTable.put("time", new TableInfo.Column("time", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutTable.put("category", new TableInfo.Column("category", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutTable.put("iconCode", new TableInfo.Column("iconCode", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutTable.put("instruction", new TableInfo.Column("instruction", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutTable.put("isSaved", new TableInfo.Column("isSaved", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutTable.put("timeSaved", new TableInfo.Column("timeSaved", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWorkoutTable.put("isRecommended", new TableInfo.Column("isRecommended", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWorkoutTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesWorkoutTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoWorkoutTable = new TableInfo("workout_table", _columnsWorkoutTable, _foreignKeysWorkoutTable, _indicesWorkoutTable);
        final TableInfo _existingWorkoutTable = TableInfo.read(_db, "workout_table");
        if (! _infoWorkoutTable.equals(_existingWorkoutTable)) {
          return new RoomOpenHelper.ValidationResult(false, "workout_table(com.example.gym.model.Workout).\n"
                  + " Expected:\n" + _infoWorkoutTable + "\n"
                  + " Found:\n" + _existingWorkoutTable);
        }
        final HashMap<String, TableInfo.Column> _columnsCategoryTable = new HashMap<String, TableInfo.Column>(4);
        _columnsCategoryTable.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategoryTable.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategoryTable.put("overview", new TableInfo.Column("overview", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategoryTable.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCategoryTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCategoryTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCategoryTable = new TableInfo("category_table", _columnsCategoryTable, _foreignKeysCategoryTable, _indicesCategoryTable);
        final TableInfo _existingCategoryTable = TableInfo.read(_db, "category_table");
        if (! _infoCategoryTable.equals(_existingCategoryTable)) {
          return new RoomOpenHelper.ValidationResult(false, "category_table(com.example.gym.model.WorkoutCategory).\n"
                  + " Expected:\n" + _infoCategoryTable + "\n"
                  + " Found:\n" + _existingCategoryTable);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "4fe2dcf5575430950b33f30850313c2d", "53ed1cc874e9b5db50cbef73e26faead");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "workout_table","category_table");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `workout_table`");
      _db.execSQL("DELETE FROM `category_table`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public WorkoutDao getWorkoutDao() {
    if (_workoutDao != null) {
      return _workoutDao;
    } else {
      synchronized(this) {
        if(_workoutDao == null) {
          _workoutDao = new WorkoutDao_Impl(this);
        }
        return _workoutDao;
      }
    }
  }

  @Override
  public WorkoutCategoryDao getCategoryDao() {
    if (_workoutCategoryDao != null) {
      return _workoutCategoryDao;
    } else {
      synchronized(this) {
        if(_workoutCategoryDao == null) {
          _workoutCategoryDao = new WorkoutCategoryDao_Impl(this);
        }
        return _workoutCategoryDao;
      }
    }
  }
}
