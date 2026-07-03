## Okay what exactly is a Class?
A class is a some sort of "template" or blueprint that outlines what data and what actions an object of that type will have.

An object is an entity created from that blueprint, or Class.

In Java the words "object", and "instance" are used interchangeably.

Classes are sometimes "models" of real life entities, e.g a Student. A student class (depending on our program's goal) might have the following attributes;
- Name
- Age
- Major

In code, this'd look like
```java
// In a file this Student class could be inside of the class whose name mathces the file's name. 
public class Student {
    // Attributes (data)
    String name;
    int age; // more realistically, we'd store someone's birth year / date and work out how old they are
    int studentNumber; // school specific id-like thing for students.
    String major;
}

public static void main(String[] args) {
    // Create object car1
    Student kid = new Student();
    kid.name = "Alice Wu";
    kid.age = 21;
    kid.major = "Software Engineering";
    kid.studentNumber = 20240012;
    displayIntroText(kid);

    Student differentKid = new Student();
    differentKid.name = "Bob Martins";
    differentKid.age = 19;
    differentKid.major = "Maths";
    differentKid.studentNumber = 20240013;
    displayIntroText(differentKid);
}

private static void displayIntroText(Student s) {
    System.out.println("Hello my name is " + s.name + ", I am " + s.age + "years old. I study " + s.major);
}

private static void numCharactersInName(Student s) int {
    return s.name.length();
}

```

The line `new Student()` creates an instance of Student class, where all of its attributes will have their "default" values.

**Note:** Default value for primitive types (int, long, float, double, char) are 0, or false (for boolean). For everything else, the default value is `null`. 

In the above example, if we don't set `kid.name` after creating the `Student kid` variable, and if we called `numCharactersInName(kid)` that would crash our program. Because the `name` attribute of that instance is `null`, and calling `s.name.length()` is essentially calling `null.length()`, which throws an exception in Java.

## Moving onto class functions:

We can also add functions into classes. All attributes of a class instance, will be visible to that instance's functions. E.g in the above example, we could have written `displayIntroText` and `numCharactersInName` as "class methods"

```java
// In a file this Student class could be inside of the class whose name mathces the file's name. 
public class Student {
    // attributes (data)
    String name;
    int age;
    int studentNumber;
    String major;

    // methods (functionality / actions)
    
    // Unlike the previous example, this functions doesn't need the Student s argument.
    // Because all of the above attributes are already visible to the function.
    void displayIntroText() {
        System.out.println("Hello my name is " + name + ", I am " + age + "years old. I study " + major);
    }

    int numCharactersInName() {
        return name.length();
    }
}

public static void main(String[] args) {
    // Create object car1
    Student kid = new Student();
    kid.name = "Alice Wu";
    kid.age = 21;
    kid.major = "Software Engineering";
    kid.studentNumber = 20240012;
    kid.displayIntroText();

    Student differentKid = new Student();
    differentKid.name = "Bob Martins";
    differentKid.age = 19;
    differentKid.major = "Maths";
    differentKid.studentNumber = 20240013;
    differentKid.displayIntroText();;
}
```

### Constructors

The function we call to create an instance of a class is called a `constructor` function. In Java, every object
has a default constructor. Constructors are called with the keyword `new` In our examples the `Student()` function is the default
constructor for Student class.

We can add more constructors inside the class. This is mostly for ergonomic reasons. Such that the user of the class
doesn't have to spend too much effort instantiating the class.

Some rules:
- A constructor function must have the same name as the class.
- We can't have more than one constructor that share the same function signature

E.g for student class

```java
public class Student {
    String major;
    String name;
    int age;
    int studentNumber;

    // The argument order of the function can be however we like.
    // Doesn't have to match the above definition order.
    // We can also name this functions parameters however we like e.g (nn, aa, studentNo, major)
    Student(String nn, int aa, int studentNo, String major) {
        this.name = nn;
        this.age = aa;
        this.studentNumber = studentNo;
        // for the above 3 lines, we could have also just written
        // 
        // name = nn;
        // age = aa;
        // studentNumber = studentNo;
        //
        // Because there is no ambiguity. `name` can only refer to the `name` we defined under the class definition.


        // Whereas `major` in this function actually refers to the "closer" variable. Which is the parameter of this function.
        // In order to make an assignment to the "class variable major", we must write `this.major`
        this.major = major;
    }

    // We can have more than 1 constructor too.
    Student(String firstName, int age, String lastName, int studentNumber, String major) {
        this.name = firstName + " " + lastName;
        this.age = age;
        this.studentNumber = studentNumber;
        this.major = major;
    }

    void displayIntroText() {
        System.out.println("Hello my name is " + name + ", I am " + age + "years old. I study " + major);
    }

    int numCharactersInName() {
        return name.length();
    }
}

public static void main(String[] args) {
    Student alice = new Student("Alice Wu", 22, 20240012, "Software Engineering");
    Student bob = new Student("Bob", 19, "Martins" 20240013, "Maths");
```
