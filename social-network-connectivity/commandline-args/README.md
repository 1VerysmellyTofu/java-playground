# The command line

The **command line** (or terminal) is a text window where you type instructions to your computer one line at a time, instead of clicking icons. On macOS it's the _Terminal_ app; on Windows it's _PowerShell_ or _Command Prompt_. You navigate to a folder and then run programs by typing their name.

```bash
cd ~/programming/java/algo/playground/social-network-connectivity  # move into the folder with our code
ls                        # list files in the folder we are in
java Main.java            # run a Java program
```

## Some useful commands to know:
- `cd` **change directory**. Move into a different folder.
  - `.` means the current directory
  - `..` means the parent directory (one level up)
  - `~` (called a **tilde**) means your home directory shortcut for `/Users/yourname` on macOS/Linux
- `ls` list the files in the current folder
- `mkdir` **make directory**. Create a new folder.
- `git status` shows current status of git local repository
- `git add .` to add the local changes at the current directory to the local repository
- `git commit -m "change summary"` stamping changes at local repository with comment on changes

`cd`, `ls`, `open`, `code` are all programs themselves. And the "argument" idea applies to them too:

- `code Main.java` open `Main.java` with VS Code. We're passing `Main.java` as an argument to the `code` program.
- `open Main.java` open `Main.java` with the default app. We're passing `Main.java` as an argument to the `open` program.

> **Java file naming rule:** Every Java file must contain a top-level class whose name matches the filename. So `Main.java` must contain a class named `Main`. This lets the compiler find and run the right class.

---

## What is an argument?

An **argument** is an extra piece of information you hand to a program when you start it. Think of ordering coffee: "coffee" is the command, but _"large, oat milk"_ are the arguments that tell the barista exactly what you want.

In the terminal, anything you type _after_ the program name separated by spaces becomes an argument. Each space starts a new argument.

```
java Main.java   5    sample.txt
   └────┬────┘ └─┬─┘ └────┬─────┘
   the program  arg 0    arg 1
```

---

## How a Java program is run

Java code goes through two steps to actually run. You write human-readable code in a `.java` file, then Java translates it into a form the computer can execute.

```bash
# Classic two-step (any Java version):
javac Main.java          # 1. compile  → produces Main.class
java Main 5 sample.txt   # 2. run      → executes Main.class

# Shortcut (Java 11+) compile and run in one step:
java Main.java 5 sample.txt
```

In both cases, the words `5` and `sample.txt` sit at the end of the line those are the arguments delivered to your program.

---

## Where arguments show up in your code

Every Java program starts with this line:

```java
public static void main(String[] args)
```

That `args` is an **array of strings**. Java automatically fills it with the arguments you typed on the command line in order, starting at index `0`.

For `java Main.java 5 sample.txt`:

| Expression      | Value          |
|-----------------|----------------|
| `args[0]`       | `"5"`          |
| `args[1]`       | `"sample.txt"` |
| `args.length`   | `2`            |

---

## Things to watch out for

Arguments are always `String`, even if you type a number. If you need `5` as an integer, you must convert it:
```java
public static void main(String[] args) {
    String firstArg = Integer.parseInt(args[0]);
    int n = Integer.parseInt(firstArg);
    // or directly
    // int n = Integer.parseInt(args[0]);
}
```

> **Common crash:** reading `args[0]` when no arguments were passed throws `ArrayIndexOutOfBoundsException`. Always check `args.length` first:
> ```java
> if (args.length < 2) {
>     System.out.println("Usage: java Main.java <n_people> <filename>");
>     return;
> }
> ```


## Exercise

Write a program in a file called `CmdExercise.java` that supports two modes:

- `--is-equal <a> <b>`: print `Yes` if the two following arguments are the same string, otherwise print `No`.
- `square <n>`: read the next argument as an integer and print its square.
- Anything else: no arguments at all, an unknown mode, or the right mode with the wrong number of arguments, should print `Bad usage`.

```bash
java CmdExercise.java --is-equal apple orange
> No

java CmdExercise.java --is-equal mandarin mandarin
> Yes

java CmdExercise.java
> Bad usage

java CmdExercise.java huhuhuhu
> Bad usage

java CmdExercise.java square 16
> 256

```