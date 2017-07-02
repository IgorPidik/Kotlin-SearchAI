/**
 * Created by igor on 2.7.2017.
 */

class DFS<StateType, ActionType>(problem: SearchProblemInterface<StateType, ActionType>) : AbstractSearchAlgorithm<StateType, ActionType>(problem) {
    override fun getNextState(): Triple<StateType, List<ActionType>, Double> {
        return states.removeAt(states.lastIndex)
    }
}

class BFS<StateType, ActionType>(problem: SearchProblemInterface<StateType, ActionType>) : AbstractSearchAlgorithm<StateType, ActionType>(problem) {
    override fun getNextState(): Triple<StateType, List<ActionType>, Double> {
        val state = states.minBy { it.second.size }
        states.remove(state)
        return state!!
    }
}

class UCS<StateType, ActionType>(problem: SearchProblemInterface<StateType, ActionType>) : AbstractSearchAlgorithm<StateType, ActionType>(problem) {
    override fun getNextState(): Triple<StateType, List<ActionType>, Double> {
        val state = states.minBy { it.second.sumByDouble { problem.getActionCost(it) } }
        states.remove(state)
        return state!!
    }
}

class AStar<StateType, ActionType>(problem: SearchProblemInterface<StateType, ActionType>) : AbstractSearchAlgorithm<StateType, ActionType>(problem) {
    override fun getNextState(): Triple<StateType, List<ActionType>, Double> {
        val state = states.minBy { it.third }
        states.remove(state)
        return state!!
    }
}