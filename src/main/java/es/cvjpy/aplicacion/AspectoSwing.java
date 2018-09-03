/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cvjpy.aplicacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 *
 * @author carlos
 */
public final class AspectoSwing implements Serializable {

    private List<String> listaLooks;
    private String lineaSelected;

    public AspectoSwing() {
    }

    public AspectoSwing(Properties prop) throws Exception {
        this();
        if (prop != null) {
            fromProperties(prop);
        }
    }

    private List<String> crearListaLooks() {
        List<String> ret = new ArrayList();
        for (LookAndFeelInfo uno : Arrays.asList(UIManager.getInstalledLookAndFeels())) {
            ret.add(uno.getClassName());
        }
        return ret;
    }

    public final void fromProperties(Properties prop) {
        lineaSelected = prop.getProperty("aspectoswing.classname", "javax.swing.plaf.metal.MetalLookAndFeel");
    }

    public Properties toProperties(Properties prop) {
        prop.setProperty("aspectoswing.classname", getLineaSelected());
        return prop;
    }


    public List<String> getListaLooks() {
        if (listaLooks == null) {
            listaLooks = crearListaLooks();
        }
        return listaLooks;
    }

    public String getLineaSelected() {
        if (lineaSelected == null) {
            lineaSelected = "javax.swing.plaf.metal.MetalLookAndFeel";
        }
        return lineaSelected;
    }

    public void setLineaSelected(String lineaSelected) throws Exception {
        this.lineaSelected = lineaSelected;
    }
}
