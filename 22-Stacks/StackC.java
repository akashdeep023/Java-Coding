import java.util.*; // Import all package
import java.lang.Math;

public class StackC {
    // ArrayList --------------------------------
    // static class Stack {
    //     static ArrayList<Integer> list = new ArrayList<>();

    //     public boolean isEmpty() { // Check Stack is empty
    //         return list.size() == 0;
    //     }

    //     public void push(int data) { // Push data (add data to stack)
    //         list.add(data);
    //     }

    //     public int pop() {
    //         if (isEmpty()) { // Check stack is empty
    //             return -1;
    //         }
    //         int data = list.get(list.size() - 1); // Pop data (remove from stack)
    //         list.remove(list.size() - 1);
    //         return data;
    //     }

    //     public int peek() { // Peek data (get from stack)
    //         if (isEmpty()) { // Check stack is empty
    //             return -1;
    //         }
    //         return list.get(list.size() - 1);
    //     }
    // }

    // LinkedList -------------------------------- 
    // static class Node { // LinkedList Node class
    //     int data;
    //     Node next;

    //     Node(int data) {
    //         this.data = data;
    //         this.next = null;
    //     }
    // }

    // static class Stack {
    //     static Node head = null;

    //     public boolean isEmpty() {
    //         return head == null;
    //     }

    //     public void push(int data) {
    //         Node newNode = new Node(data);
    //         if (isEmpty()) {
    //             head = newNode;
    //             return;
    //         }
    //         newNode.next = head;
    //         head = newNode;
    //     }

    //     public int pop() {
    //         if (isEmpty()) {
    //             return -1;
    //         }
    //         int top = head.data;
    //         head = head.next;
    //         return top;
    //     }

    //     public int peek() {
    //         if (isEmpty()) {
    //             return -1;
    //         }
    //         return head.data;
    //     }
    // }

    // Print Stack --- helper function to print stack
    public static void printStack(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
        System.out.println();
    }

    // Q-1 Push at the bottom of the Stack -------------------------------- 
    public static void pushBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) { // base case
            s.push(data);
            return;
        }
        int top = s.pop();
        pushBottom(s, data); // recursion
        s.push(top); // backtracking
    }

    // Q-2 Reverse a String using a Stack --------------------------------
    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>(); // Create character type stack
        int idx = 0;
        while (idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder sb = new StringBuilder("");
        while (!s.isEmpty()) {
            sb.append(s.pop());
        }
        return sb.toString();
    }

    // Q-3 Reverse a Stack --------------------------------
    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) { // base case
            return; // stack is empty then return
        }
        int top = s.pop(); // top element pop
        reverseStack(s); // recursion call
        pushBottom(s, top); // backtracking for top element to push bottom
    }

    // Q-4 Stock span Problem --------------------------------
    public static void stockSpan(int stocks[], int span[]) {
        Stack<Integer> s = new Stack<>();
        s.push(0);
        span[0] = 1;
        for (int i = 1; i < span.length; i++) {
            int currStock = stocks[i];
            while (!s.isEmpty() && currStock >= stocks[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }
            s.push(i);
        }
    }

    // Q-5 Next greater element --------------------------------
    public static void nextGreaterEle(int arr[], int nextGreater[]) { // TC -> O(2n + n) => O(n)
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) { // backwards travers
            // while loop to pop lessthan element idx
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) { // stack not empty && lessthan
                s.pop();
            }
            // step-1 if-else or add greater element in nextGreater
            if (s.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[s.peek()];
            }
            // push current idx in stack
            s.push(i);
        }
    }

    // Q-6 Valid Parentheses --------------------------------
    public static boolean validParentheses(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') { // Opening bracket (push character in Stack)
                s.push(ch);
            } else { // Closing bracket (pop character from Stack)
                if (s.isEmpty()) { // Start with closing bracket
                    return false;
                }
                if ((s.peek() == '(' && ch == ')') //()
                        || (s.peek() == '{' && ch == '}') // {}
                        || (s.peek() == '[' && ch == ']') // []
                ) { // Opening & closing bracket is matched then pop top character
                    s.pop();
                } else {
                    return false; // not valid (character not matching) 
                }
            }
        }
        // if (!s.isEmpty()) { // Stack is not empty then return false
        //     return false;
        // }
        // return true;
        return s.isEmpty();
    }

    // Q-7 Duplicates Parentheses --------------------------------
    public static boolean isDuplParenthese(String str) { // TC -> O(n)
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) { // loop to traverse every character
            char ch = str.charAt(i);
            if (ch == ')') { // closing
                int count = 0;
                // while (s.peek() != '(') {
                //     s.pop();
                //     count++;
                // }
                // if (count < 1) {
                //     return true; // duplicate
                // } else {
                //     s.pop(); // opening pair
                // }
                while (s.pop() != '(') { // pop every character or top character not equal to '(' then increment count
                    count++;
                }
                if (count < 1) { // count = 0 (duplicate) or count >= 1 (no duplicate)
                    return true; // duplicate
                }
            } else { // opening ya operands ya operator
                s.push(ch);
            }
        }
        return false; // duplicate not exist
    }

    // Q-8 Max Ractangular area in Histogram --------------------------------
    public static void maxArea(int height[]) { // TC -> O(n)
        int maxArea = 0;
        int nsr[] = new int[height.length];
        int nsl[] = new int[height.length];
        // Next smaller right TC -> O(n)
        Stack<Integer> s = new Stack<>();
        for (int i = height.length - 1; i >= 0; i--) { // right side
            while (!s.isEmpty() && height[s.peek()] >= height[i]) { // smaller
                s.pop();
            }
            if (s.isEmpty()) {
                nsr[i] = height.length;
            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }
        // Next smaller left TC -> O(n)
        s = new Stack<>(); // Empty stack
        for (int i = 0; i < height.length; i++) { // left side
            while (!s.isEmpty() && height[s.peek()] >= height[i]) { // smaller
                s.pop();
            }
            if (s.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = s.peek();
            }
            s.push(i);
        }
        // Current area TC -> O(n)
        for (int i = 0; i < nsl.length; i++) {
            int width = nsr[i] - nsl[i] - 1; // j - i - 1
            int currArea = height[i] * width;
            maxArea = Math.max(maxArea, currArea);
        }
        System.out.println("Max rectangle area : " + maxArea);
    }

    public static void main(String[] args) {
        // Stack using ArrayList & LinkedList --------------------------------
        // Stack s = new Stack();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // while (!s.isEmpty()) {
        //     System.out.println(s.peek());
        //     s.pop();
        // }

        // Stack using Collections framework --------------------------------
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        while (!st.isEmpty()) {
            System.out.println(st.peek());
            st.pop();
        }
        System.out.println();

        // Q-1 Push at the bottom of the Stack -------------------------------- 
        Stack<Integer> st2 = new Stack<>();
        st2.push(1);
        st2.push(2);
        st2.push(3);
        pushBottom(st2, 4);
        printStack(st2);

        // Q-2 Reverse a String using a Stack --------------------------------
        System.out.println(reverseString("jack"));
        System.out.println();

        // Q-3 Reverse a Stack --------------------------------
        Stack<Integer> st3 = new Stack<>();
        st3.push(1);
        st3.push(2);
        st3.push(3);
        reverseStack(st3);
        printStack(st3);

        // Q-4 Stock span Problem --------------------------------
        int stocks[] = { 100, 80, 60, 70, 60, 85, 100 };
        int span[] = new int[stocks.length];
        stockSpan(stocks, span);

        for (int i = 0; i < span.length; i++) {
            System.out.print(span[i] + " ");
        }
        System.out.println("\n");

        // Q-5 Next greater element --------------------------------
        // Next greater element of some element x in an array in the first greater 
        // element that is to the right of x in the same array.
        // 1st Approach -> Nested Loop (TC - O(n^2))
        // 2nd Using Stack Approach ->  (TC - O(n))
        int arr[] = { 6, 8, 0, 1, 3 };
        int nextGreater[] = new int[arr.length];
        nextGreaterEle(arr, nextGreater);
        for (int i = 0; i < nextGreater.length; i++) {
            System.out.print(nextGreater[i] + " ");
        }
        System.out.println("\n");

        // Q-6 Valid Parentheses --------------------------------
        // Given a string s containing just the charaters '()', '(', '{', '}', '[' and ']' determine 
        // if the input string is valid.
        // An input string is valid if:
        // 1. Open brackets must be closed by the same type of brackets.
        // 2. Open brackets must be closed in the correct order.
        // 3. Every close bracket has a corresponding open bracket of the same type.
        String brackets = "({[]}())[]"; // true
        System.out.println(validParentheses(brackets));
        System.out.println();

        // Q-7 Duplicates Parentheses --------------------------------
        // Given a balanced expression, find if it contains duplicate parentheses or not. A set of
        // parentheses are duplicate if the same subexpression is surrounded by multiple parentheses.
        // Returns true if it contains duplicate parentheses else returns false.
        String str = "(((a+(b)))+(c+d))"; // true (duplicate parentheses exist)
        String str2 = "((a+b)+(c+d))"; // false (duplicate parentheses not exist)
        System.out.println(isDuplParenthese(str));
        System.out.println(isDuplParenthese(str2));
        System.out.println();

        // Q-8 Max Ractangular area in Histogram --------------------------------
        // Given a array of integers height representing the histogram's bar height where the
        // width of each bar is 1, return the area of the largest rectangle in the histogram.
        int height[] = { 2, 1, 5, 6, 2, 3 }; // height in histogram
        maxArea(height); // Output -> 10
    }
}