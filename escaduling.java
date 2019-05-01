
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
          public static int process_id, arrival_time, burst_time, priority;
          public static int q , ready ;
          
          public  static void proces_id(int x)
          {
              process_id = x ;
          }
          
           public static void brst_time(int x)
          {
              burst_time = x ;
          }
           
            public static void arival_time(int x)
          {
             arrival_time = x ;
          }
            
             public static void priorty(int x)
          {
              priority = x ;
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
            process[count].proces_id(x);
            
            System.out.println("Arrival_time : ");
            int t = scan.nextInt();
            process[count].arival_time(t);
            
            System.out.println("Burst_time: ");
            int z = scan.nextInt();
            process[count].brst_time(z);
            
            System.out.println("Process Priority : ");
            int r = scan.nextInt();
            process[count].priorty(r) ;
            
            temp_process = process[count].priority; 
            process[count].q = Queue(temp_process);
            process[count].ready = 0; 
        }
        
        time =  process[0].burst_time;
        for(y=0;y<limit;y++)
        {
            for(count =y;count<limit;count++)
            {
                if(process[count].arrival_time < time) 
                  {
                        process[count].ready = 1; 
                  }
            }
            
            for(count =y ; count < limit-1;count++)
            {
                for(j = count + 1 ; j < limit ;j++)
                {
                     if(process[count].ready == 1 && process[j].ready == 1) 
                        { 
                              if(process[count].q == 2 && process[j].q == 1) 
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
                        if(process[count].ready == 1 && process[j].ready == 1) 
                        { 
                              if(process[count].q == 1 && process[j].q == 1) 
                              { 
                                    if(process[count].burst_time > process[j].burst_time) 
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
            
            System.out.print("Process[] :   " + process[y].process_id + "     ");
            System.out.print("Time :   " + time + " To " + time + process[y].burst_time);
            System.out.println("");
            time = time + process[y].burst_time; 
            for(count = y; count < limit; count++) 
            { 
                  if(process[count].ready == 1) 
                  { 
                        process[count].ready = 0; 
                  } 
            } 
        }
        
    }
}
