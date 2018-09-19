public class Test {
    public static void main(String [] a){
        iphone iphone = new IphoneImpl();
        androw androw = new AndrowImpl();
        TestFactory testFactory = new TestFactory(iphone,androw);
        testFactory.play(1).play();

        testFactory.play(2).play();

    }
}
