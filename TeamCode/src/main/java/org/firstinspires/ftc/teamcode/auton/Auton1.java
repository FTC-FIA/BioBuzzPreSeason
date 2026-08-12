package org.firstinspires.ftc.teamcode.auton;

import com.bylazar.telemetry.PanelsTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.RobotConfig;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDrive;

/**
 * A simple Autonomous OpMode demonstrating the usage of the MecanumDrive subsystem.
 */
@Autonomous(name = "Old School Drive Auton", group = "Autonomous")
public class Auton1 extends LinearOpMode {
    // 1. Declare the subsystem
    private MecanumDrive drive;
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        // Use Panels telemetry instead of standard FTC telemetry
        Telemetry panelsTelemetry = PanelsTelemetry.INSTANCE.getFtcTelemetry();

        // 2. Initialize the subsystem by passing the 'hardwareMap'
        // This 'hardwareMap' variable is inherited from LinearOpMode.
        drive = new MecanumDrive(hardwareMap);

        if (panelsTelemetry.log() != null) {
            panelsTelemetry.log().add("Status: Initialized");
        }

        // Wait for the game to start (driver presses START)
        waitForStart();
        runtime.reset();

        if (panelsTelemetry.log() != null) {
            panelsTelemetry.log().add("Status: Started");
        }

        // 3. Drive forward for 1 second
        while (opModeIsActive() && runtime.seconds() < 1.0) {
            drive.drive(0, RobotConfig.AUTON_SPEED, 0); // Use configurable speed
            // Using log for path updates will create a scrolling list of messages
            if (panelsTelemetry.log() != null) {
                panelsTelemetry.log().add(String.format("Path: Driving Forward: %2.1f S", runtime.seconds()));
            }
        }

        // 4. Stop the robot
        drive.stop();

        if (panelsTelemetry.log() != null) {
            panelsTelemetry.log().add("Status: Complete");
        }
        sleep(1000); // Pause to let the user see the message
    }
}
