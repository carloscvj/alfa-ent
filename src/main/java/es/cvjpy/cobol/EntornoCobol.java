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
public class EntornoCobol implements java.io.Serializable {

    private final String base;

    private String usuario;
    private String dd_dir;
    private String dd_mnu;
    private String dd_trz;
    private String dd_tmp;
    private String dd_rom;
    private String dd_obj;
    private String charSet;
    private boolean local = false;
    private String enlace;// = "es.cvjpy.cobol.Enlace";
    private String lanza;// = "es.cvjpy.cobol.Lanza";
    private String llamador;// = "es.cvjpy.cobol.Modulollamar";
    private EntornoCobolLocal entornoLocal;
    private EntornoCobolRemoto entornoRemoto;

    public EntornoCobol(String base) {
        this.base = base;
    }

    public boolean isLocal() {
        return local;
    }

    public void setLocal(boolean local) {
        this.local = local;
        if (local) {
            this.setRemoto(false);
            this.setEnlace("es.cvjpy.cobol.EnlaceLocal");
            this.setLanza("es.cvjpy.cobol.LanzaLocal");
            this.setLlamador("es.cvjpy.cobol.LlamarLocal");
        }
    }

    public boolean isRemoto() {
        return !local;
    }

    public void setRemoto(boolean remoto) {
        if (remoto) {
            this.setLocal(false);
            this.setEnlace("es.cvjpy.cobol.Enlace");
            this.setLanza("es.cvjpy.cobol.Lanza");
            this.setLlamador("es.cvjpy.cobol.Modulollamar");
        }
    }

    public String getEnlace() {
        if (enlace == null) {
            enlace = "es.cvjpy.cobol.Enlace";
        }
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public String getLanza() {
        if (lanza == null) {
            lanza = "es.cvjpy.cobol.Lanza";
        }
        return lanza;
    }

    public void setLanza(String lanza) {
        this.lanza = lanza;
    }

    public String getLlamador() {
        if (llamador == null) {
            llamador = "es.cvjpy.cobol.Modulollamar";
        }
        return llamador;
    }

    public void setLlamador(String llamador) {
        this.llamador = llamador;
    }

    public EntornoCobolLocal getEntornoLocal() {
        if (entornoLocal == null) {
            entornoLocal = new EntornoCobolLocal(base);
        }
        return entornoLocal;
    }

    public EntornoCobolRemoto getEntornoRemoto() {
        if (entornoRemoto == null) {
            entornoRemoto = new EntornoCobolRemoto(base);
        }
        return entornoRemoto;
    }

    public final void fromProperties(Properties prop) {
        usuario = prop.getProperty("cobolservidor.usuario", this.getUsuario());
        dd_dir = prop.getProperty("cobolservidor.dd_dir", this.getDd_dir());
        dd_mnu = prop.getProperty("cobolservidor.dd_mnu", this.getDd_mnu());
        dd_trz = prop.getProperty("cobolservidor.dd_trz", this.getDd_trz());
        dd_tmp = prop.getProperty("cobolservidor.dd_tmp", this.getDd_tmp());
        dd_rom = prop.getProperty("cobolservidor.dd_rom", this.getDd_rom());
        dd_obj = prop.getProperty("cobolservidor.dd_obj", this.getDd_obj());
        charSet = prop.getProperty("cobolservidor.charset", this.getCharSet());
        local = Boolean.parseBoolean(prop.getProperty("cobolservidor.local", "" + this.isLocal()));

        //Estas tres se establecen cuando se establece cobolservidor.local -------------------
        //this.setEnlace(prop.getProperty("cobolservidor.enlace", this.getEnlace()));
        //this.setLanza(prop.getProperty("cobolservidor.lanza", "" + this.getLanza()));
        //this.setLlamador(prop.getProperty("cobolservidor.llamador", "" + this.getLlamador()));
        //---------------------------------------------------------------------------------------
        entornoLocal = new EntornoCobolLocal(base);
        entornoLocal.fromProperties(prop);
        entornoRemoto = new EntornoCobolRemoto(base);
        entornoRemoto.fromProperties(prop);
    }

    public Properties toProperties(Properties prop) {
        //prop.setProperty("cobolservidor.usuario", this.getUsuario());
        prop.setProperty("cobolservidor.dd_dir", this.getDd_dir());
        prop.setProperty("cobolservidor.dd_mnu", this.getDd_mnu());
        prop.setProperty("cobolservidor.dd_trz", this.getDd_trz());
        prop.setProperty("cobolservidor.dd_tmp", this.getDd_tmp());
        prop.setProperty("cobolservidor.dd_rom", this.getDd_rom());
        prop.setProperty("cobolservidor.dd_obj", this.getDd_obj());
        prop.setProperty("cobolservidor.charset", this.getCharSet());
        prop.setProperty("cobolservidor.local", "" + this.isLocal());
        prop.setProperty("cobolservidor.enlace", this.getEnlace());
        prop.setProperty("cobolservidor.lanza", "" + this.getLanza());
        prop.setProperty("cobolservidor.llamador", "" + this.getLlamador());

        prop = getEntornoLocal().toProperties(prop);
        prop = getEntornoRemoto().toProperties(prop);

        return prop;
    }

    public String getUsuario() {
        if (usuario == null) {
            usuario = System.getProperty("user.name", "usuario de cobol");
        }
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDd_dir() {
        if (dd_dir == null) {
            dd_dir = "/ALFA/FILES";
        }
        return dd_dir;
    }

    public void setDd_dir(String dd_dir) {
        this.dd_dir = dd_dir;
    }

    public String getDd_mnu() {
        if (dd_mnu == null) {
            dd_mnu = "/ALFA/MENU";
        }
        return dd_mnu;
    }

    public void setDd_mnu(String dd_mnu) {
        this.dd_mnu = dd_mnu;
    }

    public String getDd_trz() {
        if (dd_trz == null) {
            dd_trz = "/ALFA/TRAZA";
        }
        return dd_trz;
    }

    public void setDd_trz(String dd_trz) {
        this.dd_trz = dd_trz;
    }

    public String getDd_tmp() {
        if (dd_tmp == null) {
            dd_tmp = "/ALFA/tmp";
        }
        return dd_tmp;
    }

    public void setDd_tmp(String dd_tmp) {
        this.dd_tmp = dd_tmp;
    }

    public String getDd_rom() {
        if (dd_rom == null) {
            dd_rom = "/ALFA/rom";
        }
        return dd_rom;
    }

    public void setDd_rom(String dd_rom) {
        this.dd_rom = dd_rom;
    }

    public String getDd_obj() {
        if (dd_obj == null) {
            dd_obj = "/ALFA/obj";
        }
        return dd_obj;
    }

    public void setDd_obj(String dd_obj) {
        this.dd_obj = dd_obj;
    }

    public String getCharSet() {
        if (charSet == null) {
            charSet = "CP850";
        }
        return charSet;
    }

    public void setCharSet(String charSet) {
        this.charSet = charSet;
    }

    public void aplicarAlfa() {
        String tiene = getEntornoLocal().getAlfa();
        setDd_dir(tiene + "/FILES");
        setDd_mnu(tiene + "/MENU");
        setDd_trz(tiene + "/TRAZA");
        setDd_tmp(tiene + "/tmp");
        setDd_rom(tiene + "/rom");
        setDd_obj(tiene + "/obj");
    }

    public VersionAlfa getVersionAlfa() {
        return VersionAlfa.get(base);
    }

    public boolean isCp850() {
        boolean ret = false;
        if (getCharSet().equals("CP850")) {
            ret = true;
        }
        return ret;
    }

    public void setCp850(boolean cp850) {
        if (cp850) {
            setCharSet("CP850");
        }
    }

    public boolean isIso88591() {
        boolean ret = false;
        if (getCharSet().equals("ISO-8859-1")) {
            ret = true;
        }
        return ret;
    }

    public void setIso88591(boolean iso88591) {
        if (iso88591) {
            setCharSet("ISO-8859-1");
        }
    }

}
