// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.concurrent.*;
import java.util.stream.*;
class Main {
    public static void main(String[] args) {
        //combining multiple futures
        CompletableFuture<String> f1= CompletableFuture.supplyAsync(()->"Task1");
        CompletableFuture<String> f2= CompletableFuture.supplyAsync(()->"Task2");
        CompletableFuture<String> f3= CompletableFuture.supplyAsync(()->"Task3");
        
        CompletableFuture<Void> allCombined=CompletableFuture.allOf(f1,f2,f3);
        // Wait for all to complete
        try{allCombined.get();}catch(Exception ex){}
        //here join avoids checked exception unlike get
        String combined=Stream.of(f1,f2,f3).map(CompletableFuture::join).
        collect(Collectors.joining(", "));
        System.out.println("result : "+ combined);
        System.out.println("Try programiz.pro");
        
       //using anyOf
       CompletableFuture<Object> anyFuture= CompletableFuture.anyOf(f1,f2,f3);
       System.out.println("Any future result: "+ anyFuture.join());
       try{System.out.println("Any future result: "+ anyFuture.get());}catch(Exception ex){};
    }
}
