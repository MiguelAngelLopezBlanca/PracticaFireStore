package miguelangellopezblanca.psp.practicafirestore.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import miguelangellopezblanca.psp.practicafirestore.R;
import miguelangellopezblanca.psp.practicafirestore.fireStore.Competidor;

public class AdapterNombreCompetidor extends RecyclerView.Adapter<AdapterNombreCompetidor.ViewHolder> {

    private Context context;
    private List<Competidor> nameCompetidor;
    private TextView tvId;
    private View v;

    public AdapterNombreCompetidor(Context context, List<Competidor> nameCompetidor, View v) {
        this.context = context;
        this.nameCompetidor = nameCompetidor;
        this.v = v;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.id_item, parent, false);
        ViewHolder holder = new ViewHolder(vista);
        tvId = v.findViewById(R.id.tvName);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvNombreCompetidor.setText(nameCompetidor.get(position).getNombre());
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvId.setText(String.valueOf(nameCompetidor.get(position).getNombre()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return nameCompetidor.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombreCompetidor;
        ConstraintLayout constraintLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombreCompetidor = itemView.findViewById(R.id.tvNombreCompetidor);
            constraintLayout = itemView.findViewById(R.id.constraintLayout);

        }
    }
}
