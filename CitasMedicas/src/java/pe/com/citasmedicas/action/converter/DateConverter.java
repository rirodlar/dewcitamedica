package pe.com.citasmedicas.action.converter;

import com.opensymphony.xwork2.conversion.TypeConversionException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.apache.struts2.util.StrutsTypeConverter;

/**
 * Esta clase contiene los métodos utilizados para manejar conversión de fechas en Struts
 * @author dew - Grupo 04
 */
public class DateConverter extends StrutsTypeConverter {

    /**
     * Convierte una o más cadenas a una clase especificada
     * @param context Acción del contexto
     * @param values Valores de cadena a ser convertidos, tales como los enviados por el formulario HTML
     * @param toClass Clase a la cual se convertirá
     * @return Fecha obtenida desde cadena
     */
    @Override
    public Object convertFromString(Map context, String[] values, Class toClass) {
        if (values != null && values.length > 0 &&
                values[0] != null && values[0].length() > 0) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            try {
                return sdf.parse(values[0]);
            } catch (ParseException e) {
                throw new TypeConversionException(e);
            }
        }
        return null;
    }

    /**
     * Convierte un objeto especificado a cadena
     * @param context Acción del contexto
     * @param o Objeto a ser convertido
     * @return Cadena convertida,  en este caso a formato dia/mes/anio
     */
    @Override
    public String convertToString(Map context, Object o) {
        if (o instanceof Date) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return sdf.format((Date) o);
        }
        return "";
    }
}
