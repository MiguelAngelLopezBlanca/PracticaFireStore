package miguelangellopezblanca.psp.practicafirestore.repositorio;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import miguelangellopezblanca.psp.practicafirestore.fireStore.Competidor;
import miguelangellopezblanca.psp.practicafirestore.fireStore.Judogui;

public class Repository {

    FirebaseFirestore db;
    private Context context;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    public Repository(Context context){
        this.context = context;
        db = FirebaseFirestore.getInstance();
    }

    public MutableLiveData<Boolean> login(String correo, String contraseña){

        MutableLiveData<Boolean> logueado = new MutableLiveData<>();
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithEmailAndPassword(correo, contraseña)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        firebaseUser = firebaseAuth.getCurrentUser();
                        setFirebaseUser(firebaseUser);
                        logueado.setValue(true);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        firebaseUser = null;
                        logueado.setValue(false);
                    }
                });

        return logueado;
    }

    public void logout(){
        firebaseAuth.signOut();
    }

    public FirebaseUser getFirebaseUser() {
        return firebaseUser;
    }

    public void setFirebaseUser(FirebaseUser firebaseUser) {
        this.firebaseUser = firebaseUser;
    }

    /* METODOS COMPETIDORES */

    public void insertarCompetidor(Competidor competidor){
        db.collection("user/" + getFirebaseUser().getUid() + "/competidor").document(competidor.getDni()).set(competidor)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(context, "Se ha dado de alta el competidor", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(context, "No se ha podido dar de alta el competidor", Toast.LENGTH_LONG).show();
                    }
                });
    }

    public void borrarCompetidor(Competidor competidor){
        db.collection("user/" + getFirebaseUser().getUid() + "/competidor").document(competidor.getDni()).delete();
    }

    public MutableLiveData<List<Competidor>> getCompetidores(){
        MutableLiveData<List<Competidor>> competidores = new MutableLiveData<>();
        db.collection("user/" + getFirebaseUser().getUid() + "/competidor").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            competidores.setValue(task.getResult().toObjects(Competidor.class));
                        } else {
                        }
                    }
                });

        return competidores;
    }

    public void actualizarCompetidor(Competidor competidor){
        db.collection("user/" + getFirebaseUser().getUid() + "/competidor").document(competidor.getDni()).update("nombre", competidor.getNombre(),
                "apellidos", competidor.getApellidos(), "edad", competidor.getEdad(), "imgCompetidor", competidor.getImgCompetidor());


    }

    /* METODOS JUDOGUI */

    public void insertarJudogui(Judogui judogui){
        db.collection("user/" + getFirebaseUser().getUid() + "/judogui").document(judogui.getIdentificador()).set(judogui)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(context, "Se ha dado de alta el judogui", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(context, "No se ha podido dar de alta el judogui", Toast.LENGTH_LONG).show();
                    }
                });
    }

    public void borrarJudogui(Judogui judogui){
        db.collection("user/" + getFirebaseUser().getUid() + "/judogui").document(judogui.getIdentificador()).delete();
    }

    public MutableLiveData<List<Judogui>> getJudoguis(){
        MutableLiveData<List<Judogui>> judoguis = new MutableLiveData<>();
        db.collection("user/" + getFirebaseUser().getUid() + "/judogui").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            judoguis.setValue(task.getResult().toObjects(Judogui.class));
                        } else {
                        }
                    }
                });

        return judoguis;
    }

    public void actualizarJudogui(Judogui judogui){
        db.collection("user/" + getFirebaseUser().getUid() + "/judogui").document(judogui.getIdentificador()).update("idCompetidor", judogui.getIdCompetidor(),
                "marca", judogui.getMarca(), "modelo", judogui.getModelo(), "imgJudogui", judogui.getImgJudogui(), "color", judogui.getColor(),
                "talla", judogui.getTalla(), "identificador", judogui.getIdentificador());
    }

}
