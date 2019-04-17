package com.leetcode.middle.sort;

import com.leetcode.leetcodeutils.PrintUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author BaoZhou
 * @date 2019/4/9
 */
public class Merge {
    @Test
    void test() {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 3));
        list.add(new Interval(2, 6));
        list.add(new Interval(8, 10));
        list.add(new Interval(15, 18));
        merge(list);
        System.out.println(merge(list).toString());
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        intervals.sort(Comparator.comparingInt(i -> i.start));
        int start;
        for (int i = 0; i < intervals.size()-1; i++) {
            start = intervals.get(i).start;
            while (i < intervals.size() - 1 && intervals.get(i).end >= intervals.get(i + 1).start) {
                i++;
            }
            result.add(new Interval(start, Math.max(intervals.get(i).end,intervals.get(i+1).end)));
        }
        return result;
    }
}
