interface I1 {
  abstract void test(int i); 
  int x = 10;
}



interface I2 {
  abstract void test(String s);
}




public class MultiInterface implements I1, I2 {


  public void test(int i)   {   System.out.println("In MultiInterface.I1.test" + " " +i); }
  public void test(String s)   {   System.out.println("In MultiInterface.I1.test" + " " +s); }

  
public static void main(String[] a) {
    MultiInterface t = new MultiInterface();
    t.test(42);
    t.test("Hello");
    }


}