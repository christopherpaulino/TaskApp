package ado.edu.itla.taskapp.entidad;


import java.io.Serializable;

public class Categoria implements Serializable {
    private Integer id;
    private String nombre;

    public Categoria(Integer id) {
        this.id = id;
    }

    public Categoria(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Categoria() {
    }

    public Integer getId() {
        return id;
    }

    public Categoria setId(Integer id) {
        this.id = id;
        return this;
    }


    public String getNombre() {

        return nombre;
    }

    public Categoria setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Categoria{");
        sb.append("id=").append(id);
        sb.append(", descripcion='").append(nombre).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
