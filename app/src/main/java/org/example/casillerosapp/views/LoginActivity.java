package org.example.casillerosapp.views;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.example.casillerosapp.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText usernameEt = findViewById(R.id.usernameEt);
        final EditText passwordEt = findViewById(R.id.passwordEt);
        Button button = findViewById(R.id.loginBtn);

        //SOLO PARA DEBUG, ELIMINAR DESPUES
        usernameEt.setText("nico.rodriguezc@alumnos.duoc.cl");
        passwordEt.setText("1234");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = usernameEt.getText().toString();
                if (validation(usernameEt, passwordEt)) {
                    Toast.makeText(LoginActivity.this, "Ingreso Correcto", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, LockersActivity.class);
                    intent.putExtra("user", email);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Los datos son incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validation(EditText username, EditText password) {
        String user = username.getText().toString().trim().toLowerCase();
        String pass = password.getText().toString().trim().toLowerCase();
        if (user.contains("@alumnos.duoc.cl") && pass.equals("1234")) {
            return true;
        }
        return false;
    }
}
