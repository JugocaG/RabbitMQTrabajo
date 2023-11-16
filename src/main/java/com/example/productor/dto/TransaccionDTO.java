package com.example.productor.dto;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class TransaccionDTO {
    private int idTransaccion;
    private int idCuentaDestino;
    private int idCuentaOrigen;
    private int valorTransaccion;

    public TransaccionDTO() {
    }
}