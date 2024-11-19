package iot.star.btcaithien_22110121.Models;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDto {
    private String name;
    private String email;
    private String password;
    private String username;
    private boolean enabled;
}
