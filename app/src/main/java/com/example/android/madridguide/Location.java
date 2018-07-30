package com.example.android.madridguide;

/**
 * Creates a Location object which contains information about a specific site.
 */

public class Location {

    private String mName;
    private String mAddress;
    private int mImageId;
    private int mStarRating = NO_RATING_PROVIDED;
    private String mTypeOfRestaurant = NO_STRING_PROVIDED;
    private String mMuseumTopic = NO_STRING_PROVIDED;

    private static final int NO_RATING_PROVIDED = -1;
    private static final String NO_STRING_PROVIDED = "";

    /**
     * Public constructor that creates an object by receiving three arguments.
     *
     * @param name is the name of the site.
     * @param address is the location of the site.
     * @param imageId refers to the ID of the image that should be related to this object.
     */
    public Location (String name, String address, int imageId){
        mName = name;
        mAddress = address;
        mImageId = imageId;
    }

    /**
     * Public constructor that creates a Location object by receiving four arguments.
     * @param name is the name of the museum.
     * @param address is the location of the museum.
     * @param imageId refers to the ID of the image that should be related to this object.
     * @param museumTopic refers to the content of the museum.
     */
    public Location(String name, String address, int imageId, String museumTopic) {
        mName = name;
        mAddress = address;
        mImageId = imageId;
        mMuseumTopic = museumTopic;
    }

    /**
     * Public constructor that creates a Location object by receiving five arguments.
     *
     * @param name is the name of the restaurant.
     * @param address is the location of the site.
     * @param imageId refers to the ID of the image that should be related to this object.
     * @param starRating is the number of stars that the restaurant has based on user's feedback.
     * @param typeOfRestaurant refers to the type of food served at the restaurant.
     */
    public Location(String name, String address, int imageId, String typeOfRestaurant, int starRating) {
        mName = name;
        mAddress = address;
        mImageId = imageId;
        mStarRating = starRating;
        mTypeOfRestaurant = typeOfRestaurant;
    }

    /** @return the name of the site */
    public String getName(){ return mName; }

    /** @return the address of the site */
    public String getAddress(){ return mAddress; }

    /** @return the ID of the image associated with the site */
    public int getImageId(){ return mImageId; }

    /** @return the star rating of the restaurant */
    public int getStarRating(){ return mStarRating; }

    /** @return what type of restaurant it is */
    public String getTypeOfRestaurant(){ return mTypeOfRestaurant; }

    /** @return the topic of the museum */
    public String getMuseumTopic(){ return mMuseumTopic; }

    /** @return if the object has a Star Rating variable declared */
    public Boolean hasStarRating() { return mStarRating != NO_RATING_PROVIDED; }

    /** @return if the object has a Type of Restaurant variable declared */
    public Boolean hasTypeOfRestaurant() { return mTypeOfRestaurant != NO_STRING_PROVIDED; }

    /** @return if the object has a Museum Topic variable declared */
    public Boolean hasMuseumTopic() { return mMuseumTopic != NO_STRING_PROVIDED; }

}
