package ru.netology.sys;

public class AlreadyRegisteredException extends RuntimeException {
  public AlreadyRegisteredException(String msg) {
    super(msg);
  }
}