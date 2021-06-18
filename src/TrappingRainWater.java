import java.util.Stack;

// 42. Trapping Rain Water
public class TrappingRainWater {

    /*
    * The core idea of this solution is to compute the water of different level separately.
    * A stack is used to store the value of each height.
    * If a little area of trapped water contains more than 1 level, then in several different
    * iterations, the water from different level will be calculated separately according to
    * the stack.
    * Value in the stack popped out after used.
    * */
    public int trap(int[] height) {
        if (height == null) return 0;
        Stack<Integer> s = new Stack<>();
        int i = 0, water = 0;
        while (i < height.length) {
            if (s.empty() || height[i] <= height[s.peek()])
                s.push(i++);
            else {
                int bot = s.pop();
                int temp = s.isEmpty() ?
                        0 : (Math.min(height[s.peek()], height[i]) - height[bot]) * (i - s.peek() - 1);
                water += temp;
            }
        }
        return water;
    }
}
