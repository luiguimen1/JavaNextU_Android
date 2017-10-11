/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import DAO.HistorialDAO;
import DAO.MedicoDAO;
import DAO.PacienteDAO;
import VO.HistorialVO;
import VO.MedicoVO;
import VO.PacienteVO;

/**
 *
 * @author Lic. Luis Eduardo Alvarez Meneses
 */
public class Menu {

    private PacienteDAO GrPct = new PacienteDAO();
    private MedicoDAO GrMdc = new MedicoDAO();
    private HistorialDAO GrHtl = new HistorialDAO();
    private Pantalla op = new Pantalla();

    /**
     * Metodo constructor
     */
    public Menu() {
    }

    /**
     * Metodo que permite mostrar el menu de opciones principales a ejecutar
     */
    public void principal() {
        int opciones = 0;
        do {
            opciones = op.capInt("CLINICA LA EVALUACIÓN\n\n"
                    + "1. Gestionar Pacientes.\n"
                    + "2. Gestionar Médicos.\n"
                    + "3. Gestionar Historial Clínico.\n"
                    + "4. Salir");
            switch (opciones) {
                case 1:
                    gesPaciente();
                    break;
                case 2:
                    gesMedico();
                    break;
                case 3:
                    gesHistoria();
                    break;
                case 4:
                    op.mensaje("Hasta la proxima");
                    break;
                default:
                    op.mensajeError("La opcione Ingresada no es valida");
                    break;
            }
        } while (opciones != 4);
    }

    public int opciones(String tipo) {
        return op.capInt("CLINICA LA EVALUACIÓN\n\n"
                + "1. Registrar " + tipo + ".\n"
                + "2. Mostrar " + tipo + ".\n"
                + "3. Modificar " + tipo + ".\n"
                + "4. Eliminar " + tipo + ".\n"
                + "5. Atrás");
    }

    public void gesPaciente() {
        int opciones = 0;
        do {
            opciones = opciones("Persona");
            switch (opciones) {
                case 1: //Agregar
                    int id = op.capInt("Ingrese la identificacón");
                    String nom = op.capString("Ingrese el nombre");
                    String ape = op.capString("Ingrese el apellido");
                    int ed = op.capInt("Ingrese la edad");
                    char gen = op.genero();
                    if (GrPct.agregar(id, nom, ape, ed, gen)) {
                        op.mensaje("El paciente Fue almacenado");
                        PacienteVO UnPac = GrPct.buscar(id);
                        String MSN = "El paciente fue registrado asi :\n"
                                + "Identificación :" + UnPac.getId() + "\n"
                                + "Nombre: " + UnPac.getNombre() + "\n"
                                + "Apellido: " + UnPac.getApellido() + "\n"
                                + "Edad: " + UnPac.getEdad() + "\n"
                                + "Genero: " + UnPac.getGenero();
                        op.mensaje(MSN);
                    } else {
                        op.mensajeError("El paciente ya existe");
                    }
                    break;
                case 2: //Mostrar
                    op.mensaje(GrPct.Lista());
                    break;
                case 3: //Modificar
                    PacienteVO UnPac = GrPct.buscar(op.capInt("ingrese la identificación"));
                    if (UnPac != null) {
                        String pValor = op.capStrDefi("Desea cambiar el Nombre ", UnPac.getNombre());
                        UnPac.setNombre(pValor == null ? UnPac.getNombre() : pValor);
                        pValor = op.capStrDefi("Desea cambiar el Apellido", UnPac.getApellido());
                        UnPac.setApellido(pValor == null ? UnPac.getApellido() : pValor);
                        int pV = op.capIntDefi("Desea cambiar Edad \n\tSi no Desea cambiarla puede 1\n\tdar aceptar y queda la misma ", "" + UnPac.getEdad());
                        UnPac.setEdad(pV);
                        UnPac.setGenero(op.genero());
                        String MSN = "Los datos del paciente quedaron asi:\n"
                                + "Identificación :" + UnPac.getId() + "\n"
                                + "Nombre: " + UnPac.getNombre() + "\n"
                                + "Apellido: " + UnPac.getApellido() + "\n"
                                + "Edad: " + UnPac.getEdad() + "\n"
                                + "Genero: " + UnPac.getGenero();
                        op.mensaje(MSN);
                    } else {
                        op.mensajeError("El paciente no esta");
                    }
                    break;
                case 4: //Eliminar
                    if (GrPct.size() != 0) {
                        int pos = op.capInt("Ingrese la POS del paciente a eliminar\n" + GrPct.Lista()) - 1;
                        if (GrPct.remover(pos)) {
                            op.mensaje("El Paciente fue eliminado");
                        } else {
                            op.mensajeError("El paciente no fue eliminado");
                        }
                    } else {
                        op.mensajeError("No hay Pacientes1");
                    }
                    break;
                case 5: //Retroceder
                    break;
                default: //Error de Selección
                    op.mensajeError("Opsss!!!\n La opcion seleccionada no es valida.");
                    break;
            }
        } while (opciones != 5);
    }

    public void gesMedico() {
        int opciones = 0;
        do {
            opciones = opciones("Medico");
            switch (opciones) {
                case 1: //Agregar
                    int id = op.capInt("Ingrese la identificacón");
                    String nom = op.capString("Ingrese el nombre");
                    String ape = op.capString("Ingrese el apellido");
                    String esp = op.capString("Ingrese la Especialidad");
                    if (GrMdc.agregar(id, nom, ape, esp)) {
                        MedicoVO UnMdc = GrMdc.buscar(id);
                        String MSN = "El Medico quedo registrado asi:\n"
                                + "Identificación :" + UnMdc.getId() + "\n"
                                + "Nombre: " + UnMdc.getNombre() + "\n"
                                + "Apellido: " + UnMdc.getApellido() + "\n"
                                + "Especialidad: " + UnMdc.getEsp();
                        op.mensaje(MSN);

                    } else {
                        op.mensajeError("El Medico ya existe");
                    }
                    break;
                case 2: //Mostrar
                    op.mensaje(GrMdc.Lista());
                    break;
                case 3: //Modificar
                    MedicoVO UnMdc = GrMdc.buscar(op.capInt("ingrese la identificación"));
                    if (UnMdc != null) {
                        String pValor = op.capStrDefi("Desea cambiar el Nombre ", UnMdc.getNombre());
                        UnMdc.setNombre(pValor == null ? UnMdc.getNombre() : pValor);
                        pValor = op.capStrDefi("Desea cambiar el Apellido", UnMdc.getApellido());
                        UnMdc.setApellido(pValor == null ? UnMdc.getApellido() : pValor);

                        pValor = op.capStrDefi("Desea cambiar el Apellido", UnMdc.getApellido());
                        UnMdc.setApellido(pValor == null ? UnMdc.getApellido() : pValor);

                        pValor = op.capStrDefi("Desea cambiar el Apellido", UnMdc.getEsp());
                        UnMdc.setApellido(pValor == null ? UnMdc.getApellido() : pValor);

                        String MSN = "Los datos del paciente quedaron asi:\n"
                                + "Identificación :" + UnMdc.getId() + "\n"
                                + "Nombre: " + UnMdc.getNombre() + "\n"
                                + "Apellido: " + UnMdc.getApellido() + "\n"
                                + "Especialidad: " + UnMdc.getEsp();
                        op.mensaje(MSN);
                    } else {
                        op.mensajeError("El Medico no esta");
                    }
                    break;
                case 4: //Eliminar
                    if (GrMdc.size() != 0) {
                        int pos = op.capInt("Ingrese la POS del Medico a eliminar\n" + GrPct.Lista()) - 1;
                        if (GrMdc.remover(pos)) {
                            op.mensaje("El Medico fue eliminado");
                        } else {
                            op.mensajeError("El Medico no fue eliminado");
                        }
                    } else {
                        op.mensajeError("No hay Pacientes1");
                    }
                    break;
                case 5: //Retroceder
                    break;
                default: //Error de Selección
                    op.mensajeError("Opsss!!!\n La opcion seleccionada no es valida.");
                    break;
            }
        } while (opciones != 5);
    }

    public void gesHistoria() {
        int opciones = 0;
        do {
            opciones = opciones("Historial");
            switch (opciones) {
                case 1: //Agregar
                    int cod = (GrHtl.size() + 1);
                    String fecha = op.capString("Ingrese la Fecha");
                    int idP = op.capInt("Ingrese el codigo del paciente \n" + GrPct.Lista());
                    int idM = op.capInt("Ingrese el codigo del paciente \n" + GrMdc.Lista());
                    String Obser = op.capString("Ingrese las Observaciones");
                    if (GrHtl.agregar(cod, fecha, idP, idM, Obser)) {
                        HistorialVO UnHTL = GrHtl.buscar(cod);
                        String MSN = "El historia fue creado asi:\n"
                                + "Codigo: " + UnHTL.getCod() + "\n"
                                + "Paciente: " + GrPct.buscar(UnHTL.getIdP()).getApellido() + "\n"
                                + "Medico: " + GrMdc.buscar(UnHTL.getIdM()).getApellido() + "\n"
                                + "Observaciones: " + UnHTL.getObs();
                        op.mensaje(MSN);
                    } else {
                        op.mensajeError("El Medico ya existe");
                    }
                    break;
                case 2: //Mostrar
                    op.mensaje(GrHtl.Lista());
                    break;
                case 3: //Modificar
                    HistorialVO UnHTL = GrHtl.buscar(op.capInt("ingrese el Código"));
                    if (UnHTL != null) {
                        idP = op.capIntDefi("Seleccion el codigo del paciente \n" + GrPct.Lista(), "" + UnHTL.getIdP());
                        UnHTL.setIdP(idP);

                        idM = op.capIntDefi("Seleccion el codigo del medico \n" + GrMdc.Lista(), "" + UnHTL.getIdM());
                        UnHTL.setIdP(idP);

                        String pValor = op.capStrDefi("Desea cambiar la fecha ", UnHTL.getFec());
                        UnHTL.setFec(pValor == null ? UnHTL.getFec() : pValor);

                        pValor = op.capStrDefi("Desea cambiar las Observaciones", UnHTL.getObs());
                        UnHTL.setFec(pValor == null ? UnHTL.getFec() : pValor);

                        String MSN = "Los datos de la historia quedaron asi:\n"
                                + "Codigo: " + UnHTL.getCod() + "\n"
                                + "Paciente: " + GrPct.buscar(UnHTL.getIdP()).getApellido() + "\n"
                                + "Medico: " + GrMdc.buscar(UnHTL.getIdM()).getApellido() + "\n"
                                + "Observaciones: " + UnHTL.getObs();
                        op.mensaje(MSN);
                    } else {
                        op.mensajeError("El Medico no esta");
                    }
                    break;
                case 4: //Eliminar
                    if (GrMdc.size() != 0) {
                        int pos = op.capInt("Ingrese la POS del Medico a eliminar\n" + GrPct.Lista()) - 1;
                        if (GrMdc.remover(pos)) {
                            op.mensaje("El Medico fue eliminado");
                        } else {
                            op.mensajeError("El Medico no fue eliminado");
                        }
                    } else {
                        op.mensajeError("No hay Pacientes1");
                    }
                    break;
                case 5: //Retroceder
                    break;
                default: //Error de Selección
                    op.mensajeError("Opsss!!!\n La opcion seleccionada no es valida.");
                    break;
            }
        } while (opciones != 5);
    }

}
