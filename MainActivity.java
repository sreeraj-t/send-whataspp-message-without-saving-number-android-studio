package com.clini.cliniwa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText phno,text;
    Button getno;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phno=(EditText)findViewById(R.id.phonenumber);
        text=(EditText)findViewById(R.id.message);
        getno=(Button)findViewById(R.id.subbutton);
        getno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = phno.getText().toString();
                String msg=text.getText().toString();
                if(number.length()>=10)
                {
                    Uri uri = Uri.parse("https://wa.me/91"+number+"?text="+msg); // missing 'http://' will cause crashed
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    Toast.makeText(getApplicationContext(),"Opening Chat "+number,Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"The Number is Invalid "+number,Toast.LENGTH_LONG).show();
                }



            }
        });

    }


}
