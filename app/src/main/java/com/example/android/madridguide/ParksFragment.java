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

public class ParksFragment extends Fragment {
    public ParksFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        // Creates an ArrayList of Location-objects and adds each object to it
        final ArrayList<Location> location = new ArrayList<Location>();
        location.add(new Location(getString(R.string.park_1_name), getString(R.string.park_1_address), R.drawable.park_1_image));
        location.add(new Location(getString(R.string.park_2_name), getString(R.string.park_2_address), R.drawable.park_2_image));
        location.add(new Location(getString(R.string.park_3_name), getString(R.string.park_3_address), R.drawable.park_3_image));
        location.add(new Location(getString(R.string.park_4_name), getString(R.string.park_4_address), R.drawable.park_4_image));
        location.add(new Location(getString(R.string.park_5_name), getString(R.string.park_5_address), R.drawable.park_5_image));
        location.add(new Location(getString(R.string.park_6_name), getString(R.string.park_6_address), R.drawable.park_6_image));
        location.add(new Location(getString(R.string.park_7_name), getString(R.string.park_7_address), R.drawable.park_7_image));

        // Creates a custom adapter
        LocationAdapter adapter = new LocationAdapter(getActivity(), location, R.color.category_parks);

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