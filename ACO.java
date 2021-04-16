import java.util.*;
 
public class ACO{
    private int antsSize;
    private int[][] path;
    private double[][] pheromones;
    private double[][] probability;
    private double pheromonesEvaporation;
 
    public ACO(int antSize, int[][] path){
        this.antsSize = antSize;
        this.path = path;
    }
    
    public void run(int maxIterations){
        
        int iteration=0;
        while(iteration < maxIterations){
            for(int i = 0; i < this.antsSize;i++){
                //x/ant(t) = 0;
 
            }
 
            iteration++;
        }
    }
 
    private void inicialize(){
        for(int i=0;i<this.path.length;i++){
            for(int j=0;j<this.path[i].length;j++){
                this.pheromones[i][j] = 0.3;
            }
        }
    }
 
    private void calcularProbabilidade(){
        for(int i=0;i<this.path.length;i++){
            for(int j=0;j<this.path[i].length;j++){
                if(this.path[i][j] != 0){
                    double soma = somatorioRotas(i);
                    double distanciaFeromonio = this.pheromones[i][j] *  (1/this.path[i][j]);
                    probability[i][j] = distanciaFeromonio/soma;
                }
            }
        }
    }
 
    private double somatorioRotas(int inicio){
        double sum = 0;
        for(int i=0;i<this.path.length;i++){
            if(this.path[inicio][i] != 0){
                double inversoDistancia = 1/this.path[inicio][i]; 
                sum += this.pheromones[inicio][i] * inversoDistancia;
            }
        }
        return sum;
    }
 
    private int rouletteWeel(int[] p, int[] c){
        int choice = 0;
        double sum = p[choice];
        double u = Math.random();
        while(sum < u){
            choice++;
            sum += p[choice];
        }
        return c[choice];
    }
}
