# Encryption-Decryption

**Step 6 (ongoing):**

_Extend your program by adding different algorithms to encode/decode data. The first one would be shifting algorithm (it shifts each letter by the specified number according to its order in the alphabet in circle). The second one would be based on Unicode table, like in the previous stage._

_When starting the program, the necessary algorithm should be specified by an argument (**-alg**). The first algorithm should be named **shift**, the second one should be named **unicode**._

***
**Step 5:**

_At this stage, you need to add the ability to read and write original and cipher data to files. The program must parse two additional arguments **-in** and **-out** to specify the full name of a file to read data and to write the result. Arguments **-mode**, **-key**, and **-data** should still work as before._

_If the **-in** or **-data** argument is not specified, the program should wait for data from the standard input. If there is no **-out** argument, the program must print data to the standard output._

_If there is a non-standard situation (an input file does not exist or an argument doesn’t have a value), the program should not fail. Instead, it must display a clear message about the problem and stop successfully._

***
**Step 4:**

_Modify the previous program to work with command-line arguments instead of the standard input. The program must parse three arguments: **-mode**, **-key** and **-data**. The first argument should determine the program’s mode (**enc** - encryption, **dec** - decryption). The second argument is an integer key to modify the message, and the third argument is a text or ciphertext within quotes to encrypt or decrypt._

_If the **-mode** argument is not specified, the default mode should be encryption. If the **-data** argument is not specified, the program must wait for it and the **-key** argument from the standard input._

_Keep in mind that arguments may be in different order. For example, **-mode enc** may be at the end, at the end or in the middle of aguments array._

***
**Step 3:**

_In this stage, you need to support decryption in your program. The decryption is simply the inverse of encryption, following the same steps but reversing the order in which the keys are applied._

_Then write a program that reads three lines from the standard input: a target operation (enc - encryption, dec - decryption), a message or a cyphertext, and a key to encrypt/decrypt messages. All non-letter characters must be encrypted as well as regular letters. We recommend you to get an integer representation of each character (according to the Unicode table) to shift it._

_Decompose your program using methods to make it easy to understand and edit later. One method should encrypt a message and another one should decrypt it according to a key._

***
**Step 2:**

_Write a program that reads an English message and an integer number (**key**) from the standard input and shifts each letter by the specified number according to its order in the alphabet._

_If you reach the end of the alphabet, start back at the beginning (**a** follows **z**)._

_The program should not modify non-letter characters._

***
**Step 1:**

_For the first stage, you need to manually encrypt the message **"we found a treasure!"** and print the ciphertext (in lower case)._

_To encrypt the message, replace each letter with the letter that is in the corresponding position from the end of the English alphabet (a→z, b→y, c→x, ... x→c, y →b, z→a). Do not replace spaces or the exclamation mark._

_Use the given template to your program to print the ciphertext instead of the original message._

_The output should look like ## ##### # ########! where **#** is a lower-case English letter._
