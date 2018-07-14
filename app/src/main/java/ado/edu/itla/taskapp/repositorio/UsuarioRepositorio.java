package ado.edu.itla.taskapp.repositorio;

import java.util.List;

import ado.edu.itla.taskapp.entidad.Usuario;

/**
 * Created by MESCyT on 14/7/2018.
 */

public interface UsuarioRepositorio {

   public boolean guardar (Usuario usuario);
   public Usuario buscarUsuario (int id);
   public Usuario buscarUsuario (String username);
   public List<Usuario> buscarTecnicos();
}
