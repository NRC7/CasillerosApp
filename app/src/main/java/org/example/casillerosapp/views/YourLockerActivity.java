package org.example.casillerosapp.views;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import org.example.casillerosapp.R;
import org.example.casillerosapp.models.Locker;

public class YourLockerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_your_locker);
        TextView yourIdTv = findViewById(R.id.yourIdTv);
        TextView yourUserTv = findViewById(R.id.yourUserTv);
        Locker locker = (Locker) getIntent().getSerializableExtra("locker");
        String id = String.valueOf(locker.getIdentifier());
        String user = locker.getUser();
        yourIdTv.setText("N°: " + id);
        yourUserTv.setText(user);
    }
}
