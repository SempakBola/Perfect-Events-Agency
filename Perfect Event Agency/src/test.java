import java.util.Dictionary;
import java.util.Hashtable;
public class test {
    public static void main(String[] args) {

        Dictionary phoneBook = new Hashtable();

        // put() method
        phoneBook.put("Johnny Walker", "2178");
        phoneBook.put("Andrew Arnold", "1298");
        phoneBook.put("Ivy Briggs", "1877");
        phoneBook.put("Ricky McBright", "2001");

        //print out Hashtable out
        System.out.println(phoneBook);

        //let's get the value using the key
        System.out.println(phoneBook.get("Ivy Briggs"));
        //there's no such key in out Hashtable
        System.out.println(phoneBook.get("Sol Frank"));

        //Is there a record with the "Johnny Walker" key?
        System.out.println(((Hashtable) phoneBook).containsKey("Johnny Walker"));
        //all keys of the Hashtable
        System.out.println(((Hashtable) phoneBook).keySet());
        //values from Hashtable
        System.out.println(((Hashtable) phoneBook).values());

        //the quantity of records
        System.out.println(phoneBook.size());
        //removing one record
        phoneBook.remove("Andrew Arnold");
        System.out.println(phoneBook);
    }
}
