/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.helsinki.tietorakenteet;

/**
 *
 * @author Matti
 */
public class MyEntry<Key, Value> {
    private MyEntry<Key, Value> next;
    private final Key key;
    private Value value;
    
    public MyEntry(Key key, Value value){
        this.key = key;
        this.value = value;
    }
    
    public Key getKey(){
        return this.key;
    }
    public void setValue(Value value){
        this.value = value;
    }
    public Value getValue(){
        return this.value;
    }
    public void setNext(MyEntry<Key, Value> next){
        this.next = next;
    }
    public MyEntry<Key, Value> getNext(){
        return this.next;
    }
    
}
