package frc.robot.commands.Auto.AutoCommands;
import frc.robot.subsystems.intakeS;

import edu.wpi.first.wpilibj2.command.CommandBase;
import com.revrobotics.CANSparkMax.IdleMode;

public class manipMove extends CommandBase {
double autoSpeed;
boolean move;
boolean isFinished;

    public final intakeS lift;
    
    public manipMove(intakeS liftS,intakeS subsystem, double MotorSpeed ){
        //when refering to desired time you can also say "seconds"
        //when saying intake you are refering to the subsystem intakeS
        lift = liftS;
        //when saying the word lift you are refering  to the subsystem liftS
        autoSpeed = MotorSpeed;
        //when saying the word "autoSpeed" you are refering to the motor Speed
        addRequirements(subsystem);
        
    }
    @Override


    public void initialize(){
    lift.resetEncoders();
    //resets the encoders so that they can be ready when the match starts
    //starts a timer
    if(autoSpeed<0){
        move=true;
        //if the motor speed is less than 0 the manipulator will stay up
    }else{
        move=false;
        //if the motor speed is more than 0 the manipulator will be down
    }
    isFinished = false;    
    }
    @Override
    public void execute() {
        if (move==true){
            while (lift.liftEncoder.getPosition()<0) { 
            
                lift.moveLiftUp(autoSpeed);
                 
             }
        }else{
            while (lift.liftEncoder.getPosition()<27) { 
            
                lift.moveLiftDown(autoSpeed);
                 
             }
        }
        
        lift.liftMotor.setIdleMode(IdleMode.kCoast);
         isFinished = true;
         
        
        
    }
    @Override
    public void end(boolean interrupted) {
        lift.stopLift();
    }
    @Override
    public boolean isFinished() {
        return isFinished;
    }
}