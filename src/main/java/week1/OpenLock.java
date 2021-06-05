package week1;

import java.util.*;

public class OpenLock {
    public int openLock(String[] deadends, String target) {
        Set<String>deadLocks=new HashSet(Arrays.asList(deadends));
        Set<String>visited=new HashSet();
        visited.add("0000");
        Queue<String>queue=new LinkedList();
        queue.offer("0000");
        int level=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size>0){
                String curr=queue.poll();
                if(curr.equals(target)){
                    return level;
                }
                if(deadLocks.contains(curr)){
                    size--;
                    continue;
                }
                StringBuilder sb=new StringBuilder(curr);
                for(int i=0;i<4;i++){
                    char currChar=sb.charAt(i);
                    String s1=sb.substring(0,i)+(currChar=='9'?0:currChar-'0'+1)+
                            sb.substring(i+1);
                    String s2=sb.substring(0,i)+(currChar=='0'?9:currChar-'0'-1)+
                            sb.substring(i+1);
                    if(!visited.contains(s1)&& !deadLocks.contains(s1)){
                        queue.offer(s1);
                        visited.add(s1);
                    }
                    if(!visited.contains(s2)&& !deadLocks.contains(s2)){
                        queue.offer(s2);
                        visited.add(s2);
                    }
                }
                size--;
            }
            level++;
        }
        return -1;
    }
}
