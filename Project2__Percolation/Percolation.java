import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean[][] grid;

    // since woking on 1D array, top = 0
    // incase of 2D, it is [0][0]
    private int top = 0;
    private int bottom;
    private int size;
    private int openedSites = 0;

    // In weightQUF:
    // we represent N * N sites of 2D grid
    // into N^2 1D sites
    private WeightedQuickUnionUF weightedQUF;

    /**
     * Creates N-by-N grid, with all sites blocked.
     */
    public Percolation(int N) {
        if(N <= 0){
            throw new IllegalArgumentException();
        }
        this.size = N;

        // since woking on 1D array
        this.bottom = size * size + 1;


        //  weightedQuickUF to maintain connected components and their union
        //  No.of sites in weightedQUF represents the size of the grid(N * N)
        //  Hence, no.of sites = ((N * N) + top + bottom)

        this.weightedQUF = new WeightedQuickUnionUF((size * size) + 2);
        this.grid = new boolean[size][size];
    }

    /**
     * Opens site (row i, column j) if it is not already.
     */

    public void open(int i, int j) {
        
        // i,j must be with in N.
        if ((0 < i && i <= size) && (0 < j && j <= size)) {

            if(grid[i-1][j-1] == true) {
                // already open
                return;
            }

            // openening now, making the value in grid true
            grid[i - 1][j - 1] = true;
            openedSites += 1;

            if (i == 1) {
                // if belongs to top row
                weightedQUF.union(get1DPosition(i, j), top);
            }

            if (i == size) {
                // belongs to bottom row
                weightedQUF.union(get1DPosition(i, j), bottom);
            }

            if (j > 1 && isOpen(i, j - 1)) {
                // below top row and open from top
                weightedQUF.union(get1DPosition(i, j), get1DPosition(i, j - 1));
            }
            if (j < size && isOpen(i, j + 1)) {
                // above bottom and open from right
                weightedQUF.union(get1DPosition(i, j), get1DPosition(i, j + 1));
            }
            if (i > 1 && isOpen(i - 1, j)) {
                // right to the left wall and open from left wall
                weightedQUF.union(get1DPosition(i, j), get1DPosition(i - 1, j));
            }

            if (i < size && isOpen(i + 1, j)) {
                // left to the right wall and open from the right wall
                weightedQUF.union(get1DPosition(i, j), get1DPosition(i + 1, j));
            }

        } else {
            throw new IllegalArgumentException();
        }
    }

    private int get1DPosition(int i, int j) {
        return size * (i - 1) + j;
    }

    /**
     * Is site (row i, column j) open?
     */
    public boolean isOpen(int i, int j) {
        // boundary validation
        if ((0 < i && i <= size) && (0 < j && j <= size)) {
            return grid[i-1][j-1];
        } else {
            throw new IllegalArgumentException();
        }
    }

     public int numberOfOpenSites(){
        return openedSites;
     }

    /**
     * checks for whether given (i, j) connected to the top.
     * 
     */
    public boolean isFull(int i, int j) {
        if ((0 < i && i <= size) && (0 < j && j <= size)) {
            return weightedQUF.connected(top, get1DPosition(i , j));
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 
     * checks for whether top and bottom connected.
     */
    public boolean percolates() {
        //                         (0, (N * N) + 1)
        return weightedQUF.connected(top, bottom);
    }


public static void main(String[] args) {

}



}
