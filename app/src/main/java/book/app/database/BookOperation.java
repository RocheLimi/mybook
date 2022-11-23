package book.app.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import book.app.list.Book;

public class BookOperation {
    private Context context;
    private DBHelper DBHelper;
    private SQLiteDatabase db;

    //构造函数
    public BookOperation(Context context) {
        this.context = context;
    }

    //打开数据库
    public void open() throws SQLiteException {
        DBHelper = new DBHelper(context);
        try {
            db = DBHelper.getWritableDatabase();
        } catch (SQLiteException ex) {
            db = DBHelper.getReadableDatabase();
        }
    }

    //关闭数据库
    public void close() {
        if (db != null) {
            db.close();
            db = null;
        }
    }

    //添加书本信息
    public long addBooks(Book o) {
        // 创建ContentValues对象
        ContentValues values = new ContentValues();

        // 向该对象中插入键值对
        values.put("uuid", o.UUID);
        values.put("title", o.TITLE);
        values.put("authors", o.AUTHORS);
        values.put("publisher", o.PUBLISHER);
        values.put("pub_time", o.PUB_TIME);
        values.put("isbn", o.ISBN);

        // 调用insert()方法将数据插入到数据库当中
        return db.insert("tb_Books", null, values);
    }

    //删除书本信息
    public int deleteBooks(Book o) {
        return db.delete("tb_Books", "uuid=?", new String[]{String.valueOf(o.UUID)});
    }

    //修改指定图书信息
    public int updateBooks(Book o) {
        ContentValues values = new ContentValues();

        values.put("uuid", o.UUID);
        values.put("title", o.TITLE);
        values.put("authors", o.AUTHORS);
        values.put("publisher", o.PUBLISHER);
        values.put("pub_time", o.PUB_TIME);
        values.put("isbn", o.ISBN);

        return db.update("tb_Books", values, "uuid=?", new String[]{String.valueOf(o.UUID)});
    }

    //根据编号查询书本
    public Book getBooks(String uuid) {
        //查询
        Cursor cursor = db.query("tb_Books", null, "uuid=?", new String[]{uuid}, null, null, null);
        Book o = new Book();
        while (cursor.moveToNext()) {
            o.UUID = cursor.getString(cursor.getColumnIndexOrThrow("uuid"));
            o.TITLE = cursor.getString(cursor.getColumnIndexOrThrow("title"));
            o.AUTHORS = cursor.getString(cursor.getColumnIndexOrThrow("authors"));
            o.PUBLISHER = cursor.getString(cursor.getColumnIndexOrThrow("publisher"));
            o.PUB_TIME = cursor.getString(cursor.getColumnIndexOrThrow("pub_time"));
            o.ISBN = cursor.getString(cursor.getColumnIndexOrThrow("isbn"));
        }
        return o;
    }

    //查找所有图书信息
    public ArrayList<Map<String, Object>> getAllbooks() {
        ArrayList<Map<String, Object>> listBooks = new ArrayList<Map<String, Object>>();
        Cursor cursor = db.query("tb_Books", null, null, null, null, null,null);

        int resultCounts = cursor.getCount();  //记录数
        if (resultCounts == 0 ) {
            return null;
        } else {
            while (cursor.moveToNext()) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("uuid", cursor.getString(cursor.getColumnIndexOrThrow("uuid")));
                map.put("title", cursor.getString(cursor.getColumnIndexOrThrow("title")));
                map.put("authors", cursor.getString(cursor.getColumnIndexOrThrow("authors")));
                map.put("publisher", cursor.getString(cursor.getColumnIndexOrThrow("publisher")));
                map.put("pub_time", cursor.getString(cursor.getColumnIndexOrThrow("pub_time")));
                map.put("isbn", cursor.getString(cursor.getColumnIndexOrThrow("isbn")));

                listBooks.add(map);
            }
            return listBooks;
        }
    }
}
