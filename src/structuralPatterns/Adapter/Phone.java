package structuralPatterns.Adapter;

public class Phone {
    private static final int INPUT_5V = 5;
    public void charge(IVoltage5V voltage5V) {
        if(voltage5V.output5V() == INPUT_5V){
            System.out.println("5V电压充电中...");
            return;
        }
        throw new RuntimeException("电压不符，无法充电!!!");
    }
}
