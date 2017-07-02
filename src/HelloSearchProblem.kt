/**
 * Created by igor on 2.7.2017.
 */
class HelloSearchProblem(private var goal: String) : SearchProblemInterface<String, Char> {

    override fun getPossibleActions(state: String): List<Char> {
        if (state is String) {
            if (state.length < goal.length) {
                return " ABCDEFGHIJKLMNOPQRSTUVWXYZ".toList()
            }
            return emptyList()
        }
        throw IllegalArgumentException("state variable must be of type String!")
    }

    override fun getSuccessor(state: String, action: Char): String {
        if (state is String && action is Char) {
            return state + action
        }
        throw IllegalArgumentException("state must be of type String and action must be of type Char!")
    }

    override fun getActionCost(action: Char): Double {
        return 1.toDouble()
    }

    override fun getHeuristic(state: String): Double {
        if (state is String) {
            var counter = 0;
            state.indices
                    .filter { state[it] == goal[it] }
                    .forEach { counter += 1 }
            return (goal.length - counter).toDouble()
        }
        throw IllegalArgumentException("state variable must be of type String!")
    }

    override fun isGoal(state: String): Boolean {
        if (state is String) return state == goal
        throw IllegalArgumentException("state variable must be of type String!")
    }

    override fun setGoal(newGoal: String) {
        goal = newGoal
    }
}
