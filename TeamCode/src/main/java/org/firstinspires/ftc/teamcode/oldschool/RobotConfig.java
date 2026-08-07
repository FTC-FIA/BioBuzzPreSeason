package org.firstinspires.ftc.teamcode.oldschool;

import com.bylazar.configurables.annotations.Configurable;

/**
 * Centralized configuration for robot hardware names and constants.
 */
@Configurable
public class RobotConfig {
    // these must match exactly the names in the Driver Station
    public static final String FRONT_LEFT_MOTOR = "front_left";
    public static final String FRONT_RIGHT_MOTOR = "front_right";
    public static final String REAR_LEFT_MOTOR = "rear_left";
    public static final String REAR_RIGHT_MOTOR = "rear_right";

    public static final String INTAKE_MOTOR = "intake_motor";
    public static final String RIGHT_INTAKE_SERVO = "right_intake_servo";
    public static final String LEFT_INTAKE_SERVO = "left_intake_servo";

    // This will appear in the Panels Dashboard under the "Configurables" widget
    public static double AUTON_SPEED = 0.5;
}
