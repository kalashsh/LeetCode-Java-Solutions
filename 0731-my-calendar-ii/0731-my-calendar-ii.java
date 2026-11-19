class MyCalendarTwo {
    List<int[]> bookings;
    List<int[]> overlaps;
    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        overlaps = new ArrayList<>();
    }
    public boolean book(int startTime, int endTime) {
        for (int[] interval : overlaps) {
            if (Math.max(startTime, interval[0]) <
                Math.min(endTime, interval[1])) {
                return false;
            }
        }
        for (int[] interval : bookings) {
            int start = Math.max(startTime, interval[0]);
            int end = Math.min(endTime, interval[1]);
            if (start < end) {
                overlaps.add(new int[]{start, end});
            }
        }
        bookings.add(new int[]{startTime, endTime});
        return true;
    }
}
