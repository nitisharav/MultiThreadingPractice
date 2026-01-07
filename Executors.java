// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.concurrent.*;
class Main {
    public static void main(String[] args) {
        ExecutorService executorFixed= Executors.newFixedThreadPool(3);
        ExecutorService executorCached= Executors.newCachedThreadPool();
        ExecutorService executorSingle= Executors.newSingleThreadExecutor();
        ExecutorService executorScheduled =Executors.newScheduledThreadPool(2);
        //Runnable Practice
        executorFixed.submit(()->{System.out.println("Running from fixedThread pool using runnable: "+Thread.currentThread().getName());});
        
        //Callable Practice
        Future<Integer> future=executorFixed.submit(()-> {Thread.sleep(10000);
            return 42;
        });
       /* try{
             Integer res= future.get();
              System.out.println("Future result: "+ res);
        } catch(Exception ex){
            System.out.println("Exception: "+ex);
        }*/
        try{
            Integer res1 = future.get(5000,TimeUnit.MILLISECONDS);
            System.out.println("Future result: "+ res1); 
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
