/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.facades;

import business.BussinessException;
import business.facade.CenarioFacade;
import control.MapaControler;
import java.io.File;
import java.io.Serializable;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;
import model.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import persistence.PersistenceException;
import persistence.XmlManager;
import persistence.local.WorldManager;

/**
 *
 * @author gurgel
 */
public class WorldFacade implements Serializable {

    private static final Log log = LogFactory.getLog(WorldFacade.class);
    private static WorldFacade instance;
    private MapaControler mapaControler;

    private WorldFacade() {
    }

    public static synchronized WorldFacade getInstance() {
        if (WorldFacade.instance == null) {
            WorldFacade.instance = new WorldFacade();
        }
        return WorldFacade.instance;
    }


    /*
     * Client Only
     */
    public synchronized void doStart(File file) throws BussinessException {
        try {
            WorldManager.getInstance().doStart(file);
        } catch (PersistenceException ex) {
            throw new BussinessException(ex.getMessage());
        }
    }

    public void doSaveOrdens(Comando com, File selectedFile) throws BussinessException {
        try {
            XmlManager.getInstance().save(com, selectedFile);
        } catch (PersistenceException ex) {
            throw new BussinessException(ex.getMessage());
        } catch (NullPointerException ex) {
            throw new BussinessException(ex.getMessage());
        }

    }

    public String getCenarioNome() {
        return WorldManager.getInstance().getPartida().getCenario().getNome();
    }

    public Cenario getCenario() {
        return WorldManager.getInstance().getPartida().getCenario();
    }

    public Jogador getJogadorAtivo() {
        return WorldManager.getInstance().getPartida().getJogadorAtivo();
    }

    public String getJogadorAtivoNome() {
        return WorldManager.getInstance().getPartida().getJogadorAtivo().getNome();
    }

    public String getNacoesJogadorAtivoNome() {
        String ret = "";
        for (Nacao nacao : WorldManager.getInstance().getNacoes().values()) {
            if (WorldManager.getInstance().getPartida().getJogadorAtivo() == nacao.getOwner()) {
                ret += nacao.getNome() + " ";
            }
        }
        return ret;
    }

    public boolean isJogadorAtivoEliminado(Jogador jogadorAtivo) {
        boolean ret = true;
        for (Nacao nacao : WorldManager.getInstance().getNacoes().values()) {
            if (jogadorAtivo == nacao.getOwner() && nacao.isAtiva()) {
                ret = false;
                break;
            }
        }
        return ret;
    }

    public Partida getPartida() {
        return WorldManager.getInstance().getPartida();
    }

    public String getPartidaNome() {
        return WorldManager.getInstance().getPartida().getNome();
    }

    public Iterator<Personagem> getPersonagens() {
        return WorldManager.getInstance().getPersonagens().values().iterator();
    }

    public SortedMap<String, Personagem> listPersonagens() {
        return WorldManager.getInstance().getPersonagens();
    }

    public SortedMap<String, Ordem> getOrdens() {
        return WorldManager.getInstance().getPartida().getCenario().getOrdens();
    }

    public int getOrdensQt(Personagem personagem) {
        return getCenario().getNumOrdens() + personagem.getOrdensExtraQt();
    }

    public int getOrdensQtMax() {
        return getCenario().getNumMaxOrdens();
    }

    public int getTurno() {
        return WorldManager.getInstance().getTurno();
    }

    public Ordem getOrdem(String ordemCodigo) {
        return WorldManager.getInstance().getOrdens().get(ordemCodigo);
    }

    public Mercado getMercado() {
        return WorldManager.getInstance().getPartida().getMercado();
    }

    public boolean isGameOver() {
        return WorldManager.getInstance().getPartida().isGameOver();
    }

    public boolean isSpells() {
        return WorldManager.getInstance().getCenario().hasHabilidade(";SLS;");
    }

    public boolean isStartupPackages() {
        return WorldManager.getInstance().getPartida().hasStartupPackages();
    }

    public boolean hasEmissario() {
        CenarioFacade cf = new CenarioFacade();
        return cf.hasDiplomat(getCenario());
    }

    public boolean hasWizard() {
        CenarioFacade cf = new CenarioFacade();
        return cf.hasWizard(getCenario());
    }

    public SortedMap<String, Habilidade> getHabilidades(String habilidades) {
        SortedMap<String, Habilidade> ret = new TreeMap<String, Habilidade>();
        String[] temp = habilidades.trim().split(";");
        for (String cdHab : temp) {
            cdHab = ";" + cdHab.trim() + ";";
            if (!cdHab.equals(";;")) {
                ret.put(cdHab, WorldManager.getInstance().getPackages().get(cdHab));
            }
        }
        return ret;
    }

    public MapaControler getMapaControler() {
        return mapaControler;
    }

    public void setMapaControler(MapaControler mapaControler) {
        this.mapaControler = mapaControler;
    }
}
