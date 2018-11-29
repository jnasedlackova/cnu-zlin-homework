# PROPOSAL: Mars Rover Simulation

Continue with the "Mars Rover Simulator", the aim is to be able to simulate all the actions that can be taken by the Rover on the Mars:
 - turn right/left
 - move forward/backward

If you like, you can enhance the commands with custom actions - eg. collect sample, take a picture ... use your imagination ;-)

The Simulator takes following inputs:
 - Rover initial position
 - Rover initial direction
 - Landscape _size_ (rectangular)
 - Positions of INACCESSIBLE fields divided by semicolons (rest of them is accessible)
 - Rover final position
 - Sequence of Commands for passage through the Landscape (R-turn right, L-turn left, F-move forward, B-move backward)

The Simulator output is either TRUE/FALSE, based on the fact, if the Rover reaches its final destination ;-)

## Assumptions
 - we do not expect you to load the data from a file, you can use the TDD approach and simulate the input with a String
 - Coordinates [0, 0] are top-left at the map. X is the vertical axis, Y is the horizontal one.
 - each information is separated by an empty line
 - both initial and final destination are not at an INACCESSIBLE field
 - you use the TDD approach, we've taught you
 - you ask us, when you need help or support! ;-)
 - yes, we like beer ... :-D

## Example Input with output TRUE

```
1,0

N

5

2,0;1,3;4,3;1,5

4,0

RRFLFRFF
```

The same input with notes:
```
1,0 <- initial position [x, y]
<empty line>
N <- initial direction
<empty line>
5 <- landscape size
<empty line>
2,0;1,3;4,3;1,5 <- positions of inaccessible fields
<empty line>
4,0 <- final destination
<empty line>
RRFLFRFF <- sequence of commands
```

## Example input with output FALSE

```
1,0

N

5

2,0;1,3;2,3;4,3

2,3

RRFLFRFF
```

## Bonus

You can make a little bit more, if you want to :-)

 1. Detect situation, when either initial or final destinations are at an INACCESSIBLE field.
 2. Make a photo every time, when there is a stone (INACCESSIBLE field) right before the Rover, at the end, print _stone coordinates_.
 3. Add one property to the input file - number of inaccessible fields which could be overcome during the passage through the Landscape
