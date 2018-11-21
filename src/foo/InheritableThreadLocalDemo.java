package foo;

public class InheritableThreadLocalDemo {

    public static void main(String[] args) {
        
         Thread t1 = new Thread() {
             public void run(){
                 DBSession session = new DBSession();
                 session.addThreadLocalValue();
                 
                 Thread t2 = new Thread(){
                     public void run(){
                         try {
                            Thread.currentThread().sleep(1000);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                         session.getThreadLocalValue();
                 };
                 
             };
             t2.start();
             System.out.println("Main Thread execute");
             session.removeValueThreadLocal();
             System.out.println("Main Thread execute End");
         }
    };
    t1.start();

}
}

class DBSession {
    private InheritableThreadLocal threadLocal = new InheritableThreadLocal();
    
    public void addThreadLocalValue() {
        threadLocal.set("Manjit");
    }
    public void getThreadLocalValue() {
        System.out.println(threadLocal.get());
    }
    
    public void removeValueThreadLocal() {
        threadLocal.set(null);
    }
}
