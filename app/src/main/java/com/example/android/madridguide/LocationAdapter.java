package com.example.android.madridguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

/**
 * Custom adapter used to implement each object on a set ListView
 */

public class LocationAdapter extends ArrayAdapter<Location> {

    private int mColorResourceId;

    public LocationAdapter(@NonNull Context context, List<Location> objects, int color) {
        super(context, 0, objects);
        mColorResourceId = color;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Gets the current Location object
        Location location = getItem(position);

        // Changes the name TextView of the Layout
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name_text_view);
        nameTextView.setText(location.getName());

        // Changes the address TextView of the Layout
        TextView addressTextView = (TextView) listItemView.findViewById(R.id.address_text_view);
        addressTextView.setText(location.getAddress());

        // Sets the image on the ImageView of the Layout
        ImageView image = (ImageView) listItemView.findViewById(R.id.image);
        image.setImageResource(location.getImageId());

        /* Checks if the Location object has a Museum Topic and, depending on the result, hides
           or shows the TextView */
        TextView museumTopic = (TextView) listItemView.findViewById(R.id.museum_text_view);
        if (location.hasMuseumTopic()) {
            museumTopic.setText(location.getMuseumTopic());
            museumTopic.setVisibility(View.VISIBLE);
        } else {
            museumTopic.setVisibility(View.GONE);
        }

        /* Checks if the Location object has a Type of Restaurant Value and, depending on the result,
           hides or shows the TextView */
        TextView restaurantType = (TextView) listItemView.findViewById(R.id.restaurant_text_view);
        if (location.hasTypeOfRestaurant()) {
            restaurantType.setText(location.getTypeOfRestaurant());
            restaurantType.setVisibility(View.VISIBLE);
        } else {
            restaurantType.setVisibility(View.GONE);
        }

        /* Checks if the Location object has a Star Rating Value and, depending on the result, hides
           or shows the TextView */
        RatingBar starRating = (RatingBar) listItemView.findViewById(R.id.rating_bar);
        if (location.hasStarRating()) {
            starRating.setMax(5);
            starRating.setNumStars(5);
            starRating.setRating(location.getStarRating());
            starRating.setVisibility(View.VISIBLE);
        } else {
            starRating.setVisibility(View.GONE);
        }

        // Sets the color of each category based on the input received
        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
