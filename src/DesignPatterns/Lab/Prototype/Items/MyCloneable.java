package DesignPatterns.Lab.Prototype.Items;

public interface MyCloneable<T> {

    T clone() throws CloneNotSupportedException;
}