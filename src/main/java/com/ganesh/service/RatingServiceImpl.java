package com.ganesh.service;

import com.ganesh.bean.Rating;
import com.ganesh.persistence.RatingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RatingServiceImpl implements RatingService {
    private RatingDao ratingDao;

    @Autowired
    public void setRatingDao(RatingDao ratingDao) {
        this.ratingDao = ratingDao;
    }

    @Override
    public Collection<Rating> getAllRatings() {
        return ratingDao.findAll();
    }

    @Override
    public Rating insertRating(Rating rating) {
        return ratingDao.save(rating);
    }

    @Override
    public Rating getRatingById(int id) {
        return ratingDao.getById(id);
    }

    @Override
    public Rating deleteRatingById(int id) {
        Rating rating = ratingDao.getById(id);
        ratingDao.deleteById(id);
        return rating;
    }

    @Override
    public Rating updateRating(int id, int rating) {
        int rows = ratingDao.updateRating(id,rating);
        if(rows > 0) return ratingDao.getById(id);
        return null;
    }

    @Override
    public Collection<Rating> getRatingByUserId(int id) {
        return ratingDao.getRatingByUserId(id);
    }
}
