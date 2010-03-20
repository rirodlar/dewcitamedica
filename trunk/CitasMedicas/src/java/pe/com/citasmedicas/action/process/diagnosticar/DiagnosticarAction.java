package pe.com.citasmedicas.action.process.diagnosticar;

import pe.com.citasmedicas.action.BaseAction;

/**
 *
 * @author dew - Grupo 04
 */
public class DiagnosticarAction extends BaseAction{

    @Override
    public String execute() {
        try {
            return SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("errorMsg", ex.getMessage());
            return ERROR;
        }
    }
}
