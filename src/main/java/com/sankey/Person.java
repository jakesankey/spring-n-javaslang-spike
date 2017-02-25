package com.sankey;

class Person {
    private String first;
    private String last;
    private Integer age;

    public Person(String first, String last, Integer age) {
        this.first = first;
        this.last = last;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return first + " " + last;
    }
}
