
public class MyQueue<T>  {
	private T[] arr;

    private int total, first, next;

    public MyQueue(int capacity)
    {
        arr = (T[]) new Object[capacity];
    }

    private void resize(int capacity)
    {
        T[] tmp = (T[]) new Object[capacity];

        for (int i = 0; i < total; i++)
            tmp[i] = arr[(first + i) % arr.length];

        arr = tmp;
        first = 0;
        next = total;
    }

    public MyQueue<T> enqueue(T ele)
    {
        if (isFUll()) throw new java.lang.IndexOutOfBoundsException(); 
        arr[next++] = ele;
        if (next == arr.length) next = 0;
        total++;
        return this;
    }

    public T dequeue()
    {
        if (isEmpty()) throw new java.util.NoSuchElementException();
        T ele = arr[first];
        arr[first] = null;
        if (++first == arr.length) first = 0;
        if (--total > 0 && total == arr.length / 4) resize(arr.length / 2);
        return ele;
    }
    public boolean isFUll()
    {
    	return arr.length == total;
    }
    public boolean isEmpty()
    {
    	return total ==0;
    }

    @Override
    public String toString()
    {
        return java.util.Arrays.toString(arr);
    }


}
