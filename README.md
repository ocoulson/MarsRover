### Mars Rover

Assumptions / Decisions:
- The rover can only move along grid lines, so 'rotate clockwise' and 'rotate anticlockwise' will be in increments of 90 degrees

- I'm going to consider the 'shortest path' to be the one that requires the least number of instructions so the 'path' will be a
list of instructions

- I'm not sure how the algorithm is going to cope with the fact that you can leave the side of the graph
and appear on the other side, I think it will work, but there may be special handling necessary

My idea for implementation of Djikstra's Algorithm:

1) Keep lists of visited and unvisited nodes - set all nodes to unvisited
2) Keep map of nodes to 'tentative distance' - distance in this case I'll consider to be number of instructions
3) Set all initial distances to MaxValue of Int, current node set to 0
4) Visit current node - Look at neighbours of current node, considering current facing determine number of instructions to
  get to each (1 for directly ahead, 2 for the ones to left / right, 3 for behind)
5) In the map of nodes to paths, if the path from the current node to each neighbour is less than the distance
  already in there, replace it in the map with the shorter one, or just leave the existing value
6) move current node to visited set
7) if destination is now visited, end algorithm, return map value for destination point
8) otherwise visit the unvisited node with the smallest 'tentative distance' and visit it
    
