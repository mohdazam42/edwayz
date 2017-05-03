package com.edwayzapp.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.edwayzapp.edwayz.QuestionActivity;
import com.edwayzapp.edwayz.R;
import com.edwayzapp.models.QuestionsPojo;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by HP on 4/30/2017.
 */

public class QuestionFragment extends Fragment implements View.OnClickListener {
    ArrayList<QuestionsPojo> questionModels;

    View view = null;
    ImageView ans1, ans2, ans3, ans4;
    TextView tv_ans0, tv_ans1, tv_ans2, tv_ans4, tv_ans3;
    int count;

    public static QuestionFragment newInstance() {
        QuestionFragment fragment = new QuestionFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_question, container, false);
        questionModels = new ArrayList<>();

        initViews();
        initListeners();
        prepareData();



        int min = 0;
        int max = 3;
        Random r = new Random();
        count = r.nextInt(max - min + 1) + min;

        tv_ans0.setText(questionModels.get(count).getQuestion());
        tv_ans1.setText(questionModels.get(count).getAnswer1());
        tv_ans2.setText(questionModels.get(count).getAnswer2());
        tv_ans3.setText(questionModels.get(count).getAnswer3());
        tv_ans4.setText(questionModels.get(count).getAnswer4());

        return view;
    }

    private void prepareData() {
        String question[] = {"Color of sky ?", "Color of water", "Color of air ?", "Color of cow ?"};
        String answer1[] = {"blue", "trans", "white", "Green"};
        String answer2[] = {"White", "Green", "trans", "Pink"};
        String answer3[] = {"trans", "white", "Green", "Brown"};
        String answer4[] = {"Green", "trans", "white", "Black"};
        String rightanswer[] = {"blue", "white", "trans", "Black"};

        for (int i = 0; i < question.length; i++) {
            questionModels.add(new QuestionsPojo(question[i], answer1[i], answer2[i], answer3[i], rightanswer[i], answer4[i]));
        }
    }

    private void initListeners() {
        ans1.setOnClickListener(this);
        ans2.setOnClickListener(this);
        ans3.setOnClickListener(this);
        ans4.setOnClickListener(this);
    }

    private void initViews() {
        tv_ans0 = (TextView) view.findViewById(R.id.tv_ans0);
        tv_ans1 = (TextView) view.findViewById(R.id.tv_ans1);
        tv_ans2 = (TextView) view.findViewById(R.id.tv_ans2);
        tv_ans3 = (TextView) view.findViewById(R.id.tv_ans3);
        tv_ans4 = (TextView) view.findViewById(R.id.tv_ans4);
        ans1 = (ImageView) view.findViewById(R.id.ans1);
        ans2 = (ImageView) view.findViewById(R.id.ans2);
        ans3 = (ImageView) view.findViewById(R.id.ans3);
        ans4 = (ImageView) view.findViewById(R.id.ans4);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ans1:
                //tv_ans1.setTextColor(Color.WHITE);
                if (tv_ans1.getText().toString().trim().equals(questionModels.get(count).getRight())) {
                    tv_ans1.setTextColor(Color.GREEN);
                    ((QuestionActivity) getActivity()).play();
                    // ans1.setImageResource(Color.GREEN);
                    ans1.setColorFilter(getContext().getResources().getColor(R.color.colorPrimary));
                } else {
                    tv_ans1.setTextColor(Color.RED);
                    ans1.setColorFilter(getContext().getResources().getColor(R.color.colorAccent));
                }
                break;
            case R.id.ans2:
                //tv_ans2.setTextColor(Color.WHITE);
                if (tv_ans2.getText().toString().trim().equals(questionModels.get(count).getRight())) {
                    tv_ans2.setTextColor(Color.GREEN);
                    ((QuestionActivity) getActivity()).play();
                    ans2.setColorFilter(getContext().getResources().getColor(R.color.colorPrimary));
                } else {
                    tv_ans2.setTextColor(Color.RED);
                    ans2.setColorFilter(getContext().getResources().getColor(R.color.colorAccent));
                }
                break;
            case R.id.ans3:
                //tv_ans3.setTextColor(Color.WHITE);
                if (tv_ans3.getText().toString().trim().equals(questionModels.get(count).getRight())) {
                    tv_ans3.setTextColor(Color.GREEN);
                    ((QuestionActivity) getActivity()).play();
                    ans3.setColorFilter(getContext().getResources().getColor(R.color.colorPrimary));
                } else {
                    tv_ans3.setTextColor(Color.RED);
                    ans3.setColorFilter(getContext().getResources().getColor(R.color.colorAccent));
                }

                break;
            case R.id.ans4:
               // tv_ans4.setTextColor(Color.WHITE);
                if (tv_ans4.getText().toString().trim().equals(questionModels.get(count).getRight())) {
                    tv_ans4.setTextColor(Color.GREEN);
                    ((QuestionActivity) getActivity()).play();
                    ans4.setColorFilter(getContext().getResources().getColor(R.color.colorPrimary));
                } else {
                    tv_ans4.setTextColor(Color.RED);
                    ans4.setColorFilter(getContext().getResources().getColor(R.color.colorAccent));
                }

                break;
        }

    }
}
