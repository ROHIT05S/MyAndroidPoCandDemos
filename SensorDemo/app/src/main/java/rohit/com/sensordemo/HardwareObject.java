package rohit.com.sensordemo;

/**
 * Created by 24343 on 12/11/2017.
 */

public class HardwareObject
{
    private String hardware;
    private String hardwareMeaning;
    public HardwareObject(String hardware, String hardwareMeaning) {
        this.hardware = hardware;
        this.hardwareMeaning = hardwareMeaning;
    }
    public String getHardware() {
        return hardware;
    }
    public String getHardwareMeaning() {
        return hardwareMeaning;
    }
}
