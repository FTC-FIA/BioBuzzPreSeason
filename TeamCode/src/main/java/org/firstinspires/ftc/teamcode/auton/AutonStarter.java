package org.firstinspires.ftc.teamcode.auton;

import static com.qualcomm.robotcore.hardware.DcMotor.ZeroPowerBehavior.BRAKE;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@Autonomous(name = "TungTungTung.Auton.Tuff676767.EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEee", group = "Autonomous")
public class AutonStarter extends LinearOpMode {

    // Declare OpMode members
    private DcMotor leftDriveTuff = null;
    private DcMotor rightDriveTuff = null;
    private DcMotor intakeTuff = null;
    private CRServo leftIntakeServoTuff = null;
    private CRServo rightIntakeServoTuff = null;

    @Override
    public void runOpMode() {

        // Hardware "names" must match what was assigned on Driver Station
        leftDriveTuff = hardwareMap.get(DcMotor.class, "left_drive");
        rightDriveTuff = hardwareMap.get(DcMotor.class, "right_drive");
        intakeTuff = hardwareMap.get(DcMotorEx.class, "intake");
        leftIntakeServoTuff = hardwareMap.get(
                CRServo.class,
                "left intake"
        );
        rightIntakeServoTuff = hardwareMap.get(
                CRServo.class,
                "right intake"
        );

        // Set this according to how the motors were installed
        leftDriveTuff.setDirection(DcMotor.Direction.REVERSE);
        rightDriveTuff.setDirection(DcMotor.Direction.FORWARD);
        intakeTuff.setDirection(DcMotor.Direction.REVERSE);
        rightIntakeServoTuff.setDirection(DcMotor.Direction.REVERSE);
        leftIntakeServoTuff.setDirection(DcMotor.Direction.REVERSE);

        // Configures motors to "brake" and not drift when power = 0
        leftDriveTuff.setZeroPowerBehavior(BRAKE);
                rightDriveTuff.setZeroPowerBehavior(BRAKE);
        intakeTuff.setZeroPowerBehavior(BRAKE);

        // Set initial values
        leftDriveTuff.setPower(0);
        rightDriveTuff.setPower(0);
        intakeTuff.setPower(0);
        leftIntakeServoTuff.setPower(0);
        rightIntakeServoTuff.setPower(0);

        // Wait for the game to start (driver presses START)
        waitForStart();

        // Start the auton program
            double drivePowerTuff = 0.8;
        double intakePowerTuff = 1.0;
        double intakeServoPowerTuff = 1.0;

        // Turn on the intake, let it run continuously
        intakeTuff.setPower(intakePowerTuff);
        leftIntakeServoTuff.setPower(intakeServoPowerTuff);
        rightIntakeServoTuff.setPower(intakeServoPowerTuff);

        // Drive forward for 1 sec
        moveForwardTuff(drivePowerTuff, 1151);

        // Shut it down
        intakeTuff.setPower(0);
        leftIntakeServoTuff.setPower(0);
        rightIntakeServoTuff.setPower(0);
    }

        private void moveForwardTuff(double power, int durationInMs) {
            leftDriveTuff.setPower(power);
            rightDriveTuff.setPower(power);
            sleep(durationInMs); // 1 sec = 1000 milliseconds
            leftDriveTuff.setPower(0);
            rightDriveTuff.setPower(0);

        }
}
//01 Intro: Getting Started
//Android Studio, Understanding OpModes, Working with Git, An Auton Challenge!
//Android Studio Overview
//Let’s have a look around Android Studio
//
//
//The Project Browser
//
//
//The Code Editor
//
//
//
//Anatomy of an OpMode
//An “OpMode” is what FTC calls a Main Program for a Robot. It defines the entire robot’s behavior from initialization (“INIT” on the driver station) to start (play button on the driver station) to stop (stop button). Your robot can have multiple OpModes, but only one can be controlling the robot at a time. There are both TeleOp and Auton OpModes.
//
//Let’s walk through the AutonStarter OpMode to get a look at how it’s put together. This code can be found in AutonStarter.java.
//
//package org.firstinspires.ftc.teamcode.auton;
//
//
//import static com.qualcomm.robotcore.hardware.DcMotor.ZeroPowerBehavior.BRAKE;
//
//
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.hardware.CRServo;
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.DcMotorEx;
//The top of the OpMode specifies the package this java file belongs to.We will use packages to keep our code well organized later. Also at the top are listed all of the java classes and variables that are defined elsewhere we will be using in the current file. All of the files we are importing come from the com.qualcomm.robotcore package. These are java classes that are included in the FTCRobotController library, which we will be using A LOT.
//
//@Autonomous(name = "Auton Starter", group = "Autonomous")
//The @ symbol indicates that this is a special line of code called an “annotation.” This is used to give the Java compiler hints about any special handling needed for the code that will follow. In OpModes, Annotations are used to indicate whether this is an @Autonomous or @TeleOp OpMode, as well as the title to display in the DriverStation and the group to put it in.
//
//public class AutonStarter extends LinearOpMode {
//Here we are starting the declaration of our class, which is Java’s way of grouping code that goes together. Typically you will have exactly one class per java file, and the class should have the same name as the file it’s in. So the class AutonStarter lives in the file AutonStarter.java.
//
//Importantly, our AutonStarter class “extends” the class LinearOpMode (which was imported at the top of the file). This basically means that AutonStarter is a more specialized version of a more basic class, and that it “inherits” all of the functionality of the “parent” class and only has to “override” the parts of the parent class that it wants to specialize. The LinearOpMode class does a lot of work for us here--connecting the OpMode into the FTC runtime system that connects the driver station to the robot controller, handles starting and stopping the robot, etc. We are only left with overriding a few functions that determine the robot’s specific behavior. All of that gnarly management and bookkeeping and coordination across devices is just handled for us as if by magic.
//
//   // Declare OpMode members.
//   private DcMotor leftDrive = null;
//   private DcMotor rightDrive = null;
//   private DcMotor intake = null;
//   private CRServo leftIntakeServo = null;
//   private CRServo rightIntakeServo = null;
//Here we are declaring class-level variables. These are variables we will be able to use inside any of our class functions. There are several parts to a variable declaration like this:
//
//private: this is a Java “scope” keyword that determines whether code outside this file can access a variable or function can be accessed. “private” means that only code inside this same class/file can access the variable/function. “public” means it can be accessed by other classes/files. Generally speaking you want to make things as private as you can--only make them public if you are certain they’ll be needed elsewhere.
//
//DcMotor and CRServo: These indicate the type of the variable being declared. In each of these cases, the variable is of a complex type (namely a class) that is defined elsewhere--see the imports at the top for where they came from.
//
//leftDrive, etc.: This is the actual name of the variable that we will use later in the file.
//
//= null: This is the “initializer” -- i.e., the initial value that the variable is set to. The keyword “null” means that the variable is set to “nothing” to start with. We will have to assign it to something more substantial before we can start using it.
//
//You may also note the top line // Declare OpMode members -- this is a comment. Comments are for other humans--the Java compiler ignores them. Use them to explain aspects of your code that aren’t obvious from reading the code itself.
//
//
//
//
//   @Override
//   public void runOpMode() {
//Here we see another “annotation” indicating that we are overriding the LinearOpMode function “runOpMode()”.
//
//       // Hardware "names" must match what was assigned on Driver Station
//       leftDrive = hardwareMap.get(DcMotor.class, "rear_left");
//       rightDrive = hardwareMap.get(DcMotor.class, "rear_right");
//       intake = hardwareMap.get(DcMotorEx.class, "intake_motor");
//       leftIntakeServo = hardwareMap.get(
//               CRServo.class,
//               "left_intake_servo"
//       );
//       rightIntakeServo = hardwareMap.get(
//               CRServo.class,
//               "right_intake_servo"
//       );
//Here we are assigning those variables we declared earlier. And we are assigning them to instances of the classes we previously declared them to be. We are using the hardwareMap to create the specific instances, which is a built-in variable within the LinearOpMode class. Its get() function, as you can probably guess, takes a class and the name of a hardware component that needs to exactly match the name given in the Driver Station configuration.
//
//
//
//       // Set this according to how the motors were installed
//       leftDrive.setDirection(DcMotor.Direction.FORWARD);
//       rightDrive.setDirection(DcMotor.Direction.REVERSE);
//
//
//       // Configures motors to "brake" and not drift when power = 0
//       leftDrive.setZeroPowerBehavior(BRAKE);
//       rightDrive.setZeroPowerBehavior(BRAKE);
//       intake.setZeroPowerBehavior(BRAKE);
//Configure the hardware components so that they behave as desired when we start activating them in our code.
//
//Note the syntax we are using for calling functions on each of these variables. The “.” is used to access class functions and variables. So when we call leftDrive.setDirection() we are actually calling the function setDirection() that is defined within the DcMotor class (see imports to find out where that comes from). How would you know that was something you could call or what it could do?
//
//There are two answers:
//Android Studio autocomplete. When you type a variable followed by a “.”, Android Studio will show you all of the valid completions for the statement you are writing. The pop up autocomplete menu will also show you the parameters you can pass to the function, which will often give you a clue as to what the function is expecting.
//Google Search. If you know you are dealing with a DcMotor, you can search for something like “FTC Java DcMotor” and pretty easily find documentation. Give it a try!
//
//       // Set initial values
//       leftDrive.setPower(0);
//       rightDrive.setPower(0);
//       intake.setPower(0);
//       leftIntakeServo.setPower(0);
//       rightIntakeServo.setPower(0);
//We are finally interacting with the actual robot components. We are starting by setting the power of all the components to 0 to make sure we’re starting from a known state.
//
//       // Wait for the game to start (driver presses START)
//       waitForStart();
//This is a built-in function of LinearOpMode and I think it’s pretty obvious what it does.
//
//       // Start the auton program
//       double drivePower = 0.8;
//       double intakePower = 1.0;
//       double intakeServoPower = 1.0;
//We are declaring some variables we will be using in the actual auton program below. Declaring them all in one place makes it easier to tweak and test than if we just hardcode the values within the program code.
//
//       // Turn on the intake, let it run continuously
//       intake.setPower(intakePower);
//       leftIntakeServo.setPower(intakeServoPower);
//       rightIntakeServo.setPower(intakeServoPower);
//Start all of the intake components--we will just have them running the whole time during auton for now.
//
//       // Drive forward for 1 sec
//       leftDrive.setPower(drivePower);
//       rightDrive.setPower(drivePower);
//       sleep(1000); // 1 sec = 1000 milliseconds
//       leftDrive.setPower(0);
//       rightDrive.setPower(0);
//This is how we will drive the robot. Since it’s a “tank drive” bot, we just set the power levels of the two drive motors to the same value, which will make the bot drive forward. sleep is another LinearOpMode function that just makes the program pause for the specified number of milliseconds.
//
//There’s an important thing to note here--at a basic level the interaction between the code and the physical robot is at the level of directly controlling the components, using whatever functionality is built into those components. For this program, the only functionality we are accessing is setting the power (and, indeed, for things like motors and servos, this is mostly what you will be doing at the lowest level). When you call setPower() on a motor or servo, that component will keep that power level until you set it to a different level. A lot of what you will be doing with coding is translating a common sense idea like “drive forward for one second” into the coding statements that will execute that idea--and in many cases the code will look quite different from the idea that you started with.
//
//
//
//       // Shut it down
//       intake.setPower(0);
//       leftIntakeServo.setPower(0);
//       rightIntakeServo.setPower(0);
//
//
//   } // end of runOpMode
//} // end of class definition
//And we wrap up by turning the intake off.
//
//Note the two curly brackets (}). These are very important in Java, and many bugs arise due to “bracket hell” where you have nested code blocks and lose track of where they begin and end. The code editor (Android Studio in this case, but all modern code editors have this feature) provides help with this, as well as with other syntax errors. It’s very important to pay attention to these cues, as well as to adhere to good coding practices for naming and formatting so that you and everyone else on your team can read and understand the code that you write.
//
//public class AutonStarter extends LinearOpMode {
//
//
//   // Declare OpMode members.
//   private DcMotor leftDrive = null;
//   ...
//
//
//   @Override
//   public void runOpMode() {
//
//
//      // Hardware "names" must match what was assigned on Driver Station
//       leftDrive = hardwareMap.get(DcMotor.class, "rear_left");
//       rightDrive = hardwareMap.get(DcMotor.class, "rear_right");
//       intake = hardwareMap.get(DcMotorEx.class, "intake_motor");
//       leftIntakeServo = hardwareMap.get(
//               CRServo.class,
//               "left_intake_servo"
//       );
//       ...
//   }
//}
//Use camelCase for variable and function names.
//Use PascalCase for class names
//All names should be clear and communicate to other people reading the code what they’re for. A long name that’s clear is better than a short name that only you understand.
//Indent the contents of blocks one level using “Tab”. In this example, each tab is converted to three spaces--hopefully everyone’s editors is configured the same way and if not, we need to make sure this is standardized.
//Keep line lengths reasonable--at a minimum everything should be visible in the editor without horizontal scrolling. Note the difference in formatting between the line that starts with intake as compared to leftIntakeServo.
//If you’re ever not sure how to format something, look for an existing example in the code--consistency is the most important thing.
//
//Working with Git - Making a Branch
//We’re about to start modifying code, and our team practice when we do that will always be to make a git branch first. We won’t go into git too much now, but what you should know is that it is a “version control system” that is used by millions of developers. The most common way to use git is with GitHub, which is a website that hosts “git repositories” and lets team members connect to them to share code.
//
//The code you have in Android Studio right now was “cloned” from GitHub (specifically from https://github.com/FTC-FIA/BioBuzzPreSeason) and you are looking at the preseason1-starter branch.
//
//A “branch” in github is essentially a different version of the code, which is useful because it allows individual team members to work on new stuff that may or may not be working and not have that potentially buggy code mess up the working code that the team depends upon. Generally speaking, our most up to date and working code will always be in the main branch, but you should NEVER be touching code in main. You will always make a separate branch, work on your code, test it, get it working, then “push” the branch to GitHub where it can be evaluated for potential inclusion into main. At least for now, the coaches will be responsible for deciding what gets merged into main when.
//
//Even though we’re not in main, I don’t want you messing up the branch I created, so you will create your own branch before modifying code. To do that, select “New Branch” from the git menu, then give it the name preseason1-<your-name-here>. Hit “Create” and the name of your new branch should show up where it used to say preseason1-starter.
//
//
//
//Now you are ready to do some coding.
//
//
//Using Functions
//Making the robot move forward (or backward, or sideways, etc.) is going to be a thing you need to do a lot in auton programming. We will look at various ways to do this as the season progresses, but for now we’ve got just the one way which is to move at a certain power for a certain amount of time.
//       // Drive forward for 1 sec
//       leftDrive.setPower(drivePower);
//       rightDrive.setPower(drivePower);
//       sleep(1000); // 1 sec = 1000 milliseconds
//       leftDrive.setPower(0);
//       rightDrive.setPower(0);
//
//If you think about auton programs we had last year, they were built out of a lot of individual “move” commands (move here, do this, then move there, do that, …). Writing this code again and again for every one of those will be very verbose, and will also make the program hard to read, hard to debug, hard to maintain, etc.
//
//In Java like other programming languages, we can use functions to clean up code and make it easier to work with. As an example, we can extract this code into a function called moveForward that can be called over and over again with different arguments to move different for different speeds and durations.
//
//This function should be written outside the {} for runOpMode() but inside the {} for class AutonStarter. Stylistically, it should be at the bottom of the class (i.e., after runOpMode()).
//
//   private void moveForward(double power, int durationInMs) {
//      leftDrive.setPower(power);
//      rightDrive.setPower(power);
//      sleep(durationInMs);
//      leftDrive.setPower(0);
//      rightDrive.setPower(0);
//   }
//
//And we can then replace the equivalent code in runOpMode() with a simple call to this function.
//      // Drive forward for 1 sec
//      moveForward(drivePower, 1000);
//
//This would be a good time to check for syntax errors. You should have no red code and no red squiggles like this:
//
//
//Also, always check in the Project Browser to see if any files have any errors. If there are errors in a file do, they will look like this:
//
//
//If you have ANY errors, the code will not build and it will not run on the robot. Fix all errors before trying to build and test any code you’ve written.
//
//
//Working with Git - Committing and Pushing
//Now you have made a change to the code. Not much of a change, to be fair, but let’s take this opportunity to practice committing and pushing your code. Before you do this, make sure you have no errors (no red code, no red squigglies anywhere).
//
//
//Select “Commit…” from the Git dropdown. Then make sure that the files you changed are selected under “Changes” and write a helpful Commit message that explains what changed in the code. This will help your team members and coaches be able to figure out who changed what as well as when and why. Once you’ve written your message, select “Commit and Push…” (FYI “commit” just commits the change to your local copy of the repo and “push” sends those changes to GitHub so they can be shared with everyone).
//
//After you commit and push you will get a warning saying that “Commit and push checks failed”. As long as all you see below that are “warnings” it is actually OK to go ahead and push, so select “Commit anyway and push.” If you look at the actual warnings (by selecting “Review code analysis” you’ll see that they are either incorrect (e.g., AutonStarter is never used) or “helpful hints” that have nothing to do with whether the code is valid.
//
//
//
//
//After you have pushed, have a coach check on GitHub to verify that everything worked!
//
//Now You Try
//Implement the following function
//private void turn(boolean isLeft, double power, int durationInMs) {
//   if (isLeft) {
//       // turn left
//   } else {
//       // turn right
//   }
//}
//
//… and add a turn into your auton program after the moveForward:
//// Drive forward for 1 sec
//moveForward(drivePower, 1000);
//
//
//// Turn left for 0.5 sec
//turn(true, drivePower, 500); // add to the right place in
//
//
//Make sure there are no errors and have a coach check your code.
//
//Activity
//The Wayfinder Challenge
//
//
//Must complete in less than 1 minute
//5 points for crossing each line
//Another 5 points for each pollen you are carrying at the end
//Bonus: seconds left on the timer if you cross the finish line before 1 minute
//
//How to do it:
//Write out your Auton Plan on paper (the series of steps you will program into the robot).
//Review your plan with a coach
//Determine any tests that you need to run before implementing your plan fully
//Review your testing plan with a coach
//Implement your testing plan
//Push your code to your branch
//Work with a coach to run your test on the robot
//Based on test results, determine whether to test further or implement the rest of the plan (i.e. test a bigger chunk of the plan)
//Repeat and try to get the highest score you can!