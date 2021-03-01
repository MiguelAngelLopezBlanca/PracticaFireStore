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

import miguelangellopezblanca.psp.practicafirestore.R;
import miguelangellopezblanca.psp.practicafirestore.fireStore.Competidor;
import miguelangellopezblanca.psp.practicafirestore.viewModel.ViewModelActivity;


public class InsertarCompetidoresFragment extends Fragment {

    ViewModelActivity viewModelActivity;

    public InsertarCompetidoresFragment() {
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
        return inflater.inflate(R.layout.fragment_insertar_competidores, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModelActivity = new ViewModelProvider(getActivity()).get(ViewModelActivity.class);
        final NavController navController = Navigation.findNavController(view);

        EditText nombre = view.findViewById(R.id.etInsertCompNombre);
        EditText apellido = view.findViewById(R.id.etInsertCompApellido);
        EditText edad = view.findViewById(R.id.etInsertcompEdad);
        EditText urlImg = view.findViewById(R.id.etInsertCompImg);
        EditText dni = view.findViewById(R.id.etInsertCompDNI);

        Button btInsertComp = view.findViewById(R.id.btInsertComp);
        btInsertComp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Competidor competidor = new Competidor(nombre.getText().toString(), apellido.getText().toString(), Integer.parseInt(edad.getText().toString()), urlImg.getText().toString(), dni.getText().toString());
                viewModelActivity.insertarCompetidor(competidor);
                navController.navigate(R.id.menuFragment);
            }
        });
    }
}