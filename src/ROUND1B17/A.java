package ROUND1B17;

import APAC2015E.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 22/04/17
 **/
public class A {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int tc = in.readInt();
            for (int t = 1; t <= tc; t++) {
                long d = in.readLong();
                int n = in.readInt();
                List<DistanceSpeed> distanceSpeeds = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    double distance = (double) in.readLong();
                    long speed = in.readLong();
                    distanceSpeeds.add(new DistanceSpeed(distance, speed));
                }
                Collections.sort(distanceSpeeds);
                double totalTimeLastHorse = 0.0d;
                DistanceSpeed lastHorse = distanceSpeeds.get(0);
                for (int i = 1; i < distanceSpeeds.size(); i++) {
                    DistanceSpeed horseBefore = distanceSpeeds.get(i);
                    if (lastHorse.speed <= horseBefore.speed) {
                        continue;
                    }
                    if (lastHorse.distance > horseBefore.distance && lastHorse.speed >= horseBefore.speed) {

                    }
                    horseBefore.distance += horseBefore.speed * totalTimeLastHorse;
                    double thistime = (horseBefore.distance - lastHorse.distance) / (lastHorse.speed - horseBefore.speed);
                    totalTimeLastHorse += thistime;
                    lastHorse.distance = lastHorse.distance + (thistime * lastHorse.speed);
                    lastHorse.speed = horseBefore.speed;
                }
                totalTimeLastHorse += ((d - lastHorse.distance) / lastHorse.speed);
                double ans = (double)d / totalTimeLastHorse;
                System.out.printf("Case #"+t+": %.9f", ans);
                System.out.println();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class DistanceSpeed implements Comparable<DistanceSpeed>{
    double distance;
    long speed;
    public DistanceSpeed(double distance, long speed) {
        this.distance = distance;
        this.speed = speed;
    }
    public int compareTo(DistanceSpeed distanceSpeed) {
        if (this.distance - distanceSpeed.distance >= (1e-9)) {
            return 1;
        }
        else if (this.distance - distanceSpeed.distance <= 1e-9) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
