# Number Guessing Game

Let's write a mini game where the computer picks a number and we try to guess it. The game should work like the following:
- We provide two numbers as commandline arguments, say `A` and `B`
- Our program selects a number `X` in the closed range [`A`, `B`].
- We input a random (from stdin), and:
  - If we the number we entered is `X`, we win the game~ Program says something like congratulations
  - If the number we entered is **smaller** than `X` the program should say something like "Try a bigger number" and reads another input from stdin
  - If the number we entered is **bigger** than `X` the program should say something like "Try a smaller number" and reads another input from stdin
