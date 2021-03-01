package miguelangellopezblanca.psp.practicafirestore.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import miguelangellopezblanca.psp.practicafirestore.R;
import miguelangellopezblanca.psp.practicafirestore.viewModel.ViewModelActivity;


public class LoginUserFragment extends Fragment {

    ViewModelActivity viewModelActivity;

    public LoginUserFragment() {
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
        return inflater.inflate(R.layout.fragment_login_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModelActivity = new ViewModelProvider(getActivity()).get(ViewModelActivity.class);
        final NavController navController = Navigation.findNavController(view);

        TextInputEditText etUserName = view.findViewById(R.id.etUserName);
        TextInputEditText etPassword = view.findViewById(R.id.etPasword);

        Button btLogin = view.findViewById(R.id.btLogin);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewModelActivity.login(etUserName.getText().toString(), etPassword.getText().toString()).observe(getActivity(), new Observer<Boolean>() {
                    @Override
                    public void onChanged(Boolean aBoolean) {
                        if(aBoolean){
                            navController.navigate(R.id.menuFragment);
                        }else{
                            Toast.makeText(getActivity(), "Los datos introducidos son incorrectos", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }
}