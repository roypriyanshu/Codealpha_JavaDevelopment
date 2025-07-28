import java.util.*;
class Student
{
    String name;
    ArrayList<Integer> marks;

    Student(String name)
    {
        this.name = name;
        this.marks = new ArrayList<>();
    }

    void addMark(int mark)
    {
        marks.add(mark);
    }

    double getAverage()
    {
        if (marks.isEmpty()) return 0;
        int sum = 0;
        for (int mark : marks) sum += mark;
        return (double) sum / marks.size();
    }

    int getHighest()
    {
        int max = Integer.MIN_VALUE;
        for (int mark : marks) if (mark > max) max = mark;
        return max;
    }

    int getLowest()
    {
        int min = Integer.MAX_VALUE;
        for (int mark : marks) if (mark < min) min = mark;
        return min;
    }
}