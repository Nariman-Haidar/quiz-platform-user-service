package narimanCode.user.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthenticationRequestDTO {

    private String username;
    private String password;
}