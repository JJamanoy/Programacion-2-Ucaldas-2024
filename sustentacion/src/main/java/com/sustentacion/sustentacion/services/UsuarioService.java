package com.sustentacion.sustentacion.services;

import java.util.List;
import java.util.Optional;

import com.sustentacion.sustentacion.domain.Usuarios;
import com.sustentacion.sustentacion.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuarios> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuarios agregarUsuario(Usuarios usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuarios editarUsuario(int id, Usuarios usuarioDetalles) {
        Optional<Usuarios> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuarios usuario = usuarioOptional.get();
            usuario.setNombre(usuarioDetalles.getNombre());
            usuario.setApellido(usuarioDetalles.getApellido());
            usuario.setEmail(usuarioDetalles.getEmail());
            usuario.setContrasena(usuarioDetalles.getContrasena());
            usuario.setRol(usuarioDetalles.getRol());
            usuario.setFecha_registro(usuarioDetalles.getFecha_registro());
            return usuarioRepository.save(usuario);
        } else {
            return null; 
        }
    }

    public void eliminarUsuario(int id) {
        usuarioRepository.deleteById(id);
    }

    public Usuarios obtenerUsuarioPorId(int id) {
        return usuarioRepository.findById(id).orElse(null);
    }
}
