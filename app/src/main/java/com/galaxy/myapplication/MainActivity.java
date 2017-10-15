package com.galaxy.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.Toast;

import com.galaxy.myapplication.model.DaoSession;
import com.galaxy.myapplication.model.Persona;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity implements PersonaAdapter.OnPersonaItemClickListener {

    @BindView(R.id.btn_add)
    Button btnAdd;
    private List<Persona> personas;
    private PersonaAdapter personaAdapter;
    private DaoSession daoSession;

    @BindView(R.id.rv_clientes)
    RecyclerView rvClientes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        SesionDAO application = (SesionDAO) getApplication();
        daoSession = application.getDaoSession();

        personaAdapter = new PersonaAdapter(this);

        rvClientes.setLayoutManager(new LinearLayoutManager(this));
        rvClientes.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rvClientes.setAdapter(personaAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        personas = daoSession.getPersonaDao().loadAll();
        personaAdapter.addList(personas);

    }

    @Override
    public void onItemClick(Persona persona) {
        daoSession.delete(persona);
        personas = daoSession.getPersonaDao().loadAll();
        personaAdapter.addList(personas);
        Toast.makeText(this,R.string.eliminar_msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onEditarPersonaClick(Persona persona) {
        LLenarPersona.start(this,persona);
    }

    @OnClick(R.id.btn_add)
    public void onViewClicked() {
        LLenarPersona.start(this,null);
    }



}
