Overview:
This repository provides a Java implementation of a linked stack data structure along with an expression validator that checks for balanced parentheses, braces, and brackets in a given string. The linked stack implementation offers basic stack operations such as push, pop, and peek, while ensuring that the internal state remains consistent. The expression validator utilizes the stack to ensure that each opening symbol has a corresponding closing symbol in the correct order.

Features:
LinkedStack - A generic stack implementation using a singly linked node structure. This allows for dynamic memory allocation, ensuring efficient use of resources.
Expression Validation - A utility function to check for balanced symbols ({}, [], ()) in an expression. This is particularly useful in scenarios like parsing code, mathematical expressions, or any domain where such symbols must be properly nested.
