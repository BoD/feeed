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

package org.jraf.webpipes.engine.step.json

import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.buildJsonObject
import org.jraf.webpipes.api.Step
import org.jraf.webpipes.engine.util.jsonArray
import org.jraf.webpipes.engine.util.jsonObject
import org.jraf.webpipes.engine.util.plus
import org.jraf.webpipes.engine.util.string

class JsonFilterKeysStep : Step {
  override suspend fun execute(context: JsonObject): JsonObject {
    val inputFieldName = context.string("inputFieldName", "json")
    val outputFieldName = context.string("outputFieldName", "json")
    val allowedKeys: List<String> = context.jsonArray("allowedKeys").map { it.string }
    val outputJsonObject = buildJsonObject {
      val jsonObject: JsonObject = context.jsonObject(inputFieldName)
      for ((key, value) in jsonObject) {
        if (key in allowedKeys) {
          put(key, value)
        }
      }
    }
    return context + (outputFieldName to outputJsonObject)
  }
}