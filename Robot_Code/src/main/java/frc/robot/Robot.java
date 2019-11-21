/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * This is a demo program showing the use of the RobotDrive class. The
 * SampleRobot class is the base of a robot application that will automatically
 * call your Autonomous and OperatorControl methods at the right time as
 * controlled by the switches on the driver station or the field controls.
 *
 * <p>The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SampleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 *
 * <p>WARNING: While it may look like a good choice to use for your code if
 * you're inexperienced, don't. Unless you know what you are doing, complex code
 * will be much more difficult under this system. Use TimedRobot or
 * Command-Based instead if you're new.
 */
public class Robot extends SampleRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";

  private final Joystick m_stick = new Joystick(0);
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  private final Simple_Compressor test_compressor = new Simple_Compressor(0);
  private final Double_Solenoid test_solenoid = new Double_Solenoid(1, 2);

  public Robot() {
  }

  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto modes", m_chooser);
  }

  @Override
  public void operatorControl() {
    boolean switch_button = m_stick.getRawButtonPressed(0);
    boolean is_pushed = false;

    while (isOperatorControl() && isEnabled()) {

      // REMEMBER!! It is important to turn the solenoid off to prevent pressure build-up 
      // and possible damage to the system. Make sure to always include an actuateOff statement

      if (switch_button) {
        test_solenoid.actuatePush();
        test_solenoid.actuateOff();
        is_pushed = true;
      }

      else {

        if (is_pushed) {
          test_solenoid.actuatePull();
          test_solenoid.actuateOff();
          is_pushed = false;
        }

        else {
          test_solenoid.actuateOff();
        }
      }

      // SmartDashboard / Shuffleboard Updates - You can change the commands here to support either 

      SmartDashboard.putNumber("Compressor Current Usage: ", test_compressor.powerUsage());
      SmartDashboard.putBoolean("Piston State (True = Pushed, False = Retracted): ", is_pushed);
      
    }
  }

  /**
   * Runs during test mode.
   */
  @Override
  public void test() {
  }
}
