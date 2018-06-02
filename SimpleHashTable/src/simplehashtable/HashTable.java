
package simplehashtable;

public class HashTable implements IHashTable
{
    Node hashTable[];
    int size;
    final int INIT_SIZE = 10;
    int total;
    
    public HashTable()
    {
        this.size = INIT_SIZE;
        hashTable = new Node[size];
    }

    @Override
    public void add(Object key, Object value) 
    {
        if(!this.containsKey(key))
        {
            int quadaraticProbe = 0;
            int hashCode = hash(key);
            int newCode = hashCode;
            Node node = new Node(key, value);


            while(hashTable[newCode] != null)
            {
                newCode = hash(hashCode + (quadaraticProbe * quadaraticProbe++));
            }

            hashTable[newCode] = node; 
            total++;
        }
        else
            System.out.println("Cannot have duplicate keys.");
        if((float)total/(float)size > .81)
        {
            reHash();
        }
    }

    @Override
    public void delete(Object key) 
    {
        int i = 0;
        for(Node node : hashTable)
        {
            if(node != null && node.getKey() == key)
            {
                hashTable[i] = null;
                total--;
            }
            i++;
        }
    }

    @Override
    public void print() 
    {
        int i = 0;
        for(Node node : hashTable)
        {
            if(node != null)
            {
                System.out.println(i + " - " + node.getKey() + " - " + node.getValue());
            }
            i++;
            
        }
    }

    @Override
    public void reHash() 
    {
       Node tempTable[] = hashTable.clone();
       size = size*2;
       total = 0;
       hashTable = new Node[size];
       for(Node node : tempTable)
       {
           if(node != null)
           {
               this.add(node.getKey(), node.getValue());
           }
       }
    }
    
    public boolean containsKey(Object key)
    {
        for(Node node : hashTable)
        {
            if(node != null)
            {
                if(node.getKey() == key)
                {
                    printValue(node);
                    return true;
                }
            }
                   
        }
        return false;        
    }
    
    @Override
    public int hash(Object key)
    {
        return (int)key%size;
    }
    
    public void printValue(Node node)
    {
        System.out.println("It's assosiated value is : " + node.getValue());
    }
    
}
