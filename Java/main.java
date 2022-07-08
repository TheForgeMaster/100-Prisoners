public class main {
    public static void main(String[] args) {
        final long startTime = System.nanoTime();
        int success = 0;
        int failure = 0;
        for(int i = 0; i < Math.pow(10,0); i++) {
            if (i % 1000000 == 0){
                System.out.println("Run: " + i);
            }
            Prison testRun = new Prison(100);
            if (testRun.success){
                success++;
            }
            else{
                failure++;
            }
        }
        System.out.println("Success: " + success + " Failure: " + failure);
        final long duration = System.nanoTime() - startTime;
        System.out.println("Duration: " + ((float)duration/1000000000));
    }
}
