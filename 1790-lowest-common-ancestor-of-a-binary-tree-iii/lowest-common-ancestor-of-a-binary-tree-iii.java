/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        return lowestCommonAncestor(p, q, new HashSet<>(), new HashSet<>());
    }

    private Node lowestCommonAncestor(Node p, Node q, Set<Node> pCache, Set<Node> qCache) {
        if (p == q) {
            return p;
        } else if (pCache.contains(q)) {
            return q;
        } else if (qCache.contains(p)) {
            return p;
        }

        pCache.add(p);
        qCache.add(q);

        if (p.parent != null) {
            p = p.parent;
        }

        if (q.parent != null) {
            q = q.parent;
        }

        return lowestCommonAncestor(p, q, pCache, qCache);
    }
}