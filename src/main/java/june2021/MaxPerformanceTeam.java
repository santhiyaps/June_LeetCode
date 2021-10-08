package june2021;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


public class MaxPerformanceTeam {
    private class Employee{
        int speed;
        int efficency;

        public Employee(int speed, int efficency) {
            this.speed = speed;
            this.efficency = efficency;
        }

    }
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        PriorityQueue<Employee>pq=new PriorityQueue<>((a,b)->a.speed-b.speed);
        List<Employee>list=new ArrayList<>();
        for(int i=0;i<n;i++){
          list.add(new Employee(speed[i],efficiency[i]));
        }
        list.sort((a,b)->b.efficency-a.efficency);
        long teamSpeed=0;
        long maxPerformance=0;
        for(Employee currEmp:list){
            if(pq.size()==k){
               Employee slow= pq.poll();
               teamSpeed-=slow.speed;
            }
            teamSpeed+=currEmp.speed;
            pq.add(currEmp);
            maxPerformance=Math.max(maxPerformance,teamSpeed * (long)currEmp.efficency);

        }
        return (int)(maxPerformance % 10000007);
    }

    public static void main(String[] args) {

        MaxPerformanceTeam maxPerformanceTeam=new MaxPerformanceTeam();
        System.out.println(maxPerformanceTeam.maxPerformance(6,new int[]{2,10,3,1,5,8},new int []{5,4,3,9,7,2},2));

    }
}
