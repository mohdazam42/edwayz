package com.edwayzapp.edwayz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SelSubjectActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView environment_tv = null;
    private TextView tv_planet = null;
    private TextView solidTv = null;
    private TextView geoGraphyTv = null;
    private TextView mathTv = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sel_subject);

        initViews();
        initListener();
    }

    private void initListener() {
        environment_tv.setOnClickListener(this);
    }

    private void initViews() {
        environment_tv = (TextView) findViewById(R.id.environment_tv);
        tv_planet = (TextView) findViewById(R.id.tv_planet);
        solidTv = (TextView) findViewById(R.id.solid_tv);
        geoGraphyTv = (TextView) findViewById(R.id.geography_tv);
        mathTv = (TextView) findViewById(R.id.math_tv);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.environment_tv:
                startQuestionActivity();
                break;
            case R.id.tv_planet:
                startQuestionActivity();
                break;
            case R.id.solid_tv:
                startQuestionActivity();
                break;
            case R.id.geography_tv:
                startQuestionActivity();
                break;
            case R.id.math_tv:
                startQuestionActivity();
                break;
        }
    }

    private void startQuestionActivity() {
        startActivity(new Intent(SelSubjectActivity.this, QuestionActivity.class));
    }
}
