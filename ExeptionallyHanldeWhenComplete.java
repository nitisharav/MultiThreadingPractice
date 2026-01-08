// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.concurrent.*;
class Main {
    public static void main(String[] args) {
        // exceptionally - handle errors
        CompletableFuture<String> future=CompletableFuture.supplyAsync(()-> {
            if(Math.random()<0.5){
                throw new RuntimeException("Error Ocurred!");
            }
            return "Success";
        }).exceptionally(ex->{
            System.out.println("Exception: "+ex);
            return "Default Value as fAIL";
        });
        future.thenAccept(System.out::println);
        
        //// handle - process both result and exception
        CompletableFuture<String> handle=CompletableFuture.supplyAsync(()->"Data").handle((result,ex)->{
             if(ex!=null) {
            return "Error "+ex.getMessage();
        }
        return result+" Processed";
        }  );
         handle.thenAccept(System.out::println);
         //whenComplete- side effect, no return, cannot modify the result
         CompletableFuture<String> whenComplete=CompletableFuture.supplyAsync(()->"Data").whenComplete((result,ex)->{
             if(ex!=null) {
           System.out.println("Error "+ex.getMessage()) ;
        }
        System.out.println( result+" Processed not modified");
        }  );
         whenComplete.thenAccept(System.out::println);
        System.out.println("Try programiz.pro");
    }
}
