package pe.com.citasmedicas.model;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 

import java.util.Date;

// #[regen=yes,id=DCE.B2243D5D-ED8F-1C32-BAB9-6D4D5B509CCE]
// </editor-fold> 
public class Paciente {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9137D69C-BCC0-33F8-5119-A842FE8C884E]
    // </editor-fold> 
    private Integer pacienteId;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C98A3CFA-F8CA-4218-C272-4158A8088840]
    // </editor-fold> 
    private String nombre;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9F624347-5037-9725-5BC5-1DE217496952]
    // </editor-fold> 
    private Date fechaNacimiento;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.668520A3-49FF-3A8C-EA8D-9A34CC174E8E]
    // </editor-fold> 
    private boolean activo;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.DA2D858A-6E15-F09B-DC0A-E2FDF72030D3]
    // </editor-fold> 
    private String nroDocumento;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9B772ADF-6ECF-00D9-608E-10F8EB382B73]
    // </editor-fold> 
    public Paciente () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.D2325466-C89C-1BDF-E950-4FC3607DA190]
    // </editor-fold> 
    public boolean getActivo () {
        return activo;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.098988A5-861C-DFBB-2283-0BAF8C3AC6F1]
    // </editor-fold> 
    public void setActivo (boolean val) {
        this.activo = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.85EE2D73-F859-DBFE-A729-083455B450F6]
    // </editor-fold> 
    public Date getFechaNacimiento () {
        return fechaNacimiento;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.FB7C33E4-DAE1-1B42-3D10-A6E8CA2F5EFB]
    // </editor-fold> 
    public void setFechaNacimiento (Date val) {
        this.fechaNacimiento = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.E7C5336F-B758-9C98-81B7-090D76E781EA]
    // </editor-fold> 
    public String getNombre () {
        return nombre;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.1617A510-89E5-96C5-16DB-C4C3DE2E6FB2]
    // </editor-fold> 
    public void setNombre (String val) {
        this.nombre = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.7C29502B-8280-9933-77AE-298713CC5F3C]
    // </editor-fold> 
    public String getNroDocumento () {
        return nroDocumento;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.F4C1D8AE-9AA2-04E8-7F22-D65CAA4B59A3]
    // </editor-fold> 
    public void setNroDocumento (String val) {
        this.nroDocumento = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.9478A76B-539D-8F41-8AB8-9C72275E015C]
    // </editor-fold> 
    public Integer getPacienteId () {
        return pacienteId;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.0B736EF7-FBCF-04DC-F521-F7FC6DDF0E10]
    // </editor-fold> 
    public void setPacienteId (Integer val) {
        this.pacienteId = val;
    }

}

