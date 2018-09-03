/*
 * InformeLinea.java
 *
 * Created on 12 de noviembre de 2007, 11:01
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package es.cvjpy;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author CarlosVJ
 */
public class InformeLinea implements Serializable {

    private Map campos;

    public Map getCampos() {
        if (campos == null) {
            campos = new HashMap();
        }
        return campos;
    }

    public Object getValorCampo(String nombre) {
        return getCampos().get(nombre);
    }

}
