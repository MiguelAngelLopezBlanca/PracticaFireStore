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
import android.widget.ImageView;
import android.widget.TextView;

import miguelangellopezblanca.psp.practicafirestore.R;
import miguelangellopezblanca.psp.practicafirestore.viewModel.ViewModelActivity;


public class MenuFragment extends Fragment {

    ViewModelActivity viewModelActivity;

    public MenuFragment() {
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
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModelActivity = new ViewModelProvider(getActivity()).get(ViewModelActivity.class);
        final NavController navController = Navigation.findNavController(view);

        Button btListarCompetidores = view.findViewById(R.id.btListadoCompetidores);
        btListarCompetidores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModelActivity.setRecyclerView(true);
                navController.navigate(R.id.listarFragment);
            }
        });

        Button btListarJudoguis = view.findViewById(R.id.btListadoJudogui);
        btListarJudoguis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModelActivity.setRecyclerView(false);
                navController.navigate(R.id.listarFragment);
            }
        });

        Button btInsertarCompetidor = view.findViewById(R.id.btInsertCompetidor);
        btInsertarCompetidor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.insertarCompetidoresFragment);
            }
        });

        Button btInsertarJudogui = view.findViewById(R.id.btInsertJudogui);
        btInsertarJudogui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navController.navigate(R.id.insertarJudoguisFragment);
            }
        });

        ImageView imgExit = view.findViewById(R.id.imgExit);
        imgExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModelActivity.logout();
                navController.navigate(R.id.loginUserFragment);
            }
        });
    }
}