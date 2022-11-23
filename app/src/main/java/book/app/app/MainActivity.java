package book.app.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btn_add);
        btnDelete = findViewById(R.id.btn_delete);
        btnUpdate = findViewById(R.id.btn_edit);
        btnSearch = findViewById(R.id.btn_search);
        btnAdd.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnSearch.setOnClickListener(this);
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
            default:
                break;
        }
    }

}