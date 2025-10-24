import java.util.*;
import java.text.SimpleDateFormat;

public class InterruptControllerSimulation {

    enum Device {
        KEYBOARD(1, "Keyboard"),
        MOUSE(2, "Mouse"),
        PRINTER(3, "Printer");

        public final int priority;
        public final String name;
        Device(int priority, String name) {
            this.priority = priority;
            this.name = name;
        }
    }

    static class InterruptController {
        private final Map<Device, Boolean> maskStatus = new HashMap<>();
        private final List<String> log = new ArrayList<>();

        public InterruptController() {
            for (Device d : Device.values()) maskStatus.put(d, true);
        }

        public void maskDevice(Device d, boolean enable) {
            maskStatus.put(d, enable);
            System.out.println(d.name + " Interrupts " + (enable ? "Enabled" : "Masked"));
        }

        public void triggerInterrupt(Device d) {
            if (!maskStatus.get(d)) {
                System.out.println(d.name + " Interrupt Ignored (Masked)");
                return;
            }
            handleInterrupt(d);
        }

        private void handleInterrupt(Device d) {
            String time = new SimpleDateFormat("HH:mm:ss.SSS").format(new Date());
            System.out.println(d.name + " Interrupt Triggered → Handling ISR → Completed");
            log.add(time + " - " + d.name + " ISR executed.");
        }

        public void showLog() {
            System.out.println("\n=== ISR Execution Log ===");
            for (String s : log) System.out.println(s);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        InterruptController controller = new InterruptController();

        // Simulate enabling/disabling (masking)
        controller.maskDevice(Device.PRINTER, false); // mask printer
        controller.maskDevice(Device.MOUSE, true);    // unmask mouse
        controller.maskDevice(Device.KEYBOARD, true); // unmask keyboard

        // Simulate interrupts sequentially
        System.out.println("\n--- Simulating Interrupts ---");
        Device[] devices = Device.values();

        for (int i = 0; i < 5; i++) {
            // Randomly pick a device
            Device d = devices[new Random().nextInt(devices.length)];
            controller.triggerInterrupt(d);
            Thread.sleep(500);
        }

        // Show final ISR log
        controller.showLog();
        System.out.println("\nSimulation completed.");
    }
}
