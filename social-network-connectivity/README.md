# Social Network Connectivity

Given a social network containing `n` members and a log file containing `m`
timestamps at which times pairs of members formed friendships, design an algorithm to determine the earliest time at which all members are connected (i.e., every member is a friend of a friend of a friend ... of a friend).

Assume that the log file is sorted by timestamp and that friendship is an equivalence relation. The running time of your algorithm should be 

## Gameplan

We want to solve this in multiple steps
1. Create a code base, put it in a state where it's able to read a file that contains that triplets (timestamp, p_number, q_number). We should take the filename as a commandline argument, and then read that file, parse the content.
  - Here we can think about errors & exceptions. E.g. what happens if there is no file with the given name
  - We'll learn about the Scanner class
  - Optional: We can learn about actual timestamps. E.g. Unix time, UTC time.
2. Build a union-find implementation ourselves. And poke this. E.g:
  - Print internal data structures that the UnionFind class uses.
  - Add extra functions to this classs
  - Poke until we feel comfortable with the idea of this "union find" class.
3. Solve the actual question
