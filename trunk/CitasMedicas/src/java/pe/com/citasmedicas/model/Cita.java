package pe.com.citasmedicas.model;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 

import java.util.Date;

// #[regen=yes,id=DCE.50C75D37-0695-232E-13D1-2D569BEB0CB1]
// </editor-fold> 
public class Cita {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.59B5670A-A9B3-3E28-4EC8-62D311A83800]
    // </editor-fold> 
    private Integer citaId;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.BE1B7E66-8253-613D-0554-39EADFCD0344]
    // </editor-fold> 
    private Date fechaCita;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.ED042563-2326-71C1-9368-12C6B9288C89]
    // </editor-fold> 
    private String estado;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.6BA1B4E2-7E46-9D8A-F214-1E531B49935F]
    // </editor-fold> 
    private String diagnostico;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.45B6A8E1-63E0-BE09-39AD-033265792BB9]
    // </editor-fold> 
    public Cita () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.9A928A7D-EA09-E238-0557-62F7663FEC13]
    // </editor-fold> 
    public Integer getCitaId () {
        return citaId;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.216BD661-563B-8705-3C0B-777EB2443852]
    // </editor-fold> 
    public void setCitaId (Integer val) {
        this.citaId = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.70B37EAD-C394-9128-C103-51615D9ECBF7]
    // </editor-fold> 
    public String getDiagnostico () {
        return diagnostico;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.65FA5488-76B2-B7D2-52A7-9414AD3EC491]
    // </editor-fold> 
    public void setDiagnostico (String val) {
        this.diagnostico = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.8FBD8A01-B02F-79D1-FA96-B9C908F1A1FA]
    // </editor-fold> 
    public String getEstado () {
        return estado;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.42A74454-28BD-457B-5884-3496043FA6C8]
    // </editor-fold> 
    public void setEstado (String val) {
        this.estado = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.D5ECB3E8-8240-08AF-B213-BEA4182251A1]
    // </editor-fold> 
    public Date getFechaCita () {
        return fechaCita;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.19F7EF13-4B12-A1F1-A506-80E60D1D43C2]
    // </editor-fold> 
    public void setFechaCita (Date val) {
        this.fechaCita = val;
    }

}

