import java.util.Scanner;

public class WeightedQuickUnionUF {

    public int[] parent;
    // In int[] of paent: index is the site, value is the root/parent
    // Ex: parent[3] = 5.
    //           5 is the parent of site 3
    //           3 and 5 are connected.


    public int[] size;
    // size[3] or size[5] is 2.
    // SIze hold the count of sites in its component/path.

    public int noOfComponents;


    WeightedQuickUnionUF(int n) {
        noOfComponents = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;  // Index as its value/name
            size[i] = 1;    // Each holds itself initially, so size, 1.
        }
    }

    // Returns the number of components.
    // Initially n componenets, Since each site is a componenet with its own.
    public int noOfComponents() {
        return noOfComponents;
    }
  

    // Returns main root/parent of p.
    public int find(int p) {

        while (p != parent[p]) {
            // Recursively goes to it's root parent
            p = parent[p];
        }
        return p;
    }

    // Return TRUE if p,q in same component (i.e., connected)
    public boolean isConnected(int p, int q) {
        // compares main root/parent of both p and q.
        return find(p) == find(q);
    }


    public void union(int p, int q) {
        int rootOfP = find(p);
        int rootOfQ = find(q);

        if (rootOfP == rootOfQ) {
            // Already connected/ in union.
            return;
        }
        // Comparing sizes of their main root/parents
        if (size[rootOfP] > size[rootOfQ]) {

            // Greater sized one becomes the lesser one's main root/parent
            // Badaa banthaa baap
            parent[rootOfQ] = rootOfP;

            // component of p is added with component q, 
            // size[p] = size[p] + size[q]
            size[rootOfP] += size[rootOfQ];
        }
        else {
            parent[rootOfP] = rootOfQ;
            size[rootOfQ] += size[rootOfP];
        }

        // Every merge/union decreases noOfComponents of components by 1
        noOfComponents--;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter no.of sites/nodes : ");

        int noOfSites = Integer.parseInt(scan.nextLine());
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(noOfSites);


        int choice = 0;
        
        while (choice != 5) {

            System.out.println("\n1.FIND\t2.UNION\t3.IsConnected\t4.SIZE\t5.END");

            choice = Integer.parseInt(scan.nextLine());

            switch(choice) {
                case 1:
                    System.out.print("Enter the site no (<= "+  (noOfSites - 1)+") : ");
                    int toFind = Integer.parseInt(scan.nextLine());
                    int root = uf.find(toFind);
    
                    System.out.println("Root of " + toFind + " is " + root);
                    break;

                case 2:
                    System.out.print("Enter the site to be connected : ");
                    int p = Integer.parseInt(scan.nextLine());
                    System.out.print("Enter the site to be connected with: ");
                    int q = Integer.parseInt(scan.nextLine());
                    uf.union(p, q);
                    break;

                case 3:
                    System.out.print("Enter the site to be checked, p : ");
                    int p1 = Integer.parseInt(scan.nextLine());
                    System.out.print("Enter the site to be checked with, q : ");
                    int q1 = Integer.parseInt(scan.nextLine());
                    if (uf.isConnected(p1, q1)) {
                        System.out.println("\n\tYes! " + p1 + " and " + q1 + " are connected.");
                    } else {
                        System.out.println("\n\tNO! " + p1 + " and " + q1 + " are not connected.");
                    }
                    break;
                
                case 4:
                    System.out.print("Enter the site no to check for size (<= "+  (noOfSites - 1)+") : ");
                    toFind = Integer.parseInt(scan.nextLine());
                    System.out.println("Size of " + toFind + " is " + uf.size[toFind] + " with root " + uf.find(toFind));
                    break;

                case 5:
                    System.out.println("There are " + uf.noOfComponents + " componenets among " + noOfSites);
                    break;
                default:
                    break;
            }
        }
        scan.close();;

    }

}
