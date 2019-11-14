package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    private MyFunction function;

    public MapDecorator(SmartArray smartArray, MyFunction function) {
        super(smartArray);
        this.function = function;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[smartArray.size()];
        for (int i = 0; i < smartArray.size(); i++) {
            result[i] = function.apply(smartArray.toArray()[i]);
        }
        return result;
    }

    @Override
    public String operationDescription() {
        return "Map Decorator, maps every element to another object using MyFunction";
    }

    @Override
    public int size() {
        return toArray().length;
    }
}
