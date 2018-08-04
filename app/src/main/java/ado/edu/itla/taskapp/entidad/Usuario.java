package ado.edu.itla.taskapp.entidad;

import java.io.Serializable;

/**
 * Created by MESCyT on 9/6/2018.
 */

public class Usuario implements Serializable {

    public Usuario() {

    }

    public enum TipoUsuario{
        TECNICO,
        NORMAL
    }
    Integer id;
    String nombre;
    String email;
    TipoUsuario tipoUsuario;
    String password;

    public Usuario(Integer id, String nombre, String email, TipoUsuario tipoUsuario, String password) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.tipoUsuario = tipoUsuario;
        this.password = password;
    }

    public Usuario(String s, String toString, String string, TipoUsuario normal) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Usuario{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", tipoUsuario=").append(tipoUsuario);
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
