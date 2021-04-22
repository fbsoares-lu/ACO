/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pheromoneStrategy;

import com.diegopinheiro.computacaonatural.myaco.colony.Ant;
import com.diegopinheiro.computacaonatural.myaco.colony.Colony;

/**
 *
 * @author deb_c
 */
public abstract class PheromoneStrategy {

    public abstract void updatePheromoneGlobal(Colony colony);

    public abstract void updatePheromoneLocal(Ant ant);

}
