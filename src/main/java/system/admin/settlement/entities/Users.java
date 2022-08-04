package system.admin.settlement.entities;

import lombok.*;
import system.admin.settlement.dtos.enums.MemberRole;

import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    private String department;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MemberRole role;

    public Users createUser(String email, String name, String password, String department) {
        return Users.builder()
                .email(email)
                .name(name)
                .password(password) // encrypt needed
                .department(department)
                .role(MemberRole.ROLE_USER)
                .build();
    }

    public Users createManager(String email, String name, String password, String department) {
        return Users.builder()
                .email(email)
                .name(name)
                .password(password) // encrypt needed
                .department(department)
                .role(MemberRole.ROLE_MANAGER)
                .build();
    }

    public Users createAdmin(String email, String name, String password, String department) {
        return Users.builder()
                .email(email)
                .name(name)
                .password(password) // encrypt needed
                .department(department)
                .role(MemberRole.ROLE_ADMIN)
                .build();
    }



}
