/**
 * Created by igor on 2.7.2017.
 */

fun main(args: Array<String>) {
    val problem = HelloSearchProblem("SEARCH AI EXAMLPLE")
    println(AStar<String, Char>(problem).getPlan(Triple("", listOf(), 0.0)))

    problem.setGoal("ASD")
    println(DFS<String, Char>(problem).getPlan(Triple("", listOf(), 0.0)))

    problem.setGoal("ASD")
    println(BFS<String, Char>(problem).getPlan(Triple("", listOf(), 0.0)))

    problem.setGoal("ASD")
    println(UCS<String, Char>(problem).getPlan(Triple("", listOf(), 0.0)))
}
