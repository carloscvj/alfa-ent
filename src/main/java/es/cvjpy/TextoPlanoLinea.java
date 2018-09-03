/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cvjpy;

import java.io.Serializable;

/**
 *
 * @author carlos
 */
public class TextoPlanoLinea extends InformeLinea implements Serializable {

    public TextoPlanoLinea(String mensaje) {
        getCampos().put("linea", mensaje);
    }

    @Override
    public String toString() {
        return getCampos().get("linea").toString();
    }

}
