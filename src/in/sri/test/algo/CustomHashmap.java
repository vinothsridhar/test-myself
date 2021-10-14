/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		CustomHashMap map = new CustomHashMap();
		map.put(7, "a");
		map.put(14, "b");
		System.out.println("key 7: " + map.get(7));
		System.out.println("key 14: " + map.get(14));
	}
	
	private static class CustomHashMap {
	    private static int SIZE = 100;
	    private Entry[] arr = new Entry[100];
	    
	    private int hash(int key) {
	        return key % 7;
	    }
	    
	    private void put(int key, String value) {
	        Entry entry = new Entry(key, value);
	        int index = hash(key);
	        while (arr[index] != null) {
	            Entry existing = arr[index];
	            if (existing.key == entry.key) {
	                existing.value = entry.value;
	                return;
	            }
	            index++;
	        }
	        if (index >= 100) {
	            throw new RuntimeException("Capacity full");
	        }
	        arr[index] = entry;
	    }
	    
	    private String get(int key) {
	        int index = hash(key);
	        while (arr[index] != null) {
	            Entry existing = arr[index];
	            if (existing.key == key) {
	                return existing.value;
	            }
	            index++;
	        }
	        return null;
	    }
	}
	
	private static class Entry {
	    int key;
	    String value;
	    
	    public Entry(int key, String value) {
	        this.key = key;
	        this.value = value;
	    }
	}
}
