package org.example.casillerosapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.example.casillerosapp.adapters.LockersAdapter;
import org.example.casillerosapp.R;
import org.example.casillerosapp.models.Locker;
import java.util.ArrayList;
import java.util.List;

public class LockersActivity extends AppCompatActivity {
    private List<Locker> lockers = new ArrayList<>();
    private String usermail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lockers);
        usermail = getIntent().getStringExtra("user");
        //Toast.makeText(this, user.getMail(), Toast.LENGTH_SHORT).show();
        lockers = getLockers();
        //Log.d("MRZUTIL", String.valueOf(lockers.size()));
        RecyclerView recyclerView = findViewById(R.id.recycler);
        LockersAdapter adapter = new LockersAdapter(lockers, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        //Toast.makeText(this, "oncreate", Toast.LENGTH_SHORT).show();
        if (getIntent().getSerializableExtra("reserved") != null) {
            Locker reservedLocker = (Locker) getIntent().getSerializableExtra("reserved");
            lockers.get(reservedLocker.getIdentifier() - 1).setAvailable(false);
            lockers.get(reservedLocker.getIdentifier() - 1).setStatus("RESERVADO");
            lockers.get(reservedLocker.getIdentifier() - 1).setUser("nico.rodriguezc@alumnos.duoc.cl");
        }
    }

    private List<Locker> getLockers() {
        List<Locker> mLockers = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Locker locker = new Locker(i + 1, "HABILITADO", true,usermail,"");
            mLockers.add(locker);
        }
        return mLockers;
    }
}
