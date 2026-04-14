# Q1 #
Choosing option cancel return `no`


# Q2 #

Must define and Object Array then pass it to showOptionDialog. 

```java
Object[] options = {"I do", "I don't"};

int n = JOptionPane.showOptionDialog(null,
    "Do you want to change the first class ticket", // Message
    JOptionPane.YES_NO_OPTION,    // Option type
    JOptionPane.QUESTION_MESSAGE, // Message type (icon)
    null,                         // Icon (null for default)
    options,                      // The array of custom button text
    options[0]);                  // Default button focus
    ```