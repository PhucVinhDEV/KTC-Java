package com.example.WareHouseSpringBoot.Utils;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ConvertIterator {
    public static <T> Set<T> convertIteratorToSet(Iterator<T> iterator) {
        return StreamSupport.stream(
                        ((Iterable<T>) () -> iterator).spliterator(), false)
                .collect(Collectors.toSet());
    }
    public static <T> List<T> convertIteratorToList(Iterator<T> iterator) {
        return StreamSupport.stream(
                        ((Iterable<T>) () -> iterator).spliterator(), false)
                .collect(Collectors.toList());
    }
}
