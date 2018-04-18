/*
 * MIT License
 *
 * Copyright (c) 2018 JUAN CALVOPINA M
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.jcalvopinam.sample;

import com.jcalvopinam.sample.domain.Address;
import com.jcalvopinam.sample.domain.Restaurant;
import com.jcalvopinam.sample.domain.Review;
import com.jcalvopinam.sample.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public void run(String... args) {

        this.restaurantRepository.deleteAll();

        Restaurant caribbean = new Restaurant("Caribbean", 150,
                new Address("Paris", "Samar 214"),
                Arrays.asList(new Review("Matt", 8),
                        new Review("Phillip", 7)));

        Restaurant pacific = new Restaurant("Pacific", 130,
                new Address("California", "Tiptop 348 "),
                Arrays.asList(new Review("Alison", 9)));

        Restaurant atlantic = new Restaurant("Atlantic", 90,
                new Address("Madrid", "Andrew 654"),
                Arrays.asList(new Review("John", 7)));

        List<Restaurant> restaurants = Arrays.asList(caribbean, pacific, atlantic);

        this.restaurantRepository.saveAll(restaurants);

    }

}
