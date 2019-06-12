package com.company.algoritms.examples.queue;

import com.company.algoritms.examples.ExampleCollection;

public interface ExampleQueue<T> extends ExampleCollection<T> {
    T remove();
    boolean isEmpty();
}
