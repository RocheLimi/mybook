package book.app.app;

import book.app.R;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText et_name;
    private EditText et_version;
    private EditText et_update_date;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        initView();
    }

    private void initView() {

        et_name = (EditText) findViewById(R.id.et_name);
        et_version = (EditText) findViewById(R.id.et_version);
        et_update_date = (EditText) findViewById(R.id.et_update_date);

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
