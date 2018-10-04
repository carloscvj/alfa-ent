/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cvjpy.cobol;

import es.cvjpy.aplicacion.VersionAlfa;
import java.util.Properties;

/**
 *
 * @author CarlosVJ
 */
public class EntornoCobolLocal implements java.io.Serializable {

    private final String base;
    private String LD_LIBRARY_PATH;
    private String COBDIR;
    private String COBPATH = "";
    private String COBSW;
    private boolean COBDEBUG = false;
    private boolean montado = false;
    private String baseCOBPATH;
    private String instalacion;
    private String cob_library_path;
    private String carpetaProyecto;
    private String viejos;
    private String alfa;
    private String PATH;

    public EntornoCobolLocal(String base) {
        this.base = base;
    }

    public String getLD_LIBRARY_PATH() {
        if (LD_LIBRARY_PATH == null) {
            LD_LIBRARY_PATH = System.getenv("LD_LIBRARY_PATH");
            if (LD_LIBRARY_PATH == null) {
                LD_LIBRARY_PATH = "/opt/lib/cobol/coblib";
            }
        }
        return LD_LIBRARY_PATH;
    }

    public void setLD_LIBRARY_PATH(String LD_LIBRARY_PATH) {
        this.LD_LIBRARY_PATH = LD_LIBRARY_PATH;
    }

    public String getCOBDIR() {
        if (COBDIR == null) {
            COBDIR = System.getenv("COBDIR");
            if (COBDIR == null) {
                COBDIR = "/opt/lib/cobol";
            }
        }
        return COBDIR;
    }

    public void setCOBDIR(String COBDIR) {
        this.COBDIR = COBDIR;
    }

    public String getCOBPATH() {
        return COBPATH;
    }

    public void setCOBPATH(String COBPATH) {
        this.COBPATH = COBPATH;
    }

    public String getCOBSW() {
        if (COBSW == null) {
            COBSW = System.getenv("COBSW");
            if (COBSW == null) {
                COBSW = "-F";
            }
        }
        return COBSW;
    }

    public void setCOBSW(String COBSW) {
        this.COBSW = COBSW;
    }

    public void fromProperties(Properties prop) {
        LD_LIBRARY_PATH = prop.getProperty("LD_LIBRARY_PATH", this.getLD_LIBRARY_PATH());
        COBDIR = prop.getProperty("COBDIR", this.getCOBDIR());
        COBSW = prop.getProperty("COBSW", "" + this.getCOBSW());
        COBDEBUG = Boolean.parseBoolean(prop.getProperty("COBDEBUG", "" + this.isCOBDEBUG()));
    }

    public Properties toProperties(Properties prop) {
        prop.setProperty("LD_LIBRARY_PATH", this.getLD_LIBRARY_PATH());
        prop.setProperty("COBDIR", this.getCOBDIR());
        prop.setProperty("COBSW", "" + this.getCOBSW());
        prop.setProperty("COBDEBUG", "" + this.isCOBDEBUG());
        prop.setProperty("COBPATH", "" + this.getCOBPATH());
        prop.setProperty("INSTALACION", this.getInstalacion());
        prop.setProperty("COB_LIBRARY_PATH", this.getCob_library_path());
        prop.setProperty("VIEJOS", this.getViejos());
        prop.setProperty("ALFA", this.getAlfa());
        prop.setProperty("PATH", "" + this.getPATH());
        return prop;
    }

    public boolean isCOBDEBUG() {
        return COBDEBUG;
    }

    public void setCOBDEBUG(boolean COBDEBUG) {
        this.COBDEBUG = COBDEBUG;
    }

    public boolean isMontado() {
        return montado;
    }

    public void setMontado(boolean montado) {
        this.montado = montado;
    }

    public String getBaseCOBPATH() {
        if (baseCOBPATH == null) {
            baseCOBPATH = getInstalacion() + "/" + getCarpetaProyecto() + "/exe";
        }
        return baseCOBPATH;
    }

    public void setBaseCOBPATH(String baseCOBPATH) {
        this.baseCOBPATH = baseCOBPATH;
    }

    public String getInstalacion() {
        if (instalacion == null) {
            instalacion = System.getenv("INSTALACION");
            if (instalacion == null) {
                instalacion = "/usr/local";
            }
        }
        return instalacion;
    }

    public String getCob_library_path() {
        return getInstalacion() + "/lib";
    }

    public void setCob_library_path(String cob_library_path) {
        this.cob_library_path = cob_library_path;
    }

    public void setInstalacion(String instalacion) {
        this.instalacion = instalacion;
    }

    public String getPATH() {
        if (PATH == null) {
            PATH = getInstalacion() + "/" + getCarpetaProyecto() + ":" + System.getenv("PATH");
        }
        return PATH;
    }

    public String getViejos() {
        if (viejos == null) {
            viejos = System.getenv("VIEJOS");
            if (viejos == null) {
                viejos = "";
            }
        }
        return viejos;
    }

    public void setViejos(String viejos) {
        this.viejos = viejos;
    }

    public String getAlfa() {
        if (alfa == null) {
            alfa = System.getenv("ALFA");
            if (alfa == null) {
                alfa = getViejos() + "/ALFA";
            }
        }
        return alfa;
    }

    public void setAlfa(String alfa) {
        this.alfa = alfa;
    }

    public String getCarpetaProyecto() {
        if (carpetaProyecto == null) {
            carpetaProyecto = getVersionAlfa().getCarpeta();
        }
        return carpetaProyecto;
    }

    public void setCarpetaProyecto(String carpetaProyecto) {
        this.carpetaProyecto = carpetaProyecto;
    }

    public VersionAlfa getVersionAlfa() {
        return VersionAlfa.get(base);
    }

}
