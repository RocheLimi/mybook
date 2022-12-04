package book.app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import book.app.R;
import book.app.list.Book;
import book.app.database.BookOperation;

public class UpdateBooksActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnSearch;

    private EditText et_uuid;
    private EditText et_title;
    private EditText et_authors;
    private EditText et_publisher;
    private EditText et_pub_time;
    private EditText et_isbn;

    private Button btnEdit;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_books);
        initView();
    }

    private void initView() {
        btnSearch=(Button) findViewById(R.id.btn_search);

        et_uuid=(EditText) findViewById(R.id.et_uuid);
        et_title=(EditText)findViewById(R.id.et_title);
        et_authors = (EditText) findViewById(R.id.et_authors);
        et_isbn = (EditText) findViewById(R.id.et_isbn);
        et_publisher = (EditText) findViewById(R.id.et_publisher);
        et_pub_time = (EditText) findViewById(R.id.et_pub_time);

        btnEdit= (Button) findViewById(R.id.btn_edit);
        btnBack= (Button) findViewById(R.id.btn_back);

        //设置按钮的点击事件
        btnSearch.setOnClickListener((View.OnClickListener) this);
        btnEdit.setOnClickListener((View.OnClickListener) this);
        btnBack.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.btn_search:   //查询操作
                searchOrder();
                break;
            case R.id.btn_edit:    //更新操作
                updateOrder();
                break;
            case R.id.btn_back:    //返回操作
                this.finish();
                break;
        }
    }

    //查找书本信息
    private void searchOrder()
    {
        String UUID = et_uuid.getText().toString().trim();

        //创建数据库访问对象
        BookOperation book_db = new BookOperation(getApplicationContext());

        book_db.open();         //打开数据库
        Book o = book_db.getBooks(UUID);

        //填入控件
        et_title.setText(o.TITLE);
        et_authors.setText(o.AUTHORS);
        et_publisher.setText(o.PUBLISHER);
        et_pub_time.setText(o.PUB_TIME);
        et_isbn.setText(o.ISBN);

        book_db.close();        //关闭数据库
    }

    //修改信息
    private void updateOrder()
    {
        Book o = new Book();
        o.UUID = et_uuid.getText().toString().trim();
        o.TITLE = et_title.getText().toString().trim();
        o.AUTHORS = et_authors.getText().toString().trim();
        o.ISBN = et_isbn.getText().toString().trim();
        o.PUBLISHER = et_publisher.getText().toString().trim();
        o.PUB_TIME = et_pub_time.getText().toString().trim();

        //创建数据库访问对象
        BookOperation book_db = new BookOperation(getApplicationContext());

        book_db.open();         //打开数据库

        long result = book_db.updateBooks(o);
        if (result > 0){
            Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "修改失败", Toast.LENGTH_SHORT).show();
        }

        book_db.close();        //关闭数据库
    }
}
