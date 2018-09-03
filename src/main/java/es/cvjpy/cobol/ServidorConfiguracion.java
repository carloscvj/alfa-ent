/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cvjpy.cobol;

import es.cvjpy.aplicacion.VersionAlfa;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 *
 * @author CarlosVJ
 */
public class ServidorConfiguracion implements Serializable {

    private final String appBase;
    private final String userName;
    private String nombreFileEntorno;
    private Properties properties;
    private Boolean mostrarInicial;
    private EntornoCobol entornoCobol;

    public ServidorConfiguracion(String appBase, String userName) {
        this.appBase = appBase;
        this.userName = userName;
    }

    private String getCarpetaTrabajo() {
        String ret = new File("").getAbsolutePath();
        return ret;
    }

    private String getCarpetaApps() {
        return System.getProperty("user.home", getCarpetaTrabajo()) + "/.alfa/apps";
    }

    private String crearNombreFileEntorno() {
        String ret;
        ret = getCarpetaApps() + "/" + getAppBase().trim() + ".properties";
        String padre = new File(ret).getParentFile().getAbsolutePath();
        new File(padre).mkdirs();
        return ret;
    }

    public String getAppBase() {
        return appBase;
    }

    public String getUserName() {
        return userName;
    }

    public String getNombreFileEntorno() {
        if (nombreFileEntorno == null) {
            nombreFileEntorno = crearNombreFileEntorno();
        }
        return nombreFileEntorno;
    }

    private Properties leerConfiguracion() throws Exception {
        Properties misprop = new Properties();
        File ficheroprop = new File(getNombreFileEntorno());
        if (ficheroprop.exists()) {
            misprop.load(new FileInputStream(ficheroprop));
            //Logger.getLogger(ConfiguracionCBLAbs.class.getName()).log(Level.INFO, "configuracion de " + getBase() + " leidas desde:{0}", ficheroprop.getAbsolutePath());
        } else {
            ResourceBundle bunle = ResourceBundle.getBundle("configuracion");
            if (bunle != null) {
                for (String cada : bunle.keySet()) {
                    misprop.setProperty(cada, bunle.getString(cada));
                }
                //Logger.getLogger(ConfiguracionCBLAbs.class.getName()).log(Level.INFO, "configuracion de " + getBase() + " leidas desde resource:{0}", "configuracion");
            }
        }
        return misprop;
    }

    private void guardarProp(Properties prop, String nombreFileEntorno) throws Exception {
        File ficheroprop = new File(nombreFileEntorno);
        FileOutputStream fo = new FileOutputStream(ficheroprop);
        prop.store(fo, ficheroprop.getName());
        fo.close();
    }

    public Properties getProperties() throws Exception {
        if (properties == null) {
            properties = leerConfiguracion();
        }
        return properties;
    }

    public Boolean getMostrarInicial() throws Exception {
        if (mostrarInicial == null) {
            mostrarInicial = Boolean.parseBoolean(getProperties().getProperty("cobolservidor.mostrarinicial", "false"));
        }
        return mostrarInicial;
    }

    public void setMostrarInicial(Boolean mostrarInicial) {
        this.mostrarInicial = mostrarInicial;
    }

    public Properties toProperties() throws Exception {
        Properties misprop = getProperties();
        misprop.setProperty("cobolservidor.mostrarinicial", "" + this.getMostrarInicial());
        misprop=getEntornoCobol().toProperties(misprop);
        return misprop;
    }

    public void grabar() throws Exception {
        guardarProp(toProperties(), getNombreFileEntorno());
    }

    public EntornoCobol getEntornoCobol() throws Exception {
        if (entornoCobol == null) {
            entornoCobol = new EntornoCobol(getAppBase());
            entornoCobol.fromProperties(getProperties());            

        }
        return entornoCobol;
    }

    public VersionAlfa getVersionAlfa() {
        return VersionAlfa.get(getAppBase());
    }
}
