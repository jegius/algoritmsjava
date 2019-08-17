package com.company.algoritms.examples.hashmap;

import com.company.algoritms.AlgorithmUtils;
import com.company.algoritms.enums.ExampleType;
import com.company.algoritms.examples.Example;
import com.company.algoritms.examples.hashmap.simplehashchain.HashTable;
import com.company.algoritms.examples.hashmap.simplehashchain.Link;

public class HashMapExample implements Example {
    private ExampleType type;

    public HashMapExample(ExampleType type) {
        this.type = type;
    }

    @Override
    public void showExample() {
//        showSimpleHashMap();
        showChainHashMap();
    }

    private void showChainHashMap() {
        HashTable simpleHashTable = new HashTable(30);
        AlgorithmUtils.fillCollectionWithRandomNumbers(simpleHashTable, 22);

        simpleHashTable.insert(123L);
        simpleHashTable.display();

        System.out.println(simpleHashTable.find(123L));

        simpleHashTable.delete(123L);
        simpleHashTable.display();
    }

    private void showSimpleHashMap() {
        SimpleHashMap simpleHashMap = new SimpleHashDoubleMap(30L);
        AlgorithmUtils.fillCollectionWithRandomNumbers(simpleHashMap, 22);

        simpleHashMap.insert(123L);
        simpleHashMap.display();

        System.out.println(simpleHashMap.find(123L));

        simpleHashMap.delete(123L);
        simpleHashMap.display();
    }

    @Override
    public ExampleType getType() {
        return type;
    }
}
