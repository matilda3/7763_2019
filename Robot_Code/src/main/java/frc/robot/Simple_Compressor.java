package frc.robot;

import edu.wpi.first.wpilibj.Compressor;

public class Simple_Compressor {

    // Initialize the Compressor Class using the passed in integer value
    int compressorInitialization; 

    Simple_Compressor (int compressorInitialization) {
        this.compressorInitialization = compressorInitialization;
    }

    Compressor instance_compressor = new Compressor(compressorInitialization);

    // Simple on / off queries
    void switchOn() { 
        this.instance_compressor.setClosedLoopControl(true);
    }

    void switchOff() {
        this.instance_compressor.setClosedLoopControl(false);
    }

    double powerUsage() {
        return this.instance_compressor.getCompressorCurrent();
    }

}