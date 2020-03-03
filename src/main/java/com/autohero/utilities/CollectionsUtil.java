package com.autohero.utilities;

import java.util.List;
import java.util.ListIterator;

public class CollectionsUtil {
    public static <T extends Comparable<? super T>> boolean isSorted(List<T> list) {
        if (list.size() != 0) {
            ListIterator<T> it = list.listIterator();
            for (it.next(); it.hasNext(); it.next()) {
                if (it.hasPrevious() && it.previous().compareTo(it.next()) > 0) {
                    return false;
                }
            }

        }
        return true;
    }
}
