package ua.edu.ucu;

import java.util.Arrays;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

public class SmartArrayApp {

    public static Integer[]
    filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {

        MyPredicate pr = t -> ((Integer) t) > 0;

        MyComparator cmp = (o1, o2) -> ((Integer) o1) - ((Integer) o2);

        MyFunction func = t -> 2 * ((Integer) t);

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);

        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
    findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(
            Student[] students) {
        int MAGIC_NUMBER = 4;

        MyPredicate predicateSecYearGPA =
                t -> ((Student) t).getYear() == 2 &&
                        ((Student) t).getGPA() >= MAGIC_NUMBER;
        MyFunction getStudentName =
                t -> ((Student) t).getSurname() + " " +
                        ((Student) t).getName();
        MyComparator compareBySurname =
                (o1, o2) -> ((Student) o1).getSurname().compareTo(((Student)
                        o2).getSurname());

        SmartArray studentArray = new BaseArray(students);
        studentArray = new MapDecorator(
                new SortDecorator(
                        new FilterDecorator(
                                new DistinctDecorator(studentArray),
                                predicateSecYearGPA),
                        compareBySurname),
                getStudentName);

        return Arrays.copyOf(studentArray.toArray(), studentArray.size(),
                String[].class);
    }
}
