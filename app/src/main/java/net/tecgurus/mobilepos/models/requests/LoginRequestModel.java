package net.tecgurus.mobilepos.models.requests;

public class LoginRequestModel extends RequestModel {

    private String usuario;
    private String password;




    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
