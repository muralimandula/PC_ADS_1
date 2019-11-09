import java.util.Scanner;
/**
 *the class for ransomNote.
 */

class RansomNote {

    // A symbol table for Key,Value pairs. (HashTable)
    // Uses SeparateChainingHashST.java from algs4.

    public  SeparateChainingHashST<String, Integer> hashTable;


    RansomNote() {
        this.hashTable = new SeparateChainingHashST<String, Integer>();
    }



    
    // To put the element into the hashTable.
    // Increases count if already exists.

    public void add(final String item) {

        if (hashTable.contains(item)) {
            // If already exists, increasing previous count by 1.
            hashTable.put(item, hashTable.get(item) + 1);
        } else {
            // adding into hashTable as new item, with count 1
            hashTable.put(item, 1);
        }
    }



    // To findAndUpdate whether the ransom note can be made from the magzineWords or NOT.
     
    public boolean findAndUpdate(final String word) {
        if (!hashTable.contains(word)) {
            // If word does not contain
            return false;
        } else {

            // Decreasing its frequency by 1, as it is used.
            int counter = hashTable.get(word) - 1;

            if (counter == 0) {
                // Deletes if no more exists
                hashTable.delete(word);
            } else {
                // Update decreased frequency
                hashTable.put(word, counter);
            }
            return true;
        }
    }


    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);


        RansomNote obj = new RansomNote(); // Create a hahsObj<String, Integer>

        String[] magzineWords = scan.nextLine().split(" ");
        String[] noteWords = scan.nextLine().split(" ");

        for (int i = 0; i < magzineWords.length; i++) {
            obj.add(magzineWords[i]);
        }

        int flag = 0;
        for (int i = 0; i < noteWords.length; i++) {

            if (! obj.findAndUpdate(noteWords[i])) {

                // If not found, can't make note.
                // SO, Break and return "No"
                System.out.println("\n No! can't make \"" + noteWords[i] + "\" from the magzine words.\n");
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            // flag remains 0, only if every word found and can be used from magzine. 
            System.out.println("\n Yes! A Ransom note can be made.\n");
        }
        scan.close();
    }
}