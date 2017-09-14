package com.example.luisafarias.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.wedeploy.android.Callback;
import com.wedeploy.android.WeDeploy;
import com.wedeploy.android.exception.WeDeployException;
import com.wedeploy.android.transport.Response;

import java.net.URL;

public class NewUser extends AppCompatActivity {

    WeDeploy weDeploy = new WeDeploy.Builder().build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
    }

    public void goSemFeed(View view) throws WeDeployException {
        final Intent intent = new Intent(this,SemFeed.class);
        EditText nome = (EditText) findViewById(R.id.caixanomee);
        String nome1 = nome.getText().toString();
        EditText email = (EditText) findViewById(R.id.caixaemaill);
        String email1 = email.getText().toString();
        EditText senha = (EditText) findViewById(R.id.caixaSenha);
        String senha1 = senha.getText().toString();
        weDeploy
                .auth("https://auth-weread.wedeploy.io")
                .createUser(email1, senha1, nome1)
                .execute(new Callback() {
                    public void onSuccess(Response response) {
                        startActivity(intent);
                    }

                    public void onFailure(Exception e) {
                        Log.e(NewUser.class.getName(),e.getMessage());
                    }
                });
    }
}
