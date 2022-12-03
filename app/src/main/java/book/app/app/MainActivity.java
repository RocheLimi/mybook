package book.app.app;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import book.app.R;
import book.app.activity.SearchBooksActivity;
import book.app.activity.UpdateBooksActivity;
import book.app.activity.AddBooksActivity;
import book.app.activity.DeleteBooksActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //组件定义
    private Button btnAdd;
    private Button btnUpdate;
    private Button btnDelete;
    private Button btnSearch;

    //设置导航按钮监听
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    private Toolbar toolbar;
    private ListView lvLeftMenu;

    private Button btnAbout;
    private Button btnSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btn_add);
        btnDelete = findViewById(R.id.btn_delete);
        btnUpdate = findViewById(R.id.btn_edit);
        btnSearch = findViewById(R.id.btn_search);
        btnAbout = findViewById(R.id.btn_about);
        btnSetting = findViewById(R.id.btn_setting);

        btnAdd.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnSearch.setOnClickListener(this);
        btnAbout.setOnClickListener(this);
        btnSetting.setOnClickListener(this);

        toolbar  = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();    //得到ActionBar实例

        if (actionBar != null){
            //显示导航按钮
            actionBar.setDisplayHomeAsUpEnabled(true);
            //设置导航按钮图片
            actionBar.setHomeAsUpIndicator(R.drawable.menu);

        }
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //显示侧滑菜单
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                Intent intent = new Intent(MainActivity.this, AddBooksActivity.class);
                startActivityForResult(intent, 0);
                break;
            case R.id.btn_edit:
                Intent intent1 = new Intent(MainActivity.this, UpdateBooksActivity.class);
                startActivityForResult(intent1, 1);
                break;
            case R.id.btn_delete:
                Intent intent2 = new Intent(MainActivity.this, DeleteBooksActivity.class);
                startActivityForResult(intent2, 2);
                break;
            case R.id.btn_search:
                Intent intent3 = new Intent(MainActivity.this, SearchBooksActivity.class);
                startActivityForResult(intent3, 3);
                break;
            case R.id.btn_about:
                Intent intent4 = new Intent(MainActivity.this, SearchBooksActivity.class);
                startActivityForResult(intent4, 4);
                break;
            case R.id.btn_setting:
                Intent intent5 = new Intent(MainActivity.this, SearchBooksActivity.class);
                startActivityForResult(intent5, 5);
                break;
            default:
                break;
        }
    }

}