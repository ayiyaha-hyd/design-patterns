package structuralPatterns.Adapter;

public class Voltage5V implements IVoltage5V{
    @Override
    public int output5V(){
        System.out.println("提供5V电压...");
        return 5;
    }
}
