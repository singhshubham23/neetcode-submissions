class TimeMap {

        private class DataPoint{
            String value;
            int timestamp;

            DataPoint(String value, int timestamp){
                this.value = value;
                this.timestamp = timestamp;
            }
        }
    private Map<String, List<DataPoint>> map;
    public TimeMap(){
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k-> new ArrayList<>()).add(new DataPoint(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }

        List<DataPoint> data = map.get(key);
        return binarySearch(data, timestamp);
    }
    private String binarySearch(List<DataPoint> list, int target){
        int left = 0;
        int right = list.size()-1;
        String result = "";

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(list.get(mid).timestamp <= target){
                result = list.get(mid).value;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return result;
    }
}
