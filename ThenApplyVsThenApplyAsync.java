// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.concurrent.*;
class Main {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        //thenApply vs thenApplyAsync using ForkJoinPool common pool
        CompletableFuture<String> future= CompletableFuture.supplyAsync(()->{
            try{Thread.sleep(1000);} catch(Exception ex){};
            System.out.println("Prev Thread with thenApply : "+Thread.currentThread().getName());
            return "data";}).thenApply(s->{
                try{Thread.sleep(1000);} catch(Exception ex){};
               System.out.println("Current Thread with thenApply : "+Thread.currentThread().getName());
               return s.toUpperCase();
            });
            future.thenAccept(System.out::println);
            
            //thenApplyAsync
             CompletableFuture<String> futureAsync= CompletableFuture.supplyAsync(()->{
                   try{Thread.sleep(1000);} catch(Exception ex){};
            System.out.println("Prev Thread with thenApply : "+Thread.currentThread().getName());
            return "data";}).thenApplyAsync(s->{
                  try{Thread.sleep(1000);} catch(Exception ex){};
               System.out.println("Current Thread with thenApply : "+Thread.currentThread().getName());
               return s.toUpperCase();
            });
            futureAsync.thenAccept(System.out::println);
            
            //Custom Executor
            ExecutorService customExecutor= Executors.newFixedThreadPool(5);
            CompletableFuture<String> customExecutorFuture=CompletableFuture.supplyAsync(()->"Nitish").thenApplyAsync(s->{
                try{Thread.sleep(1000);} catch(Exception ex){};
               System.out.println("Current Thread with thenApplyAsync with Custom Executor : "+Thread.currentThread().getName());
                return s.toUpperCase();},customExecutor);
            customExecutorFuture.thenAccept(s-> {
                 try{Thread.sleep(1000);} catch(Exception ex){};
               System.out.println("Current Thread with thenApplyAsync with Custom Executor while print : "+Thread.currentThread().getName());
                System.out.println(s);});
            customExecutor.shutdown();
    }
}
