package com.company.algoritms;

import com.company.algoritms.examples.ExampleCollection;

import java.util.Random;

public class AlgorithmUtils {
    AlgorithmUtils() {

    }

    public static void fillCollectionWithRandomNumbers(ExampleCollection collection, long stop){
        Random random = new Random();
        for(long startIndex = 0; startIndex < stop; startIndex++) {
            collection.insert(random.nextLong());
        }
    }
}
