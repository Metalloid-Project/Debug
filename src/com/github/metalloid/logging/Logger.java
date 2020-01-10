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
        this.className = clazz.getSimpleName();
    }

    public void info(Object message, Object... formatArguments) {
        log(Type.INFO, message, formatArguments);
    }

    public void warning(Object message, Object... formatArguments) {
        log(Type.WARNING, message, formatArguments);
    }

    public void error(Object message, Object... formatArguments) {
        log(Type.ERROR, message, formatArguments);
    }

    public void debug(Object message, Object... formatArguments) {
        log(Type.DEBUG, message, formatArguments);
    }

    private void log(Type type, Object message, Object... arguments) {
        if (debug) {
            String formattedMessage = String.format(message.toString(), arguments);
            System.out.println(String.format("%s: [%s][%s]", type, className, formattedMessage));
        }
    }
}
