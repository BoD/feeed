/*
 * This source is part of the
 *      _____  ___   ____
 *  __ / / _ \/ _ | / __/___  _______ _
 * / // / , _/ __ |/ _/_/ _ \/ __/ _ `/
 * \___/_/|_/_/ |_/_/ (_)___/_/  \_, /
 *                              /___/
 * repository.
 *
 * Copyright (C) 2024-present Benoit 'BoD' Lubek (BoD@JRAF.org)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.jraf.feeed.api.step

class Context private constructor(
  private val context: Map<String, Any?>,
) {
  constructor() : this(emptyMap())

  operator fun <T> get(key: String): T {
    if (!context.containsKey(key)) {
      throw IllegalArgumentException("'$key' not found in context")
    }
    return getWithCast(key)
  }

  operator fun <T> get(key: String, default: T): T {
    if (!context.containsKey(key)) {
      return default
    }
    return getWithCast(key)
  }

  private fun <T> getWithCast(key: String): T {
    return try {
      @Suppress("UNCHECKED_CAST")
      context.get(key) as T
    } catch (e: ClassCastException) {
      throw IllegalArgumentException("'$key' is not of the expected type")
    }
  }

  fun with(key: String, value: Any?): Context {
    return Context(context + (key to value))
  }

  fun without(key: String): Context {
    return Context(context - key)
  }

  operator fun plus(other: Context): Context {
    return Context(context + other.context)
  }

  fun allValues(): Map<String, Any?> {
    return context
  }

  override fun toString(): String {
    return "Context(context=$context)"
  }
}