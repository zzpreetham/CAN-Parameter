package com.royalenfield.evcansim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    SeekBar speed_change, distance, odometer, chrgtym, progressbarSOC, lowSOC, battery_SOH;
    TextView txtspeed, txtdistance, txtodo, txtvehiclechrg, txtchrgtym, txtsoc, txtLowSoc, txtbatterysoh, ride_mode_val;

    Switch right_switch, left_switch, hazard_switch, vehicle_err_switch, regen_switch, abs_switch, reverse_mode;

    boolean rightstr, leftstr, hazardstr, errorstr, regenstr, reverse_str = false;
    String abs_str = "";
    Button start_btn, stop_btn;

    ArrayList<JSONObject> arrayList = new ArrayList();
    ArrayList<Parameters> paramsarrayList;

    private String value = "", key = "";

    CountDownTimer countDownTimer;
    RadioButton ridemode, chargeMode;
    RadioGroup radioGroup, charging_Group;

    String ride_mode_str, charge_mode_str = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayList = new ArrayList();
        paramsarrayList = new ArrayList();

        speed_change = findViewById(R.id.speed_change);
        distance = findViewById(R.id.distance_change);
        odometer = findViewById(R.id.odo_change);
        chrgtym = findViewById(R.id.charge_time);

        txtspeed = findViewById(R.id.spd);
        txtdistance = findViewById(R.id.dstnce);
        txtodo = findViewById(R.id.odomtr);
        txtvehiclechrg = findViewById(R.id.charging);
        txtchrgtym = findViewById(R.id.chargetym);
        txtsoc = findViewById(R.id.txt_soc);
        txtLowSoc = findViewById(R.id.txt_low_soc);
        txtbatterysoh = findViewById(R.id.txt_battery_soh);
        ride_mode_val = findViewById(R.id.ride_mode_val);

        progressbarSOC = findViewById(R.id.vehicle_soc);
        lowSOC = findViewById(R.id.vehicle_low_soc);
        battery_SOH = findViewById(R.id.battery_SOH);

        right_switch = findViewById(R.id.right_switch);
        left_switch = findViewById(R.id.left_switch);
        hazard_switch = findViewById(R.id.hazard_switch);
        vehicle_err_switch = findViewById(R.id.vehicle_err_switch);
        regen_switch = findViewById(R.id.regen_switch);
        abs_switch = findViewById(R.id.abs_switch);
        reverse_mode = findViewById(R.id.reverse_switch);

        radioGroup = findViewById(R.id.radioGroup);
        charging_Group = findViewById(R.id.charging_Group);

        start_btn = findViewById(R.id.start_btn);
        stop_btn = findViewById(R.id.stop_btn);

        rightstr = false;
        leftstr = false;
        hazardstr = false;
        errorstr = false;
        regenstr = false;

        //Seekbar to change value
        speed_change.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValuespd = 0;


            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                progressChangedValuespd = progress;
                txtspeed.setText(String.valueOf(progressChangedValuespd));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        distance.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValuedist = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                progressChangedValuedist = progress;
                txtdistance.setText(String.valueOf(progressChangedValuedist));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        odometer.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValueodo = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                progressChangedValueodo = progress;
                txtodo.setText(String.valueOf(progressChangedValueodo));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        chrgtym.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValuechrgtym = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                progressChangedValuechrgtym = progress;
                txtchrgtym.setText(String.valueOf(progressChangedValuechrgtym));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        progressbarSOC.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValuesoc = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                progressChangedValuesoc = progress;
                txtsoc.setText(String.valueOf(progressChangedValuesoc));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        lowSOC.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValuelowsoc = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                progressChangedValuelowsoc = progress;
                txtLowSoc.setText(String.valueOf(progressChangedValuelowsoc));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        battery_SOH.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValuebattrysoh = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                progressChangedValuebattrysoh = progress;
                txtbatterysoh.setText(String.valueOf(progressChangedValuebattrysoh));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        //toogle switch parameters
        right_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    rightstr = true;
                    Toast.makeText(MainActivity.this, "Right indicator ON", Toast.LENGTH_SHORT).show();
                } else {
                    rightstr = false;
                    Toast.makeText(MainActivity.this, "Right indicator OFF", Toast.LENGTH_SHORT).show();
                }
            }
        });
        left_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    leftstr = true;
                    Toast.makeText(MainActivity.this, "Left indicator ON", Toast.LENGTH_SHORT).show();
                } else {
                    leftstr = false;
                    Toast.makeText(MainActivity.this, "Left indicator OFF", Toast.LENGTH_SHORT).show();
                }
            }
        });
        hazard_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    hazardstr = true;
                    Toast.makeText(MainActivity.this, "Hazard light ON", Toast.LENGTH_SHORT).show();
                } else {
                    hazardstr = false;
                    Toast.makeText(MainActivity.this, "Hazard light OFF", Toast.LENGTH_SHORT).show();
                }
            }
        });
        vehicle_err_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    errorstr = true;
                    Toast.makeText(MainActivity.this, "vehicle error ON", Toast.LENGTH_SHORT).show();
                } else {
                    errorstr = false;
                    Toast.makeText(MainActivity.this, "vehicle error OFF", Toast.LENGTH_SHORT).show();
                }
            }
        });
        regen_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    regenstr = true;
                    Toast.makeText(MainActivity.this, "Regeneration Active", Toast.LENGTH_SHORT).show();
                } else {
                    regenstr = false;
                    Toast.makeText(MainActivity.this, "Regeneration Inactive", Toast.LENGTH_SHORT).show();
                }
            }
        });
        abs_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    abs_str = "0";
                    Toast.makeText(MainActivity.this, "ABS ON", Toast.LENGTH_SHORT).show();
                } else {
                    abs_str = "1";
                    Toast.makeText(MainActivity.this, "ABS OFF", Toast.LENGTH_SHORT).show();
                }
            }
        });
        reverse_mode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    reverse_str = true;
                    Toast.makeText(MainActivity.this, "ABS ON", Toast.LENGTH_SHORT).show();
                } else {
                    reverse_str = false;
                    Toast.makeText(MainActivity.this, "ABS OFF", Toast.LENGTH_SHORT).show();
                }
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ridemode = group.findViewById(checkedId);
                ride_mode_str = String.valueOf(ridemode.getText());
                ride_mode_val.setText(ride_mode_str);
                if (ride_mode_str.equalsIgnoreCase("Eco")) {
                    ride_mode_str = "ES";
                    Log.d("radiobtnnn", ride_mode_str + "");
                } else if (ride_mode_str.equalsIgnoreCase("Tour")) {
                    ride_mode_str = "ST";
                    Log.d("radiobtnnn", ride_mode_str + "");
                } else if (ride_mode_str.equalsIgnoreCase("Sports")) {
                    ride_mode_str = "IS";
                    Log.d("radiobtnnn", ride_mode_str + "");
                }
            }
        });
        charging_Group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                chargeMode = group.findViewById(checkedId);
                charge_mode_str = String.valueOf(chargeMode.getText());
                txtvehiclechrg.setText(charge_mode_str);
                if (charge_mode_str.equalsIgnoreCase("Off")) {
                    charge_mode_str = "DISABLED";
                    Log.d("radiobtnnn", charge_mode_str + "");
                } else if (charge_mode_str.equalsIgnoreCase("Error")) {
                    charge_mode_str = "STATIC";
                    Log.d("radiobtnnn", charge_mode_str + "");
                } else if (charge_mode_str.equalsIgnoreCase("In Progress")) {
                    charge_mode_str = "FREQ";
                    Log.d("radiobtnnn", charge_mode_str + "");
                } else if (charge_mode_str.equalsIgnoreCase("Complete")) {
                    charge_mode_str = "OUTPUT";
                    Log.d("radiobtnnn", charge_mode_str + "");
                }
            }
        });

        //button to start the data broadcasting
        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newLogic();
            }
        });
        stop_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
            }
        });

    }

    //timer to add data in json object and send data after 100ms
    public void newLogic() {

        try {
            countDownTimer = new CountDownTimer(10000, 100) {
                @Override
                public void onTick(long l) {
                    paramsarrayList.clear();
                    txtspeed.setText(String.valueOf(Integer.parseInt(txtspeed.getText().toString())));
                    txtdistance.setText(String.valueOf(Integer.parseInt(txtdistance.getText().toString())));
                    txtodo.setText(String.valueOf(Integer.parseInt(txtodo.getText().toString())));
                    txtchrgtym.setText(String.valueOf(Integer.parseInt(txtchrgtym.getText().toString())));
                    txtsoc.setText(String.valueOf(Integer.parseInt(txtsoc.getText().toString())));
                    txtLowSoc.setText(String.valueOf(Integer.parseInt(txtLowSoc.getText().toString())));
                    txtbatterysoh.setText(String.valueOf(Integer.parseInt(txtbatterysoh.getText().toString())));

                    paramsarrayList.add(new Parameters("speed", String.valueOf(Integer.parseInt(txtspeed.getText().toString())), "123469"));
                    paramsarrayList.add(new Parameters("vehicle_range", String.valueOf(Integer.parseInt(txtdistance.getText().toString())), "123456"));
                    paramsarrayList.add(new Parameters("odo", String.valueOf(Integer.parseInt(txtodo.getText().toString())), "123456"));
                    paramsarrayList.add(new Parameters("charging_time", String.valueOf(Integer.parseInt(txtchrgtym.getText().toString())), "123456"));
                    paramsarrayList.add(new Parameters("soc", String.valueOf(Integer.parseInt(txtsoc.getText().toString())), "123456"));
                    paramsarrayList.add(new Parameters("soc_low", String.valueOf(Integer.parseInt(txtLowSoc.getText().toString())), "123456"));
                    paramsarrayList.add(new Parameters("battery_soh", String.valueOf(Integer.parseInt(txtbatterysoh.getText().toString())), "123456"));

                    paramsarrayList.add(new Parameters("right_ttl", String.valueOf(rightstr), "123456"));
                    paramsarrayList.add(new Parameters("left_ttl", String.valueOf(leftstr), "123456"));
                    paramsarrayList.add(new Parameters("hazard_ttl", String.valueOf(hazardstr), "123456"));
                    paramsarrayList.add(new Parameters("vehicle_error_ind", String.valueOf(errorstr), "123456"));
                    paramsarrayList.add(new Parameters("regen_active", String.valueOf(regenstr), "123456"));
                    paramsarrayList.add(new Parameters("abs_active", String.valueOf(abs_str), "123456"));
                    paramsarrayList.add(new Parameters("reverse_mode", String.valueOf(reverse_str), "123456"));

                    paramsarrayList.add(new Parameters("charging_status", String.valueOf(charge_mode_str), "123456"));
                    paramsarrayList.add(new Parameters("riding_mode", String.valueOf(ride_mode_str), "123456"));

                    try {
                        //JSON object adding in list an creating new json array as per RE document.
                        JSONObject jsonObject = new JSONObject();
                        for (int i = 0; i < paramsarrayList.size(); i++) {
                            int finalI = i;
                            new CountDownTimer(100, 2) {
                                public void onTick(long millisUntilFinished) {
                                    try {
                                        JSONObject speedJson = new JSONObject();
                                        jsonObject.put("signal", paramsarrayList.get(finalI).getKey());
                                        jsonObject.put("canid", paramsarrayList.get(finalI).getCanid());
                                        jsonObject.put("data", paramsarrayList.get(finalI).getValue());
                                        jsonObject.put("timestamp", System.currentTimeMillis());
                                        speedJson.put("packet", jsonObject);

                                        Iterator iteratorObj = speedJson.keys();
                                        while (iteratorObj.hasNext()) {
                                            String getJsonObj = (String) iteratorObj.next();
                                            System.out.println("Book No.: " + "------>" + getJsonObj);
                                            key = getJsonObj;
                                            value = speedJson.getString(key);
                                            Log.v("Book Title key", key + "\t" + value);

                                            MessageSender.sendBroadcast(MainActivity.this, value, key);
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }

                                public void onFinish() {

                                }
                            }.start();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFinish() {
                    countDownTimer.start();
                }
            };
            countDownTimer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}