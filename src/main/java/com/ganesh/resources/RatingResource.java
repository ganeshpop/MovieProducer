package com.ganesh.resources;


import com.ganesh.bean.Rating;
import com.ganesh.bean.User;
import com.ganesh.service.RatingService;
import com.ganesh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "/ratings")
public class RatingResource {

    private RatingService ratingService;

    @Autowired
    public void setUserService(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @Autowired

    @GetMapping(produces = "Application/json")
    Collection<Rating> findAllRatings() {
        return ratingService.getAllRatings();
    }

    @GetMapping(path = "/{id}", produces = "Application/json")
    Rating getRatingById(@PathVariable("id") int id) {
        return ratingService.getRatingById(id);
    }


    @GetMapping(path = "/xml/{id}", produces = "Application/xml")
    public Rating getXmlRatingById(@PathVariable("id") int id) {
        return ratingService.getRatingById(id);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "Application/json", consumes = "Application/json")
    Rating saveRating(@RequestBody Rating rating ) {
        return ratingService.insertRating(rating);
    }


    @RequestMapping(path = "/{id}/{rating}", method = RequestMethod.PUT, produces = "Application/json", consumes = "Application/json")
    Rating updateRating(@PathVariable("id") int id, @PathVariable("rating") int rating) {
        return ratingService.updateRating(id, rating);
    }

    @GetMapping(path = "/users/{id}",produces = "Application/json")
    Collection<Rating> getRatingByUserId(@PathVariable("id") int id) {
        return ratingService.getRatingByUserId(id);
    }


    @DeleteMapping(path = "/{id}", produces = "Application/json", consumes = "Application/json")
    Rating deleteRating(@PathVariable("id") int id) {
        return ratingService.deleteRatingById(id);
    }
}