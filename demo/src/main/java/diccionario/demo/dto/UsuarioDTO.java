package diccionario.demo.dto;


import diccionario.demo.entity.enums.Rol;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

   
    @NotBlank(message = "El usuario es obligatorio")
    private String Usuario;
    @Email(message = "El correo debe ser válido")
    @NotBlank(message = "El correo no puede estar vacío")
    private String correo;

    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    private String password;
    private Rol rol;
}
