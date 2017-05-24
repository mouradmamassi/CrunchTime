package com.example.mm.crunchtime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    public TextView txt_wagon;
    public TextView txt_cale;
    public Button btn_go = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        txt_wagon = (TextView) findViewById(R.id.wagon);
        txt_cale = (TextView) findViewById(R.id.cale);
        btn_go = (Button) findViewById(R.id.btn_acc);

        Bundle code = getIntent().getExtras();

//        String wagons = code.getString("codewagon");
//        Toast toast = Toast.makeText(this,wagons, Toast.LENGTH_LONG);
//        toast.show();
        txt_wagon.setText(code.getString("codewagon"));
        txt_cale.setText((String)code.get("codecale"));
        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(Main3Activity.this,"Cale Bien Ajouter", Toast.LENGTH_LONG);
                toast.show();

                Intent intent2 = new Intent(Main3Activity.this, MainActivity.class);
                startActivity(intent2);

            }
        });







    }
}
