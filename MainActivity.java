package dea1993.morsetorch;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.security.Policy;

public class MainActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    EditText mInputString;
    ImageView mColor;
    // torchlight status
    boolean torchStatus = false;
    // times of morse symbols
    // time of dot
    int punto = 100;
    // time of dash
    int linea = 3*punto;
    // pause between dots and dashes
    int pausa = punto;
    // pause beetween multiple characters
    int spazio_lettera = linea;
    // pause between multiple words
    int spazio_parola = 7*punto;

    // morse alphabet 0=dot, 1=dash
    // characters
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

    // numbers
    int uno[] = {0,1,1,1,1};
    int due[] = {0,0,1,1,1};
    int tre[] = {0,0,0,1,1};
    int quattro[] = {0,0,0,0,1};
    int cinque[] = {0,0,0,0,0};
    int sei[] = {1,0,0,0,0};
    int sette[] = {1,1,0,0,0};
    int otto[] = {1,1,1,0,0};
    int nove [] = {1,1,1,1,0};
    int zero []= {1,1,1,1,1};


    public void init() {
        mInputString = (EditText) findViewById(R.id.etString);
    }

    public void torch(View view) throws InterruptedException {
        final String testo = mInputString.getText().toString();
        Log.d("torch", testo);
        // convert string to char array
        final char[] carattere = testo.toCharArray();
        // show a Log on console
        Log.d("torch", "Button pressed");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i=0; i< testo.length(); i++) {
                        // show all characters
                        Log.d("torch", "carattere: "+Character.toString(carattere[i]));
                        switch (carattere[i]) {
                            case 'a':
                            case 'A':
                                for (int j = 0; j < a.length; j++) {
                                    charToFlash(a[j]);
                                }
                                break;
                            case 'b':
                            case 'B':
                                for (int j = 0; j < b.length; j++) {
                                    charToFlash(b[j]);
                                }
                                break;
                            case 'c':
                            case 'C':
                                for (int j = 0; j < c.length; j++) {
                                    charToFlash(c[j]);
                                }
                                break;
                            case 'd':
                            case 'D':
                                for (int j = 0; j < d.length; j++) {
                                    charToFlash(d[j]);
                                }
                                break;
                            case 'e':
                            case 'E':
                                for (int j = 0; j < e.length; j++) {
                                    charToFlash(e[j]);
                                }
                                break;
                            case 'f':
                            case 'F':
                                for (int j = 0; j < f.length; j++) {
                                    charToFlash(f[j]);
                                }
                                break;
                            case 'g':
                            case 'G':
                                for (int j = 0; j < g.length; j++) {
                                    charToFlash(g[j]);
                                }
                                break;
                            case 'h':
                            case 'H':
                                for (int j = 0; j < h.length; j++) {
                                    charToFlash(h[j]);
                                }
                                break;
                            case 'i':
                            case 'I':
                                for (int j = 0; j < iI.length; j++) {
                                    charToFlash(iI[j]);
                                }
                                break;
                            case 'j':
                            case 'J':
                                for (int j = 0; j < jJ.length; j++) {
                                    charToFlash(jJ[j]);
                                }
                                break;
                            case 'k':
                            case 'K':
                                for (int j = 0; j < k.length; j++) {
                                    charToFlash(k[j]);
                                }
                                break;
                            case 'l':
                            case 'L':
                                for (int j = 0; j < l.length; j++) {
                                    charToFlash(l[j]);
                                }
                                break;
                            case 'm':
                            case 'M':
                                for (int j = 0; j < m.length; j++) {
                                    charToFlash(m[j]);
                                }
                                break;
                            case 'n':
                            case 'N':
                                for (int j = 0; j < n.length; j++) {
                                    charToFlash(n[j]);
                                }
                                break;
                            case 'o':
                            case 'O':
                                for (int j = 0; j < o.length; j++) {
                                    charToFlash(o[j]);
                                }
                                break;
                            case 'p':
                            case 'P':
                                for (int j = 0; j < p.length; j++) {
                                    charToFlash(p[j]);
                                }
                                break;
                            case 'q':
                            case 'Q':
                                for (int j = 0; j < q.length; j++) {
                                    charToFlash(q[j]);
                                }
                                break;
                            case 'r':
                            case 'R':
                                for (int j = 0; j < r.length; j++) {
                                    charToFlash(r[j]);
                                }
                                break;
                            case 's':
                            case 'S':
                                for (int j = 0; j < s.length; j++) {
                                    charToFlash(s[j]);
                                }
                                break;
                            case 't':
                            case 'T':
                                for (int j = 0; j < t.length; j++) {
                                    charToFlash(t[j]);
                                }
                                break;
                            case 'u':
                            case 'U':
                                for (int j = 0; j < u.length; j++) {
                                    charToFlash(u[j]);
                                }
                                break;
                            case 'v':
                            case 'V':
                                for (int j = 0; j < v.length; j++) {
                                    charToFlash(v[j]);
                                }
                                break;
                            case 'w':
                            case 'W':
                                for (int j = 0; j < w.length; j++) {
                                    charToFlash(w[j]);
                                }
                                break;
                            case 'x':
                            case 'X':
                                for (int j = 0; j < x.length; j++) {
                                    charToFlash(x[j]);
                                }
                                break;
                            case 'y':
                            case 'Y':
                                for (int j = 0; j < y.length; j++) {
                                    charToFlash(y[j]);
                                }
                                break;
                            case 'z':
                            case 'Z':
                                for (int j = 0; j < z.length; j++) {
                                    charToFlash(z[j]);
                                }
                                break;
                            case '1':
                                for (int j = 0; j < uno.length; j++) {
                                    charToFlash(uno[j]);
                                }
                                break;
                            case '2':
                                for (int j = 0; j < due.length; j++) {
                                    charToFlash(due[j]);
                                }
                                break;
                            case '3':
                                for (int j = 0; j < tre.length; j++) {
                                    charToFlash(tre[j]);
                                }
                                break;
                            case '4':
                                for (int j = 0; j < quattro.length; j++) {
                                    charToFlash(quattro[j]);
                                }
                                break;
                            case '5':
                                for (int j = 0; j < cinque.length; j++) {
                                    charToFlash(cinque[j]);
                                }
                                break;
                            case '6':
                                for (int j = 0; j < sei.length; j++) {
                                    charToFlash(sei[j]);
                                }
                                break;
                            case '7':
                                for (int j = 0; j < sette.length; j++) {
                                    charToFlash(sette[j]);
                                }
                                break;
                            case '8':
                                for (int j = 0; j < otto.length; j++) {
                                    charToFlash(otto[j]);
                                }
                                break;
                            case '9':
                                for (int j = 0; j < nove.length; j++) {
                                    charToFlash(nove[j]);
                                }
                                break;
                            case '0':
                                for (int j = 0; j < zero.length; j++) {
                                    charToFlash(zero[j]);
                                }
                                break;
                            case ' ':
                                Log.d("torch", "spazio_parola");
                                flashlightOff();
                                // keep torch off for 300ms because after that loop automatically the torch is turned off for 200ms (300+200=500ms=5*dot)
                                Thread.sleep(100);
                                break;
                        }

                    }
                    // turn off flashlight for 300-100ms because automatically when a character is sent, torchlight is turned off for 100ms (pausa)
                    flashlightOff();
                    Thread.sleep(200);
                } catch (InterruptedException er) {
                    er.printStackTrace();
                }
            } // close run()
        }).start();
    } // close torch()

    public void charToFlash(int simbolo) throws InterruptedException {
        if (simbolo == 0) {
            morseFlash(punto);
        } else if (simbolo == 1) {
            morseFlash(linea);
        }
    }

    public void morseFlash(int tempo) throws InterruptedException {
        // turn on flash
        flashlightOn();
        // wait
        Thread.sleep(tempo);
        // turn off flash
        flashlightOff();
        // wait
        Thread.sleep(pausa);
    }

    public void flashlightOn(){
        Log.d("flashlightOn", "accendo");
        // check that device has torch flashlight
        if (getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)) {
            // device has torch flashlight
            try {
                // open camera
                CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
                cameraManager.setTorchMode("0",true);
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        }
        // set torch status on
        //torchStatus = true;
    }
    public void flashlightOff() {
        Log.d("flashlightOff", "spengo");
        // check that device has torch flashlight
        if (getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)) {
            // device has torch flashlight
            try {
                // open camera
                CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
                cameraManager.setTorchMode("0",false);
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        }
        // set torch status off
        //torchStatus = false;
    }
}
