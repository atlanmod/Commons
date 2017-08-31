/*
 * Copyright (c) 2013-2017 Atlanmod INRIA LINA Mines Nantes.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Atlanmod INRIA LINA Mines Nantes - initial API and implementation
 */

package fr.inria.atlanmod.commons.log;

import fr.inria.atlanmod.commons.annotation.Static;
import fr.inria.atlanmod.commons.cache.Cache;
import fr.inria.atlanmod.commons.cache.CacheBuilder;
import fr.inria.atlanmod.commons.primitive.Strings;

import java.text.MessageFormat;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNullableByDefault;
import javax.annotation.concurrent.ThreadSafe;

import static fr.inria.atlanmod.commons.Preconditions.checkNotNull;

/**
 * The factory that creates {@link Logger} instances.
 * <p>
 * It also provides static methods for logging without declaring a specific instance. In this case, the {@link
 * #rootLogger()} is used by default.
 */
@Static
@ThreadSafe
@ParametersAreNullableByDefault
public final class Log {

    /**
     * In-memory cache that holds loaded {@link Logger}s, identified by their name.
     */
    @Nonnull
    private static final Cache<String, Logger> LOGGERS = CacheBuilder.builder()
            .softValues()
            .build(AsyncLogger::new);

    /**
     * This class should not be instantiated.
     *
     * @throws IllegalStateException every time
     */
    private Log() {
        throw new IllegalStateException("This class should not be instantiated");
    }

    /**
     * Returns the root {@link Logger}.
     *
     * @return the root {@link Logger}
     *
     * @see #customLogger(String)
     */
    @Nonnull
    public static Logger rootLogger() {
        return customLogger(Strings.EMPTY);
    }

    /**
     * Returns a {@link Logger} with the specified name.
     *
     * @param name the logger name
     *
     * @return the {@link Logger}
     */
    @Nonnull
    public static Logger customLogger(@Nonnull String name) {
        return LOGGERS.get(checkNotNull(name));
    }

    /**
     * Logs a message at the {@link Level#TRACE TRACE} level, using the root logger.
     *
     * @param message the message to log
     *
     * @see #rootLogger()
     * @see Logger#trace(CharSequence)
     */
    public static void trace(CharSequence message) {
        rootLogger().trace(message);
    }

    /**
     * Logs a message with parameters at the {@link Level#TRACE TRACE} level, using the root logger.
     *
     * @param message the message to log; the format depends on the {@link MessageFormat}
     * @param params  parameters to the message
     *
     * @see #rootLogger()
     * @see Logger#trace(CharSequence, Object...)
     */
    public static void trace(CharSequence message, Object... params) {
        rootLogger().trace(message, params);
    }

    /**
     * Logs the stack trace of the given {@link Throwable} at the {@link Level#TRACE TRACE} level, using the root
     * logger.
     *
     * @param e the exception to log, including its stack trace
     *
     * @see #rootLogger()
     * @see Logger#trace(Throwable)
     */
    public static void trace(Throwable e) {
        rootLogger().trace(e);
    }

    /**
     * Logs a message at the {@link Level#TRACE TRACE} level including the stack trace of the given {@link Throwable},
     * using the root logger.
     *
     * @param e       the exception to log, including its stack trace
     * @param message the message to log
     *
     * @see #rootLogger()
     * @see Logger#trace(Throwable, CharSequence)
     */
    public static void trace(Throwable e, CharSequence message) {
        rootLogger().trace(e, message);
    }

    /**
     * Logs a message with parameters at the {@link Level#TRACE TRACE} level including the stack trace of the given
     * {@link Throwable}, using the root logger.
     *
     * @param e       the exception to log, including its stack trace
     * @param message the message to log; the format depends on the {@link MessageFormat}
     * @param params  parameters to the message
     *
     * @see #rootLogger()
     * @see Logger#trace(Throwable, CharSequence, Object...)
     */
    public static void trace(Throwable e, CharSequence message, Object... params) {
        rootLogger().trace(e, message, params);
    }

    /**
     * Logs a message at the {@link Level#DEBUG DEBUG} level, using the root logger.
     *
     * @param message the message to log
     *
     * @see #rootLogger()
     * @see Logger#debug(CharSequence)
     */
    public static void debug(CharSequence message) {
        rootLogger().debug(message);
    }

    /**
     * Logs a message with parameters at the {@link Level#DEBUG DEBUG} level, using the root logger.
     *
     * @param message the message to log; the format depends on the {@link MessageFormat}
     * @param params  parameters to the message
     *
     * @see #rootLogger()
     * @see Logger#debug(CharSequence, Object...)
     */
    public static void debug(CharSequence message, Object... params) {
        rootLogger().debug(message, params);
    }

    /**
     * Logs the stack trace of the given {@link Throwable} at the {@link Level#DEBUG DEBUG} level, using the root
     * logger.
     *
     * @param e the exception to log, including its stack trace
     *
     * @see #rootLogger()
     * @see Logger#debug(Throwable)
     */
    public static void debug(Throwable e) {
        rootLogger().debug(e);
    }

    /**
     * Logs a message at the {@link Level#DEBUG DEBUG} level including the stack trace of the given {@link Throwable},
     * using the root logger.
     *
     * @param e       the exception to log, including its stack trace
     * @param message the message to log
     *
     * @see #rootLogger()
     * @see Logger#debug(Throwable, CharSequence)
     */
    public static void debug(Throwable e, CharSequence message) {
        rootLogger().debug(e, message);
    }

    /**
     * Logs a message with parameters at the {@link Level#DEBUG DEBUG} level including the stack trace of the given
     * {@link Throwable}, using the root logger.
     *
     * @param e       the exception to log, including its stack trace
     * @param message the message to log; the format depends on the {@link MessageFormat}
     * @param params  parameters to the message
     *
     * @see #rootLogger()
     * @see Logger#debug(Throwable, CharSequence, Object...)
     */
    public static void debug(Throwable e, CharSequence message, Object... params) {
        rootLogger().debug(e, message, params);
    }

    /**
     * Logs a message at the {@link Level#INFO INFO} level, using the root logger.
     *
     * @param message the message to log
     *
     * @see #rootLogger()
     * @see Logger#info(CharSequence)
     */
    public static void info(CharSequence message) {
        rootLogger().info(message);
    }

    /**
     * Logs a message with parameters at the {@link Level#INFO INFO} level, using the root logger.
     *
     * @param message the message to log; the format depends on the {@link MessageFormat}
     * @param params  parameters to the message
     *
     * @see #rootLogger()
     * @see Logger#info(CharSequence, Object...)
     */
    public static void info(CharSequence message, Object... params) {
        rootLogger().info(message, params);
    }

    /**
     * Logs the stack trace of the given {@link Throwable} at the {@link Level#INFO INFO} level, using the root logger.
     *
     * @param e the exception to log, including its stack trace
     *
     * @see #rootLogger()
     * @see Logger#info(Throwable)
     */
    public static void info(Throwable e) {
        rootLogger().info(e);
    }

    /**
     * Logs a message at the {@link Level#INFO INFO} level including the stack trace of the given {@link Throwable},
     * using the root logger.
     *
     * @param e       the exception to log, including its stack trace
     * @param message the message to log
     *
     * @see #rootLogger()
     * @see Logger#info(Throwable, CharSequence)
     */
    public static void info(Throwable e, CharSequence message) {
        rootLogger().info(e, message);
    }

    /**
     * Logs a message with parameters at the {@link Level#INFO INFO} level including the stack trace of the given {@link
     * Throwable}, using the root logger.
     *
     * @param e       the exception to log, including its stack trace
     * @param message the message to log; the format depends on the {@link MessageFormat}
     * @param params  parameters to the message
     *
     * @see #rootLogger()
     * @see Logger#info(Throwable, CharSequence, Object...)
     */
    public static void info(Throwable e, CharSequence message, Object... params) {
        rootLogger().info(e, message, params);
    }

    /**
     * Logs a message at the {@link Level#WARN WARN} level, using the root logger.
     *
     * @param message the message to log
     *
     * @see #rootLogger()
     * @see Logger#warn(CharSequence)
     */
    public static void warn(CharSequence message) {
        rootLogger().warn(message);
    }

    /**
     * Logs a message with parameters at the {@link Level#WARN WARN} level, using the root logger.
     *
     * @param message the message to log; the format depends on the {@link MessageFormat}
     * @param params  parameters to the message
     *
     * @see #rootLogger()
     * @see Logger#warn(CharSequence, Object...)
     */
    public static void warn(CharSequence message, Object... params) {
        rootLogger().warn(message, params);
    }

    /**
     * Logs the stack trace of the given {@link Throwable} at the {@link Level#WARN WARN} level, using the root logger.
     *
     * @param e the exception to log, including its stack trace
     *
     * @see #rootLogger()
     * @see Logger#warn(Throwable)
     */
    public static void warn(Throwable e) {
        rootLogger().warn(e);
    }

    /**
     * Logs a message at the {@link Level#WARN WARN} level including the stack trace of the given {@link Throwable},
     * using the root logger.
     *
     * @param e       the exception to log, including its stack trace
     * @param message the message to log
     *
     * @see #rootLogger()
     * @see Logger#warn(Throwable, CharSequence)
     */
    public static void warn(Throwable e, CharSequence message) {
        rootLogger().warn(e, message);
    }

    /**
     * Logs a message with parameters at the {@link Level#WARN WARN} level including the stack trace of the given {@link
     * Throwable}, using the root logger.
     *
     * @param e       the exception to log, including its stack trace
     * @param message the message to log; the format depends on the {@link MessageFormat}
     * @param params  parameters to the message
     *
     * @see #rootLogger()
     * @see Logger#warn(Throwable, CharSequence, Object...)
     */
    public static void warn(Throwable e, CharSequence message, Object... params) {
        rootLogger().warn(e, message, params);
    }

    /**
     * Logs a message at the {@link Level#ERROR ERROR} level, using the root logger.
     *
     * @param message the message to log
     *
     * @see #rootLogger()
     * @see Logger#error(CharSequence)
     */
    public static void error(CharSequence message) {
        rootLogger().error(message);
    }

    /**
     * Logs a message with parameters at the {@link Level#ERROR ERROR} level, using the root logger.
     *
     * @param message the message to log; the format depends on the {@link MessageFormat}
     * @param params  parameters to the message
     *
     * @see #rootLogger()
     * @see Logger#error(CharSequence, Object...)
     */
    public static void error(CharSequence message, Object... params) {
        rootLogger().error(message, params);
    }

    /**
     * Logs the stack trace of the given {@link Throwable} at the {@link Level#ERROR ERROR} level, using the root
     * logger.
     *
     * @param e the exception to log, including its stack trace
     *
     * @see #rootLogger()
     * @see Logger#error(Throwable)
     */
    public static void error(Throwable e) {
        rootLogger().error(e);
    }

    /**
     * Logs a message at the {@link Level#ERROR ERROR} level including the stack trace of the given {@link Throwable},
     * using the root logger.
     *
     * @param e       the exception to log, including its stack trace
     * @param message the message to log
     *
     * @see #rootLogger()
     * @see Logger#error(Throwable, CharSequence)
     */
    public static void error(Throwable e, CharSequence message) {
        rootLogger().error(e, message);
    }

    /**
     * Logs a message with parameters at the {@link Level#ERROR ERROR} level including the stack trace of the given
     * {@link Throwable}, using the root logger.
     *
     * @param e       the exception to log, including its stack trace
     * @param message the message to log; the format depends on the {@link MessageFormat}
     * @param params  parameters to the message
     *
     * @see #rootLogger()
     * @see Logger#error(Throwable, CharSequence, Object...)
     */
    public static void error(Throwable e, CharSequence message, Object... params) {
        rootLogger().error(e, message, params);
    }

    /**
     * Logs a message at the given {@code level}, using the root logger.
     *
     * @param level   the logging level
     * @param message the message to log
     *
     * @see #rootLogger()
     * @see Logger#log(Level, CharSequence)
     */
    public static void log(@Nonnull Level level, CharSequence message) {
        rootLogger().log(level, message);
    }

    /**
     * Logs a message with parameters at the given {@code level}, using the root logger.
     *
     * @param level   the logging level
     * @param message the message to log; the format depends on the {@link MessageFormat}
     * @param params  parameters to the message
     *
     * @see #rootLogger()
     * @see Logger#log(Level, CharSequence, Object...)
     */
    public static void log(@Nonnull Level level, CharSequence message, Object... params) {
        rootLogger().log(level, message, params);
    }

    /**
     * Logs the stack trace of the given {@link Throwable} at the given {@code level}, using the root logger.
     *
     * @param level the logging level
     * @param e     the exception to log, including its stack trace
     *
     * @see #rootLogger()
     * @see Logger#log(Level, Throwable)
     */
    public static void log(@Nonnull Level level, Throwable e) {
        rootLogger().log(level, e);
    }

    /**
     * Logs a message at the given {@code level} including the stack trace of the given {@link Throwable}, using the
     * root logger.
     *
     * @param level   the logging level
     * @param e       the exception to log, including its stack trace
     * @param message the message to log
     *
     * @see #rootLogger()
     * @see Logger#log(Level, Throwable, CharSequence)
     */
    public static void log(@Nonnull Level level, Throwable e, CharSequence message) {
        rootLogger().log(level, e, message);
    }

    /**
     * Logs a message with parameters at the given {@code level} including the stack trace of the given {@link
     * Throwable}, using the root logger.
     *
     * @param level   the logging level
     * @param e       the exception to log, including its stack trace
     * @param message the message to log; the format depends on the {@link MessageFormat}
     * @param params  parameters to the message
     *
     * @see #rootLogger()
     * @see Logger#log(Level, Throwable, CharSequence, Object...)
     */
    public static void log(@Nonnull Level level, Throwable e, CharSequence message, Object... params) {
        rootLogger().log(level, e, message, params);
    }
}
