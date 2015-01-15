Poker Hands
===========

This is a Java 8 solution to the [Project Euler poker problem](https://projecteuler.net/problem=54).
 
The goal is to explore new features, particularly lambdas, and implement something akin to the Strategy pattern.

Get the winning hand from a list of hands:

```
Poker.winnerFromList(List<Hand> hands)
```

or a Texas Hold-Em type situation with community cards:

```
Poker.showdown(List<Card> board, List<Hand> players)
```

The `exp` branch is experimental :-)  Playing around with lambdas and friends.