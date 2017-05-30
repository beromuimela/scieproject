/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;

/**
 *
 * @author junito
 */
public class Periodo_Pacotes {
    private Pacotes pacotes;
    private Periodo periodo;
    private Date data;

    public Periodo_Pacotes() {
    }

    public Periodo_Pacotes(Pacotes pacotes, Periodo periodo, Date data) {
        this.pacotes = pacotes;
        this.periodo = periodo;
        this.data = data;
    }

    public Pacotes getPacotes() {
        return pacotes;
    }

    public void setPacotes(Pacotes pacotes) {
        this.pacotes = pacotes;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    
    
}
