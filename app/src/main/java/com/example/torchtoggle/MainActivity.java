package com.example.torchtoggle;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    ToggleButton tb;
    CameraManager cm;
    private boolean torch=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tb=(ToggleButton)findViewById(R.id.toggleButton);
        cm=(CameraManager)getSystemService(CAMERA_SERVICE);
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                try {
                    if (isChecked) {
                        String id = cm.getCameraIdList()[0];
                        cm.setTorchMode(id, true);
                        torch=true;

                    } else {

                        String id = cm.getCameraIdList()[0];
                        cm.setTorchMode(id, false);
                        torch=false;

                    }
                } catch (CameraAccessException ca) {

                }
            }


                });
            }
        }




