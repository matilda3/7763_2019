package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;


public class DoubleSolenoidController extends DoubleSolenoid {

    public DoubleSolenoidController (final int forwardChannel, final int reverseChannel) {
        super(forwardChannel, reverseChannel);
    }

    // SOLENOID CONTROL FUNCTIONS 
    //
    // ** 
    // These functions may require the switching of kForward and  
    // kReverse depending on the Solenoid configuration. 
    // **

    public void actuatePush(){
        set(DoubleSolenoid.Value.kForward);
    }

    public void actuatePull(){
        set(DoubleSolenoid.Value.kReverse);
    }

    public void actuateOff(){
        set(DoubleSolenoid.Value.kOff);
    }    
    
}