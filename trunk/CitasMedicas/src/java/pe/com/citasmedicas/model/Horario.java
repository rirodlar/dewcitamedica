package pe.com.citasmedicas.model;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 

import java.util.Date;

// #[regen=yes,id=DCE.F040ABAB-1B97-3334-4CA7-5E9C2C8A1B7D]
// </editor-fold> 
public class Horario {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.BDBF0798-99EA-FDEF-74DE-83CD819B887C]
    // </editor-fold> 
    private Integer horarioId;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C1F4BB50-7713-9278-8F79-654127392D01]
    // </editor-fold> 
    private Date fechaInicio;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.AA62FFC2-F8D0-2435-FDC8-46323F35BBC5]
    // </editor-fold> 
    private Date fechaFin;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8CDFBE45-B09F-06E0-1B6E-32E6EF09B65C]
    // </editor-fold> 
    public Horario () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.26191BB0-B6B2-4D1F-F689-99795471CCE9]
    // </editor-fold> 
    public Date getFechaFin () {
        return fechaFin;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.F438DF2E-2F01-6142-E7A2-0C0C854A1C63]
    // </editor-fold> 
    public void setFechaFin (Date val) {
        this.fechaFin = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.40025CA6-1DE0-3473-BFC7-AB07AAB65EBE]
    // </editor-fold> 
    public Date getFechaInicio () {
        return fechaInicio;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.7DA3964D-08BA-EF9C-1D8E-82B6420353F2]
    // </editor-fold> 
    public void setFechaInicio (Date val) {
        this.fechaInicio = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.01B1F255-43A1-99FB-C0C3-6DE09F2063EA]
    // </editor-fold> 
    public Integer getHorarioId () {
        return horarioId;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.076833A5-7796-1034-25AA-5FF27E0277E7]
    // </editor-fold> 
    public void setHorarioId (Integer val) {
        this.horarioId = val;
    }

}

