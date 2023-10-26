package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.intakeS;

/** An example command that uses an example subsystem. */

public class intakeC extends CommandBase {
    private final intakeS intakeS;
    
    public intakeC(intakeS subsystem) {
        intakeS = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        /*
       if(RobotContainer.m_driverController.getAButton() == true) {//     When the a button is pressed it spins the wheeles on the intake
        intakeS.inOutMotor1.set(-1);
        intakeS.inOutMotor2.set(1);
    } else if (RobotContainer.m_driverController.getBButton() == true) {//     When the b button is pressed it spins the wheeles on the intake the other way
        intakeS.inOutMotor1.set(1);
        intakeS.inOutMotor2.set(-1);
    } else {//     when neither the a or b are pressed it turns off
        intakeS.inOutMotor1.set(0); 
        intakeS.inOutMotor2.set(0);
    } 


    if(RobotContainer.m_driverController.getXButton() == true) {// when the x button is pressed it squeezes the game object
        intakeS.squeezeMotor.set(0.05);
    } else if (RobotContainer.m_driverController.getYButton() == true) {// when the buton y is pressed it releases the game object
        intakeS.squeezeMotor.set(-0.05);
    } else {//                                                       when no buttons are pressed it stops
        intakeS.squeezeMotor.set(0);
    } 

*/


    if(RobotContainer.m_driverController.getAButtonPressed()== true) {
        intakeS.solenoidLeft.set(true);
    } else if(RobotContainer.m_driverController.getAButtonReleased()== true) {
        intakeS.solenoidLeft.set(false);
    }

    if(RobotContainer.m_driverController.getBButtonPressed()== true) {
        intakeS.solenoidRight.set(true);
    } else if(RobotContainer.m_driverController.getBButtonReleased()== true) {
        intakeS.solenoidRight.set(false);
    }

    if(RobotContainer.m_driverController.getRightBumper() == true) {// when r1 is pressed it lifts the intake
        intakeS.liftMotor.set(0.25);
    } else if (RobotContainer.m_driverController.getLeftBumper() == true) {// when l1 is pressed it lowers the intake
        intakeS.liftMotor.set(-0.25);
    } else {
        intakeS.liftMotor.set(0);// when neither are pressed it does nothing
    } 

    }

    @Override
    public void end(boolean interrupted) {
    
    }

    @Override
    public boolean isFinished() {
        return false;
    }
    
}