package day6.Frame22Constructors;

/**
 * Created by julia on 22.06.2015.
 */
public class Launcher {
    public static void main(String[] args) {
        Glyph glyph=new RoundGlyph(10);
        glyph.draw();

        Glyph glyph2=new NpeGlyph();
    }
}
