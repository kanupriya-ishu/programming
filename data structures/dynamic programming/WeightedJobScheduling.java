/*
References: https://www.youtube.com/watch?v=cr6Ip0J9izc
			https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/WeightedJobSchedulingMaximumProfit.java
			
Question:
Given N jobs where every job is represented by following three elements of it.

Start Time
Finish Time
Profit or Value Associated (>= 0)
Find the maximum profit subset of jobs such that no two jobs in the subset overlap. 

Example: 

Input: Number of Jobs n = 4
       Job Details {Start Time, Finish Time, Profit}
       Job 1:  {1, 2, 50} 
       Job 2:  {3, 5, 20}
       Job 3:  {6, 19, 100}
       Job 4:  {2, 100, 200}
Output: The maximum profit is 250.
We can get the maximum profit by scheduling jobs 1 and 4.
Note that there is longer schedules possible Jobs 1, 2 and 3 
but the profit with this schedule is 20+50+100 which is less than 250.
*/

package test;
import java.util.*;

class FinishTimeComparator implements Comparator<Job> {
	
	@Override
	public int compare(Job job1, Job job2) {
		if(job1.end < job2.end) {
			return -1;
		}
		else {
			return 1;
		}
	}
}

class Job{
	int start, end, profit;
	
	Job(int start, int end, int profit){
		this.start = start;
		this.end = end;
		this.profit = profit;
	}
}

public class WeightedJobScheduling.java {

    public static void main(String[] args)
    {     
    	Job[] jobs = new Job[6];
    	jobs[0] = new Job(1,3,5);
        jobs[1] = new Job(2,5,6);
        jobs[2] = new Job(4,6,5);
        jobs[3] = new Job(6,7,4);
        jobs[4] = new Job(5,8,11);
        jobs[5] = new Job(7,9,2);
        
        System.out.println(maxProfit(jobs));
    }

	private static int maxProfit(Job[] jobs) {
		
		int[] dp = new int[jobs.length];
		int max = 0;
		FinishTimeComparator comparator = new FinishTimeComparator();
		// Sort array based on end time
		Arrays.sort(jobs, comparator);
				
		dp[0] = jobs[0].profit;
		
		for(int i=1; i<jobs.length; i++) {
			dp[i] = Math.max(jobs[i].profit, dp[i-1]);
			for(int j=0; j<i; j++) {
				// if job overlaps then break
				if(jobs[j].end >jobs[i].start) { 
					break;
				}
				
				// for every job see if this job profit plus profit till last 
				// non overlapping job is greater than profit till last job.
				dp[i] = Math.max(dp[i], dp[j] + jobs[i].profit);
			}
			
			max = Math.max(max, dp[i]);
		}
		
		return max;
	}

}
