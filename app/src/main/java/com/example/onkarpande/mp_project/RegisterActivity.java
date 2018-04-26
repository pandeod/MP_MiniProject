package com.example.onkarpande.mp_project;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.onkarpande.mp_project.Adapter.DatabaseHandler;

public class RegisterActivity extends AppCompatActivity {

    private String uEmail;
    private String uPassword;
    private DatabaseHandler db;
    boolean opr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db=new DatabaseHandler(getApplicationContext());

        TextView signIn=findViewById(R.id.link_signup);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,LogInActivity.class));
                //built in android fade in-out animation
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
            }
        });

        Button bt=findViewById(R.id.btn_reg);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText ed1=findViewById(R.id.reg_email);
                EditText ed2=findViewById(R.id.reg_password);
                uEmail=ed1.getText().toString();
                uPassword=ed2.getText().toString();
                if(TextUtils.isEmpty(uEmail)||TextUtils.isEmpty(uPassword))
                    opr=false;
                else
                    opr= db.insertData(uEmail,uPassword);
                if(opr)
                {
                    showMessage("Welcome..","Registration Successful !");

                    Handler hd=new Handler();
                    hd.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(RegisterActivity.this,LogInActivity.class));
                            //built in android fade in-out animation
                            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                            finish();
                        }
                    },2000);
                }
                else
                {
                    showMessage("Try Again..","Registration Failed !");
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
