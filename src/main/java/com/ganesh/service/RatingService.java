package com.ganesh.service;

import com.ganesh.bean.Rating;

import java.util.Collection;

public interface RatingService {

    Collection<Rating> getAllRatings();
    Rating insertRating(Rating rating);
    Rating getRatingById(int id);
    Rating deleteRatingById(int id);
    Rating updateRating(int id, int rating);
    Collection<Rating> getRatingByUserId(int id);
}
