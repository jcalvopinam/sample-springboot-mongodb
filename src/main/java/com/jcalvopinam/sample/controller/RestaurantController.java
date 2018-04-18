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

package com.jcalvopinam.sample.controller;

import com.jcalvopinam.sample.domain.Restaurant;
import com.jcalvopinam.sample.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping
    public List<Restaurant> getAll() {
        return this.restaurantRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Restaurant> getById(@PathVariable String id){
        return this.restaurantRepository.findById(id);
    }

    @PostMapping
    public void insert(@RequestBody Restaurant restaurant) {
        this.restaurantRepository.insert(restaurant);
    }

    @PutMapping
    public void update(@RequestBody Restaurant restaurant) {
        this.restaurantRepository.save(restaurant);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        this.restaurantRepository.deleteById(id);
    }

    @GetMapping("/price/{maxPrice}")
    public List<Restaurant> getByPrice(@PathVariable int maxPrice) {
        return this.restaurantRepository.findByPricePerDinnerLessThan(maxPrice);
    }

    @GetMapping("/address/{city}")
    public List<Restaurant> getByCity(@PathVariable String city) {
        return this.restaurantRepository.findRestaurantsByAddress_City(city);
    }

}
