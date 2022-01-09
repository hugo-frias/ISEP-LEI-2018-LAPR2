/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

/**
 *
 * @author Vera Pinto
 */

public class TroubleShooting {
    /**
     * attribute that represents the problem
     */
    private String problem;
    /**
     * attribute that represents the strategy to solve the problem
     */
    private String strategy;
    /**
     * omission variable of problem attribute
     */
    private final String PROBLEM_BY_DEFAULT = "";
    /**
     * omission variable of strategy attribute
     */
    private final String STRATEGY_BY_DEFAULT="";
    /**
     * Creates TroubleShooting's instances
     */
    public TroubleShooting() {
        this.problem = PROBLEM_BY_DEFAULT;
        this.strategy = STRATEGY_BY_DEFAULT;
    }
    /**
     * Returns the problem
     * @return problem 
     */
    public String getProblem(){
        return this.problem;
    }
    /**
     * Returns the strategy
     * @return strategy
     */
    public String getStrategy(){
        return this.strategy;
    }
    /**
     * @param problem problem to set 
     */
    public void setProblem(String problem) {
        this.problem = problem;
    }
    /**
    * @param strategy strategy to set about solve the problem
    */
    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }
    
    
}
