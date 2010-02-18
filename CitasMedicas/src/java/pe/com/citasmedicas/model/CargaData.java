package pe.com.citasmedicas.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author dew - Grupo 04
 */
public class CargaData {

    public static List<Especialidad> ESPECIALIDADES = null;
    public static List<Medico> MEDICOS = null;
    public static List<Paciente> PACIENTES = null;
    public static List<Horario> HORARIOS = null;
    public static List<Cita> CITAS = null;
    public static List<Usuario> USUARIOS = null;
    public static List<Horario> HORARIO_ATENCION = null;

    public static void inicializar() {
        ESPECIALIDADES = new ArrayList<Especialidad>();
        MEDICOS = new ArrayList<Medico>();
        PACIENTES = new ArrayList<Paciente>();
        HORARIOS = new ArrayList<Horario>();
        CITAS = new ArrayList<Cita>();
        USUARIOS = new ArrayList<Usuario>();
        HORARIO_ATENCION = new ArrayList<Horario>();

        // Especialidades
        Especialidad cardiologia = new Especialidad();
        cardiologia.setEspecialidadId(new Integer(1000000));
        cardiologia.setNombre("Cardiología");
        ESPECIALIDADES.add(cardiologia);

        Especialidad hematologia = new Especialidad();
        hematologia.setEspecialidadId(new Integer(1000001));
        hematologia.setNombre("Hematología");
        ESPECIALIDADES.add(hematologia);

        Especialidad gastroenterologia = new Especialidad();
        gastroenterologia.setEspecialidadId(new Integer(1000002));
        gastroenterologia.setNombre("Gastroenterología");
        ESPECIALIDADES.add(gastroenterologia);

        // Medicos
        Medico jorgeCasana = new Medico();
        jorgeCasana.setPersonaId(new Integer(1000000));
        jorgeCasana.setNombre("Jorge");
        jorgeCasana.setApellidoPaterno("Casana");
        jorgeCasana.setApellidoMaterno("Bejarano");
        Calendar cal = new GregorianCalendar(1975, 11, 25);
        jorgeCasana.setFechaNacimiento(cal.getTime());
        jorgeCasana.setNroColegiatura("12540");
        jorgeCasana.setNroDocumento("45842215");
        List<Especialidad> especialidadMed = new ArrayList<Especialidad>();
        especialidadMed.add(cardiologia);
        jorgeCasana.setEspecialidades(especialidadMed);
        MEDICOS.add(jorgeCasana);

        Medico jaimeEspinoza = new Medico();
        jaimeEspinoza.setPersonaId(new Integer(1000001));
        jaimeEspinoza.setNombre("Jaime");
        jaimeEspinoza.setApellidoPaterno("Espinoza");
        jaimeEspinoza.setApellidoMaterno("Solís");
        cal = new GregorianCalendar(1980, 4, 13);
        jaimeEspinoza.setFechaNacimiento(cal.getTime());
        jaimeEspinoza.setNroColegiatura("75610");
        jaimeEspinoza.setNroDocumento("58479956");
        especialidadMed = new ArrayList<Especialidad>();
        especialidadMed.add(cardiologia);
        jaimeEspinoza.setEspecialidades(especialidadMed);
        MEDICOS.add(jaimeEspinoza);

        Medico miguelSanchez = new Medico();
        miguelSanchez.setPersonaId(new Integer(1000002));
        miguelSanchez.setNombre("Miguel");
        miguelSanchez.setApellidoPaterno("Sánchez-Palacios");
        miguelSanchez.setApellidoMaterno("Paiva");
        cal = new GregorianCalendar(1968, 1, 2);
        miguelSanchez.setFechaNacimiento(cal.getTime());
        miguelSanchez.setNroColegiatura("94025");
        miguelSanchez.setNroDocumento("51024875");
        especialidadMed = new ArrayList<Especialidad>();
        especialidadMed.add(cardiologia);
        miguelSanchez.setEspecialidades(especialidadMed);
        MEDICOS.add(miguelSanchez);

        Medico joseCaravedo = new Medico();
        joseCaravedo.setPersonaId(new Integer(1000003));
        joseCaravedo.setNombre("José");
        joseCaravedo.setApellidoPaterno("Caravedo");
        joseCaravedo.setApellidoMaterno("Baigorria");
        cal = new GregorianCalendar(1973, 10, 10);
        joseCaravedo.setFechaNacimiento(cal.getTime());
        joseCaravedo.setNroColegiatura("22658");
        joseCaravedo.setNroDocumento("62354085");
        especialidadMed = new ArrayList<Especialidad>();
        especialidadMed.add(hematologia);
        joseCaravedo.setEspecialidades(especialidadMed);
        MEDICOS.add(joseCaravedo);

        Medico eduardoBarriga = new Medico();
        eduardoBarriga.setPersonaId(new Integer(1000004));
        eduardoBarriga.setNombre("Eduardo");
        eduardoBarriga.setApellidoPaterno("Barriga");
        eduardoBarriga.setApellidoMaterno("Calle");
        cal = new GregorianCalendar(1977, 8, 17);
        eduardoBarriga.setFechaNacimiento(cal.getTime());
        eduardoBarriga.setNroColegiatura("02619");
        eduardoBarriga.setNroDocumento("75124801");
        especialidadMed = new ArrayList<Especialidad>();
        especialidadMed.add(gastroenterologia);
        eduardoBarriga.setEspecialidades(especialidadMed);
        MEDICOS.add(eduardoBarriga);

        Medico fernandoSalazar = new Medico();
        fernandoSalazar.setPersonaId(new Integer(1000005));
        fernandoSalazar.setNombre("Fernando");
        fernandoSalazar.setApellidoPaterno("Salazar");
        fernandoSalazar.setApellidoMaterno("Cabrera");
        cal = new GregorianCalendar(1981, 6, 6);
        fernandoSalazar.setFechaNacimiento(cal.getTime());
        fernandoSalazar.setNroColegiatura("58460");
        fernandoSalazar.setNroDocumento("02458619");
        especialidadMed = new ArrayList<Especialidad>();
        especialidadMed.add(gastroenterologia);
        especialidadMed.add(hematologia);
        fernandoSalazar.setEspecialidades(especialidadMed);
        MEDICOS.add(fernandoSalazar);

        // Pacientes
        Paciente albertoFranco = new Paciente();
        albertoFranco.setPersonaId(new Integer(1000006));
        albertoFranco.setNombre("Alberto");
        albertoFranco.setApellidoPaterno("Franco");
        albertoFranco.setApellidoMaterno("González");
        cal = new GregorianCalendar(1984, 7, 20);
        albertoFranco.setFechaNacimiento(cal.getTime());
        albertoFranco.setNroDocumento("54128875");
        albertoFranco.setEstatura(new Integer(172));
        albertoFranco.setPeso(new Double(78.5));
        PACIENTES.add(albertoFranco);

        Paciente sandraFranco = new Paciente();
        sandraFranco.setPersonaId(new Integer(1000007));
        sandraFranco.setNombre("Sandra");
        sandraFranco.setApellidoPaterno("Franco");
        sandraFranco.setApellidoMaterno("Vitteri");
        cal = new GregorianCalendar(1981, 10, 5);
        sandraFranco.setFechaNacimiento(cal.getTime());
        sandraFranco.setNroDocumento("85469902");
        sandraFranco.setEstatura(new Integer(168));
        sandraFranco.setPeso(new Double(65.0));
        PACIENTES.add(sandraFranco);

        Paciente juanMatzumura = new Paciente();
        juanMatzumura.setPersonaId(new Integer(1000008));
        juanMatzumura.setNombre("Juan");
        juanMatzumura.setApellidoPaterno("Matzumura");
        juanMatzumura.setApellidoMaterno("Kasano");
        cal = new GregorianCalendar(1952, 3, 14);
        juanMatzumura.setFechaNacimiento(cal.getTime());
        juanMatzumura.setNroDocumento("02665402");
        juanMatzumura.setEstatura(new Integer(170));
        juanMatzumura.setPeso(new Double(81.4));
        PACIENTES.add(juanMatzumura);

        Paciente carolinaChang = new Paciente();
        carolinaChang.setPersonaId(new Integer(1000009));
        carolinaChang.setNombre("Carolina");
        carolinaChang.setApellidoPaterno("Chang");
        carolinaChang.setApellidoMaterno("Vargas");
        cal = new GregorianCalendar(1960, 5, 7);
        carolinaChang.setFechaNacimiento(cal.getTime());
        carolinaChang.setNroDocumento("21006502");
        carolinaChang.setEstatura(new Integer(156));
        carolinaChang.setPeso(new Double(57.8));
        PACIENTES.add(carolinaChang);

        Paciente anaTalavera = new Paciente();
        anaTalavera.setPersonaId(new Integer(1000010));
        anaTalavera.setNombre("Ana");
        anaTalavera.setApellidoPaterno("Talavera");
        anaTalavera.setApellidoMaterno("Escobar");
        cal = new GregorianCalendar(1975, 11, 27);
        anaTalavera.setFechaNacimiento(cal.getTime());
        anaTalavera.setNroDocumento("65410087");
        anaTalavera.setEstatura(new Integer(162));
        anaTalavera.setPeso(new Double(58.2));
        PACIENTES.add(anaTalavera);

        // Usuarios
        Usuario usuario = new Usuario();

        usuario.setUsuarioId(new Integer(1000000));
        usuario.setUsername("jorgeCasana");
        usuario.setPassword("desarrolloweb");
        usuario.setPersona(jorgeCasana);
        USUARIOS.add(usuario);

        usuario.setUsuarioId(new Integer(1000001));
        usuario = new Usuario();
        usuario.setUsername("jaimeEspinoza");
        usuario.setPassword("desarrolloweb");
        usuario.setPersona(jaimeEspinoza);
        USUARIOS.add(usuario);

        usuario.setUsuarioId(new Integer(1000002));
        usuario = new Usuario();
        usuario.setUsername("miguelSanchez");
        usuario.setPassword("desarrolloweb");
        usuario.setPersona(miguelSanchez);
        USUARIOS.add(usuario);

        usuario.setUsuarioId(new Integer(1000003));
        usuario = new Usuario();
        usuario.setUsername("joseCaravedo");
        usuario.setPassword("desarrolloweb");
        usuario.setPersona(joseCaravedo);
        USUARIOS.add(usuario);

        usuario.setUsuarioId(new Integer(1000004));
        usuario = new Usuario();
        usuario.setUsername("eduardoBarriga");
        usuario.setPassword("desarrolloweb");
        usuario.setPersona(eduardoBarriga);
        USUARIOS.add(usuario);

        usuario.setUsuarioId(new Integer(1000005));
        usuario = new Usuario();
        usuario.setUsername("fernandoSalazar");
        usuario.setPassword("desarrolloweb");
        usuario.setPersona(fernandoSalazar);
        USUARIOS.add(usuario);

        usuario.setUsuarioId(new Integer(1000006));
        usuario = new Usuario();
        usuario.setUsername("albertoFranco");
        usuario.setPassword("desarrolloweb");
        usuario.setPersona(albertoFranco);
        USUARIOS.add(usuario);

        usuario.setUsuarioId(new Integer(1000007));
        usuario = new Usuario();
        usuario.setUsername("sandraFranco");
        usuario.setPassword("desarrolloweb");
        usuario.setPersona(sandraFranco);
        USUARIOS.add(usuario);

        usuario.setUsuarioId(new Integer(1000008));
        usuario = new Usuario();
        usuario.setUsername("juanMatzumura");
        usuario.setPassword("desarrolloweb");
        usuario.setPersona(juanMatzumura);
        USUARIOS.add(usuario);

        usuario.setUsuarioId(new Integer(1000009));
        usuario = new Usuario();
        usuario.setUsername("carolinaChang");
        usuario.setPassword("desarrolloweb");
        usuario.setPersona(carolinaChang);
        USUARIOS.add(usuario);

        usuario.setUsuarioId(new Integer(1000010));
        usuario = new Usuario();
        usuario.setUsername("anaTalavera");
        usuario.setPassword("desarrolloweb");
        usuario.setPersona(anaTalavera);
        USUARIOS.add(usuario);
        
        // Horarios
        // Cardiología - Casana Bejarano, Jorge - Lunes de 09:00 - 11:00
        Horario horario00 = new Horario();
        horario00.setHorarioId(new Integer(1000000));
        cal = new GregorianCalendar(2010, 2, 22, 9, 0);
        horario00.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 22, 9, 30);
        horario00.setFechaFin(cal.getTime());
        horario00.setEspecialidad(cardiologia);
        horario00.setMedico(jorgeCasana);
        HORARIOS.add(horario00);

        Horario horario01 = new Horario();
        horario01.setHorarioId(new Integer(1000001));
        cal = new GregorianCalendar(2010, 2, 22, 9, 30);
        horario01.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 22, 10, 0);
        horario01.setFechaFin(cal.getTime());
        horario01.setEspecialidad(cardiologia);
        horario01.setMedico(jorgeCasana);
        HORARIOS.add(horario01);

        Horario horario02 = new Horario();
        horario02.setHorarioId(new Integer(1000002));
        cal = new GregorianCalendar(2010, 2, 22, 10, 0);
        horario02.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 22, 10, 30);
        horario02.setFechaFin(cal.getTime());
        horario02.setEspecialidad(cardiologia);
        horario02.setMedico(jorgeCasana);
        HORARIOS.add(horario02);

        Horario horario03 = new Horario();
        horario03.setHorarioId(new Integer(1000003));
        cal = new GregorianCalendar(2010, 2, 22, 10, 30);
        horario03.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 22, 11, 0);
        horario03.setFechaFin(cal.getTime());
        horario03.setEspecialidad(cardiologia);
        horario03.setMedico(jorgeCasana);
        HORARIOS.add(horario03);

        // Cardiología - Casana Bejarano, Jorge - Miercoles de 09:00 - 11:00
        Horario horario04 = new Horario();
        horario04.setHorarioId(new Integer(1000004));
        cal = new GregorianCalendar(2010, 2, 24, 9, 0);
        horario04.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 24, 9, 30);
        horario04.setFechaFin(cal.getTime());
        horario04.setEspecialidad(cardiologia);
        horario04.setMedico(jorgeCasana);
        HORARIOS.add(horario04);

        Horario horario05 = new Horario();
        horario05.setHorarioId(new Integer(1000005));
        cal = new GregorianCalendar(2010, 2, 24, 9, 30);
        horario05.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 24, 10, 0);
        horario05.setFechaFin(cal.getTime());
        horario05.setEspecialidad(cardiologia);
        horario05.setMedico(jorgeCasana);
        HORARIOS.add(horario05);

        Horario horario06 = new Horario();
        horario06.setHorarioId(new Integer(1000006));
        cal = new GregorianCalendar(2010, 2, 24, 10, 0);
        horario06.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 24, 10, 30);
        horario06.setFechaFin(cal.getTime());
        horario06.setEspecialidad(cardiologia);
        horario06.setMedico(jorgeCasana);
        HORARIOS.add(horario06);

        Horario horario07 = new Horario();
        horario07.setHorarioId(new Integer(1000007));
        cal = new GregorianCalendar(2010, 2, 24, 10, 30);
        horario07.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 24, 11, 0);
        horario07.setFechaFin(cal.getTime());
        horario07.setEspecialidad(cardiologia);
        horario07.setMedico(jorgeCasana);
        HORARIOS.add(horario07);

        // Cardiología - Espinoza Solis, Jaime - Martes de 15:00 - 17:00
        Horario horario08 = new Horario();
        horario08.setHorarioId(new Integer(1000008));
        cal = new GregorianCalendar(2010, 2, 23, 15, 0);
        horario08.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 23, 15, 30);
        horario08.setFechaFin(cal.getTime());
        horario08.setEspecialidad(cardiologia);
        horario08.setMedico(jaimeEspinoza);
        HORARIOS.add(horario08);

        Horario horario09 = new Horario();
        horario09.setHorarioId(new Integer(1000009));
        cal = new GregorianCalendar(2010, 2, 23, 15, 30);
        horario09.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 23, 16, 0);
        horario09.setFechaFin(cal.getTime());
        horario09.setEspecialidad(cardiologia);
        horario09.setMedico(jaimeEspinoza);
        HORARIOS.add(horario09);

        Horario horario10 = new Horario();
        horario10.setHorarioId(new Integer(1000010));
        cal = new GregorianCalendar(2010, 2, 23, 16, 0);
        horario10.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 23, 16, 30);
        horario10.setFechaFin(cal.getTime());
        horario10.setEspecialidad(cardiologia);
        horario10.setMedico(jaimeEspinoza);
        HORARIOS.add(horario10);

        Horario horario11 = new Horario();
        horario11.setHorarioId(new Integer(1000011));
        cal = new GregorianCalendar(2010, 2, 23, 16, 30);
        horario11.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 23, 17, 0);
        horario11.setFechaFin(cal.getTime());
        horario11.setEspecialidad(cardiologia);
        horario11.setMedico(jaimeEspinoza);
        HORARIOS.add(horario11);

        // Cardiología - Espinoza Solis, Jaime - Jueves de 15:00 - 17:00
        Horario horario12 = new Horario();
        horario12.setHorarioId(new Integer(1000012));
        cal = new GregorianCalendar(2010, 2, 25, 15, 0);
        horario12.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 25, 15, 30);
        horario12.setFechaFin(cal.getTime());
        horario12.setEspecialidad(cardiologia);
        horario12.setMedico(jaimeEspinoza);
        HORARIOS.add(horario12);

        Horario horario13 = new Horario();
        horario13.setHorarioId(new Integer(1000013));
        cal = new GregorianCalendar(2010, 2, 25, 15, 30);
        horario13.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 25, 16, 0);
        horario13.setFechaFin(cal.getTime());
        horario13.setEspecialidad(cardiologia);
        horario13.setMedico(jaimeEspinoza);
        HORARIOS.add(horario13);

        Horario horario14 = new Horario();
        horario14.setHorarioId(new Integer(1000014));
        cal = new GregorianCalendar(2010, 2, 25, 16, 0);
        horario14.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 25, 16, 30);
        horario14.setFechaFin(cal.getTime());
        horario14.setEspecialidad(cardiologia);
        horario14.setMedico(jaimeEspinoza);
        HORARIOS.add(horario14);

        Horario horario15 = new Horario();
        horario15.setHorarioId(new Integer(1000015));
        cal = new GregorianCalendar(2010, 2, 25, 16, 30);
        horario15.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 25, 17, 00);
        horario15.setFechaFin(cal.getTime());
        horario15.setEspecialidad(cardiologia);
        horario15.setMedico(jaimeEspinoza);
        HORARIOS.add(horario15);

        // Cardiología - Sánchez-Palacios Paiva, Miguel - Viernes de 09:00 - 11:00
        Horario horario16 = new Horario();
        horario16.setHorarioId(new Integer(1000016));
        cal = new GregorianCalendar(2010, 2, 26, 9, 0);
        horario16.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 26, 9, 30);
        horario16.setFechaFin(cal.getTime());
        horario16.setEspecialidad(cardiologia);
        horario16.setMedico(miguelSanchez);
        HORARIOS.add(horario16);

        Horario horario17 = new Horario();
        horario17.setHorarioId(new Integer(1000017));
        cal = new GregorianCalendar(2010, 2, 26, 9, 30);
        horario17.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 26, 10, 0);
        horario17.setFechaFin(cal.getTime());
        horario17.setEspecialidad(cardiologia);
        horario17.setMedico(miguelSanchez);
        HORARIOS.add(horario17);

        Horario horario18 = new Horario();
        horario18.setHorarioId(new Integer(1000018));
        cal = new GregorianCalendar(2010, 2, 26, 10, 0);
        horario18.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 26, 10, 30);
        horario18.setFechaFin(cal.getTime());
        horario18.setEspecialidad(cardiologia);
        horario18.setMedico(miguelSanchez);
        HORARIOS.add(horario18);

        Horario horario19 = new Horario();
        horario19.setHorarioId(new Integer(1000019));
        cal = new GregorianCalendar(2010, 2, 26, 10, 30);
        horario19.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 26, 11, 0);
        horario19.setFechaFin(cal.getTime());
        horario19.setEspecialidad(cardiologia);
        horario19.setMedico(miguelSanchez);
        HORARIOS.add(horario19);

        // Cardiología - Sánchez-Palacios Paiva, Miguel - Sábado de 09:00 - 11:00
        Horario horario20 = new Horario();
        horario20.setHorarioId(new Integer(1000020));
        cal = new GregorianCalendar(2010, 2, 27, 9, 0);
        horario20.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 27, 9, 30);
        horario20.setFechaFin(cal.getTime());
        horario20.setEspecialidad(cardiologia);
        horario20.setMedico(miguelSanchez);
        HORARIOS.add(horario20);

        Horario horario21 = new Horario();
        horario21.setHorarioId(new Integer(1000021));
        cal = new GregorianCalendar(2010, 2, 27, 9, 30);
        horario21.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 27, 10, 0);
        horario21.setFechaFin(cal.getTime());
        horario21.setEspecialidad(cardiologia);
        horario21.setMedico(miguelSanchez);
        HORARIOS.add(horario21);

        Horario horario22 = new Horario();
        horario22.setHorarioId(new Integer(1000022));
        cal = new GregorianCalendar(2010, 2, 27, 10, 0);
        horario22.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 27, 10, 30);
        horario22.setFechaFin(cal.getTime());
        horario22.setEspecialidad(cardiologia);
        horario22.setMedico(miguelSanchez);
        HORARIOS.add(horario22);

        Horario horario23 = new Horario();
        horario23.setHorarioId(new Integer(1000023));
        cal = new GregorianCalendar(2010, 2, 27, 10, 30);
        horario23.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 27, 11, 0);
        horario23.setFechaFin(cal.getTime());
        horario23.setEspecialidad(cardiologia);
        horario23.setMedico(miguelSanchez);
        HORARIOS.add(horario23);

        // Hematología - Caravedo Baigorria, José - Martes de 15:00 - 17:00
        Horario horario24 = new Horario();
        horario24.setHorarioId(new Integer(1000024));
        cal = new GregorianCalendar(2010, 2, 23, 15, 0);
        horario24.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 23, 15, 30);
        horario24.setFechaFin(cal.getTime());
        horario24.setEspecialidad(hematologia);
        horario24.setMedico(joseCaravedo);
        HORARIOS.add(horario24);

        Horario horario25 = new Horario();
        horario25.setHorarioId(new Integer(1000025));
        cal = new GregorianCalendar(2010, 2, 23, 15, 30);
        horario25.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 23, 16, 0);
        horario25.setFechaFin(cal.getTime());
        horario25.setEspecialidad(hematologia);
        horario25.setMedico(joseCaravedo);
        HORARIOS.add(horario25);

        Horario horario26 = new Horario();
        horario26.setHorarioId(new Integer(1000026));
        cal = new GregorianCalendar(2010, 2, 23, 16, 0);
        horario26.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 23, 16, 30);
        horario26.setFechaFin(cal.getTime());
        horario26.setEspecialidad(hematologia);
        horario26.setMedico(joseCaravedo);
        HORARIOS.add(horario26);

        Horario horario27 = new Horario();
        horario27.setHorarioId(new Integer(1000027));
        cal = new GregorianCalendar(2010, 2, 23, 16, 30);
        horario27.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 23, 17, 0);
        horario27.setFechaFin(cal.getTime());
        horario27.setEspecialidad(hematologia);
        horario27.setMedico(joseCaravedo);
        HORARIOS.add(horario27);

        // Hematología - Caravedo Baigorria, José - Jueves de 15:00 - 17:00
        Horario horario28 = new Horario();
        horario28.setHorarioId(new Integer(1000028));
        cal = new GregorianCalendar(2010, 2, 25, 15, 0);
        horario28.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 25, 15, 30);
        horario28.setFechaFin(cal.getTime());
        horario28.setEspecialidad(hematologia);
        horario28.setMedico(joseCaravedo);
        HORARIOS.add(horario28);

        Horario horario29 = new Horario();
        horario29.setHorarioId(new Integer(1000029));
        cal = new GregorianCalendar(2010, 2, 25, 15, 30);
        horario29.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 25, 16, 0);
        horario29.setFechaFin(cal.getTime());
        horario29.setEspecialidad(hematologia);
        horario29.setMedico(joseCaravedo);
        HORARIOS.add(horario29);

        Horario horario30 = new Horario();
        horario30.setHorarioId(new Integer(1000030));
        cal = new GregorianCalendar(2010, 2, 25, 16, 0);
        horario30.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 25, 16, 30);
        horario30.setFechaFin(cal.getTime());
        horario30.setEspecialidad(hematologia);
        horario30.setMedico(joseCaravedo);
        HORARIOS.add(horario30);

        Horario horario31 = new Horario();
        horario31.setHorarioId(new Integer(1000031));
        cal = new GregorianCalendar(2010, 2, 25, 16, 30);
        horario31.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 25, 17, 0);
        horario31.setFechaFin(cal.getTime());
        horario31.setEspecialidad(hematologia);
        horario31.setMedico(joseCaravedo);
        HORARIOS.add(horario31);

        // Gastroenterología - Barriga Calle, Eduardo - Lunes de 09:00 - 11:00
        Horario horario32 = new Horario();
        horario32.setHorarioId(new Integer(1000032));
        cal = new GregorianCalendar(2010, 2, 22, 9, 0);
        horario32.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 22, 9, 30);
        horario32.setFechaFin(cal.getTime());
        horario32.setEspecialidad(gastroenterologia);
        horario32.setMedico(eduardoBarriga);
        HORARIOS.add(horario32);

        Horario horario33 = new Horario();
        horario33.setHorarioId(new Integer(1000033));
        cal = new GregorianCalendar(2010, 2, 22, 9, 30);
        horario33.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 22, 10, 0);
        horario33.setFechaFin(cal.getTime());
        horario33.setEspecialidad(gastroenterologia);
        horario33.setMedico(eduardoBarriga);
        HORARIOS.add(horario33);

        Horario horario34 = new Horario();
        horario34.setHorarioId(new Integer(1000034));
        cal = new GregorianCalendar(2010, 2, 22, 10, 0);
        horario34.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 22, 10, 30);
        horario34.setFechaFin(cal.getTime());
        horario34.setEspecialidad(gastroenterologia);
        horario34.setMedico(eduardoBarriga);
        HORARIOS.add(horario34);

        Horario horario35 = new Horario();
        horario35.setHorarioId(new Integer(1000035));
        cal = new GregorianCalendar(2010, 2, 22, 10, 30);
        horario35.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 22, 11, 0);
        horario35.setFechaFin(cal.getTime());
        horario35.setEspecialidad(gastroenterologia);
        horario35.setMedico(eduardoBarriga);
        HORARIOS.add(horario35);

        // Gastroenterología - Barriga Calle, Eduardo - Miércoles de 09:00 - 11:00
        Horario horario36 = new Horario();
        horario36.setHorarioId(new Integer(1000036));
        cal = new GregorianCalendar(2010, 2, 24, 9, 0);
        horario36.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 24, 9, 30);
        horario36.setFechaFin(cal.getTime());
        horario36.setEspecialidad(gastroenterologia);
        horario36.setMedico(eduardoBarriga);
        HORARIOS.add(horario36);

        Horario horario37 = new Horario();
        horario37.setHorarioId(new Integer(1000037));
        cal = new GregorianCalendar(2010, 2, 24, 9, 30);
        horario37.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 24, 10, 0);
        horario37.setFechaFin(cal.getTime());
        horario37.setEspecialidad(gastroenterologia);
        horario37.setMedico(eduardoBarriga);
        HORARIOS.add(horario37);

        Horario horario38 = new Horario();
        horario38.setHorarioId(new Integer(1000038));
        cal = new GregorianCalendar(2010, 2, 24, 10, 0);
        horario38.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 24, 10, 30);
        horario38.setFechaFin(cal.getTime());
        horario38.setEspecialidad(gastroenterologia);
        horario38.setMedico(eduardoBarriga);
        HORARIOS.add(horario38);

        Horario horario39 = new Horario();
        horario39.setHorarioId(new Integer(1000039));
        cal = new GregorianCalendar(2010, 2, 24, 10, 30);
        horario39.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 24, 11, 0);
        horario39.setFechaFin(cal.getTime());
        horario39.setEspecialidad(gastroenterologia);
        horario39.setMedico(eduardoBarriga);
        HORARIOS.add(horario39);

        // Gastroenterología - Barriga Calle, Eduardo - Viernes de 09:00 - 11:00
        Horario horario40 = new Horario();
        horario40.setHorarioId(new Integer(1000040));
        cal = new GregorianCalendar(2010, 2, 26, 9, 0);
        horario40.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 26, 9, 30);
        horario40.setFechaFin(cal.getTime());
        horario40.setEspecialidad(gastroenterologia);
        horario40.setMedico(eduardoBarriga);
        HORARIOS.add(horario40);

        Horario horario41 = new Horario();
        horario41.setHorarioId(new Integer(1000041));
        cal = new GregorianCalendar(2010, 2, 26, 9, 30);
        horario41.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 26, 10, 0);
        horario41.setFechaFin(cal.getTime());
        horario41.setEspecialidad(gastroenterologia);
        horario41.setMedico(eduardoBarriga);
        HORARIOS.add(horario41);

        Horario horario42 = new Horario();
        horario42.setHorarioId(new Integer(1000042));
        cal = new GregorianCalendar(2010, 2, 26, 10, 0);
        horario42.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 26, 10, 30);
        horario42.setFechaFin(cal.getTime());
        horario42.setEspecialidad(gastroenterologia);
        horario42.setMedico(eduardoBarriga);
        HORARIOS.add(horario42);

        Horario horario43 = new Horario();
        horario43.setHorarioId(new Integer(1000043));
        cal = new GregorianCalendar(2010, 2, 26, 10, 30);
        horario43.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 26, 11, 0);
        horario43.setFechaFin(cal.getTime());
        horario43.setEspecialidad(gastroenterologia);
        horario43.setMedico(eduardoBarriga);
        HORARIOS.add(horario43);

        // Gastroenterología - Salazar Cabrera, Fernando - Martes de 15:00 - 17:00
        Horario horario44 = new Horario();
        horario44.setHorarioId(new Integer(1000044));
        cal = new GregorianCalendar(2010, 2, 23, 15, 0);
        horario44.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 23, 15, 30);
        horario44.setFechaFin(cal.getTime());
        horario44.setEspecialidad(gastroenterologia);
        horario44.setMedico(fernandoSalazar);
        HORARIOS.add(horario44);

        Horario horario45 = new Horario();
        horario45.setHorarioId(new Integer(1000045));
        cal = new GregorianCalendar(2010, 2, 23, 15, 30);
        horario45.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 23, 16, 0);
        horario45.setFechaFin(cal.getTime());
        horario45.setEspecialidad(gastroenterologia);
        horario45.setMedico(fernandoSalazar);
        HORARIOS.add(horario45);

        Horario horario46 = new Horario();
        horario46.setHorarioId(new Integer(1000046));
        cal = new GregorianCalendar(2010, 2, 23, 16, 0);
        horario46.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 23, 16, 30);
        horario46.setFechaFin(cal.getTime());
        horario46.setEspecialidad(gastroenterologia);
        horario46.setMedico(fernandoSalazar);
        HORARIOS.add(horario46);

        Horario horario47 = new Horario();
        horario47.setHorarioId(new Integer(1000047));
        cal = new GregorianCalendar(2010, 2, 23, 16, 30);
        horario47.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 23, 17, 0);
        horario47.setFechaFin(cal.getTime());
        horario47.setEspecialidad(gastroenterologia);
        horario47.setMedico(fernandoSalazar);
        HORARIOS.add(horario47);

        // Gastroenterología - Salazar Cabrera, Fernando - Jueves de 15:00 - 17:00
        Horario horario48 = new Horario();
        horario48.setHorarioId(new Integer(1000048));
        cal = new GregorianCalendar(2010, 2, 25, 15, 0);
        horario48.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 25, 15, 30);
        horario48.setFechaFin(cal.getTime());
        horario48.setEspecialidad(gastroenterologia);
        horario48.setMedico(fernandoSalazar);
        HORARIOS.add(horario48);

        Horario horario49 = new Horario();
        horario49.setHorarioId(new Integer(1000049));
        cal = new GregorianCalendar(2010, 2, 25, 15, 30);
        horario49.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 25, 16, 0);
        horario49.setFechaFin(cal.getTime());
        horario49.setEspecialidad(gastroenterologia);
        horario49.setMedico(fernandoSalazar);
        HORARIOS.add(horario49);

        Horario horario50 = new Horario();
        horario50.setHorarioId(new Integer(1000050));
        cal = new GregorianCalendar(2010, 2, 25, 16, 0);
        horario50.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 25, 16, 30);
        horario50.setFechaFin(cal.getTime());
        horario50.setEspecialidad(gastroenterologia);
        horario50.setMedico(fernandoSalazar);
        HORARIOS.add(horario50);

        Horario horario51 = new Horario();
        horario51.setHorarioId(new Integer(1000051));
        cal = new GregorianCalendar(2010, 2, 25, 16, 30);
        horario51.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 25, 17, 0);
        horario51.setFechaFin(cal.getTime());
        horario51.setEspecialidad(gastroenterologia);
        horario51.setMedico(fernandoSalazar);
        HORARIOS.add(horario51);

        // Hematología - Salazar Cabrera, Fernando - Sabado de 09:00 - 11:00
        Horario horario52 = new Horario();
        horario52.setHorarioId(new Integer(1000052));
        cal = new GregorianCalendar(2010, 2, 27, 9, 0);
        horario52.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 27, 9, 30);
        horario52.setFechaFin(cal.getTime());
        horario52.setEspecialidad(hematologia);
        horario52.setMedico(fernandoSalazar);
        HORARIOS.add(horario52);

        Horario horario53 = new Horario();
        horario53.setHorarioId(new Integer(1000053));
        cal = new GregorianCalendar(2010, 2, 27, 9, 30);
        horario53.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 27, 10, 0);
        horario53.setFechaFin(cal.getTime());
        horario53.setEspecialidad(hematologia);
        horario53.setMedico(fernandoSalazar);
        HORARIOS.add(horario53);

        Horario horario54 = new Horario();
        horario54.setHorarioId(new Integer(1000054));
        cal = new GregorianCalendar(2010, 2, 27, 10, 0);
        horario54.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 27, 10, 30);
        horario54.setFechaFin(cal.getTime());
        horario54.setEspecialidad(hematologia);
        horario54.setMedico(fernandoSalazar);
        HORARIOS.add(horario54);

        Horario horario55 = new Horario();
        horario55.setHorarioId(new Integer(1000055));
        cal = new GregorianCalendar(2010, 2, 27, 10, 30);
        horario55.setFechaInicio(cal.getTime());
        cal = new GregorianCalendar(2010, 2, 27, 11, 0);
        horario55.setFechaFin(cal.getTime());
        horario55.setEspecialidad(hematologia);
        horario55.setMedico(fernandoSalazar);
        HORARIOS.add(horario55);

        //Citas
        Cita cita = new Cita();
        cita.setCitaId(new Integer(1000000));
        cita.setEstado("RESERVADO");
        cita.setHorario(horario34);
        cita.setMedico(eduardoBarriga);
        cita.setPaciente(albertoFranco);
        CITAS.add(cita);
        horario34.setCita(cita);

        cita = new Cita();
        cita.setCitaId(new Integer(1000001));
        cita.setEstado("RESERVADO");
        cita.setHorario(horario04);
        cita.setMedico(jorgeCasana);
        cita.setPaciente(juanMatzumura);
        CITAS.add(cita);
        horario04.setCita(cita);

        cita = new Cita();
        cita.setCitaId(new Integer(1000002));
        cita.setEstado("RESERVADO");
        cita.setHorario(horario54);
        cita.setMedico(fernandoSalazar);
        cita.setPaciente(anaTalavera);
        CITAS.add(cita);
        horario54.setCita(cita);

        cita = new Cita();
        cita.setCitaId(new Integer(1000003));
        cita.setEstado("RESERVADO");
        cita.setHorario(horario47);
        cita.setMedico(fernandoSalazar);
        cita.setPaciente(anaTalavera);
        CITAS.add(cita);
        horario47.setCita(cita);

        // Horarios disponibles
        Calendar calAux = new GregorianCalendar();
        Calendar[] atencion = new Calendar[2];
        cal.set(Calendar.HOUR_OF_DAY, 8);
        calAux.setTimeInMillis(cal.getTimeInMillis());
        atencion[0] = calAux;
        //System.out.println("Inicio: " + calAux.get(Calendar.HOUR_OF_DAY) + ":" + calAux.get(Calendar.MINUTE));
        while(cal.get(Calendar.HOUR_OF_DAY) < 21){
            cal.add(Calendar.MINUTE, 30);
            calAux = new GregorianCalendar();
            calAux.setTimeInMillis(cal.getTimeInMillis());
            atencion[1] = calAux;
            //System.out.println("Fin: " + calAux.get(Calendar.HOUR_OF_DAY) + ":" + calAux.get(Calendar.MINUTE));
            Horario horario = new Horario();
            horario.setFechaInicio(atencion[0].getTime());
            horario.setFechaFin(atencion[1].getTime());
            HORARIO_ATENCION.add(horario);
            atencion = new Calendar[2];
            calAux = new GregorianCalendar();
            calAux.setTimeInMillis(cal.getTimeInMillis());
            atencion[0] = calAux;
            //System.out.println("Inicio: " + calAux.get(Calendar.HOUR_OF_DAY) + ":" + calAux.get(Calendar.MINUTE));
        }
    }

    public static void main(String arg[]){
        CargaData.inicializar();
        for(int i = 0; i < HORARIO_ATENCION.size(); i++){
            System.out.println(HORARIO_ATENCION.get(i).getRango());
        }
    }
}
