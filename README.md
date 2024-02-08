# grifforix
<p align="center">
  <img src="/assets/grifforix.png" width=40% heigth=40% alt="The grifforix, Marcos Paulo Soares">
</p>

<p align="center">The grifforix, Marcos Paulo Soares</p>

<br>

*Grifforix* aims to be a strong and secure password generator made in Java, it uses the Java's *java.security.SecureRandom* library. I have plans to make it also a secure authenticator software in the future. *Grifforix* is currently __experimental__ in __v.0.6.0-alpha__.

*Grifforix* is under the Apache 2.0 license, please read it carefully.

# Demo

<p align="center">
  <img src="/assets/screenshot.png" alt="The grifforix in execution">
</p>

This is *Grifforix* in use, I restricted the character limit to 20 just for demonstration purposes, but you can virtually generate a giant password if you want. Note that passwords are displayed with a good combination of all types of characters.

# How it Works

Well, first, it does not uses common methods like the famous C's rand() — that is a pseudo-random function for number generation, but it actually uses Java's SecureRandom class that generates a cryptographically secure random number for the algorithm of password generation.

In computing when a number is mathematically generated in a deterministically way its called "pseudo-random number" or just *PRNG*. __That's not secure__ because the *PRNG* is __not truly random__ since it is completely determined by an initial value, called the *PRNG's "seed"*.

John von Neumann once said: *"Anyone who considers arithmetical methods of producing random digits is, of course, in a state of sin."*

Cryptographic applications require the output not to be predictable from earlier outputs. With that said, this comes a necessity of a truly random number generator or a *RNG*. Java language has *SecureRandom* for that... it smartly calls directly OS functions for true randomness. And with that, we use it to do the algorithm of the password generation.
