package com.staysafe.stayawake.visha.stayawakestaysafepub;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HomeScreen extends AppCompatActivity {
    public static Button yes;
    private static Button no;
    private static EditText nameText;
    private static EditText ageNum;
    public static String name = "";
    public static String PREFS_NAME = "PREF";
    public static int age = 0;
    static Boolean ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        yes = (Button) findViewById(R.id.yes);
        no = (Button) findViewById(R.id.no);
        nameText = (EditText) findViewById(R.id.name);
        name = nameText.getText().toString();
        ageNum = (EditText) findViewById(R.id.age);
        //age = Integer.parseInt(ageNum.getText().toString());
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ok = true;
                startActivity(new Intent(HomeScreen.this, StartDriving.class));
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ok = false;
                startActivity(new Intent(HomeScreen.this, StartDriving.class));
            }
        });
        SharedPreferences settings = getSharedPreferences(HomeScreen.PREFS_NAME,0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("name", HomeScreen.name);
        editor.putInt("age", HomeScreen.age);
        editor.putBoolean("answer", true);
        editor.putBoolean("run",true);
        editor.commit();
    }
}
