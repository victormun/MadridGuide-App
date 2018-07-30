package com.example.android.madridguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MuseumsFragment extends Fragment {
    public MuseumsFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        // Creates an ArrayList of Location-objects and adds each object to it
        final ArrayList<Location> location = new ArrayList<Location>();
        location.add(new Location(getString(R.string.museum_1_name), getString(R.string.museum_1_address), R.drawable.museum_1_image, getString(R.string.museum_1_type)));
        location.add(new Location(getString(R.string.museum_2_name), getString(R.string.museum_2_address), R.drawable.museum_2_image, getString(R.string.museum_2_type)));
        location.add(new Location(getString(R.string.museum_3_name), getString(R.string.museum_3_address), R.drawable.museum_3_image, getString(R.string.museum_3_type)));
        location.add(new Location(getString(R.string.museum_4_name), getString(R.string.museum_4_address), R.drawable.museum_4_image, getString(R.string.museum_4_type)));
        location.add(new Location(getString(R.string.museum_5_name), getString(R.string.museum_5_address), R.drawable.museum_5_image, getString(R.string.museum_5_type)));
        location.add(new Location(getString(R.string.museum_6_name), getString(R.string.museum_6_address), R.drawable.museum_6_image, getString(R.string.museum_6_type)));
        location.add(new Location(getString(R.string.museum_7_name), getString(R.string.museum_7_address), R.drawable.museum_7_image, getString(R.string.museum_7_type)));
        location.add(new Location(getString(R.string.museum_8_name), getString(R.string.museum_8_address), R.drawable.museum_8_image, getString(R.string.museum_8_type)));
        location.add(new Location(getString(R.string.museum_9_name), getString(R.string.museum_9_address), R.drawable.museum_9_image, getString(R.string.museum_9_type)));
        location.add(new Location(getString(R.string.museum_10_name), getString(R.string.museum_10_address), R.drawable.museum_10_image, getString(R.string.museum_10_type)));

        // Creates a custom adapter
        LocationAdapter adapter = new LocationAdapter(getActivity(), location, R.color.category_museums);

        // Gets the current listview and sets the custom adapter
        final ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        // Defines what happens when an item of the list is clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Intent to open Google Maps with the specific address stored on a Location object
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + location.get(position).getAddress() + ", Madrid, Spain");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
        return rootView;
    }
}
