package book.app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.List;
import java.util.Map;

import book.app.R;
import book.app.list.Book;
import book.app.database.BookOperation;

public class SearchBooksActivity extends AppCompatActivity implements View.OnClickListener{
    //定义组件
    ListView listView=null;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_books);
        setTitle("查看书籍列表");
        //初始化界面
        initView();
    }

    private void initView() {
        //建立数据库访问对象
        BookOperation book_db=new BookOperation(getApplicationContext());

        //打开数据库
        book_db.open();

        //调用数据库访问方法
        List<Map<String,Object>> mOrderData=book_db.getAllbooks();

        //获取组件
        listView=(ListView)findViewById(R.id.lst_orders);

        //定义数据源
        String[] from={"uuid","title","authors","publisher","pub_time","isbn"};

        //定义布局控件ID
        int[] to={R.id.tv_lst_uuid,R.id.tv_lst_title,R.id.tv_lst_publisher,R.id.tv_lst_pub_time,R.id.tv_lst_isbn};
        SimpleAdapter listItemAdapter=new SimpleAdapter(SearchBooksActivity.this,mOrderData,R.layout.item_list,from,to);

        //添加并显示
        listView.setAdapter(listItemAdapter);

        //关闭数据库
        book_db.close();

        btnBack= (Button) findViewById(R.id.btn_back);

        //设置按钮的点击事件
        btnBack.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View v)
    {
        this.finish();
    }
}

