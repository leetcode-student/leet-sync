class MovingAverage {
    private int size;
    private LinkedList<Integer> stream;
    private int sum;

    public MovingAverage(int size) {
        this.size = size;
        this.stream = new LinkedList<>();
    }
    
    public double next(int val) {
        stream.add(val);
        sum += val;

        if (stream.size() > size) {
            int first = stream.poll();
            sum -= first;
        }

        return (double) sum / stream.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */