class Solution {
    public int[] findBuildings(int[] heights) {
        Stack<Integer> buildingViewsStack = new Stack<>();
        buildingViewsStack.add(heights.length - 1);

        int currMax = heights[heights.length - 1];
        for (int i = heights.length - 2; i >= 0; i--) {
            if (heights[i] > currMax) {
                buildingViewsStack.add(i);
                currMax = heights[i];
            }
        }

        //System.out.println(buildingViewsStack);

        int[] buildingViews = new int[buildingViewsStack.size()];
        for (int i = 0; i < buildingViews.length; i++) {
            buildingViews[i] = buildingViewsStack.pop();
        }

        return buildingViews;
    }
}