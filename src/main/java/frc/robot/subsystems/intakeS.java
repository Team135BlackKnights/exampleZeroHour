package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
//API is like a book. we IMPORT "chapters" of this book, to then use their knowledge.
//Imagine our .command.CommandBase saying "we're in this chapter! use this data."
import edu.wpi.first.wpilibj2.command.CommandBase; //we are a commandbase, using methods
import edu.wpi.first.wpilibj2.command.SubsystemBase; //duh
import frc.robot.Constants;

public class intakeS extends SubsystemBase { //create a subsystem

    public CANSparkMax liftMotor = new CANSparkMax(Constants.IntakeConstants.Lift_ID,MotorType.kBrushless);
    public RelativeEncoder liftEncoder = liftMotor.getEncoder();
    public  Solenoid SolenoidLeft = new Solenoid(PneumaticsModuleType.REVPH, Constants.Solonoid.LSol_ID);
    public static  Solenoid SolenoidRight = new Solenoid(PneumaticsModuleType.REVPH, Constants.Solonoid.RSol_ID);

    public intakeS(){
      liftMotor.enableVoltageCompensation(12);
      liftMotor.setIdleMode(IdleMode.kBrake);
    }

    public void moveLiftDown(double speed){

       liftMotor.set(speed);

     }
     public void moveLiftUp(double speed){

      
      liftMotor.set(speed);

     }
     public void stopLift(){

      liftMotor.set(0);

     }


    public void resetEncoders() {
      //Sets position of the encoder
           liftEncoder.setPosition(0);
      }


  }