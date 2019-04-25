package com.holger.hdoj;

import java.util.*;

public class P1004 {
    public static void main(String[] args) {
        //此题采用的是利用Collection的排序功能实现自动排序，代码较为简洁但是消耗资源较多
        Scanner sc = new Scanner(System.in);
        int n;
        Data data;
        while ((n = Integer.parseInt(sc.nextLine())) != 0) {
            List<Data> colors = new ArrayList<Data>();
            for (int i = 0; i < n; i++) {
                data = new Data(sc.nextLine());
                if (colors.indexOf(data) != -1) {
                    colors.get(colors.indexOf(data)).addColor();
                } else {
                    data.setCount(1);
                    colors.add(data);
                }
            }
            Collections.sort(colors);
            System.out.println(colors.get(0).getColor());
        }
    }

}

class Data implements Comparable<Data> {
    private String color;
    private Integer count;

    public Data(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void addColor() {
        this.count++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Data data = (Data) o;

        return color != null ? color.equals(data.color) : data.color == null;
    }

    @Override
    public int hashCode() {
        return color != null ? color.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "[ color = " + color + " count = " + count + "]";
    }

    @Override
    public int compareTo(Data o) {
        return o.getCount().compareTo(this.count);
    }
}

