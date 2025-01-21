/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2.sınıf2.proje;



  public class AVLNodeComparable<Key extends Comparable<Key>, Value> {

    public final Key key;
    public Value index;
    public int height;
    public int size;
    public AVLNodeComparable left;
    public AVLNodeComparable right;

    public AVLNodeComparable(Key key, Value val, int height, int size) {
        this.key = key;
        this.index = val;
        this.height = height;
        this.size = size;

    }

}

 
        
    
    

   
    
    
    
    
    
    
