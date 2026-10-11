1. State your name and email address.

Marwan El-Gabry
marwan.w.el-gabry@vanderbilt.edu

2. After reviewing this spec and the provided files, please estimate/report
how long you think it will take you to complete it.

5 hours.

3. How many hours did you actually spend total on this assignment?

5 hours.

4. Who/What did you find helpful for this project? If you received assistance from a person,
who were they and what assistance did they provide?

I found the DblQueue code from project 6 and the DblStack code from project 5 very useful as they
already contained the logic behind implementing a queue and stack. I was able to use them
with minimal changes to their code in this project. I also found the assignment pdf's description
of given methods and what we are supposed to implement helpful. Especially for the solve function
of MazeSolver as it explained the exact procedure of the function.

5. Did you access any other reference material other than this project description and
the class text? Please list them.

No, I only used the project description for this assignment as it felt like the only necessary
reference for this project.

6. How did you test that the final program is correct? How did you test that your stack
and queue classes are correct?

I tested the final program by inputing various solvable and unsolvable mazes and seeing whether
the program correctly indicated whether the maze was solvable or not. I also checked that it was
looking at adjacent spaces in the correct order based on the order of which I added adjacent spaces
to the point agenda and whether it was using a stack or queue based agenda. I tested the stack and
queue classes by replacing uses of DblStack with Stack<Double> in DblStackTest.java and replacing
uses of DblQueue with Queue<Double> in DblQueueTest.java then running both test files.

7. Which agenda method, FIFO or LIFO, seems to be faster at finding a solution to a given maze?
Justify your answer.

LIFO would be faster for mazes where there is a deep path to the exit whereas FIFO would be better
for a maze where you need to explore many paths to find the exit. LIFO explores down one path first
then backtracks if it hits a wall whereas FIFO checks all directions from a point to find a path.


8. If you failed to mark maze locations as visited, how would it have affected your ability to
determine if a solvable maze was indeed solvable? Would a LIFO solver still be able to correctly
determine if a maze was solvable for all solvable mazes? Would a FIFO solver still be able to
correctly determine if a maze was solvable for all solvable mazes? [Note: If you alter
your code to try this out, make sure to restore it before you submit your solution.]

It would have made it impossible to determine if the maze was solvable for the majority of mazes.
A LIFO solver would not be able to determine if the maze was solvable in all cases. Only if there
was a deep path towards the exit without backtracking. A FIFO solver would not be able to determine
if the maze was solvable in all cases as it would continually return to adjacent locations that
have already been visited since it explores all distance one path's first.

9. What did you enjoy about this assignment? What did you hate? Did we provide too much code or
not enough code to make it interesting?

I really enjoyed applying stacks and queues to a fun problem like solving a maze. There was nothing
that I particularly hated about this assignment. I think that you provided just enough code to
understand the assignment and learn from it.

10. Was this project description lacking in any manner? Please be specific.

No. I found the project description to be extremely helpful.

11. Do you have any suggestions for improving this assignment?

I don't have any suggestions for improving the assignment.

12. Any other information you would like to include.

No.