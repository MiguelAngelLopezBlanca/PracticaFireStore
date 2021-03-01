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
import miguelangellopezblanca.psp.practicafirestore.fireStore.Judogui;
import miguelangellopezblanca.psp.practicafirestore.viewModel.ViewModelActivity;

public class AdapterJudoguis extends RecyclerView.Adapter<AdapterJudoguis.ViewHolder> {

    private List<Judogui> judoguis;
    private Context context;
    private Activity activity;

    private ViewModelActivity viewModelActivity;

    public AdapterJudoguis(List<Judogui> judoguis, Context context, Activity activity) {
        this.judoguis = judoguis;
        this.context = context;
        this.activity = activity;
    }

    @NonNull
    @Override
    public AdapterJudoguis.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_judogui, parent, false);
        ViewHolder holder = new ViewHolder(vista);
        viewModelActivity = new ViewModelProvider((ViewModelStoreOwner) activity).get(ViewModelActivity.class);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterJudoguis.ViewHolder holder, int position) {
        holder.tvMarcaJudogui.setText(judoguis.get(position).getMarca());
        holder.tvModeloJudogui.setText(judoguis.get(position).getModelo());
        holder.constraintJudogui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final NavController navController = Navigation.findNavController(v);
                //Competidor competidor = competidores.get(position);
                Log.v("xyzyx", judoguis.get(position).toString() + "Adaptadorrr");
                viewModelActivity.setJudogui(judoguis.get(position));
                navController.navigate(R.id.editarJudoguisFragment);
            }
        });
    }

    @Override
    public int getItemCount() {
        return judoguis.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvMarcaJudogui;
        TextView tvModeloJudogui;
        ImageView imgJudogui;
        ConstraintLayout constraintJudogui;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvMarcaJudogui = itemView.findViewById(R.id.tvMarcaJudogui);
            tvModeloJudogui = itemView.findViewById(R.id.tvModeloJudogui);
            constraintJudogui = itemView.findViewById(R.id.constraintJudogui);
        }
    }
}
