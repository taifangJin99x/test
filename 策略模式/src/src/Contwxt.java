package src;

public class Contwxt {
    private final pc pc;

    public Contwxt(pc pc) {
        this.pc = pc;
    }

    public void exc(){
        pc.play();
    }
}
