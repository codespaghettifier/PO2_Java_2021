import java.util.Random;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.Iterator;

public class Main
{
    private static Random randomGnerator = new Random();

    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        String[] t1 = new String[n];
        for(int i = 0; i < t1.length; i++)
        {
            int length = randomGnerator.nextInt(16) + 5;
            t1[i] = randomString(length);
        }

        String[] t2 = new String[m];
        for(int i = 0; i < t2.length; i++)
        {
            t2[i] = t1[randomGnerator.nextInt(t1.length)];
        }

        String[] t3 = new String[m];
        for(int i = 0; i < t3.length; i++)
        {
            int length = randomGnerator.nextInt(16) + 5;
            t3[i] = randomString(length);
            for(int j = 0; j < t1.length; j++)
            {
                if(t3[i] == t1[j])
                {
                    i--;
                    break;
                }
            }
        }

        ArrayList<String> arrayList = new ArrayList<String>();
        LinkedList<String> linkedList = new LinkedList<String>();
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

        long startTime;
        long elapsedTime;

        System.out.println("Adding t1 elments:");

        startTime = System.nanoTime();
        for(int i = 0; i < t1.length; i++)
        {
            arrayList.add(t1[i]);
        }
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("\tArrayList.add():\t" + elapsedTime);

        startTime = System.nanoTime();
        for(int i = 0; i < t1.length; i++)
        {
            linkedList.add(t1[i]);
        }
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("\tLinkedList.add():\t" + elapsedTime);

        startTime = System.nanoTime();
        for(int i = 0; i < t1.length; i++)
        {
            treeMap.put(t1[i], 42);
        }
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("\tTreeMap.put():\t" + elapsedTime);

        startTime = System.nanoTime();
        for(int i = 0; i < t1.length; i++)
        {
            hashMap.put(t1[i], 42);
        }
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("\tHashMap.put():\t" + elapsedTime);

        System.out.println("");
        System.out.println("Iterating over elments with for:");

        startTime = System.nanoTime();
        for(int i = 0; i < t1.length; i++)
        {
            String str = arrayList.get(i);
        }
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("\tArrayList for + get():\t" + elapsedTime);

        startTime = System.nanoTime();
        for(int i = 0; i < t1.length; i++)
        {
            String str = linkedList.get(i);
        }
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("\tLinkedList for + get():\t" + elapsedTime);

        System.out.println("");
        System.out.println("Iterating over elments with for-each:");

        startTime = System.nanoTime();
        for(String str : arrayList)
        {
        }
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("\tArrayList for-each:\t" + elapsedTime);

        startTime = System.nanoTime();
        for(String str : linkedList)
        {
        }
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("\tLinkedList for-each:\t" + elapsedTime);

        System.out.println("");
        System.out.println("Iterating over elments with iterators:");

        startTime = System.nanoTime();
        for(Iterator<String> iterator = arrayList.iterator(); iterator.hasNext();)
        {
            String str = iterator.next();
        }
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("\tArrayList iterator:\t" + elapsedTime);

        startTime = System.nanoTime();
        for(Iterator<String> iterator = linkedList.iterator(); iterator.hasNext();)
        {
            String str = iterator.next();
        }
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("\tLinkedList iterator:\t" + elapsedTime);

        System.out.println("");
        System.out.println("Finding t2 elments:");

        startTime = System.nanoTime();
        for(int i = 0; i < t2.length; i++)
        {
            arrayList.contains(t2[i]);
        }
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("\tArrayList.contains():\t" + elapsedTime);

        startTime = System.nanoTime();
        for(int i = 0; i < t2.length; i++)
        {
            linkedList.contains(t2[i]);
        }
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("\tLinkedList.contains():\t" + elapsedTime);

        startTime = System.nanoTime();
        for(int i = 0; i < t2.length; i++)
        {
            treeMap.containsKey(t2[i]);
        }
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("\tTreeMap.containsKey():\t" + elapsedTime);

        startTime = System.nanoTime();
        for(int i = 0; i < t2.length; i++)
        {
            hashMap.containsKey(t2[i]);
        }
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("\tHashMap.containsKey():\t" + elapsedTime);

        System.out.println("");
        System.out.println("Finding t3 elments:");

        startTime = System.nanoTime();
        for(int i = 0; i < t3.length; i++)
        {
            arrayList.contains(t3[i]);
        }
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("\tArrayList.contains():\t" + elapsedTime);

        startTime = System.nanoTime();
        for(int i = 0; i < t3.length; i++)
        {
            linkedList.contains(t3[i]);
        }
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("\tLinkedList.contains():\t" + elapsedTime);

        startTime = System.nanoTime();
        for(int i = 0; i < t3.length; i++)
        {
            treeMap.containsKey(t3[i]);
        }
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("\tTreeMap.containsKey():\t" + elapsedTime);

        startTime = System.nanoTime();
        for(int i = 0; i < t3.length; i++)
        {
            hashMap.containsKey(t3[i]);
        }
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("\tHashMap.containsKey():\t" + elapsedTime);

        System.out.println("");
        System.out.println("Removing elments:");

        startTime = System.nanoTime();
        for(int i = 0; i < t3.length; i++)
        {
            arrayList.clear();
        }
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("\tArrayList.clear():\t" + elapsedTime);

        startTime = System.nanoTime();
        for(int i = 0; i < t3.length; i++)
        {
            linkedList.clear();
        }
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("\tLinkedList.clear():\t" + elapsedTime);

        startTime = System.nanoTime();
        for(int i = 0; i < t3.length; i++)
        {
            treeMap.clear();
        }
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("\tTreeMap.clear():\t" + elapsedTime);

        startTime = System.nanoTime();
        for(int i = 0; i < t3.length; i++)
        {
            hashMap.clear();
        }
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("\tHashMap.clear():\t" + elapsedTime);

        System.out.println("");
    }

    private static String randomString(int length)
    {
        String str = "";
        for(int i = 0; i < length; i++)
        {
            char c = randomGnerator.nextInt(2) == 0 ? 'a' : 'A';
            c += (char)randomGnerator.nextInt(26);
            str += c;
        }
        return str;
    }
}