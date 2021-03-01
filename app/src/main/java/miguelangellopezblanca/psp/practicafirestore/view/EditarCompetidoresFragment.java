package miguelangellopezblanca.psp.practicafirestore.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import miguelangellopezblanca.psp.practicafirestore.R;
import miguelangellopezblanca.psp.practicafirestore.fireStore.Competidor;
import miguelangellopezblanca.psp.practicafirestore.viewModel.ViewModelActivity;


public class EditarCompetidoresFragment extends Fragment {

    ViewModelActivity viewModelActivity;

    public EditarCompetidoresFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_editar_competidores, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModelActivity = new ViewModelProvider(getActivity()).get(ViewModelActivity.class);
        final NavController navController = Navigation.findNavController(view);

        ImageView imgEditCompetidor = view.findViewById(R.id.imageEditCompetidor);

        EditText etEditNombre = view.findViewById(R.id.etEditCompNombre);
        etEditNombre.setText(viewModelActivity.getCompetidor().getNombre());

        EditText etEditApellidos = view.findViewById(R.id.etEditCompApellido);
        etEditApellidos.setText(viewModelActivity.getCompetidor().getApellidos());

        EditText etEditEdad = view.findViewById(R.id.etEditCompEdad);
        etEditEdad.setText(String.valueOf(viewModelActivity.getCompetidor().getEdad()));

        EditText etUrlImg = view.findViewById(R.id.etEditCompImg);
        etUrlImg.setText(viewModelActivity.getCompetidor().getImgCompetidor());
        Glide.with(getContext()).load(viewModelActivity.getCompetidor().getImgCompetidor()).into(imgEditCompetidor);

        Button btDeleteComp = view.findViewById(R.id.btDeleteComp);
        btDeleteComp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModelActivity.borrarCompetidor(viewModelActivity.getCompetidor());
                navController.navigate(R.id.menuFragment);
            }
        });

        Button btActualizarComp = view.findViewById(R.id.btUpdateComp);
        btActualizarComp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Competidor competidor = new Competidor(etEditNombre.getText().toString(), etEditApellidos.getText().toString(), Integer.parseInt(etEditEdad.getText().toString()),
                        etUrlImg.getText().toString(), viewModelActivity.getCompetidor().getDni());
                viewModelActivity.actualizarCompetidor(competidor);
                navController.navigate(R.id.menuFragment);
            }
        });
    }
}