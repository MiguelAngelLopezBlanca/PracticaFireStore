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
import android.widget.TextView;

import com.bumptech.glide.Glide;

import miguelangellopezblanca.psp.practicafirestore.R;
import miguelangellopezblanca.psp.practicafirestore.fireStore.Judogui;
import miguelangellopezblanca.psp.practicafirestore.viewModel.ViewModelActivity;


public class EditarJudoguisFragment extends Fragment {

    ViewModelActivity viewModelActivity;

    public EditarJudoguisFragment() {
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
        return inflater.inflate(R.layout.fragment_editar_judoguis, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModelActivity = new ViewModelProvider(getActivity()).get(ViewModelActivity.class);
        final NavController navController = Navigation.findNavController(view);

        EditText etMarca = view.findViewById(R.id.etEditJudoguiMarca);
        etMarca.setText(viewModelActivity.getJudogui().getMarca());

        EditText etModelo = view.findViewById(R.id.etEditJudoguiModelo);
        etModelo.setText(viewModelActivity.getJudogui().getModelo());

        EditText etTalla = view.findViewById(R.id.etEditJudoguiTalla);
        etTalla.setText(String.valueOf(viewModelActivity.getJudogui().getTalla()));

        EditText etColor = view.findViewById(R.id.etEditJudoguiColor);
        etColor.setText(viewModelActivity.getJudogui().getColor());

        EditText etImgUrl = view.findViewById(R.id.etEditJudoguiImagen);
        etImgUrl.setText(viewModelActivity.getJudogui().getImgJudogui());

        ImageView img = view.findViewById(R.id.imageView4);
        Glide.with(getContext()).load(viewModelActivity.getJudogui().getImgJudogui()).into(img);

        TextView tvNameCompetidor = view.findViewById(R.id.tvNameCompetidor);
        tvNameCompetidor.setText(String.valueOf(viewModelActivity.getJudogui().getIdCompetidor()));

        Button btActualizarJudogui = view.findViewById(R.id.btEditarJudogui);
        btActualizarJudogui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Judogui judogui = new Judogui(tvNameCompetidor.getText().toString(), etMarca.getText().toString(), etModelo.getText().toString(), etImgUrl.getText().toString(),
                        etColor.getText().toString(), Integer.parseInt(etTalla.getText().toString()), viewModelActivity.getJudogui().getIdentificador());

               viewModelActivity.actualizarJudogui(judogui);
                navController.navigate(R.id.menuFragment);
            }
        });

        Button btBorrarJudogui = view.findViewById(R.id.btBorrarJudogui);
        btBorrarJudogui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModelActivity.borrarJudogui(viewModelActivity.getJudogui());
                navController.navigate(R.id.menuFragment);
            }
        });
    }
}