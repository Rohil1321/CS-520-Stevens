The Simulation Programming Project  
(As announced, this project’s score will be graded on the same scale as Final: 40%.)  
 
Please consult the remaining slides (starting from slide 45) of Lecture 2 (Process Scheduling), which outlines the approach to the project, and start the development. Note 
that the pseudo-code there is merely to provide general guidance—don’t take it as a 
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
throughput (i.e., the average number of processes completed in a unit of time)

![Figure1](https://user-images.githubusercontent.com/70903587/206315382-ed48f86a-99a0-4de9-bfef-e53e79514628.png)

