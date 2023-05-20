package org.example.leetcode150;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/car-fleet/
 * There are n cars going to the same destination along a one-lane road. The destination is target miles away.
 * You are given two integer array position and speed, both of length n,
 * where position[i] is the position of the ith car and speed[i] is the speed of the ith car (in miles per hour).
 * A car can never pass another car ahead of it, but it can catch up to it and drive bumper to bumper at the same speed.
 * The faster car will slow down to match the slower car's speed.
 * The distance between these two cars is ignored (i.e., they are assumed to have the same position).
 *
 *  A car fleet is some non-empty set of cars driving at the same position and same speed. Note that a single car is also a car fleet.
 * If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.
 * Return the number of car fleets that will arrive at the destination.
 *
 * Example 1:
 * Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
 * Output: 3
 * Explanation:
 * The cars starting at 10 (speed 2) and 8 (speed 4) become a fleet, meeting each other at 12.
 * The car starting at 0 does not catch up to any other car, so it is a fleet by itself.
 * The cars starting at 5 (speed 1) and 3 (speed 3) become a fleet, meeting each other at 6. The fleet moves at speed 1 until it reaches target.
 * Note that no other cars meet these fleets before the destination, so the answer is 3.
 */
public class CarFleet {

    public static void main(String[] args) {
        int target = 12;
        int position[] = new int[] {10,8,0,5,3};
        int speed[] = new int[]{2,4,1,1,3};
        int fleets = carFleet(target, position, speed);
        System.out.println("Fleets :" + fleets);
    }


    static record Car(int pos, int speed){}
    public static int carFleet(int target, int[] position, int[] speed) {
        int N = speed.length;
        Car[] cars = new Car[N];
        for(int i=0; i<N; i++) {
            cars[i] = new Car(position[i], speed[i]);
        }
        Arrays.sort(cars, Comparator.comparingInt(Car::pos));

        LinkedList<Car> list = new LinkedList<>();
        list.offerLast(cars[N-1]);
        for(int i= N-2; i>=0; i--) {
            double time1 = (target - cars[i].pos())*1.0/cars[i].speed();
            Car car = list.peekLast();
            double time2 = (target - car.pos())*1.0 / car.speed();
            if(time2 < time1) {
                list.offerLast(cars[i]);
            }
        }
        return list.size();
    }
}
