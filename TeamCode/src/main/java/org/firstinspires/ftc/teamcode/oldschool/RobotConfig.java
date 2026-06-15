package org.firstinspires.ftc.teamcode.oldschool;

import com.bylazar.configurables.annotations.Configurable;

/**
 * Centralized configuration for robot hardware names and constants.
 */
@Configurable
public class RobotConfig {
    public static final String FRONT_LEFT_MOTOR = "front_left";
    public static final String FRONT_RIGHT_MOTOR = "front_right";
    public static final String REAR_LEFT_MOTOR = "rear_left";
    public static final String REAR_RIGHT_MOTOR = "rear_right";

    // This will appear in the Panels Dashboard under the "Configurables" widget
    public static double AUTON_SPEED = 0.5;
}
