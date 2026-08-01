

class Twitter {
    private static class Tweet {
        int id;
        int time;
        Tweet next;

        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
            this.next = null;
        }
    }

    private static class User {
        int id;
        Set<Integer> followeeIds;
        Tweet tweetHead;

        public User(int id) {
            this.id = id;
            this.followeeIds = new HashSet<>();
            this.tweetHead = null;
            follow(id);
        }

        public void follow(int followeeId) {
            followeeIds.add(followeeId);
        }

        public void unfollow(int followeeId) {
            followeeIds.remove(followeeId);
        }

        public void post(int tweetId, int time) {
            Tweet oldHead = tweetHead;
            tweetHead = new Tweet(tweetId, time);
            tweetHead.next = oldHead;
        }
    }

    private static int timeStamp = 0;
    private Map<Integer, User> userMap;

    public Twitter() {
        this.userMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        userMap.putIfAbsent(userId, new User(userId));
        userMap.get(userId).post(tweetId, timeStamp++);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        if (!userMap.containsKey(userId)) {
            return feed;
        }

        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.time - a.time);

        Set<Integer> followees = userMap.get(userId).followeeIds;
        for (int followeeId : followees) {
            User followee = userMap.get(followeeId);
            if (followee != null && followee.tweetHead != null) {
                maxHeap.offer(followee.tweetHead);
            }
        }

        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            Tweet curr = maxHeap.poll();
            feed.add(curr.id);
            count++;

            if (curr.next != null) {
                maxHeap.offer(curr.next);
            }
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {
        userMap.putIfAbsent(followerId, new User(followerId));
        userMap.putIfAbsent(followeeId, new User(followeeId));
        userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId)
            return;

        if (userMap.containsKey(followerId)) {
            userMap.get(followerId).unfollow(followeeId);
        }
    }
}
