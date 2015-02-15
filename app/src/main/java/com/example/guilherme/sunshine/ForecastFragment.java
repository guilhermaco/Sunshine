package com.example.guilherme.sunshine;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForecastFragment extends Fragment {

    public ForecastFragment() {
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
        // Storing the raw data in an arrayList
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