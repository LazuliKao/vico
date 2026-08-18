/*
 * Copyright 2025 by Patryk Goworowski and Patrick Michalik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

plugins { `dokka-convention` }

subprojects {
  group = "com.patrykandpatrick.vico"
  version = Versions.VICO
}



tasks.withType<org.jetbrains.dokka.gradle.DokkaMultiModuleTask>().configureEach {
  pluginsMapConfiguration.set(
    mapOf(
      "org.jetbrains.dokka.base.DokkaBase" to """{ "customStyleSheets": ["$rootDir/logo-styles.css"], "footerMessage": "© 2025 Patryk Goworowski and Patrick Michalik" }"""
    )
  )
}
