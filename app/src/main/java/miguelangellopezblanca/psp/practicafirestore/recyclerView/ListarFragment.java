package miguelangellopezblanca.psp.practicafirestore.recyclerView;

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

import java.util.ArrayList;
import java.util.List;

import miguelangellopezblanca.psp.practicafirestore.R;
import miguelangellopezblanca.psp.practicafirestore.adapter.AdapterCompetidores;
import miguelangellopezblanca.psp.practicafirestore.adapter.AdapterJudoguis;
import miguelangellopezblanca.psp.practicafirestore.fireStore.Competidor;
import miguelangellopezblanca.psp.practicafirestore.fireStore.Judogui;
import miguelangellopezblanca.psp.practicafirestore.viewModel.ViewModelActivity;


public class ListarFragment extends Fragment {

    ViewModelActivity viewModelActivity;

    private List<Competidor> competidores = new ArrayList<>();
    private List<Judogui> judoguis = new ArrayList<>();

    public ListarFragment() {
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
        return inflater.inflate(R.layout.fragment_listar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModelActivity = new ViewModelProvider(getActivity()).get(ViewModelActivity.class);
        final NavController navController = Navigation.findNavController(view);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

        if(viewModelActivity.isRecyclerView()){
            //Cargo el recycler View de competidores
            viewModelActivity.getCompetidores().observe(getActivity(), new Observer<List<Competidor>>() {
                @Override
                public void onChanged(List<Competidor> competidors) {
                    competidores.clear();
                    competidores.addAll(competidors);
                    AdapterCompetidores adapter = new AdapterCompetidores(competidores, getContext(), getActivity());
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                }
            });

        }else{
            //Cargo el recycler View de judoguis
            viewModelActivity.getJudoguis().observe(getActivity(), new Observer<List<Judogui>>() {
                @Override
                public void onChanged(List<Judogui> judogui) {
                    judoguis.clear();
                    judoguis.addAll(judogui);
                    AdapterJudoguis adapter = new AdapterJudoguis(judoguis, getContext(), getActivity());
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                }
            });


        }
    }
}