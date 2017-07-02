/**
 * Created by igor on 2.7.2017.
 */

interface SearchProblemInterface<StateType, ActionType> {
    fun getPossibleActions(state: StateType): List<ActionType>
    fun getSuccessor(state: StateType, action: ActionType): StateType
    fun getActionCost(action: ActionType): Double
    fun getHeuristic(state: StateType): Double
    fun isGoal(state: StateType): Boolean
    fun setGoal(goal: StateType)
}