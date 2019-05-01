
package com.mycompany.temp;
import java.util.Scanner;

public class escaduling 
{
    static int Queue(int t1) 
   { 
      if(t1 == 0 || t1 == 1 || t1 == 2 || t1 == 3) 
      { 
            return 1; 
      } 
      else
      {
            return 2; 
      }
   }  
      public static class process_structure
      {
          private  int process_id, arrival_time, burst_time, priority;
          private int q , ready ;

        public int getProcess_id() {
            return process_id;
        }

     
        public void setProcess_id(int process_id) {
            this.process_id = process_id;
        }
          
        public int getArrival_time() {
            return arrival_time;
        }

       
        public void setArrival_time(int arrival_time) {
            this.arrival_time = arrival_time;
        }

        
        public int getBurst_time() {
            return burst_time;
        }

       
        public void setBurst_time(int burst_time) {
            this.burst_time = burst_time;
        }

       
        public int getPriority() {
            return priority;
        }

        
        public void setPriority(int priority) {
            this.priority = priority;
        }

        
        public int getQ() {
            return q;
        }

      
        public void setQ(int q) {
            this.q = q;
        }

        
        public int getReady() {
            return ready;
        }

        
        public void setReady(int ready) {
            this.ready = ready;
        }
         
      }
    
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        int limit, count, temp_process, time, j, y; 
        process_structure temp ;
        System.out.println("Enter Total Number Of Processor : ");
        limit = scan.nextInt();
        process_structure process[] = new process_structure [limit];
        for(count =0 ; count < limit ; count++)
        {
            System.out.println("Process ID : ");
            int x = scan.nextInt();
            process[count].setProcess_id(x);
            
            System.out.println("Arrival_time : ");
            int t = scan.nextInt();
            process[count].setArrival_time(t);
            
            System.out.println("Burst_time: ");
            int z = scan.nextInt();
            process[count].setBurst_time(t);
            
            System.out.println("Process Priority : ");
            int r = scan.nextInt();
            process[count].setPriority(r) ;
            
            temp_process = process[count].getPriority(); 
            process[count].setQ(Queue(temp_process));
            process[count].setReady(0); 
        }
        
        time =  process[0].getBurst_time();
        for(y=0;y<limit;y++)
        {
            for(count =y;count<limit;count++)
            {
                if(process[count].getArrival_time() < time) 
                  {
                      process[count].setReady(1); 
                  }
            }
            
            for(count =y ; count < limit-1;count++)
            {
                for(j = count + 1 ; j < limit ;j++)
                {
                     if(process[count].getReady() == 1 && process[j].getReady() == 1) 
                        { 
                              if(process[count].getQ() == 2 && process[j].getQ() == 1) 
                              { 
                                    temp = process[count]; 
                                    process[count] = process[j]; 
                                    process[j] = temp; 
                              } 
                        }    
                }
            }
            
            for(count = y; count < limit - 1; count++) 
            { 
                  for(j = count + 1; j < limit; j++) 
                  {
                        if(process[count].getReady() == 1 && process[j].getReady() == 1) 
                        { 
                              if(process[count].getQ() == 1 && process[j].getQ() == 1) 
                              { 
                                    if(process[count].getBurst_time() > process[j].getBurst_time()) 
                                    { 
                                          temp = process[count]; 
                                          process[count] = process[j]; 
                                          process[j] = temp; 
                                    } 
                                    else 
                                    { 
                                          break; 
                                    } 
                              } 
                        } 
                  } 
            }
            
            System.out.print("Process[] :   " + process[y].getProcess_id() + "     ");
            System.out.print("Time :   " + time + " To " + time + process[y].getBurst_time());
            System.out.println("");
            time = time + process[y].getBurst_time(); 
            for(count = y; count < limit; count++) 
            { 
                  if(process[count].getReady() == 1) 
                  { 
                      process[count].setReady(0); 
                  } 
            } 
        }
        
    }
}
