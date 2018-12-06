package com.example.aweso.arminterpreter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterScreen extends AppCompatActivity
{
    private EditText[] theRegisterETs = new EditText[31];

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);
        this.theRegisterETs[0] = this.findViewById(R.id.x0ET);
        this.theRegisterETs[1] = this.findViewById(R.id.x1ET);
        this.theRegisterETs[2] = this.findViewById(R.id.x2ET);
        this.theRegisterETs[3] = this.findViewById(R.id.x3ET);
        this.theRegisterETs[4] = this.findViewById(R.id.x4ET);
        this.theRegisterETs[5] = this.findViewById(R.id.x5ET);
        this.theRegisterETs[6] = this.findViewById(R.id.x6ET);
        this.theRegisterETs[7] = this.findViewById(R.id.x7ET);
        this.theRegisterETs[8] = this.findViewById(R.id.x8ET);
        this.theRegisterETs[9] = this.findViewById(R.id.x9ET);
        this.theRegisterETs[10] = this.findViewById(R.id.x10ET);
        this.theRegisterETs[11] = this.findViewById(R.id.x11ET);
        this.theRegisterETs[12] = this.findViewById(R.id.x12ET);
        this.theRegisterETs[13] = this.findViewById(R.id.x13ET);
        this.theRegisterETs[14] = this.findViewById(R.id.x14ET);
        this.theRegisterETs[15] = this.findViewById(R.id.x15ET);
        this.theRegisterETs[16] = this.findViewById(R.id.x16ET);
        this.theRegisterETs[17] = this.findViewById(R.id.x17ET);
        this.theRegisterETs[18] = this.findViewById(R.id.x18ET);
        this.theRegisterETs[19] = this.findViewById(R.id.x19ET);
        this.theRegisterETs[20] = this.findViewById(R.id.x20ET);
        this.theRegisterETs[21] = this.findViewById(R.id.x21ET);
        this.theRegisterETs[22] = this.findViewById(R.id.x22ET);
        this.theRegisterETs[23] = this.findViewById(R.id.x23ET);
        this.theRegisterETs[24] = this.findViewById(R.id.x24ET);
        this.theRegisterETs[25] = this.findViewById(R.id.x25ET);
        this.theRegisterETs[26] = this.findViewById(R.id.x26ET);
        this.theRegisterETs[27] = this.findViewById(R.id.x27ET);
        this.theRegisterETs[28] = this.findViewById(R.id.x28ET);
        this.theRegisterETs[29] = this.findViewById(R.id.x29ET);
        this.theRegisterETs[30] = this.findViewById(R.id.x30ET);

        this.fillRegistersWithCurrentValues();
    }

    private void fillRegistersWithCurrentValues()
    {
        for(int i = 0; i < ARMap.registers.length; i++)
        {
            this.theRegisterETs[i].setText("" + ARMap.registers[i].getValue());
        }
    }

    public void registerNameTFPressed(View v)
    {
        TextView tv = (TextView)v;
        String registerName = tv.getText().toString();
        Intent i = new Intent(this, RegisterDetailScreen.class);
        i.putExtra("detailRegisterName", registerName);
        this.startActivity(i);
    }

    /*
    public void onBackPressed()
    {
        //globally save the current values of all the registers such that those values are
        //accessible in MainActivity.  You should do something in MainActivity to prove this.
        for(int i = 0; i < this.theRegisterETs.length; i++)
        {
            ARMap.registerValues[i] = Integer.parseInt(this.theRegisterETs[i].getText().toString());
        }

        Toast.makeText(this, "Saved...", Toast.LENGTH_SHORT).show();
        super.onBackPressed();
    }
    */

    public void saveButtonPressed(View v)
    {
        //globally save the current values of all the registers such that those values are
        //accessible in MainActivity.  You should do something in MainActivity to prove this.
        for(int i = 0; i < this.theRegisterETs.length; i++)
        {
            ARMap.registers[i].setValue(Integer.parseInt(this.theRegisterETs[i].getText().toString()));
        }

        Toast.makeText(this, "Saved...", Toast.LENGTH_SHORT).show();
        this.onBackPressed();
    }
}
