package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.RobotConfig;

/**
 * MotorTester allows testing individual drive motors using the Dpad.
 * Up: Front Left
 * Right: Front Right
 * Down: Rear Right
 * Left: Rear Left
 * Hold Y to reverse the direction.
 */
@TeleOp(name = "Motor Tester", group = "TeleOp")
public class MotorTester extends LinearOpMode {

    @Override
    public void runOpMode() {
        // Initialize motors using RobotConfig constants
        DcMotor frontLeft = hardwareMap.get(DcMotor.class, RobotConfig.FRONT_LEFT_MOTOR);
        DcMotor frontRight = hardwareMap.get(DcMotor.class, RobotConfig.FRONT_RIGHT_MOTOR);
        DcMotor rearLeft = hardwareMap.get(DcMotor.class, RobotConfig.REAR_LEFT_MOTOR);
        DcMotor rearRight = hardwareMap.get(DcMotor.class, RobotConfig.REAR_RIGHT_MOTOR);

        // Standard zero power behavior
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            // Determine power level and direction
            double basePower = 0.5;
            double multiplier = gamepad1.y ? -1.0 : 1.0;
            double testPower = basePower * multiplier;

            // Map Dpad to motors
            // We use if/else if to only drive one motor at a time for safety during testing,
            // or just separate if statements if you want to test combinations.
            // Using separate ifs as requested.
            
            if (gamepad1.dpad_up) {
                frontLeft.setPower(testPower);
            } else {
                frontLeft.setPower(0);
            }

            if (gamepad1.dpad_right) {
                frontRight.setPower(testPower);
            } else {
                frontRight.setPower(0);
            }

            if (gamepad1.dpad_down) {
                rearRight.setPower(testPower);
            } else {
                rearRight.setPower(0);
            }

            if (gamepad1.dpad_left) {
                rearLeft.setPower(testPower);
            } else {
                rearLeft.setPower(0);
            }

            telemetry.addData("Status", "Running");
            telemetry.addData("Direction", gamepad1.y ? "REVERSE" : "FORWARD");
            telemetry.addData("Active Motor(s)", "%s %s %s %s", 
                gamepad1.dpad_up ? "FL" : "",
                gamepad1.dpad_right ? "FR" : "",
                gamepad1.dpad_down ? "RR" : "",
                gamepad1.dpad_left ? "RL" : "");
            telemetry.update();
        }
    }
}
