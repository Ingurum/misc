/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salaboy.monkey.vs.bananas.extra;

/**
 *
 * @author salaboy
 */
public class ChangeValue {
    private Object instance;
    private String className;
    private String field;
    private String operator;
    private String value;

    public ChangeValue(Object instance, String className, String field, String operator, String value) {
        this.instance = instance;
        this.className = className;
        this.field = field;
        this.operator = operator;
        this.value = value;
    }

    
    public ChangeValue() {
    }

    public Object getInstance() {
        return instance;
    }

    public void setInstance(Object instance) {
        this.instance = instance;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ChangeValue{" + "instance=" + instance + ", className=" + className + ", field=" + field + ", operator=" + operator + ", value=" + value + '}';
    }
    
    
    
    
}
