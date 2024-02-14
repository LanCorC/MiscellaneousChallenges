import static java.lang.Integer.min;

public class Main {
    //for funsies
    public static void main(String[] args) {
        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        //expected output: 6

        //Task: Rain Catcher. The heights are how high the walls are. How many square units of water (2D) can be held in this container (array)?

        //Theorycraft - currentPos has a height. iterate through the array.
        //on each currentPos, scan all LEFT and RIGHT for a maxLeft, maxRight value.
        //if the walls maxLeft go BELOW or EQUAL, then spills, contains 0 at this position (vertical); skip loop. if the maxLeft is HIGHER than current position, that's a container wall.
        //if the walls maxRight go BELOW or EQUAL, then spills, contains 0 at this position (vertical); skip loop. if the maxRight is HIGHER than current position, that's a container wall.
        //select lowest of maxLeft, maxRight. then subtract currentPos. result -> max capacity for this vertical.

        //repeat for other positions in the array.

        //Optimizations: at start of new currentPosition (left to right), if currPosition > leftMax (old), set new leftMax to current, then skip.
            //no need to keep checking left. this updates maxLeft to current, if maxLeft is less than
        //Optimizations: at start of new currentPosition, can we do similar?
            //if rightMax is lower, e.g. staircase, cannot hold. skip needing to iterate.
            //if rightMax is equal, cannot distinguish if currentPos = last, or of many;


        int sum = 0;
        int currentPos, leftMax, rightMax;
        leftMax = heights[0];
        rightMax = heights[1];

        for (int i = 1; i < heights.length; i++) {
//            rightMax = currentPos = heights[i];
            currentPos = heights[i];

            //Proceed codeblock if leftMax is still higher. it is unchanged
            if (leftMax < currentPos) {
                leftMax = currentPos;
                if (leftMax == rightMax) {
                    rightMax = 0; //reset, then find out
                    for (int y = i+1; y != heights.length; y++) { //exit if y = 0; where y = current scanned item to the left of i
                        if (heights[y] > rightMax) {
                            rightMax = heights[y];
                        }
                    }
                }
                continue;
            }

            //
            if (rightMax < currentPos) {
                continue;
            } else if (rightMax > currentPos) {
                sum += min(rightMax, leftMax) - currentPos;
                continue;
            }


            //Go left
//            for (int y = i-1; y != 0; y--) { //exit if y = 0; where y = current scanned item to the left of i
//
//                if (heights[y] > leftMax) {
//                    leftMax = heights[y];
//                }
//            }

//            if (leftMax < currentPos) {
//                continue;
//            }

            //Go right
            rightMax = 0;
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

        System.out.printf("The total here is: %d\n", sum);

    }
}

//
//    public int goLeft(int[] array, int height) {
//
//    }
