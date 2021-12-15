import java.lang.reflect.*;

public class Stack<T>
{
    private final int maxSize;
    private final T[] stack;
    private int currentSize = 0;
    private Class<T[]> classT;

    public Stack(int maxSize, Class<T[]> classT)
    {
        this.maxSize = maxSize;
        this.classT = classT;
        stack = classT.cast(Array.newInstance(classT.getComponentType(), maxSize));
    }

    public Stack(Stack<T> other)
    {
        maxSize = other.maxSize;
        classT = other.classT;
        stack = classT.cast(Array.newInstance(classT.getComponentType(), maxSize));
        currentSize = other.currentSize;
        for(int i = 0; i < currentSize; i++)
        {
            stack[i] = other.stack[i];
        }
    }

    public Class<T[]> getClassT()
    {
        return classT;
    }

    public boolean isEmpty()
    {
        return currentSize == 0;
    }

    public boolean isFull()
    {
        return currentSize == maxSize;
    }

    public void push(T element) throws StackOverflowException
    {
        if(isFull()) throw new StackOverflowException();

        stack[currentSize] = element;
        currentSize++;
    }

    public T pop() throws StackUnderflowException
    {
        if(isEmpty()) throw new StackUnderflowException();

        currentSize--;
        return stack[currentSize];
    }

    public int getCurrentSize()
    {
        return currentSize;
    }

    public int getMaxSize()
    {
        return maxSize;
    }
}
