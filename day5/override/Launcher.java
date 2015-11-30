package day5.override;

public class Launcher {
    public static void main(String[] args) {

        Instrument instrument=new Instrument();
        Flute flute=new Flute();
        Flute flute3=new Flute();
        Instrument flute2=new Flute();

        instrument.playMusic();
        flute.playMusic();
        flute2.playMusic();


        // --------------------------------------
        flute.setName("flute1");
        final Flute finalFlute=flute;

        System.out.println(flute.getName());
        System.out.println(finalFlute.getName());

        flute.setName("flute_test");

        System.out.println(flute.getName());
        System.out.println(finalFlute.getName());


    }
}
