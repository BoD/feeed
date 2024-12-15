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

package org.jraf.feeed.engine.step.core

//import org.jraf.feeed.api.step.Context
//import org.jraf.feeed.api.Step
//
//class AddToContextStep(private val additionalContext: Context) : Step {
//  constructor(vararg additionalContext: Pair<String, Any?>) : this(
//    additionalContext.fold(Context()) { acc, (key, value) ->
//      acc.with(
//        key,
//        value,
//      )
//    },
//  )
//
//  override suspend fun execute(context: Context): Result<Context> {
//    return Result.success(context + additionalContext)
//  }
//}
//
//fun StepChain.addToContext(additionalContext: Context): StepChain {
//  return this + AddToContextStep(additionalContext)
//}
//
//fun StepChain.addToContext(vararg additionalContext: Pair<String, Any?>): StepChain {
//  return this + AddToContextStep(*additionalContext)
//}
//
//fun StepChain.addToContext(key: String, value: Any?): StepChain {
//  return addToContext(key to value)
//}
//
//fun StepChain.addToContextIfNotNull(key: String, value: Any?): StepChain {
//  return if (value != null) addToContext(key to value) else this
//}