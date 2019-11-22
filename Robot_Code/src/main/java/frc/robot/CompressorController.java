package frc.robot;

import edu.wpi.first.wpilibj.Compressor;

public class CompressorController extends Compressor {

    public CompressorController(final int module) {
        super(module);
    }

    // Simple on / off functions - turn closed loop control on/off
    
    public void switchOn() { 
        setClosedLoopControl(true);
    }

    public void switchOff() {
        setClosedLoopControl(false);
    }

    public double powerUsage() {
        return getCompressorCurrent();
    }

}
