package dea1993.morsetorch;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.security.Policy;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // torchlight status
    boolean torchStatus = false;
    // Una linea è convenzionalmente tre volte un punto. Gli spazi tra i punti e le linee
    // di un carattere sono della lunghezza di un punto, quelli tra le lettere sono ampi
    // come una linea (tre punti), quelli tra parole sono lunghi sette punti.

    public void torch(View view) {
        // show a Log on console
        Log.d("torch", "Button pressed");
        // check that device has torch flashlight
        if (getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)) {
            // check the status of the torch
            if (torchStatus) {
                flashlightOff();
            } else {
                flashlightOn();
            }
        } else {
            // show a toast message
            Toast toast = Toast.makeText(getApplicationContext(), "Device Hasn't Torch", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    public void flashlightOn(){
        try {
            // open camera
            CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
            cameraManager.setTorchMode("0",true);
            // set torch status on
            torchStatus = true;
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }
    public void flashlightOff() {
        try {
            CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
            cameraManager.setTorchMode("0",false);
            // set torch status off
            torchStatus = false;
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

    }
}
