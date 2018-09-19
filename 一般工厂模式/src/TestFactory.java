public class TestFactory {
    private final iphone iphone;
    private final androw androw;


    public TestFactory(iphone iphone, androw androw) {
        this.iphone = iphone;
        this.androw = androw;
    }
    public pc play(Integer ty){
        if (ty == 1){
            return iphone;
        }else {
            return androw;
        }
    }
}
