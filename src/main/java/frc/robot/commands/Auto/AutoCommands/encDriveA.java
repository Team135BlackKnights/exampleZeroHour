package frc.robot.commands.Auto.AutoCommands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ExampleSubsystem;

public class encDriveA extends CommandBase {
    private final ExampleSubsystem driveS;
    PIDController drivePID = new PIDController(0.01, 0, 0);
    double Desired;
    boolean isFinished = false;
    
    public encDriveA(ExampleSubsystem subsystem, double desDis) {
        driveS = subsystem;
        Desired = desDis;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        driveS.resetEncoders();
        isFinished = false;
    }

    @Override
    public void execute() {
        double autoDriveSpeed = drivePID.calculate(driveS.getDrivePos(), Desired);
        driveS.tankDrive(autoDriveSpeed, autoDriveSpeed);
        if (Math.abs(drivePID.getPositionError()) < 0.1 ) {
            isFinished = true;
        }
    }

    @Override
    public void end(boolean interrupted) {
        driveS.tankDrive(0, 0);
        driveS.motorBrake();
    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }
}
