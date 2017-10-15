package com.galaxy.myapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Alumno on 15/10/2017.
 */

@Entity
public class Persona implements Parcelable {

    @Id(autoincrement = true)
    private Long id;
    private String name;
    private String apellido;
    private String correo;
    private Integer edad;
    private String direccion;


    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correo='" + correo + '\'' +
                ", edad=" + edad +
                ", direccion='" + direccion + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.name);
        dest.writeString(this.apellido);
        dest.writeString(this.correo);
        dest.writeValue(this.edad);
        dest.writeString(this.direccion);
    }

    public Persona() {
    }

    protected Persona(Parcel in) {
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.name = in.readString();
        this.apellido = in.readString();
        this.correo = in.readString();
        this.edad = (Integer) in.readValue(Integer.class.getClassLoader());
        this.direccion = in.readString();
    }

    @Generated(hash = 2077876166)
    public Persona(Long id, String name, String apellido, String correo, Integer edad,
            String direccion) {
        this.id = id;
        this.name = name;
        this.apellido = apellido;
        this.correo = correo;
        this.edad = edad;
        this.direccion = direccion;
    }

    public static final Parcelable.Creator<Persona> CREATOR = new Parcelable.Creator<Persona>() {
        @Override
        public Persona createFromParcel(Parcel source) {
            return new Persona(source);
        }

        @Override
        public Persona[] newArray(int size) {
            return new Persona[size];
        }
    };
}
