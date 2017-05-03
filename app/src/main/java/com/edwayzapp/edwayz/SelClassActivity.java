package com.edwayzapp.edwayz;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SelClassActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView selClassIv = null;
    private ImageView classOneIv = null;
    private ImageView classTwoIv = null;
    private ImageView classThreeIv = null;
    private ImageView classFourIv = null;
    private ImageView classFiveIv = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sel_class);

        initViews();
        initListener();
    }

    private void initListener() {
        classOneIv.setOnClickListener(this);
        classTwoIv.setOnClickListener(this);
        classThreeIv.setOnClickListener(this);
        classFourIv.setOnClickListener(this);
        classFiveIv.setOnClickListener(this);
    }

    private void initViews() {
        selClassIv = (ImageView) findViewById(R.id.sel_class_iv);
        classOneIv = (ImageView) findViewById(R.id.class_one_iv);
        classTwoIv = (ImageView) findViewById(R.id.class_two_iv);
        classThreeIv = (ImageView) findViewById(R.id.class_three_iv);
        classFourIv = (ImageView) findViewById(R.id.class_four_iv);
        classFiveIv = (ImageView) findViewById(R.id.class_five_iv);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.class_one_iv:
                startSelSub();
                break;
            case R.id.class_two_iv:
                startSelSub();
                break;
            case R.id.class_three_iv:
                startSelSub();
                break;
            case R.id.class_four_iv:
                startSelSub();
                break;
            case R.id.class_five_iv:
                startSelSub();
                break;
        }
    }

    private void startSelSub() {
        Intent intent = new Intent(SelClassActivity.this, SelSubjectActivity.class);
        startActivity(intent);
    }
}
