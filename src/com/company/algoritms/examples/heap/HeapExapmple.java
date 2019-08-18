package com.company.algoritms.examples.heap;

import com.company.algoritms.AlgorithmUtils;
import com.company.algoritms.enums.ExampleType;
import com.company.algoritms.examples.Example;

public class HeapExapmple implements Example {

    private final ExampleType type;

    public HeapExapmple(ExampleType type) {
        this.type = type;
    }

    @Override
    public void showExample() {
        Heap heap = new Heap(22);
        AlgorithmUtils.fillCollectionWithRandomNumbers(heap, 22);

        heap.insert(12, 33L);

        heap.display();

        System.out.println();
        System.out.println("========================");
        System.out.println(heap.remove().getKey());
        System.out.println(heap.remove().getKey());
        System.out.println(heap.remove().getKey());
        System.out.println(heap.remove().getKey());
        System.out.println(heap.remove().getKey());
        System.out.println(heap.remove().getKey());
        System.out.println(heap.remove().getKey());
        System.out.println(heap.remove().getKey());
        System.out.println(heap.remove().getKey());
        System.out.println("========================");

        heap.display();
    }

    @Override
    public ExampleType getType() {
        return type;
    }
}
