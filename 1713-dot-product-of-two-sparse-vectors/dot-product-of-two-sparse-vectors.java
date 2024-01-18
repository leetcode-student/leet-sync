class SparseVector {
    List<Element> elements;
    
    SparseVector(int[] nums) {
        elements = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                Element element = new Element();
                element.index = i;
                element.value = nums[i];
                
                elements.add(element);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int i = 0;
        int j = 0;
        int dotProduct = 0;

        while (i < elements.size() && j < vec.elements.size()) {
            if (elements.get(i).index == vec.elements.get(j).index) {
                dotProduct += elements.get(i).value * vec.elements.get(j).value;
                i++;
                j++;
            } else if (elements.get(i).index < vec.elements.get(j).index) {
                i++;
            } else {
                j++;
            }
        }

        return dotProduct;
    }

    private static class Element {
        int index;
        int value;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);