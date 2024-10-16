package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;


@TeleOp(name = "William_WiFi_Test")
public class William_WiFi_Test extends LinearOpMode {

    private ColorSensor ColorSensor_ColorSensor;
    private DistanceSensor ColorSensor_DistanceSensor;

    String current_color;

    /**
     * This function is executed when this OpMode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {
        ColorSensor_ColorSensor = hardwareMap.get(ColorSensor.class, "ColorSensor");
        ColorSensor_DistanceSensor = hardwareMap.get(DistanceSensor.class, "ColorSensor");

        // Put initialization blocks here.
        waitForStart();
        ColorSensor_ColorSensor.enableLed(true);
        if (opModeIsActive()) {
            // Put run blocks here.
            while (opModeIsActive()) {
                // Put loop blocks here.
                if (ColorSensor_DistanceSensor.getDistance(DistanceUnit.CM) < 3.9) {
                    get_current_color();
                    telemetry.addData("Color: ", current_color);
                } else {
                    telemetry.addData("Color: ", "NONE");
                }
                telemetry.update();
            }
        }
    }

    /**
     * Red:    680 460 370
     * Yellow: 1010 1480 475
     * Blue:   200 430 1100
     */
    private void get_current_color() {
        int current_red;
        int current_green;
        int current_blue;

        current_red = ColorSensor_ColorSensor.red();
        current_green = ColorSensor_ColorSensor.green();
        current_blue = ColorSensor_ColorSensor.blue();
        if (current_red > 800 && current_green > 1000) {
            current_color = "Yellow";
        } else if (current_red > 500) {
            current_color = "Red";
        } else {
            if (current_blue > 900) {
                current_color = "Blue";
            } else {
                current_color = "Null";
            }
        }
    }
}