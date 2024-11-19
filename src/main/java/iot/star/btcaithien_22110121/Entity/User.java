package iot.star.btcaithien_22110121.Entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private String userId;

    @Column(name = "username", nullable = false)
    private String userName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

}
