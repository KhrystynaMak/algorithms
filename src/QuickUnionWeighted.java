/*
* Data structure. Same as quick-union, but maintain extra array sz[i] to count number of objects in the tree rooted at i
*  Depth of any node x is at most lg N.
*
* Enhancement: path compression
*   just after computing the root of P, set the id of each examined node to point to that root.
* */
public class QuickUnionWeighted {
    int[] ids;
    int[] size;

    public QuickUnionWeighted(int elementsQuantity) {
        this.ids = new int[elementsQuantity];
        this.size = new int[elementsQuantity];

        for (int i = 0; i < elementsQuantity; i++) {
            ids[i] = i;
            size[i] = 1;
        }
    }

    public int getRoot(int i) {
        while(i != ids[i]) {
            //to make path compression improvement we add this line:
            ids[i] = ids[ids[i]]; // make every other node in path point to ots grandparent (thereby halving path length)
            i = ids[i];
        }
        return i;
    }

    /*
    * takes time proportional to depth of p and q.
    * */
    public boolean connected(int p, int q) {
        return getRoot(p) == getRoot(q);
    }

    /*
    * Link root of smaller tree to root of larger tree.
    * Update the sz[] array
    * Takes constant time, given roots.
    * */
    public void union(int p, int q) {
        int idOfP = getRoot(p);
        int idOfQ = getRoot(q);

        if (idOfP == idOfQ) {
            return;
        }

        if (size[idOfP] > size[idOfQ]) {
            ids[idOfP] = idOfQ;
            size[idOfP] += size[idOfQ];
        } else {
            ids[idOfQ] = idOfP;
            size[idOfQ] += size[idOfP];
        }
    }
}
