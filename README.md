This is an AST calculator which could take a string of input and compute its result.

The Program Process

You -> Input -> String -> Lexer -> Tokens -> AST -> Evaluate

For instance, if you type 
(1 + 2)^2
It will output 9
Below are all the notations that the program can handle
() -> Parenthesis
^ -> Power
* -> Multiplication
/ -> Division
+ -> Addition
- -> Subtraction

It can also handle Variable declaration
e.g

Line 1:    a = 5
Line 2:    a + 10
Output:    15.0

Test folder checks with the desired AST and the resulting AST structured from the program.
Test folder is found under src folder.
