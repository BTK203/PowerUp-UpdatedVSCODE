//package frc.robot.subsystems;
//
//import edu.wpi.first.wpilibj.DriverStation;
//import edu.wpi.first.wpilibj.I2C;
//import edu.wpi.first.wpilibj.command.Subsystem;
//import frc.robot.Constants;
//
//import static frc.robot.Constants.ArduinoPatterns.*;
//
///**
// * Controls for the Arduino
// */
//public class SubsystemArduino extends Subsystem {
//
//    I2C i2c;
//    byte[] toSend;
//
//    protected void initDefaultCommand() {
//    }
//
//    public SubsystemArduino() {
//        i2c = new I2C(I2C.Port.kOnboard, 4);
//        toSend = new byte[1];
//    }
//
//    public void sendData(int data) {
//        toSend[0] = (byte) data;
//        i2c.transaction(toSend, 1, null, 0);
//    }
//
//    public byte[] recieveData(int request, int size) {
//        byte[] recieved = new byte[size];
//        toSend[0] = (byte) request;
//        i2c.transaction(toSend, 1, recieved, size);
//        return recieved;
//    }
//
//    public void sendAllianceColor(DriverStation.Alliance color) {
//        sendData(color == DriverStation.Alliance.Blue ? SOLID_BLUE : SOLID_RED);
//    }
//}