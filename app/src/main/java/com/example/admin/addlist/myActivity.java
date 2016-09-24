package com.example.admin.addlist;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;


public class myActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        ListView lview=(ListView) findViewById(R.id.myList);
        final EditText mytext=(EditText) findViewById(R.id.myText);

        final ArrayList<String> doItems=new ArrayList<String>();
        final ArrayAdapter<String> stringAdapter;
        stringAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,doItems);
        lview.setAdapter(stringAdapter);

        mytext.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction()== KeyEvent.ACTION_DOWN) {
                    // Upon clicking enter on softkeyboard or clicking on the hardware enter button, new string is added to the list
                    if ((keyCode == KeyEvent.KEYCODE_DPAD_CENTER) || (keyCode == KeyEvent.KEYCODE_ENTER)) {
                        doItems.add(0, mytext.getText().toString());
                        //once the string is added to list, this function displays list view with new data
                        stringAdapter.notifyDataSetChanged();
                        mytext.setText("");
                        return true;
                    }
                }
                return false;
            }
        });

        Spinner companies=(Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.myComp,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        companies.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
