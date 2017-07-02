/**
 * Created by igor on 2.7.2017.
 */

abstract class AbstractSearchAlgorithm<StateType, ActionType>(val problem: SearchProblemInterface<StateType, ActionType>) {
    protected val states: MutableList<Triple<StateType, List<ActionType>, Double>> = arrayListOf()

    //initial state = currentState, array of actions, cost
    fun getPlan(initState: Triple<StateType, List<ActionType>, Double>): List<ActionType> {
        val expanded: MutableList<StateType> = arrayListOf()
        states.add(initState)

        println("Search Started! Algorithm: " + this.javaClass.kotlin.toString().replace("class ", ""))

        while (states.size > 0) {
            val (state, actions, cost) = getNextState()
            if (state !in expanded) {
                expanded.add(state)
                if (problem.isGoal(state)) {
                    return actions
                } else {
                    for (possibleAction in problem.getPossibleActions(state)) {
                        val newState = problem.getSuccessor(state, possibleAction)
                        val newActions = actions + possibleAction
                        val newCost = problem.getActionCost(possibleAction) + problem.getHeuristic(state)
                        states.add(Triple(newState, newActions, newCost))
                    }
                }
            }
        }
        return emptyList()
    }

    open protected fun getNextState(): Triple<StateType, List<ActionType>, Double> {
        return states.removeAt(states.size - 1)
    }
}