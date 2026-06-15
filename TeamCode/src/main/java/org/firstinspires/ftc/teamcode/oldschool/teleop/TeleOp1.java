package org.firstinspires.ftc.teamcode.oldschool.teleop;

import com.bylazar.gamepad.PanelsGamepad;
import com.bylazar.telemetry.PanelsTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.oldschool.subsystems.MecanumDrive;

/**
 * A standard Mecanum TeleOp that uses Panels Gamepad managers.
 * This allows control via physical controllers or the Panels Dashboard simulator.
 */
@TeleOp(name = "Old School TeleOp", group = "TeleOp")
public class TeleOp1 extends LinearOpMode {

    @Override
    public void runOpMode() {
        // Use Panels telemetry to see inputs in the browser dashboard
        Telemetry panelsTelemetry = PanelsTelemetry.INSTANCE.getFtcTelemetry();

        // Initialize the drivetrain subsystem
        MecanumDrive drive = new MecanumDrive(hardwareMap);

        panelsTelemetry.addData("Status", "Initialized");
        panelsTelemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            // asCombinedFTCGamepad merges physical gamepad1 inputs with the simulated inputs from the browser.
            // This ensures both can control the robot simultaneously.
            Gamepad panelsGamepad1 = PanelsGamepad.INSTANCE.getFirstManager().asCombinedFTCGamepad(gamepad1);

            // Standard Mecanum mapping:
            double ly = panelsGamepad1.left_stick_y;
            double lx = panelsGamepad1.left_stick_x;
            double rx = panelsGamepad1.right_stick_x;

            double y = -ly;
            double x = lx * 1.1; // 1.1 multiplier to counteract strafing friction
            double r = rx;

            // Send power to the motors
            drive.drive(x, y, r);

            panelsTelemetry.addData("Status", "Running");
            panelsTelemetry.addData("Raw LY", ly);
            panelsTelemetry.addData("Raw LX", lx);
            panelsTelemetry.addData("Raw RX", rx);
            panelsTelemetry.addData("Drive", "Y: %.2f, X: %.2f, RX: %.2f", y, x, r);
            panelsTelemetry.update();
        }

        drive.stop();
    }
}
