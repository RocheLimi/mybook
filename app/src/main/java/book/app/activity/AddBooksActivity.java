package book.app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import book.app.database.BookOperation;
import book.app.list.Book;
import book.app.R;

public class AddBooksActivity extends AppCompatActivity implements View.OnClickListener {
    //组件定义
    private EditText et_uuid;
    private EditText et_title;
    private EditText et_authors;
    private EditText et_publisher;
    private EditText et_pub_time;
    private EditText et_isbn;

    private Button btnAdd;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addbooks);
        initView();
    }

    //初始化界面
    private void initView() {
        et_uuid = (EditText) findViewById(R.id.et_uuid);
        et_title = (EditText) findViewById(R.id.et_title);
        et_authors = (EditText) findViewById(R.id.et_authors);
        et_isbn = (EditText) findViewById(R.id.et_isbn);
        et_publisher = (EditText) findViewById(R.id.et_publisher);
        et_pub_time = (EditText) findViewById(R.id.et_pub_time);

        btnBack= (Button) findViewById(R.id.btn_back);
        btnAdd = (Button) findViewById(R.id.btn_add);

        //设置按钮的点击事件
        btnAdd.setOnClickListener(this);
        btnBack.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                addOrder();
                break;
            case R.id.btn_back:
                this.finish();
                break;
        }
    }

    public void addOrder(){
        //当单击“添加”按钮时，获取添加信息
        String uuid = et_uuid.getText().toString().trim();
        String title = et_title.getText().toString().trim();
        String authors = et_authors.getText().toString().trim();
        String isbn = et_isbn.getText().toString().trim();
        String publisher = et_publisher.getText().toString().trim();
        String pub_time = et_pub_time.getText().toString().trim();

        Book o = new Book();
        o.UUID = uuid;
        o.TITLE = title;
        o.AUTHORS = authors;
        o.PUB_TIME = pub_time;
        o.ISBN = isbn;
        o.PUBLISHER = publisher;

        BookOperation book_db = new BookOperation(getApplicationContext());
        book_db.open();
        long result = book_db.addBooks(o);
        if (result > 0) {
            Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "添加失败", Toast.LENGTH_SHORT).show();
        }
        book_db.close();
        finish();
    }
}
