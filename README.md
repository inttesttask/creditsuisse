### Startup in IDE:
* Run Starter.class
* Type commands in terminal window

### Startup with Jar
`mvn clean package`

`java -jar target\console-draw-1.0-SNAPSHOT.jar`

### Usage:
    Command         Description 
    C w h           Creates a new canvas of width w and height h.
     
    L x1 y1 x2 y2   Creates a new line from (x1,y1) to (x2,y2). Currently only 
                    horizontal or vertical lines are supported. Horizontal and vertical lines 
                    will be drawn using the 'x' character. 
                    
    R x1 y1 x2 y2   Creates a new rectangle, whose upper left corner is (x1,y1) and 
                    lower right corner is (x2,y2). Horizontal and vertical lines will be drawn 
                    using the 'x' character.
                     
    B x y c         Fills the entire area connected to (x,y) with \color\ c.
      
    Q               Quit the program.
     
    F               Flushes the canvas
    
### Assumptions
 * Added Guava library to get arguments validation o-o-t-b. 
 Maybe for such small project it was better to make separate util class "Preconditions".
 
 * Preconditions.checkArgument is used instead of Preconditions.checkNotNull in some cases 
 to remove catching of NullPointerException.
 
 * BucketFill checks starting pixel color, and then fills connected pixels of that color only. So if you point to the line or rectangle, 
 it'll repaint only line\rectangle and not their inside or outside space
 
 * BucketFill counts only 4 neighbours. And not 8.
 It was chosen to simplify.
 
 * drawingContext.render() is called after QUIT command. I decided that it is better than one more if-clause.
 
 * catch(Exception e) in main(). Generally i don't think that it is good, but in this place i think it is ok.
 Because exceptions there would not brake app workflow.
  
### TODO:
* Divide some tests into separate methods for easier debug.
Combined for now due to lack of time.

* Add logging.





