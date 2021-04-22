import com.diegopinheiro.computacaonatural.myaco.graph.Att48GraphCreator;
import com.diegopinheiro.computacaonatural.myaco.graph.GraphAdapter;
import com.diegopinheiro.computacaonatural.myaco.graph.GraphCreator;
import com.diegopinheiro.computacaonatural.myaco.transitionStrategies.SACOTransitionStrategy;
import com.diegopinheiro.computacaonatural.myaco.transitionStrategies.TransitionStrategy;
import com.diegopinheiro.computacaonatural.myaco.util.Solver;

public class Main {
	public static void main(String[] args){
		GraphCreator creator = new Att48GraphCreator();
		GraphAdapter graph = creator.createGraph();
		int maxIterations = 10;
		double alpha = 2;
		double beta = 2;
		int colonySize = 10;
		TransitionStrategy transitionStrategy = new SACOTransitionStrategy(alpha);
		//TransitionStrategy transitionStrategy = new AntSystemTransitionStrategy(alpha, beta);
        Solver solver = new Solver(maxIterations, colonySize, transitionStrategy);
        solver.solve(graph);
        //solver.toString();
	}
}
