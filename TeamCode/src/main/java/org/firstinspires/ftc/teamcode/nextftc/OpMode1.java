package org.firstinspires.ftc.teamcode.nextftc;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import dev.nextftc.ftc.NextFTCOpMode;
import dev.nextftc.hardware.driving.MecanumDriverControlled;
import dev.nextftc.ftc.components.BulkReadComponent;
import dev.nextftc.core.components.BindingsComponent;
import dev.nextftc.core.components.SubsystemComponent;

@TeleOp(name = "NextFTC Mecanum", group = "TeleOp")
public class OpMode1 extends NextFTCOpMode {

    public OpMode1() {
        // Register components
        addComponents(
            new SubsystemComponent(Drivetrain.INSTANCE),
            BulkReadComponent.INSTANCE,
            BindingsComponent.INSTANCE
        );
    }

    @Override
    public void onStartButtonPressed() {
        // Create the drive command
        MecanumDriverControlled driveCommand = new MecanumDriverControlled(
            Drivetrain.INSTANCE.frontLeft,
            Drivetrain.INSTANCE.frontRight,
            Drivetrain.INSTANCE.backLeft,
            Drivetrain.INSTANCE.backRight,
            () -> (double) -gamepad1.left_stick_y,
            () -> (double) gamepad1.left_stick_x,
            () -> (double) gamepad1.right_stick_x
        );

        driveCommand.schedule();
    }
}
