package org.example.casillerosapp.adapters;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.example.casillerosapp.R;
import org.example.casillerosapp.views.YourLockerActivity;
import org.example.casillerosapp.models.Locker;
import org.example.casillerosapp.views.ReservedLockerActivity;
import java.io.Serializable;
import java.util.List;

public class LockersAdapter extends RecyclerView.Adapter<LockersAdapter.ViewHolder> {

    private List<Locker> lockers;
    private Context mContext;

    public LockersAdapter(List<Locker> lockers, Context mContext) {
        this.lockers = lockers;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.locker_list_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int position) {
        String lockerId = String.valueOf(lockers.get(position).getIdentifier());
        viewHolder.identifierTv.setText(lockerId);
        viewHolder.statusTv.setText(lockers.get(position).getStatus());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean lockerAvailable = lockers.get(viewHolder.getAdapterPosition()).isAvailable();
                Locker auxLocker = lockers.get(viewHolder.getAdapterPosition());
                if (lockerAvailable) {
                    Intent intent = new Intent(v.getContext(), ReservedLockerActivity.class);
                    intent.putExtra("locker", (Serializable) auxLocker);
                    v.getContext().startActivity(intent);

                } else {
                    //Toast.makeText(v.getContext(), "Reservado", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(v.getContext(), YourLockerActivity.class);
                    intent.putExtra("locker", (Serializable) auxLocker);
                    v.getContext().startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return lockers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView identifierTv;
        private TextView statusTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            identifierTv = itemView.findViewById(R.id.identifierTv);
            statusTv = itemView.findViewById(R.id.statusTv);
        }
    }
}
