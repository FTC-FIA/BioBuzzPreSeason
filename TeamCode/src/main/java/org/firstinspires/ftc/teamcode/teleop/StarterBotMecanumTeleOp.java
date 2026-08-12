/*
 * Copyright (c) 2025 FIRST
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to
 * endorse or promote products derived from this software without specific prior
 * written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
 * TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode.teleop;

import static com.qualcomm.robotcore.hardware.DcMotor.ZeroPowerBehavior.BRAKE;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import org.firstinspires.ftc.teamcode.RobotConfig;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDrive;

/**
 * TeleOp2 is a modified version of StarterBotChassisTeleop.
 * It uses the MecanumDrive subsystem and standard FTC telemetry/gamepads.
 */
@TeleOp(name = "TeleOp2", group = "TeleOp")
public class StarterBotMecanumTeleOp extends LinearOpMode {

    @Override
    public void runOpMode() {
        // Declare OpMode members.
        MecanumDrive drive = new MecanumDrive(hardwareMap);
        DcMotor intake = hardwareMap.get(DcMotor.class, RobotConfig.INTAKE_MOTOR);
        CRServo leftIntakeServo = hardwareMap.get(CRServo.class, RobotConfig.LEFT_INTAKE_SERVO);
        CRServo rightIntakeServo = hardwareMap.get(CRServo.class, RobotConfig.RIGHT_INTAKE_SERVO);

        // Setting zeroPowerBehavior to BRAKE enables a "brake mode".
        intake.setZeroPowerBehavior(BRAKE);

        // set Feeders to an initial value to initialize the servo controller
        leftIntakeServo.setPower(0);
        rightIntakeServo.setPower(0);

        // Much like our drivetrain motors, we set the right intake servo to reverse so that both
        // servos work to pull elements into the intake.
        rightIntakeServo.setDirection(DcMotorSimple.Direction.REVERSE);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            /*
             * Mecanum drive mapping:
             * left_stick_y: Forward/Backward
             * left_stick_x: Strafing
             * right_stick_x: Rotation
             */
            double y = -gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x * 1.1; // 1.1 multiplier to counteract strafing friction
            double rx = gamepad1.right_stick_x;

            drive.drive(x, y, rx);

            /*
             * Set the intake power variable to equal the right trigger, minus the left trigger.
             */
            double intakePower = gamepad1.right_trigger - gamepad1.left_trigger;

            intake.setPower(intakePower);
            leftIntakeServo.setPower(intakePower);
            rightIntakeServo.setPower(intakePower);

            /*
             * Show motor powers and trigger values on the Driver Station via telemetry.
             */
            telemetry.addData("Status", "Running");
            telemetry.addData("Drive", "Y: %.2f, X: %.2f, RX: %.2f", y, x, rx);
            telemetry.addData("Triggers", "left (%.2f), right (%.2f)", gamepad1.left_trigger, gamepad1.right_trigger);
            telemetry.update();
        }

        drive.stop();
    }
}
