package org.firstinspires.ftc.teamcode.nextftc;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import dev.nextftc.ftc.NextFTCOpMode;
import dev.nextftc.core.commands.Commands;
import dev.nextftc.ftc.components.BulkReadComponent;
import dev.nextftc.core.components.SubsystemComponent;

import org.firstinspires.ftc.teamcode.oldschool.RobotConfig;

@Autonomous(name = "Drive Forward Auton", group = "Autonomous")
public class Auton1 extends NextFTCOpMode {

    public Auton1() {
        addComponents(
            new SubsystemComponent(Drivetrain.INSTANCE),
            BulkReadComponent.INSTANCE
        );
    }

    @Override
    public void onStartButtonPressed() {
        // Drive forward at the configurable speed for 0.5 seconds, then stop.
        Commands.run(() -> Drivetrain.INSTANCE.drive(0, RobotConfig.AUTON_SPEED, 0))
            .requires(Drivetrain.INSTANCE)
            .endAfter(0.5)
            .then(Commands.instant(Drivetrain.INSTANCE::stop))
            .schedule();
    }
}
