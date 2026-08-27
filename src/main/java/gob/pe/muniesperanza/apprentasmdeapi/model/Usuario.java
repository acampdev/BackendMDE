//package gob.pe.muniesperanza.apprentasmdeapi.model;
//
//import java.util.Collection;
//import java.util.List;
//
//import jakarta.persistence.*;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name="Usuario", uniqueConstraints = {@UniqueConstraint(columnNames = {"V_Username"})})
//public class Usuario implements UserDetails {
//    @Id
//  //  @GeneratedValue
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "I_Codusuario")
//    Integer id;
//    @Basic
//    @Column(name = "V_Username", nullable = false)
//    String username;
//    @Column(name = "V_Nombrepersona")
//    String nombrePersona;
//    @Column(name = "C_Documento")
//    String documento;
//    @Column(name = "V_Password")
//    String password;
//    @Column(name = "C_Codestado")
//    String codEstado;
//   ////// @Enumerated(EnumType.ORDINAL)
//    @Column(name = "I_Codrol")
//    Integer codRol;
//   // @Transient
//   // @Enumerated(EnumType.ORDINAL)
//   ///// Role role;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//      if (codRol == null) {
//        return List.of(new SimpleGrantedAuthority(Role.USER.getNombre()));
//      }else {
//        Role role = Role.fromCodigo(codRol);
//        return List.of(new SimpleGrantedAuthority((role.name())));
//      }
//    }
//    @Override
//    public boolean isAccountNonExpired() {
//       return true;
//    }
//    @Override
//    public boolean isAccountNonLocked() {
//       return true;
//    }
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
package gob.pe.muniesperanza.apprentasmdeapi.model;

import java.util.Collection;
import java.util.List;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Usuario", uniqueConstraints = {@UniqueConstraint(columnNames = {"V_Username"})})
public class Usuario implements UserDetails {
  @Id
  //  @GeneratedValue
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "I_Codusuario")
  Integer id;
  @Basic
  @Column(name = "V_Username", nullable = false)
  String username;
  @Column(name = "V_Nombrepersona")
  String nombrePersona;
  @Column(name = "C_Documento")
  String documento;
  @Column(name = "V_Password")
  String password;
  @Column(name = "C_Codestado")
  String codEstado;
  ////// @Enumerated(EnumType.ORDINAL)
  @Column(name = "I_Codrol")
  Integer codRol;
  // @Transient
  // @Enumerated(EnumType.ORDINAL)
  ///// Role role;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    if (codRol == null) {
      return List.of(new SimpleGrantedAuthority(Role.USER.getNombre()));
    }else {
      Role role = Role.fromCodigo(codRol);
      return List.of(new SimpleGrantedAuthority((role.name())));
    }
  }
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }
  @Override
  public boolean isEnabled() {
    return true;
  }
}
