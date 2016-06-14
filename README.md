# Client-Server-Authorization

Target 0: The system consists of two components, the client and the

server. The client places a user friendly GUI for the user’s to enter their

name and password. These values are then transferred to the server for

validation. The server contains a hash table which stores the usernames

and corresponding passwords in plain text. The server validates the user

and shows the “successful connection” message. If the client enters the

wrong password for 3 times in succession, his username is blocked for 3

minutes.

Target 1: The server uses the hashed version of the password instead of

plain text. When the client passes on the username and password, its

hashed version is compared with the table and validated.

Target 2: The server generates the public and private key and sends the

public key to the user to encrypt the message.
