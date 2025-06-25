package diccionario.demo.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import diccionario.demo.config.JwtUtil;
import diccionario.demo.dto.AuthRequest;
import diccionario.demo.entity.Usuario;
import diccionario.demo.repository.UsuarioRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil,
                          UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest request, HttpServletResponse response) {
    Authentication auth = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
    );

    String token = jwtUtil.generateToken(request.getUsername());

    
    Cookie cookie = jwtUtil.createJwtCookie(token);
    response.addCookie(cookie);

    return ResponseEntity.ok("Login exitoso");
}


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthRequest request) {
        Usuario nuevo = new Usuario();
        nuevo.setUsername(request.getUsername());
        nuevo.setPassword(passwordEncoder.encode(request.getPassword()));
        usuarioRepository.save(nuevo);
        return ResponseEntity.ok("Usuario registrado");
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("jwt", null);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return ResponseEntity.ok("Sesión cerrada");
    }
}
