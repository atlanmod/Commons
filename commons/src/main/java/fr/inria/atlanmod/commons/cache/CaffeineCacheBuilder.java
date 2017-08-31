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

package fr.inria.atlanmod.commons.cache;

import java.util.function.Function;
import java.util.function.ToIntBiFunction;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import static fr.inria.atlanmod.commons.Preconditions.checkArgument;
import static fr.inria.atlanmod.commons.Preconditions.checkNotNull;

/**
 * A Caffeine {@link CacheBuilder} implementation.
 *
 * @param <K> the base key type for {@link Cache}s created by this builder
 * @param <V> the base value type for {@link Cache} created by this builder
 */
@ParametersAreNonnullByDefault
final class CaffeineCacheBuilder<K, V> implements CacheBuilder<K, V> {

    /**
     * The internal cache builder implementation.
     */
    @Nonnull
    private final com.github.benmanes.caffeine.cache.Caffeine<Object, Object> builder;

    /**
     * Constructs a new {@code CacheBuilder}.
     */
    protected CaffeineCacheBuilder() {
        builder = com.github.benmanes.caffeine.cache.Caffeine.newBuilder();
    }

    @Nonnull
    @Override
    public CacheBuilder<K, V> recordStats() {
        builder.recordStats();
        return this;
    }

    @Nonnull
    @Override
    public CacheBuilder<K, V> maximumSize(@Nonnegative long maximumSize) {
        checkArgument(maximumSize >= 0);

        builder.maximumSize(maximumSize);
        return this;
    }

    @Override
    public <K1 extends K, V1 extends V> CacheBuilder<K, V> maximumWeight(@Nonnegative long maximumWeight, ToIntBiFunction<? super K1, ? extends V1> weigher) {
        checkArgument(maximumWeight >= 0);

        builder.maximumWeight(maximumWeight);
        builder.weigher(weigher::applyAsInt);
        return this;
    }

    @Nonnull
    @Override
    public CacheBuilder<K, V> weakKeys() {
        builder.weakKeys();
        return this;
    }

    @Nonnull
    @Override
    public CacheBuilder<K, V> softValues() {
        builder.softValues();
        return this;
    }

    @Nonnull
    @Override
    public <K1 extends K, V1 extends V> Cache<K1, V1> build() {
        return new CaffeineManualCache<>(builder.build());
    }

    @Nonnull
    @Override
    public <K1 extends K, V1 extends V> Cache<K1, V1> build(Function<? super K1, ? extends V1> mappingFunction) {
        checkNotNull(mappingFunction);

        return new CaffeineLoadingCache<>(builder.build(mappingFunction::apply));
    }
}
