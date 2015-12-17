package day6.Frame22Constructors;


public class Launcher {
    public static void main(String[] args) {
        Glyph glyph=new RoundGlyph(10);
        glyph.draw();

        Glyph glyph3=new NpeGlyph();
    }
}
