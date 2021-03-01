package miguelangellopezblanca.psp.practicafirestore.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import miguelangellopezblanca.psp.practicafirestore.R;
import miguelangellopezblanca.psp.practicafirestore.fireStore.Competidor;
import miguelangellopezblanca.psp.practicafirestore.viewModel.ViewModelActivity;

public class AdapterCompetidores extends RecyclerView.Adapter<AdapterCompetidores.ViewHolder> {

    private List<Competidor> competidores;
    private Context context;
    private Activity activity;
    private ViewModelActivity viewModelActivity;

    public AdapterCompetidores(List<Competidor> competidores, Context context, Activity activity) {
        this.competidores = competidores;
        this.context = context;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_competidor, parent, false);
        viewModelActivity = new ViewModelProvider((ViewModelStoreOwner) activity).get(ViewModelActivity.class);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tvNombreCompetidor.setText(competidores.get(position).getNombre());
        holder.tvApellidoCompetidor.setText(competidores.get(position).getApellidos());
        holder.constraintCompetidor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final NavController navController = Navigation.findNavController(v);
                //Competidor competidor = competidores.get(position);
                Log.v("xyzyx", competidores.get(position).toString() + "Adaptadorrr");
                viewModelActivity.setCompetidor(competidores.get(position));
                navController.navigate(R.id.editarCompetidoresFragment);

            }
        });
    }

    @Override
    public int getItemCount() {
        return competidores.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvNombreCompetidor;
        TextView tvApellidoCompetidor;
        ImageView imgCompetidor;
        ConstraintLayout constraintCompetidor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombreCompetidor = itemView.findViewById(R.id.tvNombreCompetidor);
            tvApellidoCompetidor = itemView.findViewById(R.id.tvApellidoCompetidor);
            imgCompetidor = itemView.findViewById(R.id.imgCompetidor);
            constraintCompetidor = itemView.findViewById(R.id.constraintCompetidor);
        }
    }
}
