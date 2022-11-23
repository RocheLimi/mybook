package book.app.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import book.app.list.Book;

public class DBHelper extends SQLiteOpenHelper {
    //定义数据库名和版本号
    public static final String name = "book.db";
    public static final int DB_VERSION = 1;

    public static final String CREATE_USERDATA =
            "create table tb_Books (" +
                    "uuid , " +
                    "title , " +
                    "authors , " +
                    "publisher , " +
                    "pub_time , " +
                    "isbn , " +
                    "has_cover )";
    //构造函数
    public DBHelper(Context context) {
        super(context, name, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USERDATA);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
