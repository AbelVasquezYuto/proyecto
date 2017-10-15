package com.galaxy.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.galaxy.myapplication.model.Persona;

import java.util.List;

/**
 * Created by Alumno on 15/10/2017.
 */

public class PersonaAdapter extends RecyclerView.Adapter<PersonaAdapter.PersonaViewHolder> {

    private List<Persona> personas;
    private OnPersonaItemClickListener onPersonaItemClick;

    public PersonaAdapter(OnPersonaItemClickListener onPersonaItemClick){
        this.onPersonaItemClick=onPersonaItemClick;
    }

    public void addList(List<Persona> personas){
        this.personas=personas;
        notifyDataSetChanged();
    }

    @Override
    public PersonaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main_lista,parent,false);

        return new PersonaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PersonaViewHolder holder, int position) {

        final Persona cliente = personas.get(position);
        holder.tvName.setText(cliente.getName());
        holder.tvApellido.setText(cliente.getApellido());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onPersonaItemClick!=null)
                    onPersonaItemClick.onItemClick(cliente);
            }
        });

        holder.btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onPersonaItemClick!=null)
                    onPersonaItemClick.onEditarPersonaClick(cliente);
            }
        });

    }

    @Override
    public int getItemCount() {

        if(personas==null){
            return 0;
        }else{
            return personas.size();
        }
    }

    class PersonaViewHolder extends RecyclerView.ViewHolder{

        TextView tvName,tvApellido;
        Button btnEditar;

        public PersonaViewHolder(View itemView){
            super(itemView);

            tvName=itemView.findViewById(R.id.tv_name);
            tvApellido=itemView.findViewById(R.id.tv_apellido);
            btnEditar=itemView.findViewById(R.id.Btn_editar);
        }

    }

    public interface OnPersonaItemClickListener{
        void onItemClick(Persona persona);
        void onEditarPersonaClick(Persona persona);
    }

}


