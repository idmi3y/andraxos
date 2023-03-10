package com.thecrackertechnology.dragonterminal.component.config.loaders

import com.thecrackertechnology.dragonterminal.component.config.IConfigureLoader
import com.thecrackertechnology.dragonterminal.frontend.config.NeoConfigureFile
import java.io.File

/**
 * @author kiva
 */
class OldConfigureLoader(private val configFile: File) : IConfigureLoader {
    override fun loadConfigure(): NeoConfigureFile? {
        return when (configFile.extension) {
            "eks" -> returnConfigure(OldExtraKeysConfigureFile(configFile))
            "color" -> returnConfigure(OldColorSchemeConfigureFile(configFile))
            else -> null
        }
    }

    private fun returnConfigure(configureFile: NeoConfigureFile): NeoConfigureFile? {
        return if (configureFile.parseConfigure()) configureFile else null
    }
}