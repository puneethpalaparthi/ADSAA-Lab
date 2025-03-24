import java.util.*;

class Job {
    char jobId;
    int profit;
    int deadline;

    public Job(char jobId, int profit, int deadline) {
        this.jobId = jobId;
        this.profit = profit;
        this.deadline = deadline;
    }
}

public class JobSequencing {
    public static void jobSequencing(Job[] jobs, int n) {
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        boolean[] slot = new boolean[n];
        char[] result = new char[n];

        for (int i = 0; i < n; i++) {
            result[i] = '-';
        }

        for (int i = 0; i < n; i++) {
            for (int j = Math.min(n, jobs[i].deadline) - 1; j >= 0; j--) {
                if (!slot[j]) {
                    result[j] = jobs[i].jobId;
                    slot[j] = true;
                    break;
                }
            }
        }

        System.out.println("Job sequence to maximize profit:");
        for (char job : result) {
            if (job != '-') {
                System.out.print(job + " ");
            }
        }
    }

    public static void main(String[] args) {
        Job[] jobs = {
            new Job('A', 20, 2),
            new Job('B', 15, 2),
            new Job('C', 10, 1),
            new Job('D', 5, 3),
            new Job('E', 1, 3)
        };

        int n = jobs.length;
        jobSequencing(jobs, n);
    }
}
