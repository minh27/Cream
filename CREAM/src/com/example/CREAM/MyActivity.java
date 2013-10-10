package com.example.CREAM;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    private CommentsDataSource datasource;
    public final static String EXTRA_MESSAGE = "com.example.CREAM.MESSAGE";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        datasource = new CommentsDataSource(this);
        datasource.open();

        /*List<Comment> values = datasource.getAllComments();

        // Use the SimpleCursorAdapter to show the
        // elements in a ListView
        ArrayAdapter<Comment> adapter = new ArrayAdapter<Comment>(this,
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);*/
    }

    // Will be called via the onClick attribute
    // of the buttons in main.xml
    public void onClick(View view) {
        @SuppressWarnings("unchecked")
        //ArrayAdapter<Comment> adapter = (ArrayAdapter<Comment>) getListAdapter();
        Comment comment = null;
        TextView editText = (TextView) findViewById(R.id.editText);
        String message = editText.getText().toString();
        switch (view.getId()) {
            case R.id.button:
                /*String[] comments = new String[] { "Cool", "Very nice", "Hate it" };
                int nextInt = new Random().nextInt(3);
                comment = datasource.createComment(comments[nextInt]);*/
                // Save the new comment to the database
                comment = datasource.createComment(message);
                //adapter.add(comment);
                Intent intent = new Intent(this, DisplayMessageActivity.class);
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
                break;
            //case R.id.delete:
                /*if (getListAdapter().getCount() > 0) {
                    comment = (Comment) getListAdapter().getItem(0);
                    datasource.deleteComment(comment);
                    //adapter.remove(comment);
                }  */
               // break;
        }
        //adapter.notifyDataSetChanged();
    }

    /*public void sendMessage (View view) {
        @SuppressWarnings("unchecked")
        //do something in response to clicking button
        //Intent intent = new Intent(this, DisplayMessageActivity.class);
        //ArrayAdapter<Comment> adapter = (ArrayAdapter<Comment>) getListAdapter();
        //Comment comment = null;

        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        comment = datasource.createEntry(message);
        adapter.add(comment);
        adapter.notifyDataSetChanged();

        TextView txt = (TextView) findViewById(R.id.txt);
        txt.setAllCaps(true);
        txt.setText(message);
        //intent.putExtra(EXTRA_MESSAGE, message);
        //startActivity(intent);
    }

    public void deleteMessage (View view) {
        @SuppressWarnings("unchecked")
        ArrayAdapter<Comment> adapter = (ArrayAdapter<Comment>) getListAdapter();
        Comment comment = null;

        if (getListAdapter().getCount() > 0) {
            comment = (Comment) getListAdapter().getItem(0);
            datasource.deleteComment(comment);
            adapter.remove(comment);
        }

        adapter.notifyDataSetChanged();
    }*/

    public void registerNumKey (View view) {
        TextView editText = (TextView) findViewById(R.id.editText);
        String message = editText.getText().toString();
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
            case R.id.imageButton0: num += "0"; break;
            case R.id.imageButtonDot: num += "."; break;
            case R.id.imageButtonBack: editText.setText(message.substring(0, message.length()-1)); break;
        }
        editText.append(num);
    }

    @Override
    protected void onResume() {
        datasource.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        datasource.close();
        super.onPause();
    }
}
