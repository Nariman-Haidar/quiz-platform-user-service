package narimanCode.user.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthenticationResponseDTO {

    private String token;
    private String refreshToken;
}