package structuralPatterns.Adapter;

public class Voltage5V implements IVoltage5V{
    @Override
    public int output5V(){
        System.out.println("ęä¾5Vēµå...");
        return 5;
    }
}
