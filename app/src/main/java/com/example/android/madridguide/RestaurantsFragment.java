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

public class RestaurantsFragment extends Fragment {
    public RestaurantsFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        // Creates an ArrayList of Location-objects and adds each object to it
        final ArrayList<Location> location = new ArrayList<Location>();
        location.add(new Location(getString(R.string.restaurant_1_name), getString(R.string.restaurant_1_address), R.drawable.restaurant_1_image, getString(R.string.restaurant_1_type), Integer.parseInt(getString(R.string.restaurant_1_rating))));
        location.add(new Location(getString(R.string.restaurant_2_name), getString(R.string.restaurant_2_address), R.drawable.restaurant_2_image, getString(R.string.restaurant_2_type), Integer.parseInt(getString(R.string.restaurant_2_rating))));
        location.add(new Location(getString(R.string.restaurant_3_name), getString(R.string.restaurant_3_address), R.drawable.restaurant_3_image, getString(R.string.restaurant_3_type), Integer.parseInt(getString(R.string.restaurant_3_rating))));
        location.add(new Location(getString(R.string.restaurant_4_name), getString(R.string.restaurant_4_address), R.drawable.restaurant_4_image, getString(R.string.restaurant_4_type), Integer.parseInt(getString(R.string.restaurant_4_rating))));
        location.add(new Location(getString(R.string.restaurant_5_name), getString(R.string.restaurant_5_address), R.drawable.restaurant_5_image, getString(R.string.restaurant_5_type), Integer.parseInt(getString(R.string.restaurant_5_rating))));
        location.add(new Location(getString(R.string.restaurant_6_name), getString(R.string.restaurant_6_address), R.drawable.restaurant_6_image, getString(R.string.restaurant_6_type), Integer.parseInt(getString(R.string.restaurant_6_rating))));
        location.add(new Location(getString(R.string.restaurant_7_name), getString(R.string.restaurant_7_address), R.drawable.restaurant_7_image, getString(R.string.restaurant_7_type), Integer.parseInt(getString(R.string.restaurant_7_rating))));
        location.add(new Location(getString(R.string.restaurant_8_name), getString(R.string.restaurant_8_address), R.drawable.restaurant_8_image, getString(R.string.restaurant_8_type), Integer.parseInt(getString(R.string.restaurant_8_rating))));

        // Creates a custom adapter
        LocationAdapter adapter = new LocationAdapter(getActivity(), location, R.color.category_restaurants);

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