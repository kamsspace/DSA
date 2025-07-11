// LeetCode problem: 2402. Meeting Rooms III
// Difficulty: hard
// time: O(nlogn)
// space: O(n)
class Pair {
    long meeting;
    int room;
    
    public Pair(long meeting, int room) {
        this.meeting = meeting;
        this.room = room;
    }
}
class Solution {
    public int mostBooked(int n, int[][] meetings) {
        if (n == 1) {
            return 0;
        }

        Arrays.sort(meetings, (a,b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            freeRooms.offer(i);
        }

        PriorityQueue<Pair> endings = new PriorityQueue<>(
            (a,b) -> (a.meeting == b.meeting) ? Integer.compare(a.room, b.room) : Long.compare(a.meeting, b.meeting)
        );
        int[] rooms = new int[n];

        for (int[] m : meetings) {
            while (!endings.isEmpty() && endings.peek().meeting <= m[0]) {
                freeRooms.offer(endings.poll().room);
            }

            if (!freeRooms.isEmpty()) {
                int number = freeRooms.poll();
                rooms[number]++;
                endings.offer(new Pair(m[1],number));
            } else {
                Pair next = endings.poll();
                endings.offer(new Pair(next.meeting + m[1] - m[0],next.room));
                rooms[next.room]++;
            }
        }

        int heldMostMeetings = -1, room = -1;
        for (int i = 0; i < n; i++) {
            if (heldMostMeetings < rooms[i]) {
                heldMostMeetings = rooms[i];
                room = i;
            }
        }

        return room;
    }
}
