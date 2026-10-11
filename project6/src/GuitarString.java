// File name: GuitarString.java
// Author: Marwan El-Gabry
// userid: elgabrmw
// Email: marwan.w.el-gabry@vanderbilt.edu
// Class: CS2201
// Assignment Number: #6
// Honor Statement: I attest that I have neither given nor received unauthorized aid concerning
// this homework. I further acknowledge that the instructors are the copyright owners of this HW.
// Description: Simulates a vibrating guitar string of a given frequency
// Last Changed: 10/27/2025
//

import java.util.Random;

public class GuitarString {

    // Do not change or delete these two public constants
    public static final int SAMPLE_RATE = 44100;
    public static final double DECAY_FACTOR = 0.996;

    private final double frequency;
    private final double N;
    private DblQueue ringBuffer;
    private int tics;

    /**
     * The constructor for a string of the given frequency.
     * pre: Frequency is in range of human hearing
     * post: GuitarString is constructed. Throws an IllegalArgumentException
     *       exception if the frequency is not positive.
     */
    public GuitarString(double frequency) {
        if (frequency <= 0) {
            throw new IllegalArgumentException("Frequency must be positive.");
        }

        this.frequency = frequency;

        N = Math.round(SAMPLE_RATE / frequency);

        ringBuffer = new DblQueue();

        for (int i = 0; i < N; i++) {
            ringBuffer.enqueue(0);
        }

        tics = 0;
    }


    /**
     * pluck
     * Fill the string’s buffer with white noise.
     * pre: GuitarString exists
     * post: N elements in the ring buffer have been replaced
     *       with N random values between -0.5 and +0.5
     */
    public void pluck() {
        Random rand = new Random();

        for (int i = 0; i < N; i++) {
            ringBuffer.dequeue();
            ringBuffer.enqueue(rand.nextDouble() - 0.5);
        }
    }


    /**
     * tic
     * Advance the simulation one time step.
     * pre: GuitarString exists
     * post: Apply the Karplus-Strong update: delete the sample at the front of the buffer
     *       and add to the end of the buffer the
     *       average of the deleted sample & the next sample, multiplied by the energy decay
     *       factor.
     */
    public void tic() {
        double frontValue = sample();

        ringBuffer.dequeue();

        double nextValue = sample();

        ringBuffer.enqueue(DECAY_FACTOR * ((frontValue + nextValue) / 2));

        tics++;
    }


    /**
     * sample
     * Return the current sample.
     * pre: GuitarString exists
     * post: Return the value of the item at the front of the buffer.
     */
    public double sample() {
        return ringBuffer.front();
    }


    /**
     * getTime
     * Return number of tics that have been performed.
     * pre: GuitarString exists
     * post: Return the total number of times tic() was called since the object was created.
     */
    public int getTime() {
        return tics;
    }


    /**
     * getFrequency
     * Return the frequency of the string
     * pre: GuitarString exists
     * post: Return the frequency that was specified in the constructor.
     */
    public double getFrequency() {
        return frequency;
    }


    /**
     * clone
     * Return a clone of the current GuitarString object
     * pre: GuitarString exists
     * post: Return a copy of the current GuitarString object.
     */
    public GuitarString clone() {
        GuitarString guitarClone = new GuitarString(getFrequency());

        guitarClone.ringBuffer = ringBuffer.clone();
        guitarClone.tics = getTime();

        return guitarClone;
    }


    /**
     * equals
     * Determine the equality of two GuitarString objects
     * @param other -- The object to compare
     * @return true if the two GuitarStrings are equivalent (same frequency and same time)
     */
    public boolean equals(Object other) {
        if (!(other instanceof GuitarString guitar)) {
            return false;
        }

        return (getFrequency() == guitar.getFrequency()) && (getTime() == guitar.getTime());
    }
}
