package com.github.metalloid.logging;

public class Logger {
    private String className;
    private Boolean debug;

    private enum Type {
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }

    public Logger(Object clazz) {
        this.className = clazz.getClass().getSimpleName();
        this.debug = Boolean.parseBoolean(System.getProperty("metalloid.debug"));
    }

    public Logger(Class<?> clazz) {
        this.className.getClass().getSimpleName();
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
        if (debug) {
            System.out.println(String.format("%s: [%s][%s]", type, className, message.toString()));
        }
    }
}
