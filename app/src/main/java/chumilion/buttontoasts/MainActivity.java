package chumilion.buttontoasts;

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

    Integer[] textPresses = {0, 0, 0, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView[] textViews = {(TextView) findViewById(R.id.tl_textView),
                                (TextView) findViewById(R.id.tr_textView),
                                (TextView) findViewById(R.id.bl_textView),
                                (TextView) findViewById(R.id.br_textView)};


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
                    Log.i("onCreate", textViewz[y].getId() + " was pressed " +
                            textPresses[y] + timez);
                }
            });
        }

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
