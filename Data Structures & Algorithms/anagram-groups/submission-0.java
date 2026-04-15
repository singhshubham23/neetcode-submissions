
 class Solution{
    public static List<List<String>> groupAnagrams(String[] strs) {
            // HashMap: key -> sorted string, value -> list of anagrams
                    HashMap<String, List<String>> map = new HashMap<>();

                            for (String str : strs) {
                                        // Convert string to char array
                                                    char[] chars = str.toCharArray();
                                                                
                                                                            // Sort the characters
                                                                                        Arrays.sort(chars);
                                                                                                    
                                                                                                                // Create key from sorted characters
                                                                                                                            String key = new String(chars);

                                                                                                                                        // Add to map
                                                                                                                                                    if (!map.containsKey(key)) {
                                                                                                                                                                    map.put(key, new ArrayList<>());
                                                                                                                                                                                }
                                                                                                                                                                                            map.get(key).add(str);
                                                                                                                                                                                                    }

                                                                                                                                                                                                            // Return all grouped anagrams
                                                                                                                                                                                                                    return new ArrayList<>(map.values());
                                                                                                                                                                                                                        }
}