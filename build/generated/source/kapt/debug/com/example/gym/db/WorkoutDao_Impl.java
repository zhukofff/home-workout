package com.example.gym.db;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.gym.model.Workout;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class WorkoutDao_Impl implements WorkoutDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Workout> __insertionAdapterOfWorkout;

  private final EntityDeletionOrUpdateAdapter<Workout> __updateAdapterOfWorkout;

  public WorkoutDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfWorkout = new EntityInsertionAdapter<Workout>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `workout_table` (`id`,`title`,`time`,`category`,`iconCode`,`instruction`,`isSaved`,`timeSaved`,`isRecommended`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Workout value) {
        stmt.bindLong(1, value.getId());
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        stmt.bindLong(3, value.getTime());
        if (value.getCategory() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCategory());
        }
        if (value.getIconCode() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getIconCode());
        }
        if (value.getInstruction() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getInstruction());
        }
        final int _tmp;
        _tmp = value.isSaved() ? 1 : 0;
        stmt.bindLong(7, _tmp);
        stmt.bindLong(8, value.getTimeSaved());
        final int _tmp_1;
        _tmp_1 = value.isRecommended() ? 1 : 0;
        stmt.bindLong(9, _tmp_1);
      }
    };
    this.__updateAdapterOfWorkout = new EntityDeletionOrUpdateAdapter<Workout>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `workout_table` SET `id` = ?,`title` = ?,`time` = ?,`category` = ?,`iconCode` = ?,`instruction` = ?,`isSaved` = ?,`timeSaved` = ?,`isRecommended` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Workout value) {
        stmt.bindLong(1, value.getId());
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        stmt.bindLong(3, value.getTime());
        if (value.getCategory() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCategory());
        }
        if (value.getIconCode() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getIconCode());
        }
        if (value.getInstruction() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getInstruction());
        }
        final int _tmp;
        _tmp = value.isSaved() ? 1 : 0;
        stmt.bindLong(7, _tmp);
        stmt.bindLong(8, value.getTimeSaved());
        final int _tmp_1;
        _tmp_1 = value.isRecommended() ? 1 : 0;
        stmt.bindLong(9, _tmp_1);
        stmt.bindLong(10, value.getId());
      }
    };
  }

  @Override
  public Object insertAll(final List<Workout> list, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfWorkout.insert(list);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object update(final Workout workout, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfWorkout.handle(workout);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Flow<List<Workout>> getWorkouts() {
    final String _sql = "SELECT * FROM workout_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"workout_table"}, new Callable<List<Workout>>() {
      @Override
      public List<Workout> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfIconCode = CursorUtil.getColumnIndexOrThrow(_cursor, "iconCode");
          final int _cursorIndexOfInstruction = CursorUtil.getColumnIndexOrThrow(_cursor, "instruction");
          final int _cursorIndexOfIsSaved = CursorUtil.getColumnIndexOrThrow(_cursor, "isSaved");
          final int _cursorIndexOfTimeSaved = CursorUtil.getColumnIndexOrThrow(_cursor, "timeSaved");
          final int _cursorIndexOfIsRecommended = CursorUtil.getColumnIndexOrThrow(_cursor, "isRecommended");
          final List<Workout> _result = new ArrayList<Workout>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Workout _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final long _tmpTime;
            _tmpTime = _cursor.getLong(_cursorIndexOfTime);
            final String _tmpCategory;
            _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            final String _tmpIconCode;
            _tmpIconCode = _cursor.getString(_cursorIndexOfIconCode);
            final String _tmpInstruction;
            _tmpInstruction = _cursor.getString(_cursorIndexOfInstruction);
            final boolean _tmpIsSaved;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsSaved);
            _tmpIsSaved = _tmp != 0;
            final long _tmpTimeSaved;
            _tmpTimeSaved = _cursor.getLong(_cursorIndexOfTimeSaved);
            final boolean _tmpIsRecommended;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsRecommended);
            _tmpIsRecommended = _tmp_1 != 0;
            _item = new Workout(_tmpId,_tmpTitle,_tmpTime,_tmpCategory,_tmpIconCode,_tmpInstruction,_tmpIsSaved,_tmpTimeSaved,_tmpIsRecommended);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<Workout> getWorkout(final int id) {
    final String _sql = "SELECT * FROM workout_table WHERE id LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return __db.getInvalidationTracker().createLiveData(new String[]{"workout_table"}, false, new Callable<Workout>() {
      @Override
      public Workout call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfIconCode = CursorUtil.getColumnIndexOrThrow(_cursor, "iconCode");
          final int _cursorIndexOfInstruction = CursorUtil.getColumnIndexOrThrow(_cursor, "instruction");
          final int _cursorIndexOfIsSaved = CursorUtil.getColumnIndexOrThrow(_cursor, "isSaved");
          final int _cursorIndexOfTimeSaved = CursorUtil.getColumnIndexOrThrow(_cursor, "timeSaved");
          final int _cursorIndexOfIsRecommended = CursorUtil.getColumnIndexOrThrow(_cursor, "isRecommended");
          final Workout _result;
          if(_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final long _tmpTime;
            _tmpTime = _cursor.getLong(_cursorIndexOfTime);
            final String _tmpCategory;
            _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            final String _tmpIconCode;
            _tmpIconCode = _cursor.getString(_cursorIndexOfIconCode);
            final String _tmpInstruction;
            _tmpInstruction = _cursor.getString(_cursorIndexOfInstruction);
            final boolean _tmpIsSaved;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsSaved);
            _tmpIsSaved = _tmp != 0;
            final long _tmpTimeSaved;
            _tmpTimeSaved = _cursor.getLong(_cursorIndexOfTimeSaved);
            final boolean _tmpIsRecommended;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsRecommended);
            _tmpIsRecommended = _tmp_1 != 0;
            _result = new Workout(_tmpId,_tmpTitle,_tmpTime,_tmpCategory,_tmpIconCode,_tmpInstruction,_tmpIsSaved,_tmpTimeSaved,_tmpIsRecommended);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
