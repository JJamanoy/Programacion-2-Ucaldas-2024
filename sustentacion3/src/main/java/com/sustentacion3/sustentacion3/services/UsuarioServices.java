package com.sustentacion3.sustentacion3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sustentacion3.sustentacion3.repository.UsuarioRepository;
import com.sustentacion3.sustentacion3.domain.Usuario;

@Service
public class UsuarioServices {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario agregarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario editarUsuario(Integer id, Usuario usuarioAux){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if(usuarioOptional.isPresent()){
            Usuario usuario = usuarioOptional.get();
            usuario.setNombre(usuarioAux.getNombre());
            usuario.setApellido(usuarioAux.getApellido());
            usuario.setCorreo(usuarioAux.getCorreo());
            usuario.setPelicula(usuario.getPelicula());
            usuario.setFecha(usuarioAux.getFecha());
            usuario.setHora(usuarioAux.getHora());
            usuario.setAdultos(usuarioAux.getAdultos());
            usuario.setNiños(usuarioAux.getNiños());
            usuario.setPreferencia(usuarioAux.getPreferencia());
            usuario.setNotificaciones(usuarioAux.getNotificaciones());
            return usuarioRepository.save(usuario);
        } else {
            return null;
        }
    }

    public void eliminarUsuario(Integer id){
        usuarioRepository.deleteById(id);
    }

    public List<Usuario> buscarUsuarioPorNombre(String nombre){
        return usuarioRepository.findByNombre(nombre);
    }
}
