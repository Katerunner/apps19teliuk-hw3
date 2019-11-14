package ua.edu.ucu.smartarr;


import java.util.LinkedList;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {
//    private Set<Object> set =
//    new HashSet<>(Arrays.asList(smartArray.toArray()));

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
    }

    @Override
    public Object[] toArray() {
        LinkedList<Object> preResult = new LinkedList<>();
        for (int i = 0; i < smartArray.size(); i++) {
            Object el = smartArray.toArray()[i];
            boolean doInsertion = true;
            for (int j = 0; j < preResult.size(); j++) {
                if (preResult.get(j).toString().equals(el.toString())) {
                    doInsertion = false;
                    break;
                }
            }
            if (doInsertion) {
                preResult.add(el);
            }
        }
        return preResult.toArray();
    }

    @Override
    public String operationDescription() {
        return "Distinct Decorator, removes duplicates";
    }

    @Override
    public int size() {
        return toArray().length;
    }
}
