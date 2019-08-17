package com.company.algoritms;
import com.company.algoritms.examples.ExampleCollection;

public class AlgorithmUtils {
    AlgorithmUtils() {

    }

    public static void fillCollectionWithRandomNumbers(ExampleCollection<Long> collection, long stop){
        for(long startIndex = 0; startIndex < stop; startIndex++) {
            collection.insert((long) (Math.random() * 100));
        }
    }
}
