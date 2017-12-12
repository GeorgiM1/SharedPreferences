package com.example.android.sharedpreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.getName)
    TextView getName;
    @BindView(R.id.getLastname)
    TextView getLastname;
    @BindView(R.id.getAge)
    TextView getAge;
    @BindView(R.id.sex)
    TextView sex;
    @BindView(R.id.loadBtn)
    Button loadBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
    }
    @OnClick (R.id.loadBtn)
    public void onLoadClick (View view){

        getName.setText(PreferencesMenager.getFirstName(this).toString());
        getLastname.setText(PreferencesMenager.getLastname(this).toString());
        getAge.setText(PreferencesMenager.getAge(this).toString());
       sex.setText(PreferencesMenager.getSex(this) ? "Male" : "Female");

    }
}
