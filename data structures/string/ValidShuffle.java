/*
Question:
Check if a string is a valid shuffle of two other strings
1XY2 is a valid shuffle of XY and 12
Y12X is not a valid shuffle of XY and 12
In the above example, we have a string array named results. It contains two strings: 1XY2 and Y12X. We are checking if these two strings are valid shuffle of strings first(XY) and second(12).

Here, the program says 1XY2 is a valid shuffle of XY and 12. However, Y12X is not a valid shuffle.

This is because Y12X has altered the order of string XY. Here, Y is used before X. Hence, to be a valid shuffle, the order of string should be maintained.
*/