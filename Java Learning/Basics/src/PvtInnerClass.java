//class Outer{
//    int x = 5;
//  private class Inner{
//      int y = 10;
//  }
//  public int getY()
//  {
//      Inner i = new Inner();
//      return i.y;
//  }
//}
//public class PvtInnerClass {
//    public static void main(String[] args) {
//        Outer o = new Outer();
//        System.out.println(o.x);
//        Outer.Inner i = o.new Inner(); // Error : Outer.Inner has private access in Outer
////        System.out.println(o.x + i.y);
//        System.out.println(o.x + o.getY());
//    }
//}
