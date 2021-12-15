public class Main
{
    public static void main(String[] args) 
    {
        try
        {
            Stack<Integer> stack = new Stack<Integer>(5, Integer[].class);

            System.out.println("isEmpty(): " + stack.isEmpty());
            System.out.println("isFull(): " + stack.isEmpty());

            stack.push(42);
            System.out.println("isEmpty(): " + stack.isEmpty());
            
            stack.push(2);
            stack.push(3);
            stack.push(4);
            System.out.println("currentSize(): " + stack.getCurrentSize());
            System.out.println("maxSize(): " + stack.getMaxSize());

            stack.push(5);
            stack.push(6);
        }
        catch(StackOverflowException exception)
        {
            System.out.println("Caught SackOverflowException (expected).");
        }

        try
        {
            Stack<Integer> stack = new Stack<Integer>(5, Integer[].class);

            System.out.println("isEmpty(): " + stack.isEmpty());
            stack.pop();
        }
        catch(StackUnderflowException exception)
        {
            System.out.println("Caught SackUnderflowException (expected).");
        }

        try
        {
            Stack<Integer> stack = new Stack<Integer>(5, Integer[].class);

            stack.push(42);
            stack.push(420);
            stack.push(4);
            stack.push(2);
            stack.push(0);
            System.out.println(StackUtils.toString(stack));

            Stack<Integer> stackB = new Stack<Integer>(stack);
            System.out.println("StackUtils.compare:() " + StackUtils.compare(stack, stackB));

            stackB.pop();
            stackB.pop();
            StackUtils.swap(stack, stackB);
            System.out.println("StackUtils.compare(): " + StackUtils.compare(stack, stackB));
            System.out.println("StackUtils.toString(): " + StackUtils.toString(stack));
        }
        catch(StackOverflowException exception)
        {
            System.out.println("Caught SackOverflowException (not expected).");
        }
        catch(StackUnderflowException exception)
        {
            System.out.println("Caught StackUnderflowException (not expected).");
        }

    }
}
