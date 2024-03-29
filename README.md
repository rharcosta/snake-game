# snake-game

## Objective

  The main objective of this work was to develop an application that involves, at least, the communication of two clients through a server. 
  The server must act as a mediating entity and repository of data common to customers, in accordance with the problem resolved. 
  Field delimiters should be used in messages exchanged between clients and server and, consequently, byte stuffing is implemented.
  In addition, clients and servers are multi-threaded.

  “Snake Game” has the interaction of these parties involved: two clients, communicating through a server. 
  The purpose of this game is to make “snake” eat as many apples as possible without colliding with the screen or with her own body. 
  In the end, the player who reaches the highest score during the game wins.
  Initially, the two snakes could not collide with each other, but during development, it was found more interesting to have the objective of count only the final score of each one,        based on the amount of apples eaten by snakes, in order to make the game more dynamic and continuous.

## Solution Model
  In this model, the server is responsible for carrying out the commands and sending these responses to customers. 
  Customers, in turn, are responsible for receiving these responses and send messages to the server that will serve as an intermediary between the communication of these two clients. 
  The classes present in the application are:
  * **SnakeGame**: main class, responsible for calling the server class;
  * **Server**: responsible for initializing the connection with the TCP server;
  * **Play**: responsible for starting and disconnecting the client connection, setting the panel background color, draw snakes, apples, game over on the screen and the score;
  * **TCPClientHandler**: responsible for receiving information from the server to the client;
  * **TCPClientMain**: responsible for connecting and sending client messages to the server;
  * **TCPServerAtivosHandler**: responsible for sending messages from the server to the client and receive messages from clients to the server;
  * **TCPServerAtivosMain**: responsible for adding and removing a client, define variables and calculate game commands;
  * **TCPServerConnection**: responsible for managing connections to the server.

<p align="center">
  <img src="https://github.com/rharcosta/snake-game/blob/main/Documents/SnakeGame.png" />
</p>
