package com.sustentacion3.sustentacion3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sustentacion3.sustentacion3.services.UsuarioServices;
import com.sustentacion3.sustentacion3.domain.Usuario;

@RestController
@RequestMapping("/api/cine")
public class UsuarioController {
    
    @Autowired
    private UsuarioServices usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        List<Usuario> usuario = usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<Usuario> editarUsuario(@PathVariable Integer id, @RequestBody Usuario usuarioAux){
        Usuario usuario = usuarioService.editarUsuario(id, usuarioAux);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Integer id){
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/busqueda")
    public ResponseEntity<List<Usuario>> busquedaUsuario(@RequestParam(required = false) String nombre){
        List<Usuario> usuarios;
        if(nombre != null){
            usuarios = usuarioService.buscarUsuarioPorNombre(nombre);
        } else {
            usuarios = usuarioService.listarUsuarios();
        }
        return ResponseEntity.ok(usuarios);
    }
}
