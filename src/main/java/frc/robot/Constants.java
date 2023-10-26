// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */

public final class Constants {
  public static class DriveConstants{
    //anything here is imported to ExampleSubsystem
    public static final int 
    FL_ID = 10, 
    FR_ID = 11,
    BL_ID = 12,
    BR_ID = 13;

    static double wheelDiameter = 6;
    static double wheelCircumfrence = wheelDiameter * Math.PI;
    static double gearRatios = 1/22.67; // this changes depending on the robot
    public static final double motorConversionFactor = wheelCircumfrence * gearRatios;

  } 
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0; //what 'port' is the xbox controller on? found in DRIVER STATION
  }
  public static class IntakeConstants{
    public static final int 
    Lift_ID = 21;
  }
  public static class Solonoid{
    public static final int 
    LSol_ID = 31,
    RSol_ID = 32;
  }
}
