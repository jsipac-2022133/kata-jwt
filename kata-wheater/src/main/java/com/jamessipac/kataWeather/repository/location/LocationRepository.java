package com.jamessipac.kataWeather.repository.location;

import com.jamessipac.kataWeather.model.Location;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationRepository extends MongoRepository<Location, String> {
}
