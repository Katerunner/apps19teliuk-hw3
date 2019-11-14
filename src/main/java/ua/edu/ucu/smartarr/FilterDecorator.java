package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.LinkedList;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private MyPredicate predicate;

    public FilterDecorator(SmartArray smartArray, MyPredicate predicate) {
        super(smartArray);
        this.predicate = predicate;
    }

    @Override
    public Object[] toArray() {
        LinkedList<Object> preResult = new LinkedList<>();
        for (int i = 0; i < smartArray.size(); i++) {
            Object el = smartArray.toArray()[i];
            if (predicate.test(el)) {
                preResult.add(el);
            }
        }
        return preResult.toArray();
    }

    @Override
    public String operationDescription() {
        return "Filter Decorator, tests every element and removes it " +
                "if it doesn't satisfy MyPredicate";
    }

    @Override
    public int size() {
        return toArray().length;
    }
}
