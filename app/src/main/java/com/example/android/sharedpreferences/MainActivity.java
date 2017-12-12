package com.example.android.sharedpreferences;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.name)
    EditText firstName;
    @BindView(R.id.lastname)
    EditText lastname;
    @BindView(R.id.age)
    EditText age;
    @BindView(R.id.fBtn)
    RadioButton fBtn;
    @BindView(R.id.mBtn)
    RadioButton mBtn;
    @BindView(R.id.saveBtn)
    Button saveBtn;
    @BindView(R.id.contBtn)
    Button contBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }
    @OnClick(R.id.saveBtn)
    public void onBtnClick (View view){
    User user = new User();
    user.setName(firstName.getText().toString());
    user.setLastname(lastname.getText().toString());
    user.setAge(age.getText().toString());
    user.setMale(mBtn.isChecked());
    PreferencesMenager.addUser(user,this);


        Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();

    }
    @OnClick (R.id.contBtn)
    public void onContClick (View v){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);

    }
}
