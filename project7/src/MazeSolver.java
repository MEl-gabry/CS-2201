// File name: MazeSolver.java
// Author: Marwan El-Gabry
// userid: elgabrmw
// Email: marwan.w.el-gabry@vanderbilt.edu
// Class: CS2201 @ Vanderbilt U.
// Honor Statement: I attest that I have neither given nor received unauthorized aid concerning
// this homework. I further acknowledge that the instructors are the copyright owners of this HW.
// Assignment Number: #7
// Description:  Class that solves a maze, given the maze and an agenda.
// Last Changed: 11/2/2025

public class MazeSolver {
    private Maze maze;
    private PointAgenda agenda;

    /**
     * Constructor -- initializes maze and agenda
     */
    public MazeSolver(Maze newMaze, PointAgenda newAgenda) {
        maze = newMaze;
        agenda = newAgenda;
    }

    /**
     *  solve
     *  Explore the maze that was provided when the MazeSolver object was created
     *  pre:  The MazeSolver exits and trace is a boolean value.
     *  post: Lists all Points as they are visited and print a total count of visited Points
     *  when done. Prints a message indicating if the ending point of the Maze is reachable or
     * unreachable.
     */
    public boolean solve(boolean trace) {
        agenda.add(maze.getStartLocation());

        boolean found = false;

        int pointsVisited = 0;

        while (!agenda.isEmpty() && !found) {
            Point location = agenda.peek();
            agenda.remove();

            if (!maze.hasBeenVisited(location)) {
                System.out.print(location + "->");
                pointsVisited++;

                if (location.equals(maze.getEndLocation())) {
                    found = true;
                } else {
                    addLocation(location.x + 1, location.y);
                    addLocation(location.x, location.y + 1);
                    addLocation(location.x - 1, location.y);
                    addLocation(location.x, location.y - 1);

                    maze.markVisited(location);
                }
            }
        }

        if (found) {
            System.out.println("Solution found!");
        } else {
            System.out.println("Maze not solvable.");
        }
        System.out.print("Number of nodes visited: " + pointsVisited);

        return found;
    }

    /**
     *  addLocation
     *  Add a location to agenda if it is not a wall
     *  pre:  The MazeSolver exits and x, y are integers
     *  post: Add a location at (x,y) to agenda if it is not a wall
     */
    private void addLocation(int x, int y) {
        Point location = new Point(x, y);

        if (maze.isOpen(location)) {
            agenda.add(location);
        }
    }
}
