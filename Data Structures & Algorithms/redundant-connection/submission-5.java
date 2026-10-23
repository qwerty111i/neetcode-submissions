class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parentNodes = new int[edges.length + 1];
        for (int i = 0; i < parentNodes.length; i++) {
            parentNodes[i] = i;
        }

        for (int[] edge : edges) {
            int vertexA = edge[0];
            int vertexB = edge[1];

            int parentA = findParent(parentNodes, vertexA);
            int parentB = findParent(parentNodes, vertexB);

            if (parentA == parentB) {
                return edge;
            } else {
                parentNodes[parentB] = parentA;
            }
        }

        return new int[]{};
    }

    public int findParent(int[] parentNodes, int currVertex) {
        if (parentNodes[currVertex] != currVertex) {
            return parentNodes[currVertex] = findParent(parentNodes, parentNodes[currVertex]);
        }
        return parentNodes[currVertex];
    }
}
