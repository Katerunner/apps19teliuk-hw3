package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.ArrayList;
import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    private MyComparator comparator;

    public SortDecorator(SmartArray smartArray, MyComparator comparator) {
        super(smartArray);
        this.comparator = comparator;
    }

    @Override
    public Object[] toArray() {
        ArrayList<Object> preResult =
                new ArrayList<>(Arrays.asList(smartArray.toArray()));
        preResult.sort(comparator);
        return preResult.toArray();
    }

    @Override
    public String operationDescription() {
        return "Sort Decorator, " +
                "sorts elements using MyComparator to compare them";
    }

    @Override
    public int size() {
        return toArray().length;
    }
}
