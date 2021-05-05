package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiffumArray {

    public static void main(String[] args) {
        int[][] array = new int[3][2];
        array[0] = new int[]{1, 3};
        array[1] = new int[]{2, 4};
        array[2] = new int[]{8, 10};
        int n = array.length;
        int first = 0;
        int second = 1;
        int[][] newArrays = new int[3][2];

        DiffumArray diffumArray = new DiffumArray();
        ;
        List<Interval> intervals = diffumArray.merge(diffumArray.getData());
        System.out.println(intervals);



    }

    public List<Interval> getData(){
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(2,4));
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(5,10));
        return intervals;
    }

    public class Interval{
        private int start;
        private int end;

        Interval(){}

        Interval(int a,int b){
            start = a;
            end = b;
        }

    }



    public List<Interval> merge(List<Interval> intervals) {
        int n=intervals.size();
        int[] starts=new int[n];
        int[] ends=new int[n];
        for(int i=0;i<n;i++){
            starts[i]=intervals.get(i).start;
            ends[i]=intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        List<Interval> res=new ArrayList<Interval>();
        for(int i=0,j=0;i<n;i++){
            if(i==n-1||starts[i+1]>ends[i]){
                res.add(new Interval(starts[j],ends[i]));
                j=i+1;
            }
        }
        return res;
    }

}
