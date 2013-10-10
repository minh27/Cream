package com.example.CREAM;

import android.*;
import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Minh
 * Date: 8/10/13
 * Time: 3:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class DisplayMessageActivity extends Activity {

    private CommentsDataSource datasource;
    private ListView listView;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // get message from intent
        Intent intent = getIntent();
        String message = intent.getStringExtra(MyActivity.EXTRA_MESSAGE);

        // create the text view
        //ListView textView = new ListView(this);

        datasource = new CommentsDataSource(this);
        datasource.open();

        List<Comment> values = datasource.getAllComments();

        // Use the SimpleCursorAdapter to show the
        // elements in a ListView
        ArrayAdapter<Comment> adapter = new ArrayAdapter<Comment>(this,
                android.R.layout.simple_list_item_1, values);
        //setListAdapter(adapter);

        /*TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);*/

        listView = new ListView(this);
        listView.setAdapter(adapter);

        setContentView(listView);
    }

    public void deleteMessage (View view) {
        @SuppressWarnings("unchecked")
        ArrayAdapter<Comment> adapter = (ArrayAdapter<Comment>) listView.getAdapter();
        Comment comment = null;

        if (listView.getAdapter().getCount() > 0) {
            comment = (Comment) listView.getAdapter().getItem(0);
            datasource.deleteComment(comment);
            adapter.remove(comment);
        }

        adapter.notifyDataSetChanged();
    }
    /*public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // This ID represents the Home or Up button. In the case of this
                // activity, the Up button is shown. Use NavUtils to allow users
                // to navigate up one level in the application structure. For
                // more details, see the Navigation pattern on Android Design:
                //
                // http://developer.android.com/design/patterns/navigation.html#up-vs-back
                //
                //NavUtils.navigateUpFromSameTask(this);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }             */
}
