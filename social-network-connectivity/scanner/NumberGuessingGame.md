# Number Guessing Game

## Exercise
Let's write a mini game where the computer picks a number and we try to guess it. The game should work like the following:
- We provide two numbers as commandline arguments, say `A` and `B`
- Our program selects a number `X` in the closed range [`A`, `B`].
- We input a random (from stdin), and:
  - If we the number we entered is `X`, we win the game~ Program says something like congratulations
  - If the number we entered is **smaller** than `X` the program should say something like "Try a bigger number" and reads another input from stdin
  - If the number we entered is **bigger** than `X` the program should say something like "Try a smaller number" and reads another input from stdin

Note: We can assume that the user will always enter valid inputs when running this program. E.g. Commandline arguments will be proper integers, and so will the std-in inputs that the program reads later.


## Practical Info

### Generating random numbers:

Let's go over two ways to generate random numbers in Java.

First way is using `Math.random()`. `Math.random()` generates a **double** value between 0.0 (inclusive) and 1.0 (exclusive). So it's an half open range is `[0, 1)`. If we want to geneate a random int in the range `[A, B]` (note that this window is closed, it includes both A and B). We can do the following:
```java
    int randomNum = (int) (Math.random() * (B-A+1)) + A;
```

Let's say A is 10, and B is 15. Let's look at the expression now: `(int) (Math.random() * 6) + 10)`
- `Math.random()` gives us a `double` in the range `[0, 1)`
- `Math.random() * 6` gives us a `double` in the range `[0, 6)`
- `Math.random() * 6 + 10` gives us a `double` in the range `[10, 16)`
- `(int) (Math.random() * 6 + 10)` That `(int)` casting will take a number in the range `[10, 16)` and:
  - If it's between 10 and 11, e.g 10.8054 it will be cast to 10
  - If it's between 11 and 12, e.g 11.0231 it will be cast to 11
  - If it's between 12 and 13, e.g 12.0000 it will be cast to 12
  - ...
  - If it's between 15 and 16 (note that it can never be 16), it will be cast to 15.

Piggyback question: what would happen if we didn't use paranthesis around the Math.random() bit. E.g just wrote `(int) Math.random() * 6 + 10`? Think think a bit, and try to run this and see.

Second way is using the Random class. The Random class has a method called nextInt(A, B) that generates a random integer in the range `[A, B)` (note that B is _not_ included). So if we want to generate a random integer between 10 and 15 (inclusive) we do the following:
```java
    Random rand = new Random();
    int randomNum2 = rand.nextInt(10, 16);
```
