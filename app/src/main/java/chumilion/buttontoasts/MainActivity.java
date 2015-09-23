package chumilion.buttontoasts;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    Integer[] textPresses = new Integer[4];

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences mySP = getPreferences(Context.MODE_PRIVATE);
        final SharedPreferences.Editor mySPEditor = mySP.edit();


        TextView[] textViews = {(TextView) findViewById(R.id.tl_textView),
                                (TextView) findViewById(R.id.tr_textView),
                                (TextView) findViewById(R.id.bl_textView),
                                (TextView) findViewById(R.id.br_textView)};

        for(int x = 0; x < 4; x++)
        {
            textPresses[x] = mySP.getInt("textViews_" + x, 0);
        }


        for(int x = 0; x < textViews.length; x++)
        {
            final int y = x;
            final TextView[] textViewz = textViews;
            textViews[x].setOnClickListener(new View.OnClickListener()
            {

                public void onClick(View v)
                {
                    textPresses[y] = textPresses[y] + 1;
                    String timez;
                    if(textPresses[y] == 1)
                        timez = " time.";
                    else
                        timez = " times.";
                    Toast.makeText(MainActivity.this, "Pressed " + textPresses[y] + timez,
                            Toast.LENGTH_SHORT).show();
                    Log.i("onCreate", textViewz[y].getText() + " was pressed " +
                            textPresses[y] + timez);
                    mySPEditor.putInt("textViews_" + y, textPresses[y]);
                    mySPEditor.commit();
                }
            });
        }

        TextView res_textView = (TextView) findViewById(R.id.res_textView);
        res_textView.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Toast.makeText(MainActivity.this, "Resetting press count...",
                        Toast.LENGTH_SHORT).show();
                Log.i("onCreate", "Resetting press count...");
                for(int x = 0; x < 4; x++)
                {
                    mySPEditor.putInt("textViews_" + x, 0);
                    textPresses[x] = 0;
                }
                mySPEditor.commit();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
