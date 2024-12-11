package br.com.joaopaulo.api_cadastro.models;

import org.springframework.stereotype.Component;

@Component
public class Response {

    private String mensage;

    public String getMensage() {
        return mensage;
    }

    public void setMensage(String mensage) {
        this.mensage = mensage;
    }

    
}