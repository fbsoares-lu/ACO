import com.diegopinheiro.computacaonatural.myaco.graph.Att48GraphCreator;
import com.diegopinheiro.computacaonatural.myaco.graph.GraphAdapter;
import com.diegopinheiro.computacaonatural.myaco.graph.GraphCreator;
import com.diegopinheiro.computacaonatural.myaco.pheromoneStrategy.PheromoneStrategy;
import com.diegopinheiro.computacaonatural.myaco.pheromoneStrategy.SACOPheromoneStrategy;
import com.diegopinheiro.computacaonatural.myaco.transitionStrategies.SACOTransitionStrategy;
import com.diegopinheiro.computacaonatural.myaco.transitionStrategies.TransitionStrategy;
import com.diegopinheiro.computacaonatural.myaco.util.Solver;

public class Main {
	public static void main(String[] args){
		GraphCreator creator = new Att48GraphCreator();
        GraphAdapter graph = creator.createGraph(); // cria grafo do Att48
        
        int maxIterations = 10;
        double alpha = 2;
        double beta = 2;
        int colonySize = 10; // qtd de formigas
        double rho = .1;
        PheromoneStrategy pheromoneStrategy = new SACOPheromoneStrategy(rho);
        // beta
        TransitionStrategy transitionStrategy = new SACOTransitionStrategy(alpha); // escolhe o tipo de transicao
        //TransitionStrategy transitionStrategy = new AntSystemTransitionStrategy(alpha, beta);
        Solver solver = new Solver(maxIterations, colonySize, transitionStrategy, pheromoneStrategy);
        solver.solve(graph);
        //solver.toString();
	}
}
