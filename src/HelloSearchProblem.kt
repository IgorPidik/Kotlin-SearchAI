/**
 * Created by igor on 2.7.2017.
 */

class HelloSearchProblem(private var goal: String) : SearchProblemInterface<String, Char> {

    override fun getPossibleActions(state: String): List<Char> {
        if (state.length < goal.length) {
            return " ABCDEFGHIJKLMNOPQRSTUVWXYZ".toList()
        }
        return emptyList()
    }

    override fun getSuccessor(state: String, action: Char): String {
        return state + action
    }

    override fun getActionCost(action: Char): Double {
        return 1.toDouble()
    }

    override fun getHeuristic(state: String): Double {
        var counter = 0
        state.indices
                .filter { state[it] == goal[it] }
                .forEach { counter += 1 }
        return (goal.length - counter).toDouble()
    }

    override fun isGoal(state: String): Boolean {
        return state == goal
    }

    override fun setGoal(newGoal: String) {
        goal = newGoal
    }
}