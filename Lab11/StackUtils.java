public class StackUtils
{
    public static <T> String toString(Stack<T> stack) throws StackOverflowException, StackUnderflowException
    {
        Stack<T> copy = new Stack<T>(stack.getMaxSize(), stack.getClassT()); 
        while(!stack.isEmpty())
        {
            copy.push(stack.pop());
        }

        String str = "";
        while(!copy.isEmpty())
        {
	    T temp = copy.pop();
	    stack.push(temp);
            str += temp + ", ";
        }

        return str;
    }

    public static <T> boolean compare(Stack<T> a, Stack<T> b) throws StackUnderflowException
    {
        if(a.getCurrentSize() != b.getCurrentSize()) return false;
        
        if(a.getMaxSize() != b.getMaxSize()) return false;

        Stack<T> copyA = new Stack<T>(a);
        Stack<T> copyB = new Stack<T>(b);
        while(!copyA.isEmpty())
        {
            if(copyA.pop() != copyB.pop())
            {
                return false;
            }
        }
        
        return true;
    }

    public static <T> void swap(Stack<T> a, Stack<T> b) throws StackOverflowException, StackUnderflowException
    {
        Stack<T> copyA = new Stack<T>(a.getMaxSize(), a.getClassT()); 
        while(!a.isEmpty())
        {
            copyA.push(a.pop());
        }

        Stack<T> copyB = new Stack<T>(b.getMaxSize(), b.getClassT()); 
        while(!b.isEmpty())
        {
            copyB.push(b.pop());
        }

        while(!copyB.isEmpty())
        {
            a.push(copyB.pop());
        }

        while(!copyA.isEmpty())
        {
            b.push(copyA.pop());
        }
    }
}
