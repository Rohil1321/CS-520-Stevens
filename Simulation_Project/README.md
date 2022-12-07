The Simulation Programming Project

(As announced, this project’s score will be graded on the same scale as Final: 40%.)  
 
Please consult the remaining slides (starting from slide 45) of Lecture 2 (Process Scheduling), which outlines the approach to the project, and start the development. Note that the pseudo-code there is merely to provide general guidance—don’t take it as a 
directive.  
 
You must submit a zip file with the copies of both your well-commented code, the 
output, and the report.  Your code must run, of course. 
Write a simulation of a (rather simplistic) system of Figure 1. You should re-use the core 
code of the “bus problem” as well as the code you have written for the bus simulation. 
 Create 10 processes of random execution time with lengths uniformly distributed 
between 2 and 4 minutes (use the uniform distribution method for random number 
generation). 
 
• For each process, the times between I/O requests (i.e, CPU bursts) are 
distributed exponentially. The mean inter-I/O intervals for the processes are 
respectively 30ms, 35ms, 40ms, 45ms, 50ms, 55ms, 60ms, 65ms, 70ms, and 
75ms. 
• Each time an I/O is needed it takes precisely 60 ms 
• A process, once it enters the system and before it exits it, can be either in the 
Ready Queue, or the I/O queue. (It is convenient to consider the process at the 
front of the Ready Queue to be serviced by the CPU, and the process at the 
front in the I/O Queue to be serviced by the channel that deals with all I/O 
devices; however, care should be taken to count the time of the process being 
serviced separately from waiting time.) 
 
Correspondingly, your data objects will be the Process Control Block, the Ready Queue, 
and the I/O Queue along with the event object, which you should adapt from the Bus 
Simulation. 

The task is to write the simulation of the system behavior for the whole period of the 
execution, while computing and collecting the following statistics: CPU utilization, 
throughput (i.e., the average number of processes completed in a unit of time) turnaround time (i.e., the average time it took to execute a process), and average waiting 
time.  
 
a) Different simulation runs are to be performed with the First-Come-First-Served 
and Shortest-Job-First (SJF) algorithms. For simplicity, use the actual burst times 
that you have generated rather than predict them with exponential averaging.   
 
b) Think about the conditions under which average waiting time increases with the 
decreasing quantum in Round Robin and under what conditions it decreases with 
the decreasing quantum. Write a statement describing these conditions. (Note: 
There is no need to use a quantum that is larger than the maximum CPU burst 
[computed on the set of all the processes] since in this case RR reduces to FCFS.) 
 
c) Design experiments to test your statements in Part b). In the first experiment, the 
processes will satisfy the conditions you listed and will cause the average waiting 
time to increase with decreasing quantum. In the second experiment, the 
processes will satisfy the condition you listed that will cause the average waiting 
time to decrease with decreasing quantum. Each experiment should have about 5 
runs, which differ only in the respective value of the quantum. Design some 
experiments with the following characteristics:  
o At least 10 processes are used, each having many CPU bursts.  
o The largest and smallest CPU burst averages differ by a factor of at least 
2.  
o The CPU utilization is between 50 and 90 percent.  
Run the experiments using the simulator. For each experiment, create a log file 
containing the tabular data and Gantt charts for the runs.  
 
You should submit the following, in a zip file: 
 
1. Source code listing; 
2. Logs for all runs, as described above; and 
3. Report with your observations. 
 
Please make sure that you check everything before you submit it.  If your code does 
not compile or if it crashes on the input that you use in your logs, this assignment 
will be graded 0.  Grading this work will include testing your code to confirm its 
consistency with the report, analyzing the report, and other time-consuming tasks 
(including checking for plagiarism). Because of the time constraints, no re-grading 
is possible and no resubmission is allowed. 
 
 (100 points) 



![Figure1](https://user-images.githubusercontent.com/70903587/206315382-ed48f86a-99a0-4de9-bfef-e53e79514628.png)

