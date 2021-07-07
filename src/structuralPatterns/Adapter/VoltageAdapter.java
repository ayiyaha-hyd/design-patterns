package structuralPatterns.Adapter;

/**
 * 适配器
 */
public class VoltageAdapter implements IVoltage5V{
    private Voltage220V voltage220V;
    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5V(){
        int output = voltage220V.output220V();
        System.out.println("220V转5V电压...");
        return output/44;
    }
}
