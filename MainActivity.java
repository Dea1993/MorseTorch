package dea1993.morsetorch;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    ImageView mColorSend;
    EditText mInputString;
    TextView mMorseCodeOutput;
    boolean fineParola = false;
    boolean nextIsSpace = false;
    // ms of dot
    int punto = 100;
    // ms of dash
    int linea = 3*punto;
    // ms between dots and dashes
    int pausa = punto;
    // ms beetween multiple characters (substract "pausa", because after every flash, automatically wait "pausa")
    int PausaFineLettera = linea-pausa;
    // ms between multiple words (substract "pausa", because after every flash, automatically wait "pausa")
    int PausaFineParola = (7*punto)-pausa;
    // morse alphabet 0=dot, 1=dash
    int a[] = {0,1};
    int b[] = {1,0,0,0};
    int c[] = {1,0,1,0};
    int d[] = {1,0,0};
    int e[] = {0};
    int f[] = {0,0,1,0};
    int g[] = {1,1,0};
    int h[] = {0,0,0,0};
    int iI[] = {0,0};
    int jJ[] = {0,1,1,1};
    int k[] = {1,0,1};
    int l[] = {0,1,0,0};
    int m[] = {1,1};
    int n[] = {1,0};
    int o[] = {1,1,1};
    int p[] = {0,1,1,0};
    int q[] = {1,1,0,1};
    int r[] = {0,1,0};
    int s[] = {0,0,0};
    int t[] = {1};
    int u[] = {0,0,1};
    int v[] = {0,0,0,1};
    int w[] = {0,1,1};
    int x[] = {1,0,0,1};
    int y[] = {1,0,1,1};
    int z[] = {1,1,0,0};
    int uno[] = {0,1,1,1,1};
    int due[] = {0,0,1,1,1};
    int tre[] = {0,0,0,1,1};
    int quattro[] = {0,0,0,0,1};
    int cinque[] = {0,0,0,0,0};
    int sei[] = {1,0,0,0,0};
    int sette[] = {1,1,0,0,0};
    int otto[] = {1,1,1,0,0};
    int nove [] = {1,1,1,1,0};
    int zero [] = {1,1,1,1,1};
    int pnt[] = {0,1,0,1,0,1};
    int vir[] = {1,1,0,0,1,1};
    int duePnt[] = {1,1,1,0,0,0};
    int pntDom[] = {0,0,1,1,0,0};
    int pntEsc[] = {1,0,1,0,1,1};
    int uguale[] = {1,0,0,0,1};
    int trattino[] = {1,0,0,0,0,1};
    int apici[] = {0,1,0,0,1,0};
    int apostrofo[] = {0,1,1,1,1,0};
    int slash[] = {1,0,0,1,0};
    int chiocciola[] = {0,1,1,0,1,0};
    int apertaParTonda[] = {1,0,1,1,0};
    int chiusaParTonda[] = {1,0,1,1,0,1};

    public void init() {
        mInputString = findViewById(R.id.etString);
        mColorSend = findViewById(R.id.ivSend);
        mMorseCodeOutput = findViewById(R.id.tvMorseCode);
    }

    public void torch(View view) {
        // clear output TextView
        mMorseCodeOutput.setText("");
        final String testo = mInputString.getText().toString();
        //Log.d("torch", testo);
        // convert string to char array
        final char[] carattere = testo.toCharArray();
        // show a Log on console
        //Log.d("torch", "Button pressed");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < testo.length(); i++) {
                        /* if this char isn't the last, check if the next char is "space"
                        *  if yes, don't wait for "fineLettera" ms */
                        if (i < (testo.length())-1) if (carattere[i+1] == ' ') nextIsSpace=true;

                        // show all characters inserted by user
                        //Log.d("torch", "carattere: "+Character.toString(carattere[i]));

                        // read inserted char, and convert his value (01) to morse code (.-)
                        switch (carattere[i]) {
                            case 'a': case 'A': for (int j : a) charToFlash(j); break;
                            case 'b': case 'B': for (int j : b) charToFlash(j); break;
                            case 'c': case 'C': for (int j : c) charToFlash(j); break;
                            case 'd': case 'D': for (int j : d) charToFlash(j); break;
                            case 'e': case 'E': for (int j : e) charToFlash(j); break;
                            case 'f': case 'F': for (int j : f) charToFlash(j); break;
                            case 'g': case 'G': for (int j : g) charToFlash(j); break;
                            case 'h': case 'H': for (int j : h) charToFlash(j); break;
                            case 'i': case 'I': for (int j : iI) charToFlash(j); break;
                            case 'j': case 'J': for (int j : jJ) charToFlash(j); break;
                            case 'k': case 'K': for (int j : k) charToFlash(j); break;
                            case 'l': case 'L': for (int j : l) charToFlash(j); break;
                            case 'm': case 'M': for (int j : m) charToFlash(j); break;
                            case 'n': case 'N': for (int j : n) charToFlash(j); break;
                            case 'o': case 'O': for (int j : o) charToFlash(j); break;
                            case 'p': case 'P': for (int j : p) charToFlash(j); break;
                            case 'q': case 'Q': for (int j : q) charToFlash(j); break;
                            case 'r': case 'R': for (int j : r) charToFlash(j); break;
                            case 's': case 'S': for (int j : s) charToFlash(j); break;
                            case 't': case 'T': for (int j : t) charToFlash(j); break;
                            case 'u': case 'U': for (int j : u) charToFlash(j); break;
                            case 'v': case 'V': for (int j : v) charToFlash(j); break;
                            case 'w': case 'W': for (int j : w) charToFlash(j); break;
                            case 'x': case 'X': for (int j : x) charToFlash(j); break;
                            case 'y': case 'Y': for (int j : y) charToFlash(j); break;
                            case 'z': case 'Z': for (int j : z) charToFlash(j); break;
                            case '1': for (int j : uno) charToFlash(j); break;
                            case '2': for (int j : due) charToFlash(j); break;
                            case '3': for (int j : tre) charToFlash(j); break;
                            case '4': for (int j : quattro) charToFlash(j); break;
                            case '5': for (int j : cinque) charToFlash(j); break;
                            case '6': for (int j : sei) charToFlash(j); break;
                            case '7': for (int j : sette) charToFlash(j); break;
                            case '8': for (int j : otto) charToFlash(j); break;
                            case '9': for (int j : nove) charToFlash(j); break;
                            case '0': for (int j : zero) charToFlash(j); break;
                            case '.': for (int j : pnt) charToFlash(j); break;
                            case ',': for (int j : vir) charToFlash(j); break;
                            case ':': for (int j : duePnt) charToFlash(j); break;
                            case '?': for (int j : pntDom) charToFlash(j); break;
                            case '=': for (int j : uguale) charToFlash(j); break;
                            case '-': for (int j : trattino) charToFlash(j); break;
                            case '(': for (int j : apertaParTonda) charToFlash(j); break;
                            case ')': for (int j : chiusaParTonda) charToFlash(j); break;
                            case '"': for (int j : apici) charToFlash(j); break;
                            case '\'': for (int j : apostrofo) charToFlash(j); break;
                            case '/': for (int j : slash) charToFlash(j); break;
                            case '@': for (int j : chiocciola) charToFlash(j); break;
                            case '!': for (int j : pntEsc) charToFlash(j); break;
                            case ' ': fineParola = true; break;
                            default: traduzione(carattere[i]+"err"); break;
                        } // end switch

                        // sleep only if isn't finished the word
                        if ((!fineParola) && (!nextIsSpace)) {
                            //Log.d("torch", "lettera terminata");
                            // turn off flashlight for "spazioLettera" ms
                            traduzione(" ");
                            flashlightOff();
                            Thread.sleep(PausaFineLettera);
                        } else if (fineParola) { // if word is finished, wait 7*dots
                            traduzione(" / ");
                            flashlightOff();
                            Thread.sleep(PausaFineParola);
                            fineParola = false;
                            // assume that next char isn't space
                            nextIsSpace = false;
                        } // end if
                    } // end for
                } catch (InterruptedException er) {
                    er.printStackTrace();
                } // end try catch
            } // end run()
        }).start();
    } // end torch()

    // method that reads that converts 0 to . and 1 to -
    public void charToFlash(int simbolo) throws InterruptedException {
        if (simbolo == 0) {
            //System.out.println("punto");
            traduzione(".");
            morseFlash(punto);
        } else if (simbolo == 1) {
            //System.out.println("linea");
            traduzione("-");
            morseFlash(linea);
        } // end if
    } // end charToFlash

    // method for convert chat to flashlight
    public void morseFlash(int tempo) throws InterruptedException {
        // turn on flash
        flashlightOn();
        // wait
        Thread.sleep(tempo);
        // turn off flash
        flashlightOff();
        // wait
        Thread.sleep(pausa);
    } // end morseFlash

    // method to show morse code in TextView
    public void traduzione(final String simbolo) {
        runOnUiThread(new Runnable() {
            public void run() {
                mMorseCodeOutput.append(simbolo);
            } // end run
        }); // end runOnUiThread
    } // end traduzione

    // method that turn on flashlight and change ImageView (send button) color
    public void flashlightOn(){
        //Log.d("flashlightOn", "accendo");
        runOnUiThread(new Runnable() {
            public void run() {
                // change ImageView color to colorPrimary
                mColorSend.setColorFilter(0xFF3F51B5, PorterDuff.Mode.MULTIPLY);
            } // end run
        }); // end runOnUiThread

        // check if device has torch flashlight
        if (getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)) {
            // device has torch flashlight
            try {
                // open camera
                CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
                if (cameraManager != null) {
                    cameraManager.setTorchMode("0",true);
                } // end if
            } catch (CameraAccessException e) {
                e.printStackTrace();
            } // end try catch
        } // end if
    } // end flashlightOn

    // method that turn off flashlight and change ImageView (send button) color
    public void flashlightOff() {
        //Log.d("flashlightOff", "spengo");
        runOnUiThread(new Runnable() {
            public void run() {
                // change ImageView color to white
                mColorSend.setColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY);
            } // end run
        }); // end runOnUiThread
        // check if device has torch flashlight
        if (getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)) {
            // device has torch flashlight
            try {
                // open camera
                CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
                if (cameraManager != null) {
                    cameraManager.setTorchMode("0",false);
                } // end if
            } catch (CameraAccessException e) {
                e.printStackTrace();
            } // end try catch
        } // end if
    } // end flashlightOff
} // end class
