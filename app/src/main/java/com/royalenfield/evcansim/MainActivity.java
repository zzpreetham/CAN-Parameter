package com.royalenfield.evcansim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.Key;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    SeekBar speed_change, distance, odometer, vehicle_chrg, chrgtym, progressbarSOC, lowSOC, battery_SOH;
    TextView txtspeed, txtdistance, txtodo, txtvehiclechrg, txtchrgtym, txtsoc, txtLowSoc, txtbatterysoh;

    Switch right_switch, left_switch, hazard_switch, vehicle_err_switch, regen_switch, abs_switch;

    boolean rightstr, leftstr, hazardstr, errorstr, regenstr, abs_str = false;


    Button button;

    ArrayList<JSONObject> arrayList = new ArrayList();
    ArrayList<Parameters> paramsarrayList ;

    private String value = "", key = "";

    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayList = new ArrayList();
        paramsarrayList = new ArrayList();

        speed_change = findViewById(R.id.speed_change);
        distance = findViewById(R.id.distance_change);
        odometer = findViewById(R.id.odo_change);
        vehicle_chrg = findViewById(R.id.charge_state);
        chrgtym = findViewById(R.id.charge_time);

        txtspeed = findViewById(R.id.spd);
        txtdistance = findViewById(R.id.dstnce);
        txtodo = findViewById(R.id.odomtr);
        txtvehiclechrg = findViewById(R.id.charging);
        txtchrgtym = findViewById(R.id.chargetym);
        txtsoc = findViewById(R.id.txt_soc);
        txtLowSoc = findViewById(R.id.txt_low_soc);
        txtbatterysoh = findViewById(R.id.txt_battery_soh);

        progressbarSOC = findViewById(R.id.vehicle_soc);
        lowSOC = findViewById(R.id.vehicle_low_soc);
        battery_SOH = findViewById(R.id.battery_SOH);

        right_switch = findViewById(R.id.right_switch);
        left_switch = findViewById(R.id.left_switch);
        hazard_switch = findViewById(R.id.hazard_switch);
        vehicle_err_switch = findViewById(R.id.vehicle_err_switch);
        regen_switch = findViewById(R.id.regen_switch);
        abs_switch = findViewById(R.id.abs_switch);

        button = findViewById(R.id.start_btn);

        rightstr = false;
        leftstr = false;
        hazardstr = false;
        errorstr = false;
        regenstr = false;
        abs_str = false;


        speed_change.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValuespd = 0;


            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                progressChangedValuespd = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                txtspeed.setText(String.valueOf(progressChangedValuespd));
            }
        });

        distance.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValuedist = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                progressChangedValuedist = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                txtdistance.setText(String.valueOf(progressChangedValuedist));
            }
        });
        odometer.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValueodo = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                progressChangedValueodo = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                txtodo.setText(String.valueOf(progressChangedValueodo));
            }
        });
        vehicle_chrg.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValuechrgng = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                progressChangedValuechrgng = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                txtvehiclechrg.setText(String.valueOf(progressChangedValuechrgng ));
            }
        });
        chrgtym.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValuechrgtym = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                progressChangedValuechrgtym = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                txtchrgtym.setText(String.valueOf(progressChangedValuechrgtym ));
            }
        });

        progressbarSOC.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValuesoc = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                progressChangedValuesoc = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                txtsoc.setText(String.valueOf(progressChangedValuesoc));
            }
        });
        lowSOC.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValuelowsoc = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                progressChangedValuelowsoc = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                txtLowSoc.setText(String.valueOf(progressChangedValuelowsoc ));
            }
        });
        battery_SOH.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValuebattrysoh = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                progressChangedValuebattrysoh = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                txtbatterysoh.setText(String.valueOf(progressChangedValuebattrysoh) );
            }
        });

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
                    abs_str = true;
                    Toast.makeText(MainActivity.this, "ABS ON", Toast.LENGTH_SHORT).show();
                } else {
                    abs_str = false;
                    Toast.makeText(MainActivity.this, "ABS OFF", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newLogic();


                /*JSONObject jsonObject = new JSONObject();
                CountDownTimer updateTimer=new CountDownTimer(5000, 100) {
                    public void onTick(long millisUntilFinished) {
                        txtspeed.setText(String.valueOf(Integer.parseInt(txtspeed.getText().toString()) + 1));
                        txtdistance.setText(String.valueOf(Integer.parseInt(txtdistance.getText().toString()) + 1));
                        paramsarrayList.add(new Parameters("speed",String.valueOf(Integer.parseInt(txtspeed.getText().toString()) + 1),"123469"));
                        paramsarrayList.add(new Parameters("distance",String.valueOf(Integer.parseInt(txtdistance.getText().toString()) + 1),"123456"));
                        paramsarrayList.add(new Parameters("odometer",String.valueOf(Integer.parseInt(txtodo.getText().toString())),"987645"));
                    }

                    public void onFinish() {
                        new CountDownTimer(5000, 2) {
                            public void onTick(long millisUntilFinished) {
                                Long tsLong = System.currentTimeMillis()/1000;
                                String ts = tsLong.toString();
                                try {
                                    //JSON object adding in list an creating new json array as per RE document
                                    JSONObject speedJson=new JSONObject();
                                    for(int i=0;i<paramsarrayList.size();i++){
                                        jsonObject.put("signal",paramsarrayList.get(i).getKey());
                                        jsonObject.put("canid",paramsarrayList.get(i).getCanid());
                                        jsonObject.put("data",paramsarrayList.get(i).getValue());
                                        jsonObject.put("timestamp",System.currentTimeMillis());
                                        //jsonObject.put("SignalPacket", speedJson);
                                        //arrayList.add(jsonObject);

                                        *//*try {
                                            Iterator iteratorObj = jsonObject.keys();
                                            while (iteratorObj.hasNext()) {
                                                String getJsonObj = (String) iteratorObj.next();
                                                System.out.println("Book No.: " + "------>" + getJsonObj);
                                                key = getJsonObj;
                                                value = jsonObject.getString(key);
                                                Log.v("Book Title key", key + "\t" + value);

                                                MessageSender.sendBroadcast(MainActivity.this, value, key);
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }*//*
                                        Log.d("listttttttt", jsonObject.toString()+ "");
                                    }

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            public void onFinish() {

                            }
                        }.start();
                    }
                }.start();*/


                //TODO: 100ms upload and evry 50ms change data

                /*new CountDownTimer(5000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        try {
                            Iterator iteratorObj = jsonObject.keys();
                            while (iteratorObj.hasNext()) {
                                String getJsonObj = (String) iteratorObj.next();
                                System.out.println("Book No.: " + "------>" + getJsonObj);
                                key = getJsonObj;
                                value = jsonObject.getString(key);
                                Log.v("Book Title key", key + "\t" + value);

                                MessageSender.sendBroadcast(MainActivity.this, value, key);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    public void onFinish() {
                        start();
                    }
                }.start();*/


                //new logic as per RE document
               /* new CountDownTimer(5000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        try {
                            Iterator iteratorObj = jsonObject.keys();
                            while (iteratorObj.hasNext()) {
                                String getJsonObj = (String) iteratorObj.next();
                                System.out.println("Book No.: " + "------>" + getJsonObj);
                                key = getJsonObj;
                                value = jsonObject.getString(key);
                                Log.v("Book Title key", key + "\t" + value);

                                MessageSender.sendBroadcast(MainActivity.this, value, key);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    public void onFinish() {
                        start();
                    }
                }.start();*/

            }
        });

    }

    public void newLogic() {

        try {
            countDownTimer = new CountDownTimer(10000, 100) {
                @Override
                public void onTick(long l) {
                    paramsarrayList.clear();
                    txtspeed.setText(String.valueOf(Integer.parseInt(txtspeed.getText().toString())));
                    txtdistance.setText(String.valueOf(Integer.parseInt(txtdistance.getText().toString())));
                    txtodo.setText(String.valueOf(Integer.parseInt(txtodo.getText().toString())));
                    txtvehiclechrg.setText(String.valueOf(Integer.parseInt(txtvehiclechrg.getText().toString())));
                    txtchrgtym.setText(String.valueOf(Integer.parseInt(txtchrgtym.getText().toString())));
                    txtsoc.setText(String.valueOf(Integer.parseInt(txtsoc.getText().toString())));
                    txtLowSoc.setText(String.valueOf(Integer.parseInt(txtLowSoc.getText().toString())));
                    txtbatterysoh.setText(String.valueOf(Integer.parseInt(txtbatterysoh.getText().toString())));

                    paramsarrayList.add(new Parameters("speed", String.valueOf(Integer.parseInt(txtspeed.getText().toString())), "123469"));
                    paramsarrayList.add(new Parameters("distance", String.valueOf(Integer.parseInt(txtdistance.getText().toString())), "123456"));
                    paramsarrayList.add(new Parameters("odo", String.valueOf(Integer.parseInt(txtodo.getText().toString())), "123456"));
                    paramsarrayList.add(new Parameters("vehiclechrg", String.valueOf(Integer.parseInt(txtvehiclechrg.getText().toString())), "123456"));
                    paramsarrayList.add(new Parameters("chrgtym", String.valueOf(Integer.parseInt(txtchrgtym.getText().toString())), "123456"));
                    paramsarrayList.add(new Parameters("soc", String.valueOf(Integer.parseInt(txtsoc.getText().toString())), "123456"));
                    paramsarrayList.add(new Parameters("lowSOC", String.valueOf(Integer.parseInt(txtLowSoc.getText().toString())), "123456"));
                    paramsarrayList.add(new Parameters("batterySOH", String.valueOf(Integer.parseInt(txtbatterysoh.getText().toString())), "123456"));
                    paramsarrayList.add(new Parameters("rightIND", String.valueOf(rightstr), "123456"));
                    paramsarrayList.add(new Parameters("leftIND", String.valueOf(leftstr), "123456"));
                    paramsarrayList.add(new Parameters("hazard", String.valueOf(hazardstr), "123456"));
                    paramsarrayList.add(new Parameters("vehicle_err", String.valueOf(errorstr), "123456"));
                    paramsarrayList.add(new Parameters("regen", String.valueOf(regenstr), "123456"));
                    paramsarrayList.add(new Parameters("abs", String.valueOf(abs_str), "123456"));



                    try {
                        //JSON object adding in list an creating new json array as per RE document.
                        JSONObject jsonObject = new JSONObject();
                        /*boolean exit = false;
                        long currentTimeMs = System.currentTimeMillis();
                        long previousTimeSentMs = currentTimeMs;
                        while (!exit){
                            for (int i = 0; i < paramsarrayList.size(); i++) {
                                currentTimeMs = System.currentTimeMillis();
                                if(currentTimeMs - previousTimeSentMs > 2) {
                                    try {
                                        JSONObject speedJson = new JSONObject();
                                        jsonObject.put("signal", paramsarrayList.get(i).getKey());
                                        jsonObject.put("canid", paramsarrayList.get(i).getCanid());
                                        jsonObject.put("data", paramsarrayList.get(i).getValue());
                                        jsonObject.put("timestamp", System.currentTimeMillis());
                                        speedJson.put("", jsonObject);

                                        Iterator iteratorObj = speedJson.keys();
                                        while (iteratorObj.hasNext()) {
                                            String getJsonObj = (String) iteratorObj.next();
                                            System.out.println("Book No.: " + "------>" + getJsonObj);
                                            key = getJsonObj;
                                            value = speedJson.getString(key);
                                            Log.v("Book Title key", key + "\t" + value);

                                            MessageSender.sendBroadcast(MainActivity.this, value, key);
                                            previousTimeSentMs = System.currentTimeMillis();
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                            break;
                        }*/









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
                                        speedJson.put("", jsonObject);

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