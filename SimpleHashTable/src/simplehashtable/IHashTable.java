
package simplehashtable;

public interface IHashTable<K, V>
{
    public void add(K key, V value);
    
    public void delete(K key);
    
    public void print();
    
    public void reHash();
    
    public int hash(K key);
}
