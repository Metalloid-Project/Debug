package com.github.metalloid.logging;

public class Logger {
    private Object clazz;

    private enum Type {
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }

    public Logger(Object clazz) {
        this.clazz = clazz;
    }

    public void info(Object message) {
        log(Type.INFO, message);
    }

    public void warning(Object message) {
        log(Type.WARNING, message);
    }

    public void error(Object message) {
        log(Type.ERROR, message);
    }

    public void debug(Object message) {
        log(Type.DEBUG, message);
    }

    private void log(Type type, Object message) {
        System.out.println(String.format("%s: [%s][%s]", type, clazz.getClass().getSimpleName(), message.toString()));
    }
}
