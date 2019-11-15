package ua.edu.ucu;

import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

import static org.junit.Assert.assertEquals;

public class DecoratorsTest {
    private MyPredicate pr;
    private MyComparator cmp;
    private MyFunction func;

    @Before
    public void setUp() {
        pr = t -> ((Integer) t) > 0;
        cmp = (o1, o2) -> ((Integer) o1) - ((Integer) o2);
        func = t -> 2 * ((Integer) t);
    }

    @Test
    public void distinctDecoratorSizeTest() {
        Object[] numbers = {1, 2, 3, 65, -2};
        SmartArray ba = new BaseArray(numbers);
        FilterDecorator fd = new FilterDecorator(ba, pr);
        assertEquals(4, fd.size());
    }

    @Test
    public void testDescription() {
        Object[] numbers = {1, 2, 3, 65, -2};
        BaseArray ba = new BaseArray(numbers);
        DistinctDecorator dd = new DistinctDecorator(ba);
        FilterDecorator fd = new FilterDecorator(ba, pr);
        SortDecorator sd = new SortDecorator(ba, cmp);
        MapDecorator md = new MapDecorator(ba, func);

        assertEquals("Base array", ba.operationDescription());
        assertEquals("Distinct Decorator, removes duplicates",
                dd.operationDescription());
        assertEquals("Filter Decorator, tests every" +
                        " element and removes it " +
                        "if it doesn't satisfy MyPredicate",
                fd.operationDescription());
        assertEquals("Sort Decorator, " +
                        "sorts elements using MyComparator to compare them",
                sd.operationDescription());
        assertEquals("Map Decorator, maps every element to another" +
                        " object using MyFunction",
                md.operationDescription());


    }
}
