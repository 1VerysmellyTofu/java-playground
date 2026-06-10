# Scanner

`Scanner` is the built-in "reader" class in Java. We need to point it at a source (this source could be a file, standard input, a string), then it reads numbers, words, lines.

You create one by telling it where to read from, and then ask it for data piece by piece.

## Creating a Scanner

You always construct a `Scanner` by passing it a source:

```java
import java.util.Scanner;
import java.io.File;

// From a file
Scanner sc = new Scanner(new File("some_file.txt"));

// From the keyboard (standard input)
Scanner sc = new Scanner(System.in);

// From a string
Scanner sc = new Scanner("10 20 30");
```

> **Import:** `Scanner` lives in `java.util`, and `File` lives in `java.io`. You need these at the top of your file:

## Quick Cheatsheat about Reading Data

Once you have a `Scanner` object, you can call methods on it to pull out data one piece at a time.

| Method            | What it does                                          |
|-------------------|-------------------------------------------------------|
| `nextInt()`       | Reads the next token, converts it to an integer       |
| `nextDouble()`    | Reads the next token, converts it to a decimal number |
| `next()`          | Reads the next token (stops at whitespace)            |
| `nextLine()`      | Reads the rest of the current line                    |
| `hasNextInt()`    | Returns `true` if the next token is an int            |
| `hasNext()`       | Returns `true` if there's more tokens to read         |

`Scanner` skips over whitespace (spaces, tabs, newlines) automatically when reading. So it doesn't matter if your numbers are on the same line or different lines `nextInt()` finds the next one either way.

```java
// File A:      // File B:
// 10 20 30     // 10
//              // 20
//              // 30

// Both files can be read the same way. As scanner hops over
// whitespace and newlines when nextInt() is called.
int a = scanner.nextInt(); // 10
int b = scanner.nextInt(); // 20
int c = scanner.nextInt(); // 30
```

## A common pattern: loop until empty

When you don't know how many values are in the file, loop with `hasNextInt()`:

```java
Scanner sc = new Scanner(new File("sample.txt"));

while (sc.hasNextInt()) { 
    int timestamp = sc.nextInt();
    int restOfTheLine = sc.nextLine();
    System.out.println(timestamp + " " + restOfTheLine);
}

sc.close();
```

## Closing the Scanner

Always call `sc.close()` when you're done. This releases the file handle so the OS knows you're finished with it. For keyboard input (`System.in`) it's less critical, but it's a good habit regardless.


## Exercise

Write a program in a file called `ScannerExample.java` that supports three modes:
```bash
java ScannerExample.java stdin                # reads two numbers you type
java ScannerExample.java file numbers.txt     # reads two numbers from a file
java ScannerExample.java string "14 16"       # reads two numbers from the argument itself
```

The program should create a scanner class that points to the source indicated by the first command-line argument. Then it should read two integers, and print out their sums

**1. `stdin` mode** — create a `Scanner` that reads from the keyboard. The user will type two numbers after the program starts.

**2. `file` mode** — create a `Scanner` that reads from a file. The filename is provided as a commandline arg. We can create a file in this folder and use that as an input.

**3. `string` mode** — create a `Scanner` that reads from a string. The single string is provided as a commandline arg (e.g. `"14 16"`). Notice that the quotes in the command are what tell the shell to treat `14 16` as a single argument. Without the pitchiks, `14` and `16` would land in separate slots in `args`.

### Stretch goal

Let's play around with the program we just wrote.
- What happens if you run `file` mode but give it a filename that doesn't exist?
- What happens if the `string` provides `"hihihih huhuhuhu"` as an arg instead of two numbers?
