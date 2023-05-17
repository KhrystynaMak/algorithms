/*
* Data structure.
・Integer array id[] of length N.
・Interpretation: id[i] is parent of i.
・Root of i is id[id[id[...id[i]...]]].
*
* Quick-union defect.
・Trees can get tall.
・Find too expensive (could be N array accesses).
* */
public class QuickUnion {

    int[] ids;

    /*
     * set id of each object to itself (N array accesses)
     */
    public QuickUnion(int elementsQuantity) {
        this.ids = new int[elementsQuantity];

        for (int i = 0; i < elementsQuantity; i++) {
            ids[i] = i;
        }
    }

    /*
    * chase parent pointers until reach root (depth of i array accesses)
    * */
    public int getRoot(int i) {
        while(i != ids[i]) {
            i = ids[i];
        }
        return i;
    }

    /*
    * check if p and q have same root (depth of p and q array accesses)
    * */
    public boolean connected(int p, int q) {
        return getRoot(p) == getRoot(q);
    }

    /*
    * change root of p to point to root of q (depth of p and q array accesses)
    * */
    public void union(int p, int q) {
        int idOfP = getRoot(p);
        int idOfQ = getRoot(q);

        ids[idOfP] = idOfQ;
    }
}
