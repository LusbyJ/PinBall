# PinBall
### Requirements
Program writtin using IntelliiJ IDEA  
SDK = Java 8  
Entry for program is Display.java

### Instructions
This is a simple "pinball" style game.  When launched, the start button is active and reset button is not.  
The user can use their mouse to move the ball along the start bar to a position they desire to start from.  
When the ball is in the desired start position, the user then clicks the start button.  The ball will release
upward from the start bar at a pre-defined angle.  If the ball contacts a yellow square, 10 points are awarded.
The ball will continue to bounce around the play area until 3 consecutive borders are hit without hitting a yellow square.  
The game can be reset at anytime by clicking the reset button.

### Known Bugs
Collision detection does not detect when the ball passes through corner of the tiles.
Ball gets hung up when started from the far left or right edge of start bar.
