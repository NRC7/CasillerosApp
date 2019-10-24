package org.example.casillerosapp.views;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.example.casillerosapp.R;
import org.example.casillerosapp.models.Locker;

public class ReservedLockerActivity extends AppCompatActivity {

    String url = "";
    Locker auxLocker;
    TextView statusTv;
    TextView idTv;
    TextView userTv;
    Button btn;
    String lockerStatus;
    String lockerId;
    String lockerUser;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() != null) {
                url = result.getContents();
                //Toast.makeText(this, "correcto", Toast.LENGTH_SHORT).show();
                //Toast.makeText(this, result.getContents(), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserved_locker);
        statusTv = findViewById(R.id.detailsStatusTv);
        idTv = findViewById(R.id.detailsIdTv);
        userTv = findViewById(R.id.detailsUserTv);
        btn = findViewById(R.id.detailsBtn);
        statusTv.setText(lockerStatus);
        if (url.equals("")) {
            new IntentIntegrator(ReservedLockerActivity.this).initiateScan();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Toast.makeText(this, "OnResume", Toast.LENGTH_SHORT).show();
        auxLocker = (Locker) getIntent().getSerializableExtra("locker");
        lockerStatus = auxLocker.getStatus();
        lockerId = String.valueOf(auxLocker.getIdentifier());
        lockerUser = auxLocker.getUser();
        if (lockerStatus != null) {
            //Toast.makeText(this, auxLocker.getStatus(), Toast.LENGTH_SHORT).show();
            statusTv.setVisibility(View.VISIBLE);
            statusTv.setText("Detalle Reserva");
            idTv.setText("N°: " + lockerId);
            userTv.setText("Usuario: " + lockerUser);
        } /*else {
            Toast.makeText(this, "salio null", Toast.LENGTH_SHORT).show();
        }*/
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lockerReserved();
                Toast.makeText(getApplicationContext(), "Reserva Exitosa", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        lockerReserved();
    }

    public void lockerReserved() {
        Intent intent = new Intent(ReservedLockerActivity.this, LockersActivity.class);
        intent.putExtra("reserved", auxLocker);
        startActivity(intent);
    }
}
