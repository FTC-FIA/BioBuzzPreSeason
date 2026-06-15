package org.firstinspires.ftc.teamcode.oldschool.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.oldschool.RobotConfig;

/**
 * A simple Mecanum Drive subsystem using the standard FTC HardwareMap pattern.
 */
public class MecanumDrive {
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;

    public MecanumDrive(HardwareMap hardwareMap) {
        // Initialize motors using the hardwareMap passed from the OpMode and names from RobotConfig
        frontLeft = hardwareMap.get(DcMotor.class, RobotConfig.FRONT_LEFT_MOTOR);
        frontRight = hardwareMap.get(DcMotor.class, RobotConfig.FRONT_RIGHT_MOTOR);
        backLeft = hardwareMap.get(DcMotor.class, RobotConfig.REAR_LEFT_MOTOR);
        backRight = hardwareMap.get(DcMotor.class, RobotConfig.REAR_RIGHT_MOTOR);

        // Set motor directions (standard setup)
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);
        backRight.setDirection(DcMotorSimple.Direction.FORWARD);

        // Set to brake mode for better control in autonomous
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    /**
     * Drives the robot based on x, y, and rotation inputs.
     * @param x Strafe speed (-1 to 1)
     * @param y Forward speed (-1 to 1)
     * @param rx Rotation speed (-1 to 1)
     */
    public void drive(double x, double y, double rx) {
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1.0);
        double frontLeftPower = (y + x + rx) / denominator;
        double backLeftPower = (y - x + rx) / denominator;
        double frontRightPower = (y - x - rx) / denominator;
        double backRightPower = (y + x - rx) / denominator;

        frontLeft.setPower(frontLeftPower);
        backLeft.setPower(backLeftPower);
        frontRight.setPower(frontRightPower);
        backRight.setPower(backRightPower);
    }

    public void stop() {
        drive(0, 0, 0);
    }
}
