package com.galaxy.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.galaxy.myapplication.model.DaoSession;
import com.galaxy.myapplication.model.Persona;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LLenarPersona extends AppCompatActivity {

    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_apellidos)
    EditText etApellidos;
    @BindView(R.id.et_correo)
    EditText etCorreo;
    @BindView(R.id.et_edad)
    EditText etEdad;
    @BindView(R.id.et_dirreccion)
    EditText etDirreccion;
    @BindView(R.id.btn_guardar)
    Button btnGuardar;

    private DaoSession daoSession;
    private Persona persona;
    private boolean actualizar;

    public static void start(Context context,Persona persona){
        Intent starset = new Intent(context,LLenarPersona.class);
        starset.putExtra("persona",persona);
        context.startActivity(starset);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llenar_persona);
        ButterKnife.bind(this);

        persona = getIntent().getParcelableExtra("persona");

        SesionDAO application = (SesionDAO) getApplication();
        daoSession = application.getDaoSession();

        if(persona==null){
            btnGuardar.setText("AGREGAR");
            actualizar = false;
        }else{
            etName.setText(persona.getName());
            etApellidos.setText(persona.getApellido());
            etCorreo.setText(persona.getCorreo());
            etEdad.setText(persona.getEdad().toString());
            etDirreccion.setText(persona.getDireccion());
            btnGuardar.setText("ACTUALIZAR");
            actualizar = true;
        }


    }

    @OnClick(R.id.btn_guardar)
    public void onViewClicked() {

        if (actualizar){
            actualizarPersona();
        }
        else {
            agregarPersona();
        }
    }

    public void actualizarPersona(){
        persona.setName(etName.getText().toString());
        persona.setApellido(etApellidos.getText().toString());
        persona.setCorreo(etCorreo.getText().toString());
        persona.setEdad(Integer.parseInt(etEdad.getText().toString()));
        persona.setDireccion(etDirreccion.getText().toString());

        daoSession.getPersonaDao().update(persona);

        Toast.makeText(this,R.string.actualizar_msg, Toast.LENGTH_SHORT).show();
        finish();

    }

    public void agregarPersona(){
        Persona persona = new Persona();
        persona.setName(etName.getText().toString());
        persona.setApellido(etApellidos.getText().toString());
        persona.setCorreo(etCorreo.getText().toString());
        persona.setEdad(Integer.parseInt(etEdad.getText().toString()));
        persona.setDireccion(etDirreccion.getText().toString());

        daoSession.getPersonaDao().insert(persona);

        Toast.makeText(this,R.string.registrar_msg, Toast.LENGTH_SHORT).show();
        finish();

    }

}
