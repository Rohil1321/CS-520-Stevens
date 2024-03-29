package Def_Pack;

import java.lang.*;
import java.util.*;

import Def_Pack.*;

public class FCFS 
{
    
    // output route
    public static String route = "./output/FCFS Output.txt";
    
    // start time
    public static int startTime = 0;
    
    // end time
    public static int endTime = 0;
    
    // current time
    public static int currentTime = startTime;
    
    // process quantity
    public static int numberOfProcess = 10;
    
    // array of mean inter I/O interval
    public static int[] meanInterIOIntervalA = {0,30,35,40,45,50,55,60,65,70,75};
    
    // I/O Time
    public static int IOTime = 60;
    
    // the time I/O queue is empty
    public static int emptyIOQueueTime = 0;
    
    // process list
    public static ArrayList<Process> processL = new ArrayList<Process>();
    
    // finished process state
    public static int[][] recordA = new int[numberOfProcess+1][3]; 
    // record[id]: turnaround time, running time, waiting time
    
    public static void main(String[] args) 
    {
        
        // generate processes
        for(int i = 1; i <= numberOfProcess; i++) 
        {
            int _burstTime = T.uniformlyExecutionTime();
            Process _p = new Process(i, _burstTime, meanInterIOIntervalA[i]);
            processL.add(_p);
        }
        
        for(; !processL.isEmpty();) 
        {
            
            // import processes in ready queue
            boolean _empty = true;
            
            for(int i = 0; i < processL.size(); i++) 
            {
                Process _p = processL.get(i);
                if(_p.nextStartTime <= currentTime) 
                {
                    _p.place = "ready queue";
                    processL.set(i, _p);
                    _empty = false;
                }
            }
            
            // if ready queue is empty, let time pass to the nextStartTime of next process
            if(_empty) 
            {
                processL = Sort.sort("nextStartTime", processL);
                currentTime = processL.get(0).nextStartTime;
                endTime = currentTime;
                continue;
            }
            
            // now have at least one process in ready queue
            
            // FCFS
            processL = Sort.sort("nextStartTime", processL);
            
            // get next process in ready queue
            Process prs = null;
            
            for(int i = 0; i < processL.size(); i++) 
            {
                prs = processL.get(i);
                if(prs.place.equals("ready queue")) 
                {
                    processL.remove(i);
                    break;
                }
                prs = null;
            }
            
            // now CPU starts running the process which is stored in prs
            prs.waitingTime = prs.waitingTime + currentTime - prs.nextStartTime;
            int _interIOTime = T.exponentiallyIOTime(prs.meanInterIOInterval);
            prs.thisRunningTime = T.doubleToInt(Math.min(_interIOTime, prs.leftBurstTime));
            prs.leftBurstTime = prs.leftBurstTime - prs.thisRunningTime;
            prs.lastEndTime = currentTime + prs.thisRunningTime;
            prs.turnaroundTime = prs.lastEndTime - startTime;
            prs.runningTime = prs.runningTime + prs.thisRunningTime;
            
            // prs is finished
            if(prs.leftBurstTime <= 0) 
            {
                recordA[prs.id][0] = prs.turnaroundTime;
                recordA[prs.id][1] = prs.runningTime;
                recordA[prs.id][2] = prs.waitingTime;
            }
            // prs is not finished and brought to I/O queue
            else 
            {
                prs.nextStartTime = T.doubleToInt(Math.max(prs.lastEndTime, emptyIOQueueTime) + IOTime);
                prs.place = "I/O queue";
                emptyIOQueueTime = prs.nextStartTime;
                processL.add(prs);
            }
            
            currentTime = prs.lastEndTime;
            endTime = currentTime;
        }
        
        // print out result
        int sumTurnaroundTime = 0;
        int sumRunningTime = 0;
        int sumWaitingTime = 0;
        
        for(int i = 1; i <= numberOfProcess; i++) 
        {
            sumTurnaroundTime += recordA[i][0];
            sumRunningTime += recordA[i][1];
            sumWaitingTime += recordA[i][2];
        }
        double CPUUtilization = T.keepDecimalPlaces((double)sumRunningTime/((double)endTime-(double)startTime)*100d, 2);  // %
        double throughput = T.keepDecimalPlaces((double)numberOfProcess/(((double)endTime-(double)startTime)/1000d/60d), 2);  // processes per minute
        double averageTurnaroundTime = T.keepDecimalPlaces((double)sumTurnaroundTime/1000d/60d /10d, 2);  // minutes per process
        double averageWaitingTime = T.keepDecimalPlaces((double)sumWaitingTime/1000d/60d /10d, 2);  // minutes per process

        System.out.println("CPU utilization: "+CPUUtilization+" %");
        System.out.println("Throughput: "+throughput+" processes/minute");
        System.out.println("Average turnaround time: "+averageTurnaroundTime+" minutes/process");
        System.out.println("Average waiting time: "+averageWaitingTime+" minutes/process");
        
        Output.export(route, "CPU utilization: "+CPUUtilization+" %\n");
        Output.export(route, "Throughput: "+throughput+" processes/minute\n");
        Output.export(route, "Average turnaround time: "+averageTurnaroundTime+" minutes/process\n");
        Output.export(route, "Average waiting time: "+averageWaitingTime+" minutes/process\n\n");
        
    }

}
