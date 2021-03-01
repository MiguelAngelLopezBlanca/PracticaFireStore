package miguelangellopezblanca.psp.practicafirestore.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import miguelangellopezblanca.psp.practicafirestore.R;
import miguelangellopezblanca.psp.practicafirestore.adapter.AdapterNombreCompetidor;
import miguelangellopezblanca.psp.practicafirestore.fireStore.Competidor;
import miguelangellopezblanca.psp.practicafirestore.fireStore.Judogui;
import miguelangellopezblanca.psp.practicafirestore.viewModel.ViewModelActivity;


public class InsertarJudoguisFragment extends Fragment {

    ViewModelActivity viewModelActivity;
    private List<Competidor> listName = new ArrayList<>();

    public InsertarJudoguisFragment() {
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
        return inflater.inflate(R.layout.fragment_insertar_judoguis, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModelActivity = new ViewModelProvider(getActivity()).get(ViewModelActivity.class);
        final NavController navController = Navigation.findNavController(view);

        EditText etMarca = view.findViewById(R.id.etInsertJudoguiMarca);
        EditText etModelo = view.findViewById(R.id.etInsertJudoguiModelo);
        EditText etTalla = view.findViewById(R.id.etInsertJudoguiTalla);
        EditText etColor = view.findViewById(R.id.etInsertJudoguiColor);
        EditText etUrlImg = view.findViewById(R.id.etInsertJudoguiImagen);
        EditText etIdentificador = view.findViewById(R.id.etInsertJudoguiIdentificador);
        TextView tvName = view.findViewById(R.id.tvName);
        //Spinner idCompetidor = view.findViewById(R.id.spinner);

        RecyclerView idCompetidor = view.findViewById(R.id.recyclerID);
        AdapterNombreCompetidor adapter = new AdapterNombreCompetidor(getContext(), listName, view);

        idCompetidor.setAdapter(adapter);
        idCompetidor.setLayoutManager(new LinearLayoutManager(getContext()));

        viewModelActivity.getCompetidores().observe(getActivity(), new Observer<List<Competidor>>() {
            @Override
            public void onChanged(List<Competidor> competidors) {
                listName.clear();
                listName.addAll(competidors);
                adapter.notifyDataSetChanged();
            }
        });

        Button btInsertJudogui = view.findViewById(R.id.btInsertarJudogui);
        btInsertJudogui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Judogui judogui = new Judogui(tvName.getText().toString(), etMarca.getText().toString(), etModelo.getText().toString(), etUrlImg.getText().toString(), etColor.getText().toString()
                        ,Integer.parseInt(etTalla.getText().toString()), etIdentificador.getText().toString());

                viewModelActivity.insertarJudogui(judogui);
                navController.navigate(R.id.menuFragment);
            }
        });
    }
}