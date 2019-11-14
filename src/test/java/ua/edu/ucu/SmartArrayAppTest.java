package ua.edu.ucu;

import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

import static org.junit.Assert.*;

/**
 * @author Andrii_Rodionov
 */
public class SmartArrayAppTest {
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
    public void testFilterPositiveIntegersSortAndMultiplyBy2() {
        Integer[] integers = {-1, 2, 0, 1, -5, 3};

        Integer[] res =
                SmartArrayApp.filterPositiveIntegersSortAndMultiplyBy2(integers);
        Integer[] expectedRes = {2, 4, 6};

        assertArrayEquals(expectedRes, res);
    }

    @Test
    public void testFindDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname() {
        Student[] students = {
                new Student("Ivar", "Grimstad", 3.9, 2),
                new Student("Ittai", "Zeidman", 4.5, 1),
                new Student("Antons", "Kranga", 4.0, 2),
                new Student("Burr", "Sutter", 4.2, 2),
                new Student("Philipp", "Krenn", 4.3, 3),
                new Student("Tomasz", "Borek", 4.1, 2),
                new Student("Ittai", "Zeidman", 4.5, 1),
                new Student("Burr", "Sutter", 4.2, 2)};
        String[] studentNames =
                SmartArrayApp.findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(students);
        String[] expectedStudentNames = {"Borek Tomasz", "Kranga Antons", "Sutter Burr"};
        assertArrayEquals(expectedStudentNames, studentNames);

    }

    @Test
    public void testSmartArrayApp() {
        SmartArrayApp sma = new SmartArrayApp();
        assertEquals("ua.edu.ucu.SmartArrayApp", sma.getClass().getName());
    }

    @Test
    public void testDescription() {
        BaseArray ba = new BaseArray(new Object[0]);
        DistinctDecorator dd = new DistinctDecorator(ba);
        FilterDecorator fd = new FilterDecorator(ba, pr);
        SortDecorator sd = new SortDecorator(ba, cmp);
        MapDecorator md = new MapDecorator(ba, func);


        assertEquals("Base array", ba.operationDescription());
        assertEquals("Distinct Decorator, removes duplicates",
                dd.operationDescription());
        assertEquals("Filter Decorator, tests every element and removes it " +
                "if it doesn't satisfy MyPredicate", fd.operationDescription());
        assertEquals("Sort Decorator, " +
                        "sorts elements using MyComparator to compare them",
                sd.operationDescription());
        assertEquals("Map Decorator, maps every element to another object using MyFunction",
                md.operationDescription());


    }

}