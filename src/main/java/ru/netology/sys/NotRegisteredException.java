package ru.netology.sys;

public class NotRegisteredException extends RuntimeException {
  public NotRegisteredException(String msg) {
    super(msg);
  }
}
