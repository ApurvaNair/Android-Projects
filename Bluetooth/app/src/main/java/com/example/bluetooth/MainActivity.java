package com.example.bluetooth;
import androidx.appcompat.app.AppCompatActivity;
import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_ENABLE_BT = 0;
    private static final int REQUEST_DISCOVERABLE_BT = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView out1 = (TextView) findViewById(R.id.out1);
        final Button button1 = (Button) findViewById(R.id.buttonON);
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            out1.append("Device not supported");
        }
    button1.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            try {
                if (mBluetoothAdapter.isEnabled()) {
                    mBluetoothAdapter.disable();
                    String s1 = mBluetoothAdapter.getAddress();
                    String bname = mBluetoothAdapter.getName();
                    out1.setText("Bluetooth Disabled" +"\n\n"+ s1 + "\n" + bname);
                    button1.setText("TURN ON");
                } else {
                    mBluetoothAdapter.enable();
                    out1.setText("Bluetooth Enabled");
                    button1.setText("TURN OFF");
                }
            }catch(SecurityException se){
                out1.setText("Exception Occurred");}
        }
    });
    }
}
