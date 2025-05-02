# LEXX - A Lexical Analyzer

## Overview
LEXX is a lexical analyzer implementation in Java that processes source code and breaks it down into tokens using Deterministic Finite Automata (DFA).

## Features
The analyzer recognizes the following tokens:
- Keywords (`if`, `then`, `else`, `endif`, `while`, `do`, `endwhile`, `print`, `newline`)
- Operators (`+`, `-`, `*`, `/`, `<`, `>`, `=`, `<=`, `>=`, `==`, `!=`)
- Integers
- Identifiers (variable names)
- Parentheses
- Semicolons
- Quoted strings
- Comments (starting with `//`)

## Implementation Details
- Uses a DFA with 41 states to recognize tokens
- State transitions stored in 2D array `q[state][value]`
- ASCII character set (0-127) used for input alphabet
- Maintains symbol table for identifiers
- Implemented using separate DFAs for each token type, combined into one master DFA

## Project Structure
```
├── Lexx.java          # Main implementation
├── Comments.jff       # JFLAP file for comment tokens
├── Identifiers.jff    # JFLAP file for identifier tokens
├── Integers.jff       # JFLAP file for integer tokens
├── Keywords.jff       # JFLAP file for keyword tokens
├── Operators.jff      # JFLAP file for operator tokens
├── Quoted Strings.jff # JFLAP file for string tokens
└── Lexx Project.jff   # Combined DFA for all tokens
```

## Usage
1. Compile the Java source:
```bash
javac Lexx.java
```

2. Run the program:
```bash
java Lexx
```

3. When prompted, select an input file through the file dialog

## Output
The program processes the input file line by line and outputs:
- Token type and value for each recognized token
- Error message and line number for unrecognized tokens
- Maintains a symbol table for identifiers

## Example Output
```
keyword: if
operator: >
integer: 5
identifier: "count"
semicolon: ;
quoted string: Hello World
```

## Course Information
- Course: CSC 4500 - Introduction to Theoretical Computer Science
- Instructor: Suzanne Jennings

## Author
Jacqueline D. Brown
