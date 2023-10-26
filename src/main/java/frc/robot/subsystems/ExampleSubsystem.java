// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems; //we are LOCATED UNDER the robot folder, and the subsys.
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
//API is like a book. we IMPORT "chapters" of this book, to then use their knowledge.
//Imagine our .command.CommandBase saying "we're in this chapter! use this data."
import edu.wpi.first.wpilibj2.command.CommandBase; //we are a commandbase, using methods
import edu.wpi.first.wpilibj2.command.SubsystemBase; //duh
import frc.robot.Constants;
//  typing a . means going inside another {}
//public means it can be accessed by other files. 
public class ExampleSubsystem extends SubsystemBase { //create a subsystem
  /** Creates a new ExampleSubsystem. */
  public CANSparkMax frontLeft = new CANSparkMax(Constants.DriveConstants.FL_ID,MotorType.kBrushless); 
  public CANSparkMax frontRight = new CANSparkMax(Constants.DriveConstants.FR_ID,MotorType.kBrushless);
  public CANSparkMax backLeft = new CANSparkMax(Constants.DriveConstants.BL_ID,MotorType.kBrushless);
  public CANSparkMax backRight = new CANSparkMax(Constants.DriveConstants.BL_ID,MotorType.kBrushless); 
  MotorControllerGroup MCGleft = new MotorControllerGroup (frontLeft,backLeft);
  MotorControllerGroup MCGright = new MotorControllerGroup(frontRight,backRight);
  public DifferentialDrive tank = new DifferentialDrive(MCGleft, MCGright);
  public static RelativeEncoder eLFront, eRFront, eLBack, eRBack;

  public ExampleSubsystem() {
    eLFront = frontLeft.getEncoder();
    eRFront = frontRight.getEncoder();
    eLBack = backLeft.getEncoder();
    eRBack = backRight.getEncoder();

    eLFront.setPositionConversionFactor(Constants.DriveConstants.motorConversionFactor);
    eRFront.setPositionConversionFactor(Constants.DriveConstants.motorConversionFactor);
    eLBack.setPositionConversionFactor(Constants.DriveConstants.motorConversionFactor);
    eRBack.setPositionConversionFactor(Constants.DriveConstants.motorConversionFactor);

    //anything to START your subsystem/what variables get set to (that require it being focused)
  }

  //void = no return
  //double = 0.00000000000000002 (long decimal...64 bit)
  public void tankDrive(double left,double right){ //make the tankDrive function! 
    tank.tankDrive(left, right); //...drive the motors.
  }

  public double getDrivePos() {
    double avgEnc = (eLFront.getPosition() + eRFront.getPosition())/2;
    return avgEnc;
  }

  public void motorBrake() {
    frontLeft.setIdleMode(IdleMode.kBrake);
    frontRight.setIdleMode(IdleMode.kBrake);
    backLeft.setIdleMode(IdleMode.kBrake);
    backRight.setIdleMode(IdleMode.kBrake);
  }

  public void resetEncoders() {
    eLFront.setPosition(0);
    eRFront.setPosition(0);
    eLBack.setPosition(0);
    eRBack.setPosition(0);
  }
}
