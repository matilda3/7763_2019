package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;


public class Double_Solenoid {

    int DoubleSolenoid_Forward;
    int DoubleSolenoid_Reverse;

    Double_Solenoid (int DoubleSolenoid_Forward, int DoubleSolenoid_Reverse){
        this.DoubleSolenoid_Forward = DoubleSolenoid_Forward;
        this.DoubleSolenoid_Reverse = DoubleSolenoid_Reverse; 
    }

    // Initialize the classes from the variables defined during class construction
    DoubleSolenoid test_solenoid = new DoubleSolenoid(DoubleSolenoid_Forward, DoubleSolenoid_Reverse);

    // SOLENOID CONTROL FUNCTIONS 
    //
    // ** 
    // These functions may require the switching of kForward and  
    // kReverse depending on the Solenoid configuration. 
    // **

    void actuatePush(){
        this.test_solenoid.set(DoubleSolenoid.Value.kForward);
    }

    void actuatePull(){
        this.test_solenoid.set(DoubleSolenoid.Value.kReverse);
    }

    void actuateOff(){
        this.test_solenoid.set(DoubleSolenoid.Value.kOff);
    }    
    
}