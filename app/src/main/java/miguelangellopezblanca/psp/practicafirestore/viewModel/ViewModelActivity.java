package miguelangellopezblanca.psp.practicafirestore.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.auth.FirebaseUser;

import java.util.List;

import miguelangellopezblanca.psp.practicafirestore.fireStore.Competidor;
import miguelangellopezblanca.psp.practicafirestore.fireStore.Judogui;
import miguelangellopezblanca.psp.practicafirestore.repositorio.Repository;

public class ViewModelActivity extends AndroidViewModel {

    private Repository repository;
    private boolean recyclerView;

    private Competidor competidor;
    private Judogui judogui;

    public ViewModelActivity(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    public MutableLiveData<Boolean> login(String correo, String contraseña) {
        return repository.login(correo, contraseña);
    }

    public FirebaseUser getFirebaseUser() {
        return repository.getFirebaseUser();
    }

    public void setFirebaseUser(FirebaseUser firebaseUser) {
        repository.setFirebaseUser(firebaseUser);
    }

    public void insertarCompetidor(Competidor competidor) {
        repository.insertarCompetidor(competidor);
    }

    public boolean isRecyclerView() {
        return recyclerView;
    }

    public void setRecyclerView(boolean recyclerView) {
        this.recyclerView = recyclerView;
    }

    public void borrarCompetidor(Competidor competidor) {
        repository.borrarCompetidor(competidor);
    }

    public MutableLiveData<List<Competidor>> getCompetidores() {
        return repository.getCompetidores();
    }

    public void actualizarCompetidor(Competidor competidor) {
        repository.actualizarCompetidor(competidor);
    }

    public Competidor getCompetidor() {
        return competidor;
    }

    public void setCompetidor(Competidor competidor) {
        this.competidor = competidor;
    }

    public Judogui getJudogui() {
        return judogui;
    }

    public void setJudogui(Judogui judogui) {
        this.judogui = judogui;
    }

    public void insertarJudogui(Judogui judogui) {
        repository.insertarJudogui(judogui);
    }

    public void borrarJudogui(Judogui judogui) {
        repository.borrarJudogui(judogui);
    }

    public MutableLiveData<List<Judogui>> getJudoguis() {
        return repository.getJudoguis();
    }

    public void actualizarJudogui(Judogui judogui) {
        repository.actualizarJudogui(judogui);
    }

    public void logout() {
        repository.logout();
    }
}
