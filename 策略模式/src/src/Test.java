package src;

public class Test {
    public static void main(String [] a){
       androw androw = new AndrowImpl();
       iphone iphone = new IphoneImpl();

       Contwxt contwxt = new Contwxt(androw);
       contwxt.exc();

        Contwxt contwxt1 = new Contwxt(iphone);
        contwxt1.exc();

    }
}
