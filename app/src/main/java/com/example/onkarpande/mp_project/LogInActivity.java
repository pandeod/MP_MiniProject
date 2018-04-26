package com.example.onkarpande.mp_project;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.onkarpande.mp_project.Activity.HomeActivity;
import com.example.onkarpande.mp_project.Adapter.DatabaseHandler;

public class LogInActivity extends AppCompatActivity {

    private String uEmail;
    private String uPassword;
    private DatabaseHandler db;
    boolean opr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        db=new DatabaseHandler(getApplicationContext());

        TextView signUp=findViewById(R.id.link_signin);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LogInActivity.this,RegisterActivity.class));
                //built in android fade in-out animation
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
            }
        });

        Button bt=findViewById(R.id.btn_login);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText ed1=findViewById(R.id.input_email);
                EditText ed2=findViewById(R.id.input_password);
                uEmail=ed1.getText().toString();
                uPassword=ed2.getText().toString();
                if(TextUtils.isEmpty(uEmail)||TextUtils.isEmpty(uPassword))
                    opr=false;
                else
                    opr=db.isPresent(uEmail,uPassword);
                if(opr)
                {
                    //showMessage("Successful !","Log In Successful !!!");
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                }
                else
                {
                    showMessage("Failed !","Log In Failed !!!");
                }
            }
        });
    }

    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        //builder.setPositiveButton("ok",null);
        builder.show();
    }
}
