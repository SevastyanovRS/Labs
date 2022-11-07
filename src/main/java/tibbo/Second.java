package tibbo;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;

public class Second {

    /**
     * implement hit counting logic per user and must be thread safe
     */

    public static void main(String[] args) {
        UserStats userStats = new UserStats();

        ArrayList<Thread> arrayList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            System.out.println("Thread-" + i + " started");
            arrayList.add(new Thread(() -> userStats.onUserCall(String.valueOf(1)), "Thread-" + i));
        }
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            System.out.println("Thread-" + i + " started");
            arrayList.add(new Thread(() -> userStats.onUserCall(String.valueOf(finalI)), "Thread-" + i));
        }
        for (int i = 9; i >= 0; i--) {
            int finalI = i;
            System.out.println("Thread-" + i + " started");
            arrayList.add(new Thread(() -> userStats.onUserCall(String.valueOf(finalI)), "Thread-" + i));
        }
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            System.out.println("Thread-" + i + " started");
            arrayList.add(new Thread(() -> userStats.onUserCall(String.valueOf(1)), "Thread-" + i));
        }
        arrayList.forEach(Thread::start);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Map<String, AtomicLong> hitsPerUser = userStats.getHitsPerUser();
        System.out.println(hitsPerUser);
    }

}

class UserStats {
    private volatile Map<String, AtomicLong> hitsPerUser;

    public void onUserCall(String userId) {

        if (hitsPerUser == null) {
            synchronized (UserStats.class) {
                if (hitsPerUser == null) {
                    hitsPerUser = new ConcurrentHashMap<>();
                }
            }
        }

        if (!hitsPerUser.containsKey(userId)) {
            synchronized (UserStats.class) {
                hitsPerUser.computeIfAbsent(userId, s -> new AtomicLong());
            }
        }

        hitsPerUser.get(userId).addAndGet(1L);
    }

    public Map<String, AtomicLong> getHitsPerUser() {
        return hitsPerUser;
    }

}
