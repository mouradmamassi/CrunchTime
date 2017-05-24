package com.example.mm.crunchtime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class Main2Activity extends AppCompatActivity {


    private ListView lv = null;

    // Listview Adapter
    ArrayAdapter<String> adapter = null;

    // Search EditText
    EditText inputSearch;


    // ArrayList for Listview
    ArrayList<HashMap<String, String>> productList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        String products[] = {"120154", "120151", "102452", "102484", "124789",
                "120157", "124963","100254", "124896", "147895", "128520"};

        lv = (ListView) findViewById(R.id.list_view);
        inputSearch = (EditText) findViewById(R.id.inputSearch);

        // Adding items to listview
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.product_name, products);
        lv.setAdapter(adapter);
        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Main2Activity.this.adapter.getFilter().filter(s);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = (String)parent.getItemAtPosition(position);
                Bundle codecale = getIntent().getExtras();
               Toast toast = Toast.makeText(Main2Activity.this,(String)codecale.get("codeqr") , Toast.LENGTH_LONG);
                toast.show();
                Intent intent2 = new Intent(Main2Activity.this, Main3Activity.class);

                Bundle bundle = new Bundle();

//Add your data to bundle
                bundle.putString("codewagon", value);
                bundle.putString("codecale", (String)codecale.get("codeqr"));
                intent2.putExtras(bundle);
                startActivity(intent2);

            }
        });
    }









}
