package com.example.guilherme.sunshine;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            String[] forecastArray = {
                    "Today - Sunny - 35º/25º",
                    "Tomorrow - Rainy - 30º/22º",
                    "Wednesday - Cloudy - 29º/25º",
                    "Thursday - Sunny - 36º/26º",
                    "Friday -  Rainy - 27º/22º",
                    "Saturday - Rainy - 29º/24º",
                    "Sunday - Sunny - 35º/25º"
            };
            //Storing the raw data in an arrayList
            List<String> weekForecast = new ArrayList<>(Arrays.asList(forecastArray));
            ArrayAdapter<String> mForecastAdapter = new ArrayAdapter<>(
                    // The current context (this fragment parent activity)
                    getActivity(),
                    // ID of list item LAYOUT
                    R.layout.list_item_forecast,
                    // ID of the textview to populate
                    R.id.list_item_forecast_textview,
                    // Data to populate the textview
                    weekForecast);

            // Getting reference to the listview from the fragment_main.xml and attaching the adapter to it
            ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);
            listView.setAdapter(mForecastAdapter);

            return rootView;
        }
    }
}
