package com.thecrackertechnology.dragonterminal.component.config.loaders

import com.thecrackertechnology.dragonterminal.component.config.IConfigureLoader
import com.thecrackertechnology.dragonterminal.frontend.config.NeoConfigureFile
import java.io.File

/**
 * @author kiva
 */
class NeoLangConfigureLoader(private val configFile: File) : IConfigureLoader {
    override fun loadConfigure(): NeoConfigureFile? {
        val configureFile = NeoConfigureFile(configFile)
        return if (configureFile.parseConfigure()) configureFile else null
    }
}