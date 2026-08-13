package org.firstinspires.ftc.teamcode.auton;

import static com.qualcomm.robotcore.hardware.DcMotor.ZeroPowerBehavior.BRAKE;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@Autonomous(name = "Auton lars", group = "Autonomous")
public class AutonStarter extends LinearOpMode {

    // Declare OpMode members
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
    private DcMotor intake = null;
    private CRServo leftIntakeServo = null;
    private CRServo rightIntakeServo = null;

    @Override
    public void runOpMode() {

        // Hardware "names" must match what was assigned on Driver Station
        leftDrive = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
        intake = hardwareMap.get(DcMotorEx.class, "intake");
        leftIntakeServo = hardwareMap.get(
                CRServo.class,
                "left intake"
        );
        rightIntakeServo = hardwareMap.get(
                CRServo.class,
                "right intake"
        );

        // Set this according to how the motors were installed
        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);
        intake.setDirection(DcMotor.Direction.REVERSE);
        rightIntakeServo.setDirection(DcMotor.Direction.REVERSE);
        leftIntakeServo.setDirection(DcMotor.Direction.REVERSE);

        // Configures motors to "brake" and not drift when power = 0
        leftDrive.setZeroPowerBehavior(BRAKE);
        rightDrive.setZeroPowerBehavior(BRAKE);
        intake.setZeroPowerBehavior(BRAKE);

        // Set initial values
        leftDrive.setPower(0);
        rightDrive.setPower(0);
        intake.setPower(0);
        leftIntakeServo.setPower(0);
        rightIntakeServo.setPower(0);

        // Wait for the game to start (driver presses START)
        waitForStart();

        // Start the auton program
        double drivePower = 0.8;
        double intakePower = 1.0;
        double intakeServoPower = 1.0;

        // Turn on the intake, let it run continuously
        intake.setPower(intakePower);
        leftIntakeServo.setPower(intakeServoPower);
        rightIntakeServo.setPower(intakeServoPower);

        // Drive forward for 1 sec
        moveForward(drivePower, 1125);

        // Shut it down
        intake.setPower(0);
        leftIntakeServo.setPower(0);
        rightIntakeServo.setPower(0);
    }
    private void moveForward(double power, int durationTnMs) {
        leftDrive.setPower(power);
        rightDrive.setPower(power);
        sleep(durationTnMs);
        leftDrive.setPower(0);
        rightDrive.setPower(0);
    }
}

