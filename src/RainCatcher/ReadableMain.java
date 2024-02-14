//Challenge: Rain Catcher. The heights are how high the walls are. How many square units of water (2D) can be held in this container (array)?
//expected output: 6
package RainCatcher;

import static java.lang.Integer.min;

public class ReadableMain {

    public static void main(String[] args) {

        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        //Thought process - currentPos has a height. iterate through the array.
        //on each currentPos, scan all LEFT and RIGHT for a maxLeft, maxRight value.
        //if the walls maxLeft go BELOW or EQUAL, then spills, contains 0 at this position (vertical); skip loop. if the maxLeft is HIGHER than current position, that's a container wall.
        //if the walls maxRight go BELOW or EQUAL, then spills, contains 0 at this position (vertical); skip loop. if the maxRight is HIGHER than current position, that's a container wall.
        //select lowest of maxLeft, maxRight. then subtract currentPos. result -> max capacity for this vertical.

        //repeat for other positions in the array.


        int sum = 0;
        int currentPos, leftMax, rightMax;

        for (int i = 1; i < heights.length; i++) {
          leftMax = rightMax = currentPos = heights[i];

//            Go left
            for (int y = i-1; y != 0; y--) { //exit if y = 0; where y = current scanned item to the left of i

                if (heights[y] > leftMax) {
                    leftMax = heights[y];
                }
            }

            if (leftMax < currentPos) {
                continue;
            }

            //Go right
            for (int y = i+1; y != heights.length; y++) { //exit if y = 0; where y = current scanned item to the left of i
                if (heights[y] > rightMax) {
                    rightMax = heights[y];
                }
            }
            if (rightMax < currentPos) {
                continue;
            }

            //find potential vertical storage of position
            sum += min(rightMax, leftMax) - currentPos;
        }

        System.out.printf("%d\n", sum);
    }
}
