// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.concurrent.*;
import java.util.*;
class Main {
    public static void main(String[] args) {
        ExecutorService executorFixed= Executors.newFixedThreadPool(3);
        ExecutorService executorCached= Executors.newCachedThreadPool();
        ExecutorService executorSingle= Executors.newSingleThreadExecutor();
        ExecutorService executorScheduled =Executors.newScheduledThreadPool(2);
       List<Callable<String>> tasks= Arrays.asList(
           ()->{Thread.sleep(2000); return "Task 1";},
           ()->{Thread.sleep(1000); return "Task 2";},
           ()->{Thread.sleep(1000); return "Task 3";},
           ()->{Thread.sleep(1000); return "Task 4";});
        
      
        try{
            List<Future<String>> futures= executorFixed.invokeAll(tasks);
            String futureInvokeAny= executorFixed.invokeAny(tasks);
            for(Future<String> future:futures ){
                 String res1 = future.get(5000,TimeUnit.MILLISECONDS);
            System.out.println("Future result: "+ res1);
            System.out.println("Future result from Any: "+ futureInvokeAny);
            }
             
        } catch (Exception ex){
            System.out.println("Exception: "+ex); 
        } 
        
        try{
             executorFixed.awaitTermination(1, TimeUnit.SECONDS);
           executorFixed.shutdown(); 
     
        } catch (Exception ex){
            System.out.println("Exception: "+ex); 
        }

       
        System.out.println("Try programiz.pro");
      
    }
}
