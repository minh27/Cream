package com.example.CREAM;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void sendMessage (View view) {
        //do something in response to clicking button
        //Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        TextView txt = (TextView) findViewById(R.id.textView);
        txt.setAllCaps(true);
        txt.setText(message);
        //FeedReaderContract.FeedReaderDbHelper helper = new FeedReaderContract.FeedReaderDbHelper(getContext());
        //intent.putExtra(EXTRA_MESSAGE, message);
        //startActivity(intent);
    }

    public void registerNumKey (View view) {
        EditText editText = (EditText) findViewById(R.id.editText);
        String num = new String("");
        switch(view.getId()){
            case R.id.imageButton1: num += "1"; break;
            case R.id.imageButton2: num += "2"; break;
            case R.id.imageButton3: num += "3"; break;
            case R.id.imageButton4: num += "4"; break;
            case R.id.imageButton5: num += "5"; break;
            case R.id.imageButton6: num += "6"; break;
            case R.id.imageButton7: num += "7"; break;
            case R.id.imageButton8: num += "8"; break;
            case R.id.imageButton9: num += "9"; break;
        }
        editText.append(num);
    }
}
