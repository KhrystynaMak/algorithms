/*
* Data structure.
・Integer array id[] of length N.
・Interpretation: p and q are connected iff they have the same id.
* */

public class QuickFind {
    int[] ids;

    /*
    * set id of each object to itself (N array accesses)
    */
    public QuickFind(int elementsQuantity) {
        this.ids = new int[elementsQuantity];

        for (int i = 0; i < elementsQuantity; i++) {
            ids[i] = i;
        }
    }

    /*
    * Check if p and q have the same id
    */
    public boolean connected(int p, int q) {
        return ids[p] == ids[q];
    }

    /*
    * Union. To merge components containing p and q, change all entries whose id equals id[p] to id[q].
    * Union is too expensive. It takes N 2 array accesses to process a sequence of N union commands on N objects.
    * */
    public void union(int p, int q) {
        int idOfP = ids[p];
        int idOfQ = ids[q];

        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == idOfP) {
                ids[i] = idOfQ;
            }
        }
    }
}
