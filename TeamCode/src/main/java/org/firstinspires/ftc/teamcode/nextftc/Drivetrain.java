package org.firstinspires.ftc.teamcode.nextftc;

import dev.nextftc.core.subsystems.Subsystem;
import dev.nextftc.hardware.impl.MotorEx;

public class Drivetrain implements Subsystem {
    // Static instance for Singleton pattern
    public static final Drivetrain INSTANCE = new Drivetrain();

    // Hardware variables
    public MotorEx frontLeft, frontRight, backLeft, backRight;

    private Drivetrain() { }

    @Override
    public void initialize() {
        // Names must match your hardware configuration
        frontLeft = new MotorEx("front_left").brakeMode().reversed();
        frontRight = new MotorEx("front_right").brakeMode();
        backLeft = new MotorEx("rear_left").brakeMode().reversed();
        backRight = new MotorEx("rear_right").brakeMode();
    }

    public void drive(double x, double y, double rx) {
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1.0);
        frontLeft.setPower((y + x + rx) / denominator);
        backLeft.setPower((y - x + rx) / denominator);
        frontRight.setPower((y - x - rx) / denominator);
        backRight.setPower((y + x - rx) / denominator);
    }

    public void stop() {
        drive(0, 0, 0);
    }
}
